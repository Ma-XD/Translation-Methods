package parser

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParserTest {
    private val parser = Parser()

    private companion object {
        const val BUILDING_MESSAGE = "Test tree building"
        const val CALCULATION_MESSAGE = "Test calculation"
        fun f(x: Int) = x * x // default function for calculations

        fun calc(tree: Tree): Int = when (tree.node) {

            "F" -> {
                var i = 0
                var f: (Int) -> Int = { it }
                if (tree.children.size == 4) {
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
                var next = tree.children[1] // T1
                while (next.children.isNotEmpty()) {
                    res *= calc(next.children[1])
                    next = next.children[2] // T1
                }
                res
            }

            "E" -> {
                var res = calc(tree.children[0])
                var next = tree.children[1] // E1
                while (next.children.isNotEmpty()) {
                    val op = next.children[0].node
                    res += if (op == "+") calc(next.children[1]) else -calc(next.children[1])
                    next = next.children[2] // E1
                }
                res
            }

            else -> {
                tree.node.toInt()
            }
        }


        fun getExpr(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T1"),
            exprCont: Tree = Tree("E1")
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
            exprCont: Tree = Tree("E1")
        ) = Tree(
            "E1", listOf(
                Tree(op),
                term,
                exprCont
            )
        )

        fun getTerm(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T1")
        ) = Tree(
            "T", listOf(
                sign(factor),
                termCont
            )
        )


        fun getTermCont(
            factor: Tree,
            sign: (Tree) -> Tree = ::getNoSign,
            termCont: Tree = Tree("T1")
        ) = Tree(
            "T1", listOf(
                Tree("*"),
                sign(factor),
                termCont
            )
        )

        private fun getNumber(n: Int) = Tree(
            "F", listOf(
                Tree(n.toString())
            )
        )

        private fun getBracket(expr: Tree) = Tree(
            "F", listOf(
                Tree("("),
                expr,
                Tree(")")
            )
        )

        private fun getFunction(f: String, expr: Tree) = Tree(
            "F", listOf(
                Tree(f),
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

        fun getNumberExpr(n: Int) = getExpr(getNumber(n))

        fun getBracketExpr(expr: Tree) = getExpr(getBracket(expr))

        fun getFunctionExpr(f: String, expr: Tree) = getExpr(getFunction(f, expr))

        fun getUnaryMinusExpr(factor: Tree) = getExpr(factor = factor, sign = ::getUnaryMinus)
    }

    @Test
    fun testNumber() {
        val input = "1234567890"
        val expectedTree = getNumberExpr(1234567890)
        val expectedCalculation = 1234567890
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testBrackets() {
        val input = "(2)"
        val expectedTree = getBracketExpr(getNumberExpr(2))
        val expectedCalculation = (2)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleBrackets() {
        val input = "((2))"
        val expectedTree = getBracketExpr(getBracketExpr(getNumberExpr(2)))
        val expectedCalculation = ((2))
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testFunction() {
        val input = "f(2)"
        val expectedTree = getFunctionExpr("f", getNumberExpr(2))
        val expectedCalculation = f(2)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testEmpty() {
        val input = " "
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testTwoNumbersWithoutOperation() {
        val input = "2 2"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testEmptyBrackets() {
        val input = "()"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testLeftBrackets() {
        val input = "(2"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testOnlyRightBracket() {
        val input = "2)"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testFunctionWithoutBrackets() {
        val input = "sin 2 "
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testEmptyFunction() {
        val input = "sin()"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMinus() {
        val input = "-2"
        val expectedTree = getUnaryMinusExpr(getNumber(2))
        val expectedCalculation = -2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleUnaryMinusWithBrackets() {
        val input = "-(-2)"
        val expectedTree = getUnaryMinusExpr(
            getBracket(
                getUnaryMinusExpr(getNumber(2))
            )
        )
        val expectedCalculation = -(-2)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testUnaryMinusAndFunction() {
        val input = "-f(2)"
        val expectedTree = getUnaryMinusExpr(getFunction("f", getNumberExpr(2)))
        val expectedCalculation = -f(2)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleUnaryMinus() {
        val input = "--2"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMinusWithoutFactor() {
        val input = "-"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryPlus() {
        val input = "+2"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testUnaryMultiply() {
        val input = "*2"
        Assertions.assertThrows(ParseException::class.java) { parser.parse(input) }
    }

    @Test
    fun testMultiply() {
        val input = "2 * 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            termCont = getTermCont(getNumber(2))
        )
        val expectedCalculation = 2 * 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleMultiply() {
        val input = "2 * 2 * 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            termCont = getTermCont(
                factor = getNumber(2),
                termCont = getTermCont(getNumber(2))
            )
        )
        val expectedCalculation = 2 * 2 * 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testMultiplyAndUnaryMinus() {
        val input = "2*-2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            termCont = getTermCont(
                factor = getNumber(2),
                sign = ::getUnaryMinus
            )
        )
        val expectedCalculation = 2 * -2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testIllegalTokenAfterMultiply() {
        val input = listOf(
            "2 *",
            "2 ** 2",
            "2 *+ 2",
            "(2 *)"
        ).map { it }
        input.forEach {
            Assertions.assertThrows(ParseException::class.java) { parser.parse(it) }
        }
    }

    @Test
    fun testAdd() {
        val input = "2 + 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(getNumber(2))
            )
        )
        val expectedCalculation = 2 + 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testSubtract() {
        val input = "2 - 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(getNumber(2))
            )
        )
        val expectedCalculation = 2 - 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleAdd() {
        val input = "2 + 2 + 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(getNumber(2)),
                exprCont = getExprCont(
                    op = "+",
                    term = getTerm(getNumber(2)),
                )
            )
        )
        val expectedCalculation = 2 + 2 + 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testDoubleSubtract() {
        val input = "2 - 2 - 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(getNumber(2)),
                exprCont = getExprCont(
                    op = "-",
                    term = getTerm(getNumber(2)),
                )
            )
        )
        val expectedCalculation = 2 - 2 - 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testSubtractAndAdd() {
        val input = "2 - 2 + 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(getNumber(2)),
                exprCont = getExprCont(
                    op = "+",
                    term = getTerm(getNumber(2)),
                )
            )
        )
        val expectedCalculation = 2 - 2 + 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testSubtractAndUnaryMinus() {
        val input = "2--2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(
                    factor = getNumber(2),
                    sign = ::getUnaryMinus
                )
            )
        )
        val expectedCalculation = 2 - -2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testAddAndMultiplyPriority() {
        val input = "2 + 2 * 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(
                    factor = getNumber(2),
                    termCont = getTermCont(getNumber(2))
                )
            )
        )
        val expectedCalculation = 2 + 2 * 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testAddAndMultiplyWithBracketsPriority() {
        val input = "(2 + 2) * 2"
        val expectedTree = getExpr(
            factor = getBracket(
                getExpr(
                    factor = getNumber(2),
                    exprCont = getExprCont(
                        op = "+",
                        term = getTerm(
                            factor = getNumber(2)
                        )
                    )
                )
            ),
            termCont = getTermCont(getNumber(2))
        )
        val expectedCalculation = (2 + 2) * 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testMultiplyAndAddPriority() {
        val input = "2 * 2 + 2"
        val expectedTree = getExpr(
            factor = getNumber(2),
            termCont = getTermCont(
                factor = getNumber(2)
            ),
            exprCont = getExprCont(
                op = "+",
                term = getTerm(getNumber(2))
            )
        )
        val expectedCalculation = 2 * 2 + 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testManyOperationsPriority() {
        val input = "6 * 5 - 4 * 3 - 2 * 2"
        val expectedTree = getExpr(
            factor = getNumber(6),
            termCont = getTermCont(getNumber(5)),
            exprCont = getExprCont(
                op = "-",
                term = getTerm(
                    factor = getNumber(4),
                    termCont = getTermCont(getNumber(3))
                ),
                exprCont = getExprCont(
                    op = "-",
                    term = getTerm(
                        factor = getNumber(2),
                        termCont = getTermCont(getNumber(2))
                    )
                )
            )
        )
        val expectedCalculation = 6 * 5 - 4 * 3 - 2 * 2
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

    @Test
    fun testIllegalTokenAfterAddOrSubtract() {
        val input = listOf(
            "2 +",
            "2 -",
            "2 ++ 2",
            "2 -+ 2",
            "2 +* 2",
            "2 -* 2",
            "(2 +)",
            "(2 -)",
        ).map { it }
        input.forEach {
            Assertions.assertThrows(ParseException::class.java) { parser.parse(it) }
        }
    }

    @Test
    fun testFromExample() {
        val input = "(1+2)*sin(-3*(7-4)+2)"
        val expectedTree = getExpr(
            factor = getBracket(
                getExpr(
                    factor = getNumber(1),
                    exprCont = getExprCont(
                        op = "+",
                        term = getTerm(getNumber(2))
                    )
                )
            ),
            termCont = getTermCont(
                factor = getFunction(
                    f = "sin",
                    getExpr(
                        factor = getNumber(3),
                        sign = ::getUnaryMinus,
                        termCont = getTermCont(
                            factor = getBracket(
                                getExpr(
                                    factor = getNumber(7),
                                    exprCont = getExprCont(
                                        op = "-",
                                        term = getTerm(getNumber(4))
                                    )
                                )
                            )
                        ),
                        exprCont = getExprCont(
                            op = "+",
                            term = getTerm(getNumber(2))
                        )
                    )
                )
            )
        )
        // in calculation sin is changed to default function
        val expectedCalculation = (1 + 2) * f(-3 * (7 - 4) + 2)
        val actualTree = parser.parse(input)
        Assertions.assertEquals(expectedTree, actualTree, BUILDING_MESSAGE)
        Assertions.assertEquals(expectedCalculation, calc(actualTree), CALCULATION_MESSAGE)
    }

}