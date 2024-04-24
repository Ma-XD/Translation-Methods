package parser

class Parser {
    private lateinit var lex: LexicalAnalyzer

    fun parse(input: String): Tree {
        lex = LexicalAnalyzer(input)
        lex.nextToken()
        val res = parseE()
        assertToken(Token.END)
        return res
    }

    private fun parseE(): Tree {
        val node = "E"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.MINUS, Token.NUMBER, Token.LBRACKET, Token.FUNCTION -> {
                children.add(parseT())
                children.add(parseE1())
                Tree(node, children = children)
            }


            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun parseE1(): Tree {
        val node = "E1"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.PLUS -> {
                assertToken(Token.PLUS)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseT())
                children.add(parseE1())
                Tree(node, children = children)
            }

            Token.MINUS -> {
                assertToken(Token.MINUS)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseT())
                children.add(parseE1())
                Tree(node, children = children)
            }

            Token.RBRACKET, Token.END -> {

                Tree(node, children = children)
            }

            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun parseT(): Tree {
        val node = "T"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.MINUS, Token.NUMBER, Token.LBRACKET, Token.FUNCTION -> {
                children.add(parseS())
                children.add(parseT1())
                Tree(node, children = children)
            }


            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun parseT1(): Tree {
        val node = "T1"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.MULTIPLY -> {
                assertToken(Token.MULTIPLY)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseS())
                children.add(parseT1())
                Tree(node, children = children)
            }

            Token.RBRACKET, Token.MINUS, Token.END, Token.PLUS -> {

                Tree(node, children = children)
            }

            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun parseS(): Tree {
        val node = "S"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.MINUS -> {
                assertToken(Token.MINUS)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseF())
                Tree(node, children = children)
            }

            Token.NUMBER, Token.LBRACKET, Token.FUNCTION -> {
                children.add(parseF())
                Tree(node, children = children)
            }


            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun parseF(): Tree {
        val node = "F"
        val children = ArrayList<Tree>()
        return when (lex.curToken) {
            Token.FUNCTION -> {
                assertToken(Token.FUNCTION)
                children.add(Tree(lex.curString))
                lex.nextToken()
                assertToken(Token.LBRACKET)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseE())
                assertToken(Token.RBRACKET)
                children.add(Tree(lex.curString))
                lex.nextToken()
                Tree(node, children = children)
            }

            Token.LBRACKET -> {
                assertToken(Token.LBRACKET)
                children.add(Tree(lex.curString))
                lex.nextToken()
                children.add(parseE())
                assertToken(Token.RBRACKET)
                children.add(Tree(lex.curString))
                lex.nextToken()
                Tree(node, children = children)
            }

            Token.NUMBER -> {
                assertToken(Token.NUMBER)
                children.add(Tree(lex.curString))
                lex.nextToken()
                Tree(node, children = children)
            }


            else -> throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun assertToken(expected: Token) {
        if (lex.curToken != expected) {
            throw ParseException("Unexpected end token: " + errorInfo())
        }
    }

    private fun errorInfo() = "found token " + lex.curToken.name + " at position " + (lex.curPos - lex.curString.length)
}

class ParseException(message: String?) : Exception(message)