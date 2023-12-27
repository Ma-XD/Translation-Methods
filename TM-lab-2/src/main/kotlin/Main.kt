import parser.Parser
import parser.Tree

fun printTree(tree: Tree) {
    recursivePrintTree(tree, 0)
}

fun recursivePrintTree(tree: Tree, deep: Int) {
    val tabs = "_".repeat(deep)
    println("$tabs${tree.node}")
    tree.children.forEach { recursivePrintTree(it, deep + 1) }
}

fun main(args: Array<String>) {
    printTree(Parser().parse("-1".byteInputStream()))
}