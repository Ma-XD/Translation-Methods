import parser.Parser
import java.io.File

const val PATH = "src/main/resources"
val INPUT_DIR = File(PATH, "input")
val OUTPUT_DIR = File(PATH, "output")

fun main() {
    val fileName = "example.txt"
    val inputFile = File(INPUT_DIR, fileName)
    val outputFile = File(OUTPUT_DIR, inputFile.nameWithoutExtension)

    val tree = Parser().parse(inputFile.inputStream())
    TreeVisualizer(tree).visualize(outputFile)
}