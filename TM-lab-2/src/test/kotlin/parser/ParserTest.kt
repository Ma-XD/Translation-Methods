package parser

import parser.exception.ParseException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParserTest {
    private val parser = Parser()

    private companion object {
        fun getExprTree(
            factor: Tree,
            sign: (Tree) -> Tree = ::getSignTree
        ) = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        sign(factor),
                        Tree("T'")
                    )
                ),
                Tree("E'")
            )
        )

        private fun getSignTree(factor: Tree) = Tree(
            "S", listOf(
                factor
            )
        )

        fun getNumberTree() = getExprTree(
            factor = Tree(
                "F", listOf(
                    Tree("n")
                )
            )
        )

        fun getBracketTree(expr: Tree) = getExprTree(
            factor = Tree(
                "F", listOf(
                    Tree("("),
                    expr,
                    Tree(")")
                )
            )
        )

        fun getFunctionTree(expr: Tree) = getExprTree(
            factor = Tree(
                "F", listOf(
                    Tree("f("),
                    expr,
                    Tree(")")
                )
            )
        )

        fun getUnaryMinusTree(factor: Tree) = getExprTree(
            factor = factor,
            sign = { _factor ->
                Tree(
                    "S", listOf(
                        Tree("-"),
                        Tree(
                            "F", listOf(
                                _factor
                            )
                        ),
                    )
                )
            }
        )
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
    fun testBracket() {
        val input = "(1)".byteInputStream()
        val expected = getBracketTree(getNumberTree())
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testEmptyBracket() {
        val input = "()".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testFunction() {
        val input = "f(1)".byteInputStream()
        val expected = getFunctionTree(getNumberTree())
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testUnaryMinus() {
        val input = "-1".byteInputStream()
        val expected = getUnaryMinusTree(Tree("n"))
        Assertions.assertEquals(expected, parser.parse(input))
    }

    @Test
    fun testDoubleUnaryMinus() {
        val input = "--1".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }
}