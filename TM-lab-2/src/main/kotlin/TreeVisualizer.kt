import guru.nidi.graphviz.attribute.Attributes
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.model.*
import guru.nidi.graphviz.toGraphviz
import parser.Tree
import java.io.File

class TreeVisualizer {
    private class IdFactory {
        private var id = 0
        fun getId() = (id++).toString()
    }

    private lateinit var idFactory: IdFactory

    fun visualize(tree: Tree, file: File) {
        idFactory = IdFactory()
        val graph = Factory.mutGraph()
        buildGraphFromTree(graph, parent = tree, parentId = idFactory.getId())
        graph.toGraphviz().render(Format.SVG).toFile(file)
    }

    private fun buildGraphFromTree(graph: MutableGraph, parent: Tree, parentId: String) {
        if (parent.value == "n" || parent.value == "f") return

        val parentNode = Factory.mutNode(parentId)
        parentNode.setLabel(parent.value)

        if ((parent.value == "E'" || parent.value == "T'")
            && parent.children.isEmpty()
        ) {
            val epsNode = Factory.mutNode(idFactory.getId())
            epsNode.setLabel("eps")
            graph.add(parentNode.addLink(epsNode))
            return
        }

        parent.children.forEach { child ->
            val childId = idFactory.getId()
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
