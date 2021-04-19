// Generated from br/ufscar/dc/compiladores/iprocess/iprocess.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.iprocess;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link iprocessParser}.
 */
public interface iprocessListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link iprocessParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(iprocessParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(iprocessParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(iprocessParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(iprocessParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#decl_group}.
	 * @param ctx the parse tree
	 */
	void enterDecl_group(iprocessParser.Decl_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#decl_group}.
	 * @param ctx the parse tree
	 */
	void exitDecl_group(iprocessParser.Decl_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#decl_one}.
	 * @param ctx the parse tree
	 */
	void enterDecl_one(iprocessParser.Decl_oneContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#decl_one}.
	 * @param ctx the parse tree
	 */
	void exitDecl_one(iprocessParser.Decl_oneContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#process}.
	 * @param ctx the parse tree
	 */
	void enterProcess(iprocessParser.ProcessContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#process}.
	 * @param ctx the parse tree
	 */
	void exitProcess(iprocessParser.ProcessContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(iprocessParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(iprocessParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#cmdFilter}.
	 * @param ctx the parse tree
	 */
	void enterCmdFilter(iprocessParser.CmdFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#cmdFilter}.
	 * @param ctx the parse tree
	 */
	void exitCmdFilter(iprocessParser.CmdFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#filterType}.
	 * @param ctx the parse tree
	 */
	void enterFilterType(iprocessParser.FilterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#filterType}.
	 * @param ctx the parse tree
	 */
	void exitFilterType(iprocessParser.FilterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#cmdMorpho}.
	 * @param ctx the parse tree
	 */
	void enterCmdMorpho(iprocessParser.CmdMorphoContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#cmdMorpho}.
	 * @param ctx the parse tree
	 */
	void exitCmdMorpho(iprocessParser.CmdMorphoContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#morphfilterType}.
	 * @param ctx the parse tree
	 */
	void enterMorphfilterType(iprocessParser.MorphfilterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#morphfilterType}.
	 * @param ctx the parse tree
	 */
	void exitMorphfilterType(iprocessParser.MorphfilterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#cmdThreshold}.
	 * @param ctx the parse tree
	 */
	void enterCmdThreshold(iprocessParser.CmdThresholdContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#cmdThreshold}.
	 * @param ctx the parse tree
	 */
	void exitCmdThreshold(iprocessParser.CmdThresholdContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#showGrid}.
	 * @param ctx the parse tree
	 */
	void enterShowGrid(iprocessParser.ShowGridContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#showGrid}.
	 * @param ctx the parse tree
	 */
	void exitShowGrid(iprocessParser.ShowGridContext ctx);
	/**
	 * Enter a parse tree produced by {@link iprocessParser#showSimple}.
	 * @param ctx the parse tree
	 */
	void enterShowSimple(iprocessParser.ShowSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link iprocessParser#showSimple}.
	 * @param ctx the parse tree
	 */
	void exitShowSimple(iprocessParser.ShowSimpleContext ctx);
}