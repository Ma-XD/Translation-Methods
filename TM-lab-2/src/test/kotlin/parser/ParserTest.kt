package parser

import parser.exception.ParseException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParserTest {
    private val parser = Parser()

    private companion object {
        fun getExpr(
            factor: Tree,
            getSign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T'"),
            exprCont: Tree = Tree("E'")
        ) = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        getSign(factor),
                        termCont
                    )
                ),
                exprCont
            )
        )

        fun getTermCont(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T'")
        ) = Tree(
            "T'", listOf(
                Tree("*"),
                sign(factor),
                termCont
            )
        )

        private fun getNumber() = Tree(
            "F", listOf(
                Tree("n")
            )
        )

        private fun getBracket(expr: Tree) = Tree(
            "F", listOf(
                Tree("("),
                expr,
                Tree(")")
            )
        )

        private fun getFunction(expr: Tree) = Tree(
            "F", listOf(
                Tree("f"),
                Tree("("),
                expr,
                Tree(")")
            )
        )

        private fun getNoSign(factor: Tree) = Tree(
            "S", listOf(
                factor
            )
        )

        private fun getUnaryMinus(factor: Tree) = Tree(
            "S", listOf(
                Tree("-"),
                factor
            )
        )

        fun getNumberTree() = getExpr(getNumber())

        fun getBracketTree(expr: Tree) = getExpr(getBracket(expr))

        fun getFunctionTree(expr: Tree) = getExpr(getFunction(expr))

        fun getUnaryMinusTree(factor: Tree) = getExpr(factor, getSign = ::getUnaryMinus)
    }

    @Test
    fun testEmpty() {
        val input = " ".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testNumber() {
        val input = "1".byteInputStream()
        val expected = getNumberTree()
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testBrackets() {
        val input = "(1)".byteInputStream()
        val expected = getBracketTree(getNumberTree())
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testEmptyBrackets() {
        val input = "()".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testLeftBrackets() {
        val input = "(1".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testOnlyRightBracket() {
        val input = "1)".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testFunction() {
        val input = "f(1)".byteInputStream()
        val expected = getFunctionTree(getNumberTree())
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testFunctionWithoutBrackets() {
        val input = "sin 1 ".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMinus() {
        val input = "-1".byteInputStream()
        val expected = getUnaryMinusTree(getNumber())
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testDoubleUnaryMinus() {
        val input = "--1".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryPlus() {
        val input = "+1".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMultiply() {
        val input = "*1".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testMultiply() {
        val input = "1 * 1".byteInputStream()
        val expected = getExpr(
            factor = getNumber(),
            termCont = getTermCont(getNumber())
        )
        Assertions.assertEquals(expected, parser.parse(input))
    }
}