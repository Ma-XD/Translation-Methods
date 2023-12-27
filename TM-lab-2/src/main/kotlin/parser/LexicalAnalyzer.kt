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
                skip(Char::isDigit)
                Token.NUMBER
            }

            curChar.isLetter() -> {
                skip(Char::isLetter)
                Token.FUNCTION
            }

            OPERATIONS.containsKey(curChar) -> {
                val token = OPERATIONS[curChar]!!
                nextChar()
                token
            }

            curChar == END -> {
                Token.END
            }

            else -> throw LexicalException("Illegal character '$curChar' at position $curPos")
        }
    }

    private fun skip(predicate: (Char) -> Boolean) {
        while (predicate(curChar)) nextChar()
    }
}
