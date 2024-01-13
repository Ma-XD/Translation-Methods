package parser

import parser.exception.LexicalException
import java.io.IOException
import java.io.InputStream
import java.lang.StringBuilder

class LexicalAnalyzer(private var source: InputStream) {
    private var curChar = '\u0000'
    var curPos = 0
        private set
    var curToken = Token.START
        private set
    var curString: String = ""
        private set

    private companion object {
        private const val END: Char = (-1).toChar()
        private val OPERATIONS: Map<Char, Token> = mapOf(
            '?' to Token.IF,
            ':' to Token.ELSE,
            '+' to Token.PLUS,
            '-' to Token.MINUS,
            '*' to Token.MULTIPLICATION,
            '(' to Token.LBRACKET,
            ')' to Token.RBRACKET,
        )
        private val COMPARISONS: Map<Char, Token> = mapOf(
            '=' to Token.EQUAL,
            '!' to Token.NOT_EQUAL,
            '>' to Token.GREATER,
            '<' to Token.LESS,
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
        readWhile(Char::isWhitespace)
        curToken = when {
            curChar.isDigit() -> {
                curString = readWhile(Char::isDigit)
                Token.NUMBER
            }

            curChar.isLetter() -> {
                curString = readWhile(Char::isLetter)
                Token.FUNCTION
            }

            OPERATIONS.containsKey(curChar) -> {
                val token = OPERATIONS[curChar]!!
                curString = curChar.toString()
                nextChar()
                token
            }

            COMPARISONS.containsKey(curChar) -> {
                val token = COMPARISONS[curChar]!!
                curString = curChar.toString()
                nextChar()
                if (token == Token.EQUAL || token == Token.NOT_EQUAL) {
                    if (curChar == '=') {
                        curString += "="
                        nextChar()
                    } else {
                        throw LexicalException("Illegal character '$curChar' at position $curPos, expected '='")
                    }
                }
                token
            }

            curChar == END -> {
                curString = ""
                Token.END
            }

            else -> throw LexicalException("Illegal character '$curChar' at position $curPos")
        }
    }

    private fun readWhile(predicate: (Char) -> Boolean): String {
        val buffer = StringBuilder()
        while (predicate(curChar)) {
            buffer.append(curChar)
            nextChar()
        }
        return buffer.toString()
    }
}
