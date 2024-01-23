// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-3/src/main/antlr/PrefixExpr.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrefixExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrefixExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(PrefixExprParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#prefixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(PrefixExprParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(PrefixExprParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(PrefixExprParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#ifBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBranch(PrefixExprParser.IfBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#elseBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBranch(PrefixExprParser.ElseBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PrefixExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrefixExprParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(PrefixExprParser.OperandContext ctx);
}