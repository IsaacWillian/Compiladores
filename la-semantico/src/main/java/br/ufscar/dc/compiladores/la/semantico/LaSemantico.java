
package br.ufscar.dc.compiladores.la.semantico;

/**
 * A classe LaSemantico extende a classe laBaseVisitor,
 * dessa forma é possível verificar regras específicas da linguagem como equivalência de tipos
 * para posterior geração de código de forma correta.
 *
 * @author isaacwillian
 */
public class LaSemantico extends laBaseVisitor<Void> {
    Escopos escope = new Escopos();


    @Override
    public Void visitPrograma(laParser.ProgramaContext ctx) {
        escope.criarNovoEscopo();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_local(laParser.Declaracao_localContext ctx) {
        if (ctx.variavel() != null) {

            String ret = LaSemanticoUtil.verificaTipo(escope, ctx.variavel());
        }
        return super.visitDeclaracao_local(ctx);
    }

    //Apenas verifica se a variável utilizada ja foi declarada anteriormente, não verificando seu tipo.
    @Override
    public Void visitCmdLeia(laParser.CmdLeiaContext ctx) {
        for (laParser.IdentificadorContext i : ctx.identificador()) {
            String ident = LaSemanticoUtil.verificarIdentificador(i);
            if (!escope.obterEscopoAtual().existe(ident)) {
                LaSemanticoUtil.adicionarErroSemantico(ctx.getStart(), "identificador " + ident + " nao declarado");
            }
        }
        return super.visitCmdLeia(ctx);
    }


    @Override
    public Void visitCmdEscreva(laParser.CmdEscrevaContext ctx) {
        String tipo = "";
        TabelaDeSimbolos tabela = escope.obterEscopoAtual();
        for (laParser.ExpressaoContext ex : ctx.expressao())
            tipo = LaSemanticoUtil.verificarTipo(tabela, ex);


        return super.visitCmdEscreva(ctx);
    }

    public Void visitCmdAtribuicao(laParser.CmdAtribuicaoContext ctx) { // Expressao está retornando tipos errados
        TabelaDeSimbolos tabela = escope.obterEscopoAtual();
        String ident = LaSemanticoUtil.verificarIdentificador(ctx.identificador());
        String tipoIdent = tabela.verificar(ident);
        String tipo = LaSemanticoUtil.verificarTipo(tabela, ctx.expressao());
        if (ctx.getStart().getText().equals("^")) {
            ident = "^" + ident;
        }
        if (!LaSemanticoUtil.equivalenciaDeTipos(tipo, tipoIdent)) {
            LaSemanticoUtil.adicionarErroSemantico(ctx.getStart(), "atribuicao nao compativel para " + ident);
        }
        return super.visitCmdAtribuicao(ctx);
    }

    public Void visitCmdEnquanto(laParser.CmdEnquantoContext ctx) {
        TabelaDeSimbolos tabela = escope.obterEscopoAtual();
        String tipo = LaSemanticoUtil.verificarTipo(tabela, ctx.expressao());


        return super.visitCmdEnquanto(ctx);
    }

}