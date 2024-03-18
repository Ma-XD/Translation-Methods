package parser

import java.util.regex.Pattern

enum class Token {
   START, END, ADD, DIV, RBRACKET, SUB, LBRACKET, MUL, EPS, N
}

class LexicalAnalyzer(private val source: String) {
    private val matcher = Pattern.compile("").matcher(source)
    var curPos = 0
        private set
    var curToken = Token.START
        private set
    var curString: String = ""
        private set

    private companion object {
        private val WS = Pattern.compile("[ \t\r\n]+")
        private val TOKENS: List<Pair<Pattern, Token>> = listOf(
            Pattern.compile("\\+") to Token.ADD, Pattern.compile("/") to Token.DIV, Pattern.compile("\\)") to Token.RBRACKET, Pattern.compile("-") to Token.SUB, Pattern.compile("\\(") to Token.LBRACKET, Pattern.compile("\\*") to Token.MUL, Pattern.compile("э") to Token.EPS, Pattern.compile("[0-9]+") to Token.N
        ).sortedBy { it.first.pattern().length }.reversed()
    }

    fun nextToken() {
        skipWhiteSpaces()
        if (curPos == source.length) {
            curString = ""
            curToken = Token.END
            return
        }

        TOKENS.forEach { (pattern, token) ->
            matcher.usePattern(pattern)
            if (matcher.lookingAt()) {
                curString = matcher.group()
                curPos += matcher.end()
                matcher.reset(source.substring(curPos))
                curToken = token
              return
           }
        }

        throw LexicalException("Illegal character at position " + curPos)
    }

    private fun skipWhiteSpaces() {
        matcher.usePattern(WS)
        if (matcher.lookingAt()) {
            curPos += matcher.end()
            matcher.reset(source.substring(curPos))
        }
   }
}

class LexicalException(message: String?) : Exception(message)