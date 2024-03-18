package grammar

data class Rule(
    val nonTermName: String,
    val states: List<String>,
    val args: List<String?>,
    val codes: List<String?>,
)