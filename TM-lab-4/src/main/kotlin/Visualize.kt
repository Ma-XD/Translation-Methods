import parser.Parser
import java.io.File

const val PATH = "src/main/resources"

fun main() {
    val outputFile = File(File(PATH), "tree")

    val tree = Parser().parse("(1+2)*(-3*(7-4)+2)")
    TreeVisualizer(tree).visualize(outputFile)
}