package grammar

import java.util.HashMap
import java.util.HashSet

class Grammar(
    val rules: List<Rule>,
    nonTermsNotFiltered: List<NonTerm>,
    val terms: HashMap<String, String>,
) {
    val startNonTerm = nonTermsNotFiltered[0].name
    val nonTerms: Map<String, NonTerm>
    lateinit var first: Map<String, MutableSet<String>>
        private set
    lateinit var follow: Map<String, MutableSet<String>>
        private set

    init {
        val groups = nonTermsNotFiltered.groupBy { it.name }
        groups.values.forEach { group ->
            if (group.any { it != group[0] }) throw GrammarException("different args or returns for 0ne non terminal")
        }
        nonTerms = groups.mapValues { it.value[0] }

        makeFirst()
        makeFollow()
        checkLL1()
    }

    private fun makeFirst() {
        first = nonTerms.map { it.key to HashSet<String>() }.toMap()

        var change = true
        while (change) {
            change = false
            rules.forEach { rule ->
                val a = rule.nonTermName
                val aFist = first[a] ?: throw GrammarException("Unknown non terminal $a")
                val size = aFist.size
                aFist += getFist(rule.states)
                if (size != aFist.size) {
                    change = true
                }
            }
        }
    }

    fun getFist(states: List<String>): Set<String> {
        if (states.isEmpty()) return setOf(EPS)
        val current = states[0]
        if (terms.containsKey(current)) return setOf(current)

        val res = first[current] ?: throw GrammarException("Unknown non terminal $current")

        if (res.contains(EPS)) return res + getFist(states.subList(1, states.size))
        return res
    }

    private fun makeFollow() {
        follow = nonTerms.map { it.key to HashSet<String>() }.toMap()


        val startFollow = follow[startNonTerm] ?: throw GrammarException("")
        startFollow += END
        var change = true
        while (change) {
            change = false
            rules.forEach { rule ->
                val a = rule.nonTermName
                rule.states.forEachIndexed { i, state ->
                    if (terms.containsKey(state)) return@forEachIndexed

                    val bFollow = follow[state] ?: throw GrammarException("No non terminal '$state'")
                    val size = bFollow.size
                    val right = getFist(rule.states.subList(i + 1, rule.states.size))
                    bFollow += right.minus(EPS)
                    if (right.isEmpty() || right.contains(EPS)) {
                        bFollow += follow[a] ?: throw GrammarException("No non terminal '$a'")
                    }
                    if (size != bFollow.size) {
                        change = true
                    }
                }
            }
        }
    }

    private fun checkLL1() {
        nonTerms.keys.forEach { A ->
            val rulesFromA = rules.filter { it.nonTermName == A }

            rulesFromA.forEach { r1 ->
                rulesFromA.forEach { r2 ->
                    if (r1 != r2) {
                        val alpha = r1.states[0]
                        val betta = r2.states[0]
                        val firstAlpha = getFist(listOf(alpha))
                        val firstBetta = getFist(listOf(betta))

                        if ((firstAlpha intersect firstBetta).isNotEmpty()) throw GrammarException("Grammar is not LL1")

                        if (firstAlpha.contains(EPS)) {
                            val followA = follow[A] ?: throw GrammarException("No follow for $A")
                            if ((firstBetta intersect followA).isNotEmpty()) throw GrammarException("Grammar is not LL1")
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val EPS = "eps"
        const val END = "end"
    }
}