package codebuilders

import grammar.*
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.text.StringBuilder

class ParserBuilder(
    private val grammar: Grammar,
    private val path: String,
    private val pckg: String,
) {
    fun build() {
        val code: String = generateCode()

        val file = Path(path, "Parser.kt")

        file.bufferedWriter().use {
            it.write(code)
            it.flush()
        }
    }

    private fun generateCode(): String {
        return """
            |package $pckg
            |
            |class Parser {
            |   private lateinit var lex: LexicalAnalyzer
            |   
            |   fun parse(input: String): Tree {
            |       lex = LexicalAnalyzer(input)
            |       lex.nextToken()
            |       val tree = ${generateStart()}
            |       assertToken(Token.END)
            |       return tree
            |   }
            |   
            |${generateNonTermsParsers()}
            |
            |   private fun getValue() = lex.curString
            |   
            |   private fun assertToken(expected: Token) {
            |       if (lex.curToken != expected) {
            |           throw ParseException("Unexpected end token: "  + errorInfo())
            |       }
            |   }
            |   
            |   private fun errorInfo() = "found token " + lex.curToken.name + " at position " + (lex.curPos - lex.curString.length)
            |}   
            |
            |class ParseException(message: String?) : Exception(message)
        """.trimMargin()
    }

    private fun generateStart(): String {
        val startName = grammar.startNonTerm
        val startArgs = grammar.nonTerms[startName]?.args?.split(":")?.first() ?: "("
        return "parse${startName}$startArgs)"
    }

    private fun generateNonTermsParsers(): StringBuilder {
        val sb = StringBuilder()
        grammar.nonTerms.values.forEach {
            sb.append(genNTparser(it))
            sb.append("\n\n")
        }

        return sb
    }

    private fun genNTparser(current: NonTerm): String {
        val name = current.name
        val first = grammar.first[name] ?: throw GrammarException("FIRST for $name isn't built")
        val follow = grammar.follow[name] ?: throw GrammarException("FOLLOW for $name isn't built")
        val rules = grammar.rules.filter { it.nonTermName == name }

        return """
            |   private fun parse${name.uppercase()}${current.args ?: "()"}: Tree { 
            |       val node = "${name.uppercase()}"
            |       val children = ArrayList<Tree>()
            |       return when (lex.curToken) {
            |${generateRules(rules)}
            |${generateEPSRule(first, follow, rules)}
            |           else -> throw ParseException("Unexpected end token: "  + errorInfo())
            |       }
            |   }    
        """.trimMargin()
    }

    private fun generateRules(rules: List<Rule>): StringBuilder {
        val sb = StringBuilder("\t\t   ")
        rules.forEach { rule ->
            if (rule.states[0] == Grammar.EPS) return@forEach

            val firstForRule = grammar.getFist(rule.states)
            val tokens = firstForRule.joinToString(", ") { genToken(it) }

            sb.append(
                """
            |$tokens -> {
            |${genRule(rule)}
            |           }
            |           
            """.trimMargin()
            )

        }
        return sb
    }

    private fun genRule(rule: Rule): StringBuilder {
        val tt = "\t\t\t\t"
        val sb = StringBuilder()
        rule.states.forEachIndexed { i, state ->
            if (grammar.terms.containsKey(state)) {
                sb.append(tt + "assertToken(${genToken(state)})\n")
                rule.codes[i]?.let { sb.append(tt + genCode(it) + "\n") }
                sb.append(tt + "children.add(Tree(lex.curString))" + "\n")
                sb.append(tt + "lex.nextToken()" + "\n")
            } else {
                val nonTerm = grammar.nonTerms[state] ?: throw GrammarException("Unknown non terminal $state")
                val name = nonTerm.name
                sb.append(tt + "val ${name}_tree = parse${name}${rule.args[i] ?: "()"}" + "\n")
                sb.append(tt + "children.add(${name}_tree)" + "\n")
                val type = genType(nonTerm)
                if (type != null) {
                    sb.append(tt + "val ${name}_res = ${name}_tree.res as $type" + "\n")
                }
                rule.codes[i]?.let { sb.append(tt + genCode(it) + "\n") }
            }
        }
        val res = grammar.nonTerms[rule.nonTermName]?.returns?.let { " res=res," } ?: ""
        sb.append(tt + "Tree(node,$res children=children)")
        return sb
    }

    private fun generateEPSRule(first: Set<String>, follow: Set<String>, rules: List<Rule>): String {
        if (first.contains(Grammar.EPS)) {
            val rule = rules.find { it.states[0] == Grammar.EPS } ?: throw GrammarException("No rule for eps")
            val res = grammar.nonTerms[rule.nonTermName]?.returns?.let { " res=res," } ?: ""
            return """
            |           ${follow.joinToString(", ") { genToken(it) }} -> {
            |               ${rule.codes[0]?.let { genCode(it) } ?: ""}
            |               ${"Tree(node,$res children=children)"}
            |           }    
            """.trimMargin()
        }
        return ""
    }

    private fun genToken(t: String) = "Token.${t.uppercase()}"

    private fun genType(nt: NonTerm) = nt.returns?.substring(1, nt.returns.length - 1)

    private fun genCode(code: String) = code.substring(1, code.length - 1).trim()

}