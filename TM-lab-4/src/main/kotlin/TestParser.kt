import parser.Parser
import java.io.File

const val PATH = "src/main/resources"

fun main() {
    val outputFile = File(File(PATH), "calc_tree")

    val tree = Parser().parse("16 / (3 + 1) / 2")
    TreeVisualizer(tree).visualize(outputFile)
    println(tree.res ?: "tree doesn't return anything")
}