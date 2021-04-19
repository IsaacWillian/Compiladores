package br.ufscar.dc.compiladores.iprocess;

public class IprocessSemantico extends iprocessBaseVisitor<Void> {

    /** Como a principal função da linguagem é processar uma imagem ou comparar
    *   o processamento para várias, então não possui escopos
    */
     TabelaDeSimbolos tabela = new TabelaDeSimbolos();


    // Adiciona na tabela a variável, seu tipo como "group" e o tamanho do grupo.
    @Override
    public Void visitDecl_group(iprocessParser.Decl_groupContext ctx) {
        String ident = ctx.IDENT().toString();
        tabela.adicionar(ident,"group",ctx.PATH().size());

        return super.visitDecl_group(ctx);
    }

    // Adiciona na tabela a variável, seu tipo como "one" e o tamanho do grupo como 1.
    @Override
    public Void visitDecl_one(iprocessParser.Decl_oneContext ctx) {
        String ident = ctx.IDENT().toString();
        tabela.adicionar(ident,"one",1);

        return super.visitDecl_one(ctx);
    }

    // Verifica se a variável existe e se o tipo é group para poder ser usado esse comando
    @Override
    public Void visitShowGrid(iprocessParser.ShowGridContext ctx) {
        String ident = ctx.IDENT().toString();
        if(tabela.existe(ident)){
            String tipo = tabela.verificar(ident);
            if(!tipo.equals("group")){
                Util.addErrosSemanticos(ctx.getStart().getLine(),"Para usar essa função o tipo deve ser GROUP");
            }
        }
        else{
            Util.addErrosSemanticos(ctx.getStart().getLine(),"Identificador "+ ident + " não declarado");
        }

        return super.visitShowGrid(ctx);
    }


    // Verifica se a variável existe e se o tipo é one para poder ser usado esse comando
    @Override
    public Void visitShowSimple(iprocessParser.ShowSimpleContext ctx) {
        String ident = ctx.IDENT().toString();
        if(tabela.existe(ident)){
            String tipo = tabela.verificar(ident);
            if(!tipo.equals("one")){
                Util.addErrosSemanticos(ctx.getStart().getLine(),"Para usar essa função o tipo deve ser ONE");
            }
        }
        else{
            Util.addErrosSemanticos(ctx.getStart().getLine(),"Identificador "+ ident + " não declarado");
        }
        return super.visitShowSimple(ctx);
    }

    // Verifica se a variável existe
    @Override
    public Void visitCmdFilter(iprocessParser.CmdFilterContext ctx) {
        String ident = ctx.IDENT().toString();
        if(!tabela.existe(ident)) {
            Util.addErrosSemanticos(ctx.getStart().getLine(), "Identificador "+ ident + " não declarado");
        }

        return super.visitCmdFilter(ctx);
    }

    // Verifica se a variável existe
    @Override
    public Void visitCmdMorpho(iprocessParser.CmdMorphoContext ctx) {
        String ident = ctx.IDENT().toString();
        if(!tabela.existe(ident)) {
            Util.addErrosSemanticos(ctx.getStart().getLine(), "Identificado "+ ident + " não declarado");
        }

        return super.visitCmdMorpho(ctx);
    }

    // Verifica se a variável existe
    @Override
    public Void visitCmdThreshold(iprocessParser.CmdThresholdContext ctx) {
        String ident = ctx.IDENT().getText();
        if(!tabela.existe(ident)){
            Util.addErrosSemanticos(ctx.getStart().getLine(),"Identificador "+ ident + " não declarado");
        }
        return super.visitCmdThreshold(ctx);
    }
}
