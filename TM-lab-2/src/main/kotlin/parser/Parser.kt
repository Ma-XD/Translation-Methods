package parser

import parser.exception.ParseException
import java.io.InputStream

class Parser {
    private lateinit var lex: LexicalAnalyzer

    fun parse(input: InputStream): Tree {
        lex = LexicalAnalyzer(input)
        lex.nextToken()
        val res = parseCond()
        assertToken(Token.END, "Unacceptable end token")
        return res
    }

    /**
     * C  -> EC'
     */
    private fun parseCond(): Tree {
        val node = "C"
        return when (lex.curToken) {
            Token.NUMBER,
            Token.LBRACKET,
            Token.FUNCTION,
            Token.MINUS -> {
                Tree(node, listOf(parseExpr(), parseCondCont()))
            }

            else -> throw ParseException("Unacceptable start of condition, ${errorInfo()}")
        }
    }

    /**
     * C' -> pE?E:E
     *
     * C' -> eps
     */
    private fun parseCondCont(): Tree {
        val node = "C'"
        return when (lex.curToken) {
            Token.EQUAL,
            Token.NOT_EQUAL,
            Token.GREATER,
            Token.LESS -> {
                val cmp = lex.curString
                lex.nextToken()
                val condExpr = parseExpr()
                assertToken(Token.IF, "Unacceptable continuation of condition, expected token ${Token.IF}")
                lex.nextToken()
                val ifExpr = parseExpr()
                assertToken(Token.ELSE, "Unacceptable continuation of condition, expected token ${Token.ELSE}")
                lex.nextToken()
                val elseExpr = parseExpr()
                Tree(node, listOf(Tree(cmp), condExpr, Tree("?"), ifExpr, Tree(":"), elseExpr))
            }

            Token.RBRACKET,
            Token.END -> Tree(node)

            else -> throw ParseException("Unacceptable continuation of condition, ${errorInfo()}")
        }
    }

    /**
     * E  -> TE'
     */
    private fun parseExpr(): Tree {
        val node = "E"
        return when (lex.curToken) {
            Token.NUMBER,
            Token.LBRACKET,
            Token.FUNCTION,
            Token.MINUS -> Tree(node, listOf(parseTerm(), parseExprCont()))

            else -> throw ParseException("Unacceptable start of expression, ${errorInfo()}")
        }
    }

    /**
     * E' -> +TE'
     *
     * E' -> -TE'
     *
     * E' -> eps
     */
    private fun parseExprCont(): Tree {
        val node = "E'"
        return when (lex.curToken) {
            Token.PLUS,
            Token.MINUS -> {
                val op = lex.curString
                lex.nextToken()
                Tree(node, listOf(Tree(op), parseTerm(), parseExprCont()))
            }

            Token.EQUAL,
            Token.NOT_EQUAL,
            Token.GREATER,
            Token.LESS,
            Token.IF,
            Token.ELSE,
            Token.RBRACKET,
            Token.END -> Tree(node)

            else -> throw ParseException("Unacceptable continuation of expression, ${errorInfo()}")
        }
    }

    /**
     * T  -> ST'
     */
    private fun parseTerm(): Tree {
        val node = "T"
        return when (lex.curToken) {
            Token.NUMBER,
            Token.LBRACKET,
            Token.FUNCTION,
            Token.MINUS -> Tree(node, listOf(parseSign(), parseTermCont()))

            else -> throw ParseException("Unacceptable start of term, ${errorInfo()}")
        }
    }

    /**
     * T' -> *ST'
     *
     * T' -> eps
     */
    private fun parseTermCont(): Tree {
        val node = "T'"
        return when (lex.curToken) {
            Token.MULTIPLICATION -> {
                lex.nextToken()
                Tree(node, listOf(Tree("*"), parseSign(), parseTermCont()))
            }

            Token.EQUAL,
            Token.NOT_EQUAL,
            Token.GREATER,
            Token.LESS,
            Token.IF,
            Token.ELSE,
            Token.PLUS,
            Token.MINUS,
            Token.RBRACKET,
            Token.END -> Tree(node)

            else -> throw ParseException("Unacceptable continuation of term, ${errorInfo()}")
        }
    }

    /**
     * S  -> -F
     *
     * S  -> F
     */
    private fun parseSign(): Tree {
        val node = "S"
        return when (lex.curToken) {
            Token.NUMBER,
            Token.LBRACKET,
            Token.FUNCTION -> Tree(node, listOf(parseFactor()))

            Token.MINUS -> {
                lex.nextToken()
                Tree(node, listOf(Tree("-"), parseFactor()))
            }

            else -> throw ParseException("Unacceptable start of sign, ${errorInfo()}")
        }
    }

    /**
     * F  -> n
     *
     * F  -> (E)
     *
     * F  -> f(E)
     */
    private fun parseFactor(): Tree {
        val node = "F"
        val res: List<Tree> = when (lex.curToken) {
            Token.NUMBER -> {
                val value = Tree(lex.curString)
                lex.nextToken()
                listOf(Tree("n", listOf(value)))
            }

            Token.LBRACKET -> {
                parseBracket()
            }

            Token.FUNCTION -> {
                val value = Tree(lex.curString)
                lex.nextToken()
                assertToken(Token.LBRACKET, "Function must have brackets")
                parseBracket(arrayListOf(Tree("f", listOf(value))))
            }

            else -> throw ParseException("Unacceptable start of factor, ${errorInfo()}")
        }

        return Tree(node, res)
    }

    private fun parseBracket(res: ArrayList<Tree> = arrayListOf()): List<Tree> {
        lex.nextToken()
        res.add(Tree("("))
        res.add(parseCond())
        assertToken(Token.RBRACKET, "Closing bracket missed")
        res.add(Tree(")"))
        lex.nextToken()
        return res
    }

    private fun assertToken(expected: Token, message: String) {
        if (lex.curToken != expected) {
            throw ParseException("$message, ${errorInfo()}")
        }
    }

    private fun errorInfo() = "found token ${lex.curToken.name} at position ${lex.curPos - lex.curString.length}"
}