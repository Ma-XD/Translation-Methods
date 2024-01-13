package parser

import parser.exception.LexicalException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class LexicalAnalyzerTest {

    @Test
    fun testEmpty() {
        val lex = LexicalAnalyzer("".byteInputStream())
        Assertions.assertEquals(Token.START, lex.curToken)
        Assertions.assertEquals("", lex.curString)
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
        Assertions.assertEquals("", lex.curString)
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
        Assertions.assertEquals("", lex.curString)
    }

    @Test
    fun testSpaces() {
        val lex = LexicalAnalyzer("  \t\t\n \t \r  \r\r  \t\t\n \r\n\n".byteInputStream())
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testNumber() {
        val lex = LexicalAnalyzer("123".byteInputStream())
        lex.nextToken()
        Assertions.assertEquals(Token.NUMBER, lex.curToken)
        Assertions.assertEquals("123", lex.curString)
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testLetter() {
        val lex = LexicalAnalyzer("sin".byteInputStream())
        lex.nextToken()
        Assertions.assertEquals(Token.FUNCTION, lex.curToken)
        Assertions.assertEquals("sin", lex.curString)
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testSplit() {
        val lex = LexicalAnalyzer("sin 123\ncos456".byteInputStream())
        val expected = listOf(
            Token.FUNCTION to "sin",
            Token.NUMBER to "123",
            Token.FUNCTION to "cos",
            Token.NUMBER to "456",
        )
        expected.forEach {
            lex.nextToken()
            Assertions.assertEquals(it.first, lex.curToken)
            Assertions.assertEquals(it.second, lex.curString)
        }
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testOperations() {
        val lex = LexicalAnalyzer("?:+-*()".byteInputStream())
        val expected = listOf(
            Token.IF to "?",
            Token.ELSE to ":",
            Token.PLUS to "+",
            Token.MINUS to "-",
            Token.MULTIPLICATION to "*",
            Token.LBRACKET to "(",
            Token.RBRACKET to ")",
        )
        expected.forEach {
            lex.nextToken()
            Assertions.assertEquals(it.first, lex.curToken)
            Assertions.assertEquals(it.second, lex.curString)
        }
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testComparisons() {
        val lex = LexicalAnalyzer("==!=<>".byteInputStream())
        val expected = listOf(
            Token.EQUAL to "==",
            Token.NOT_EQUAL to "!=",
            Token.LESS to "<",
            Token.GREATER to ">",
        )
        expected.forEach {
            lex.nextToken()
            Assertions.assertEquals(it.first, lex.curToken)
            Assertions.assertEquals(it.second, lex.curString)
        }
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }

    @Test
    fun testEqualWithoutSecondChar() {
        val lex = LexicalAnalyzer("=1".byteInputStream())
        Assertions.assertThrows(LexicalException::class.java, lex::nextToken)
    }

    @Test
    fun testUnacceptable() {
        val lex = LexicalAnalyzer("/".byteInputStream())
        Assertions.assertThrows(LexicalException::class.java, lex::nextToken)
    }

    @Test
    fun testExpression() {
        val lex = LexicalAnalyzer(" 12 +tg(3* 45 ) - fx".byteInputStream())
        val expected = listOf(
            Token.NUMBER to "12",
            Token.PLUS to "+",
            Token.FUNCTION to "tg",
            Token.LBRACKET to "(",
            Token.NUMBER to "3",
            Token.MULTIPLICATION to "*",
            Token.NUMBER to "45",
            Token.RBRACKET to ")",
            Token.MINUS to "-",
            Token.FUNCTION to "fx",
        )
        expected.forEach {
            lex.nextToken()
            Assertions.assertEquals(it.first, lex.curToken)
            Assertions.assertEquals(it.second, lex.curString)
        }
        lex.nextToken()
        Assertions.assertEquals(Token.END, lex.curToken)
    }
}