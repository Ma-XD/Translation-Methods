package parser

import parser.exception.ParseException
import java.io.InputStream

class Parser {
    private lateinit var lex: LexicalAnalyzer

    fun parse(input: InputStream): Tree {
        lex = LexicalAnalyzer(input)
        lex.nextToken()
        val res = parseExpr()
        assertToken(Token.END, "Unacceptable end token")
        return res
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
                val op = if (lex.curToken == Token.PLUS) "+" else "-"
                lex.nextToken()
                Tree(node, listOf(Tree(op), parseTerm(), parseExprCont()))
            }

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
                lex.nextToken()
                listOf(Tree("n"))
            }

            Token.LBRACKET -> {
                parseBracket(first = "(")
            }

            Token.FUNCTION -> {
                lex.nextToken()
                assertToken(Token.LBRACKET, "Function must have brackets")
                parseBracket(first = "f(")
            }

            else -> throw ParseException("Unacceptable start of factor, ${errorInfo()}")
        }

        return Tree(node, res)
    }

    private fun parseBracket(first: String): List<Tree> {
        lex.nextToken()
        val res = arrayListOf(Tree(first), parseExpr())
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

    private fun errorInfo() = "found token ${lex.curToken.name} at position ${lex.curPos - lex.curTokenLength}"
}