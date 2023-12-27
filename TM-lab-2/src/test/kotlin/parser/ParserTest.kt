package parser

import parser.exception.ParseException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParserTest {
    private val parser = Parser()

    private companion object {
        fun getNumberTree() = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        Tree(
                            "F", listOf(
                                Tree("n")
                            )
                        ),
                        Tree("T'")
                    )
                ),
                Tree("E'")
            )
        )

        fun getBracketTree(inside: Tree) = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        Tree(
                            "F", listOf(
                                Tree("("),
                                inside,
                                Tree(")")
                            )
                        ),
                        Tree("T'")
                    )
                ),
                Tree("E'")
            )
        )

        fun getFunctionTree(inside: Tree) = Tree(
            "E", listOf(
                Tree(
                    "T", listOf(
                        Tree(
                            "F", listOf(
                                Tree("f("),
                                inside,
                                Tree(")")
                            )
                        ),
                        Tree("T'")
                    )
                ),
                Tree("E'")
            )
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
    fun testFunction() {
        val input = "f(1)".byteInputStream()
        val expected = getFunctionTree(getNumberTree())
        Assertions.assertEquals(expected, parser.parse(input))
    }
}