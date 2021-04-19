// Generated from br/ufscar/dc/compiladores/iprocess/iprocess.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.iprocess;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link iprocessParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface iprocessVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link iprocessParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(iprocessParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(iprocessParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#decl_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_group(iprocessParser.Decl_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#decl_one}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_one(iprocessParser.Decl_oneContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#process}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcess(iprocessParser.ProcessContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(iprocessParser.ShowContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#cmdFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFilter(iprocessParser.CmdFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#filterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterType(iprocessParser.FilterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#cmdMorpho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdMorpho(iprocessParser.CmdMorphoContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#morphfilterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMorphfilterType(iprocessParser.MorphfilterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#cmdThreshold}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdThreshold(iprocessParser.CmdThresholdContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#showGrid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGrid(iprocessParser.ShowGridContext ctx);
	/**
	 * Visit a parse tree produced by {@link iprocessParser#showSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSimple(iprocessParser.ShowSimpleContext ctx);
}