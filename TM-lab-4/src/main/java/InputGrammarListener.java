// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-4/src/main/antlr/InputGrammar.g4 by ANTLR 4.13.1

import grammar.*;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InputGrammarParser}.
 */
public interface InputGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(InputGrammarParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(InputGrammarParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#parseGrammar}.
	 * @param ctx the parse tree
	 */
	void enterParseGrammar(InputGrammarParser.ParseGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#parseGrammar}.
	 * @param ctx the parse tree
	 */
	void exitParseGrammar(InputGrammarParser.ParseGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#parseRules}.
	 * @param ctx the parse tree
	 */
	void enterParseRules(InputGrammarParser.ParseRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#parseRules}.
	 * @param ctx the parse tree
	 */
	void exitParseRules(InputGrammarParser.ParseRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#parseStates}.
	 * @param ctx the parse tree
	 */
	void enterParseStates(InputGrammarParser.ParseStatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#parseStates}.
	 * @param ctx the parse tree
	 */
	void exitParseStates(InputGrammarParser.ParseStatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#parseNonTerm}.
	 * @param ctx the parse tree
	 */
	void enterParseNonTerm(InputGrammarParser.ParseNonTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#parseNonTerm}.
	 * @param ctx the parse tree
	 */
	void exitParseNonTerm(InputGrammarParser.ParseNonTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#parseTerms}.
	 * @param ctx the parse tree
	 */
	void enterParseTerms(InputGrammarParser.ParseTermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#parseTerms}.
	 * @param ctx the parse tree
	 */
	void exitParseTerms(InputGrammarParser.ParseTermsContext ctx);
}