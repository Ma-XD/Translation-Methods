import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import parser.Parser
import java.lang.RuntimeException

class CalcTest {
    private val parser = Parser()

    private fun getRes(input: String): Int {
        return parser.parse(input).res?.let { it as Int } ?: throw RuntimeException("Parser doesn't return result")
    }

    @Test
    fun test1() {
        val input = "2 + 2"
        Assertions.assertEquals(4, getRes(input))
    }

    @Test
    fun test2() {
        val input = "3 - 2"
        Assertions.assertEquals(1, getRes(input))
    }

    @Test
    fun test3() {
        val input = "6 - 3 - 2 - 1"
        Assertions.assertEquals(0, getRes(input))
    }

    @Test
    fun test4() {
        val input = "2 * 3"
        Assertions.assertEquals(6, getRes(input))
    }

    @Test
    fun test5() {
        val input = "2 * (2 + 3)"
        Assertions.assertEquals(10, getRes(input))
    }


    @Test
    fun test6() {
        val input = "6 - 2 * 3"
        Assertions.assertEquals(0, getRes(input))
    }


    @Test
    fun test7() {
        val input = "16 / 4 / 2"
        Assertions.assertEquals(2, getRes(input))
    }

    @Test
    fun test8() {
        val input = "2 * (4 - 1 - 1)"
        Assertions.assertEquals(4, getRes(input))
    }

}
