package parser

data class Tree(val node: String, val children: List<Tree> = emptyList())
