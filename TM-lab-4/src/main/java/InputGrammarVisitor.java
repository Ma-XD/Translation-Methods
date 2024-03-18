// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-4/src/main/antlr/InputGrammar.g4 by ANTLR 4.13.1

import grammar.*;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InputGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InputGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(InputGrammarParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#parseGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseGrammar(InputGrammarParser.ParseGrammarContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#parseRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseRules(InputGrammarParser.ParseRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#parseStates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseStates(InputGrammarParser.ParseStatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#parseNonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseNonTerm(InputGrammarParser.ParseNonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#parseTerms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseTerms(InputGrammarParser.ParseTermsContext ctx);
}