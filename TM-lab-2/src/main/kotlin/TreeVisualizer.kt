import guru.nidi.graphviz.attribute.Attributes
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.model.*
import guru.nidi.graphviz.toGraphviz
import parser.Tree
import java.io.File

class TreeVisualizer {
    private object UID {
        private var id = 0
        fun getUID() = (id++).toString()
    }

    fun visualize(tree: Tree, file: File) {
        val graph = Factory.mutGraph()
        buildGraphFromTree(graph, parent = tree, parentId = UID.getUID())
        graph.toGraphviz().render(Format.SVG).toFile(file)
    }

    private fun buildGraphFromTree(graph: MutableGraph, parent: Tree, parentId: String) {
        if (parent.value == "n" || parent.value == "f") return

        val parentNode = Factory.mutNode(parentId)
        parentNode.setLabel(parent.value)

        parent.children.forEach { child ->
            val childId = UID.getUID()
            val childNode = Factory.mutNode(childId)
            childNode.setLabel(child.value)
            graph.add(parentNode.addLink(childNode))

            buildGraphFromTree(graph, child, childId)
        }
    }

    private fun MutableNode.setLabel(label: String) {
        this.attrs().add(Attributes.attr("label", label))
    }
}
