import codebuilders.LexicalAnalyzerBuilder
import codebuilders.ParserBuilder
import grammar.Grammar
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Files
import java.nio.file.Path

private const val INPUT_PATH = "src/main/resources"
private const val GENERATED_PATH = "src/main/kotlin/parser"

fun getGrammar(fi: Path): Grammar {
    Files.newInputStream(fi).use { `is` ->
        val lexer = InputGrammarLexer(CharStreams.fromStream(`is`))
        val parser = InputGrammarParser(CommonTokenStream(lexer))
        val grammar = parser.run().grammar

//        println(grammar.first.toList().joinToString("\n") { it.first + " : " + it.second.joinToString(", ") })
//        println("\n")
//        println(grammar.follow.toList().joinToString("\n") { it.first + " : " + it.second.joinToString(", ") })
//        println("\n")

        return grammar
    }
}

fun main() {
    val fi = Path.of(INPUT_PATH, "calc.txt")
    val grammar = getGrammar(fi)
    LexicalAnalyzerBuilder(grammar.terms, GENERATED_PATH, "parser").build()
    ParserBuilder(grammar, GENERATED_PATH, "parser").build()
}