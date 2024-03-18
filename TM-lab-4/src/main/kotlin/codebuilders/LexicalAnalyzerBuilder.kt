package codebuilders

import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter

class LexicalAnalyzerBuilder(
    private val terms: Map<String, String>,
    private val path: String,
    private val pckg: String,
) {
    fun build() {
        val code: String = generateCode()

        val file = Path(path, "LexicalAnalyzer.kt")

        file.bufferedWriter().use {
            it.write(code)
            it.flush()
        }
    }

    private fun generateCode(): String {
        val tokens = terms.map { it.key.uppercase() }
        val tokensAndPattens = terms.map { "Pattern.compile(${it.value}) to Token.${it.key.uppercase()}" }

        return """
            |package $pckg
            |
            |import java.util.regex.Pattern
            |
            |enum class Token {
            |   START, END, ${tokens.joinToString(", ")}
            |}
            |
            |class LexicalAnalyzer(private val source: String) {
            |    private val matcher = Pattern.compile("").matcher(source)
            |    var curPos = 0
            |        private set
            |    var curToken = Token.START
            |        private set
            |    var curString: String = ""
            |        private set
            |
            |    private companion object {
            |        private val WS = Pattern.compile("[ \t\r\n]+")
            |        private val TOKENS: List<Pair<Pattern, Token>> = listOf(
            |            ${tokensAndPattens.joinToString(", ")}
            |        ).sortedBy { it.first.pattern().length }.reversed()
            |    }
            |
            |    fun nextToken() {
            |        skipWhiteSpaces()
            |        if (curPos == source.length) {
            |            curString = ""
            |            curToken = Token.END
            |            return
            |        }
            |
            |        TOKENS.forEach { (pattern, token) ->
            |            matcher.usePattern(pattern)
            |            if (matcher.lookingAt()) {
            |                curString = matcher.group()
            |                curPos += matcher.end()
            |                matcher.reset(source.substring(curPos))
            |                curToken = token
            |              return
            |           }
            |        }
            |
            |        throw LexicalException("Illegal character at position " + curPos)
            |    }
            |
            |    private fun skipWhiteSpaces() {
            |        matcher.usePattern(WS)
            |        if (matcher.lookingAt()) {
            |            curPos += matcher.end()
            |            matcher.reset(source.substring(curPos))
            |        }
            |   }
            |}
            |
            |class LexicalException(message: String?) : Exception(message)
        """.trimMargin()
    }
}