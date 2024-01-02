package parser

import parser.exception.LexicalException
import java.io.IOException
import java.io.InputStream

class LexicalAnalyzer(private var source: InputStream) {
    private var curChar = '\u0000'
    var curPos = 0
        private set
    var curToken = Token.START
        private set
    var curTokenLength = 0
        private set

    private companion object {
        private const val END: Char = (-1).toChar()
        private val OPERATIONS: Map<Char, Token> = mapOf(
            '+' to Token.PLUS,
            '-' to Token.MINUS,
            '*' to Token.MULTIPLICATION,
            '(' to Token.LBRACKET,
            ')' to Token.RBRACKET,
        )
    }

    init {
        nextChar()
    }

    private fun nextChar() {
        curPos++
        curChar = try {
            source.read().toChar()
        } catch (e: IOException) {
            throw LexicalException("${e.message} at position $curPos")
        }
    }

    fun nextToken() {
        skip(Char::isWhitespace)
        curToken = when {
            curChar.isDigit() -> {
                curTokenLength = skip(Char::isDigit)
                Token.NUMBER
            }

            curChar.isLetter() -> {
                curTokenLength = skip(Char::isLetter)
                Token.FUNCTION
            }

            OPERATIONS.containsKey(curChar) -> {
                val token = OPERATIONS[curChar]!!
                nextChar()
                curTokenLength = 1
                token
            }

            curChar == END -> {
                curTokenLength = 0
                Token.END
            }

            else -> throw LexicalException("Illegal character '$curChar' at position $curPos")
        }
    }

    private fun skip(predicate: (Char) -> Boolean): Int {
        var length = 0
        while (predicate(curChar)) {
            nextChar()
            length++
        }
        return length
    }
}
