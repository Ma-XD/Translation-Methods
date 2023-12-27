package parser

import parser.exception.ParseException
import java.io.InputStream

class Parser {
    private lateinit var lex: LexicalAnalyzer

    fun parse(input: InputStream): Tree {
        lex = LexicalAnalyzer(input)
        lex.nextToken()
        val res = parseExpr()
        assertToken(Token.END, "Unexpected end token")
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

            else -> throw ParseException("Unexpected start of expression: ${lex.curToken.name} at position ${lex.curPos}")
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

            else -> throw ParseException("Unexpected continuation of expression: ${lex.curToken.name} at position ${lex.curPos}")
        }
    }

    /**
     * T  -> FT'
     */
    private fun parseTerm(): Tree {
        val node = "T"
        return when (lex.curToken) {
            Token.NUMBER,
            Token.LBRACKET,
            Token.FUNCTION,
            Token.MINUS -> Tree(node, listOf(parseFactor(), parseTermCont()))

            else -> throw ParseException("Unexpected start of term: ${lex.curToken.name} at position ${lex.curPos}")
        }
    }

    /**
     * T' -> *FT'
     *
     * T' -> eps
     */
    private fun parseTermCont(): Tree {
        val node = "T'"
        return when (lex.curToken) {
            Token.MULTIPLICATION -> {
                lex.nextToken()
                Tree(node, listOf(Tree("*"), parseFactor(), parseTermCont()))
            }

            Token.PLUS,
            Token.MINUS,
            Token.RBRACKET,
            Token.END -> Tree(node)

            else -> throw ParseException("Unexpected continuation of term: ${lex.curToken.name} at position ${lex.curPos}")
        }
    }

    /**
     * F  -> n
     *
     * F  -> (E)
     *
     * F  -> f(E)
     *
     * F  -> -F
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
                assertToken(Token.LBRACKET, "Unexpected start of factor")
                parseBracket(first = "f(")
            }

            Token.MINUS -> {
                lex.nextToken()
                listOf(Tree("-"), parseFactor())
            }

            else -> throw ParseException("Unexpected start of factor: ${lex.curToken.name} at position ${lex.curPos}")
        }

        return Tree(node, res)
    }

    private fun parseBracket(first: String): List<Tree> {
        lex.nextToken()
        val res = arrayListOf(Tree(first), parseExpr())
        assertToken(Token.RBRACKET, "Unexpected end of factor")
        res.add(Tree(")"))
        lex.nextToken()
        return res
    }

    private fun assertToken(expected: Token, message: String) {
        if (lex.curToken != expected) {
            throw ParseException("$message: ${lex.curToken.name} at position ${lex.curPos}")
        }
    }
}