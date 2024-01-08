import guru.nidi.graphviz.attribute.Attributes
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.model.*
import guru.nidi.graphviz.toGraphviz
import parser.Tree
import java.io.File

class TreeVisualizer(tree: Tree) {
    private object IdFactory {
        private var id = 0
        fun getId() = (id++).toString()
    }

    private val graph = Factory.mutGraph()

    init {
        buildGraphFromTree(tree, IdFactory.getId())
    }

    fun visualize(file: File, format: Format = Format.SVG) {
        graph.toGraphviz().render(format).toFile(file)
    }

    private fun buildGraphFromTree(parent: Tree, parentId: String) {
        if (parent.value == "n" || parent.value == "f") return

        val parentNode = Factory.mutNode(parentId)
        parentNode.setLabel(parent.value)

        if ((parent.value == "E'" || parent.value == "T'")
            && parent.children.isEmpty()
        ) {
            val epsNode = Factory.mutNode(IdFactory.getId())
            epsNode.setLabel("eps")
            graph.add(parentNode.addLink(epsNode))
            return
        }

        parent.children.forEach { child ->
            val childId = IdFactory.getId()
            val childNode = Factory.mutNode(childId)
            childNode.setLabel(child.value)
            graph.add(parentNode.addLink(childNode))

            buildGraphFromTree(child, childId)
        }
    }

    private fun MutableNode.setLabel(label: String) {
        this.attrs().add(Attributes.attr("label", label))
    }
}
