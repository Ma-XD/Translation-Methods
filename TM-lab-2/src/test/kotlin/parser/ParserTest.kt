package parser

import parser.exception.ParseException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

internal class ParserTest {
    private val parser = Parser()

    private companion object {
        const val BUILDING_MESSAGE = "Test tree building"
        const val CALCULATION_MESSAGE = "Test calculation"
        const val N = 2 // default number for calculations
        fun f(x: Int) = x * x // default function for calculations

        fun calc(tree: Tree): Int = when (tree.node) {
            "n" -> {
                N
            }

            "F" -> {
                var i = 0
                var f: (Int) -> Int = { it }
                if (tree.children[i].node == "f") {
                    i++
                    f = ::f
                }
                if (tree.children[i].node == "(") i++
                f(calc(tree.children[i]))
            }

            "S" -> {
                if (tree.children[0].node == "-") {
                    -calc(tree.children[1])
                } else {
                    calc(tree.children[0])
                }
            }

            "T" -> {
                var res = calc(tree.children[0])
                var next = tree.children[1] // T'
                while (next.children.isNotEmpty()) {
                    res *= calc(next.children[1])
                    next = next.children[2] // T'
                }
                res
            }

            "E" -> {
                var res = calc(tree.children[0])
                var next = tree.children[1] // E'
                while (next.children.isNotEmpty()) {
                    val op = next.children[0].node
                    res += if (op == "+") calc(next.children[1]) else -calc(next.children[1])
                    next = next.children[2] // E'
                }
                res
            }

            else -> {
                throw RuntimeException()
            }
        }


        fun getExpr(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T'"),
            exprCont: Tree = Tree("E'")
        ) = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        sign(factor),
                        termCont
                    )
                ),
                exprCont
            )
        )

        fun getExprCont(
            op: String,
            term: Tree,
            exprCont: Tree = Tree("E'")
        ) = Tree(
            "E'", listOf(
                Tree(op),
                term,
                exprCont
            )
        )

        fun getTerm(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T'")
        ) = Tree(
            "T", listOf(
                sign(factor),
                termCont
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

        fun getNumberExpr() = getExpr(getNumber())

        fun getBracketExpr(expr: Tree) = getExpr(getBracket(expr))

        fun getFunctionExpr(expr: Tree) = getExpr(getFunction(expr))

        fun getUnaryMinusExpr(factor: Tree) = getExpr(factor = factor, sign = ::getUnaryMinus)
    }

    @Test
    fun testEmpty() {
        val input = " ".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testNumber() {
        val input = "2".byteInputStream()
        val expectedTree = getNumberExpr()
        val expectedCalculation = N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testBrackets() {
        val input = "(2)".byteInputStream()
        val expectedTree = getBracketExpr(getNumberExpr())
        val expectedCalculation = N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testEmptyBrackets() {
        val input = "()".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testLeftBrackets() {
        val input = "(2".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testOnlyRightBracket() {
        val input = "2)".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testFunction() {
        val input = "f(2)".byteInputStream()
        val expectedTree = getFunctionExpr(getNumberExpr())
        val expectedCalculation = f(N)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testFunctionWithoutBrackets() {
        val input = "sin 2 ".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMinus() {
        val input = "-2".byteInputStream()
        val expectedTree = getUnaryMinusExpr(getNumber())
        val expectedCalculation = -N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testUnaryMinusAndFunction() {
        val input = "-f(2)".byteInputStream()
        val expectedTree = getUnaryMinusExpr(getFunction(getNumberExpr()))
        val expectedCalculation = -f(N)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleUnaryMinus() {
        val input = "--2".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryPlus() {
        val input = "+2".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMultiply() {
        val input = "*2".byteInputStream()
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testMultiply() {
        val input = "2 * 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            termCont = getTermCont(getNumber())
        )
        val expectedCalculation = N * N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleMultiply() {
        val input = "2 * 2 * 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            termCont = getTermCont(
                factor = getNumber(),
                termCont = getTermCont(getNumber())
            )
        )
        val expectedCalculation = N * N * N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testIllegalTokenAfterMultiply() {
        val input = listOf(
            "2 *",
            "2 ** 2",
            "(2 *)"
        ).map { it.byteInputStream() }
        input.forEach {
            Assertions.assertThrows(ParseException::class.java) { parser.parse(it) }
        }
    }

    @Test
    fun testMultiplyAndUnaryMinus() {
        val input = "2*-2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            termCont = getTermCont(
                factor = getNumber(),
                sign = ::getUnaryMinus
            )
        )
        val expectedCalculation = N * -N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testAdd() {
        val input = "2 + 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(getNumber())
            )
        )
        val expectedCalculation = N + N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testSubtract() {
        val input = "2 - 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(getNumber())
            )
        )
        val expectedCalculation = N - N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleAdd() {
        val input = "2 + 2 + 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(getNumber()),
                exprCont = getExprCont(
                    op = "+",
                    term = getTerm(getNumber()),
                )
            )
        )
        val expectedCalculation = N + N + N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleSubtract() {
        val input = "2 - 2 - 2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(getNumber()),
                exprCont = getExprCont(
                    op = "-",
                    term = getTerm(getNumber()),
                )
            )
        )
        val expectedCalculation = N - N - N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testSubtractAndUnaryMinus() {
        val input = "2--2".byteInputStream()
        val expectedTree = getExpr(
            factor = getNumber(),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(
                    factor = getNumber(),
                    sign = ::getUnaryMinus
                )
            )
        )
        val expectedCalculation = N - -N
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }
}