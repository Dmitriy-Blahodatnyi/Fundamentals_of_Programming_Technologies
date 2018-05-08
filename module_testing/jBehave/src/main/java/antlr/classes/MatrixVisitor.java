// Generated from /home/dima/Fundamentals_of_Programming_Technologies/module_testing/jBehave/src/main/java/antlr/Matrix.g4 by ANTLR 4.7
package antlr.classes;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MatrixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MatrixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code RootRule}
	 * labeled alternative in {@link MatrixParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootRule(MatrixParser.RootRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToSetVariable}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToSetVariable(MatrixParser.ToSetVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExecuteExpression}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteExpression(MatrixParser.ExecuteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeAssignment}
	 * labeled alternative in {@link MatrixParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeAssignment(MatrixParser.MakeAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToMultiple}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToMultiple(MatrixParser.ToMultipleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakePlus}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakePlus(MatrixParser.MakePlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToInverse}
	 * labeled alternative in {@link MatrixParser#multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToInverse(MatrixParser.ToInverseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeMultiple}
	 * labeled alternative in {@link MatrixParser#multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeMultiple(MatrixParser.MakeMultipleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeInverse}
	 * labeled alternative in {@link MatrixParser#inverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeInverse(MatrixParser.MakeInverseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link MatrixParser#inverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(MatrixParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeNumber}
	 * labeled alternative in {@link MatrixParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeNumber(MatrixParser.MakeNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeMatrix}
	 * labeled alternative in {@link MatrixParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeMatrix(MatrixParser.MakeMatrixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MatrixParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MatrixParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MakeBraces}
	 * labeled alternative in {@link MatrixParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMakeBraces(MatrixParser.MakeBracesContext ctx);
}