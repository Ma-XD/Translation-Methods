// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-3/src/main/antlr/PrefixExpr.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrefixExprParser}.
 */
public interface PrefixExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(PrefixExprParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(PrefixExprParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(PrefixExprParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(PrefixExprParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(PrefixExprParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(PrefixExprParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(PrefixExprParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(PrefixExprParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#ifBranch}.
	 * @param ctx the parse tree
	 */
	void enterIfBranch(PrefixExprParser.IfBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#ifBranch}.
	 * @param ctx the parse tree
	 */
	void exitIfBranch(PrefixExprParser.IfBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void enterElseBranch(PrefixExprParser.ElseBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void exitElseBranch(PrefixExprParser.ElseBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PrefixExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PrefixExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixExprParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(PrefixExprParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixExprParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(PrefixExprParser.OperandContext ctx);
}