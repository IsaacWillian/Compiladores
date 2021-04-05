package br.ufscar.dc.compiladores.la.semantico;

/**
 * A classe LaGerador também extende a class laBaseVisitor e permite a geração de Código C
 * equivalente ao código da linguagem LA.
 *
 * Se o código não possui erros semânticos então cada método gera o código C equivalente a suas funções.
 *
 * As funções possuem funcionamento semelhante, escrevendo sua parte de código (se houver) e
 * acessando as outras regras que estão dentro de seus contextos.
 *
 * Algumas funções possuem regras expecificas que estão explicadas em cada uma.
 *
 * @author isaacwillian
 */


public class LaGerador extends laBaseVisitor<Void>{

    StringBuilder saida;
    TabelaDeSimbolos tabela;

    public LaGerador(){
        saida = new StringBuilder();
        tabela = new TabelaDeSimbolos();
    }

    // Escreve os códigos iniciais e finais da linguagem C e acessa as outras regras definidas.
    @Override
    public Void visitPrograma(laParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        if (ctx.declaracoes() != null) {
            visitDeclaracoes(ctx.declaracoes());
        }
        saida.append("int main(){\n");
        visitCorpo(ctx.corpo());
        saida.append("\treturn 0; \n  }");

        return null;
    }

    @Override
    public Void visitCorpo(laParser.CorpoContext ctx) {
        for(int i=0;i<ctx.declaracao_local().size();i++){
            visitDeclaracao_local(ctx.declaracao_local(i));
        }
        for(int j=0;j<ctx.cmd().size();j++){
            visitCmd(ctx.cmd(j));
        }
        return null;
    }

    @Override
    public java.lang.Void visitDeclaracoes(laParser.DeclaracoesContext ctx) {
        for(int i=0 ; i<ctx.decl_local_global().size();i++){
            visitDecl_local_global(ctx.decl_local_global(i));
        }


        return null;
    }

    @Override
    public Void visitDecl_local_global(laParser.Decl_local_globalContext ctx) {
        if(ctx.declaracao_local() != null){
            visitDeclaracao_local(ctx.declaracao_local());
        }
        else{
            visitDeclaracao_global(ctx.declaracao_global());
        }

        return null;
    }

    // Se a variável é constante ela é definida sem declarar seu tipo
    @Override
    public Void visitDeclaracao_local(laParser.Declaracao_localContext ctx) {
        if(ctx.variavel() != null) {
            visitVariavel(ctx.variavel());
        }
        else if(ctx.tipo_basico() != null){
            saida.append("#define ");
            saida.append(ctx.IDENT().getText()+" ");
            saida.append(ctx.valor_constante().getText());
            saida.append("\n");
        }
        else{
            // declaracao tipo
        }


            return null;
    }

    //De acordo com o tipo retornado deve ser escrita uma declaração diferente.
    @Override
    public Void visitVariavel(laParser.VariavelContext ctx) {
        String tipo = LaSemanticoUtil.verificarTipo(ctx.tipo(),false);
        if(tipo.equals("registro")){
            saida.append("struct{");
            saida.append("}");
        }
        if(tipo.equals("inteiro")){
            saida.append("\tint ");
        }
        else if(tipo.equals("real")){
            saida.append("\tfloat ");
        }
        else if(tipo.equals("literal")){
            saida.append("\tchar ");
        }
        String ident = LaSemanticoUtil.verificarIdentificador(ctx.identificador(0));
        tabela.adicionar(ident,tipo);
        saida.append(ident);
        if(tipo.equals("literal")){
            saida.append("[80]");
        }
        for(int i=1;i<ctx.identificador().size();i++) {
            ident = LaSemanticoUtil.verificarIdentificador(ctx.identificador(i));
            saida.append(","+ident);
            if(tipo.equals("literal")){
                saida.append("[80]");
            }
            tabela.adicionar(ident,tipo);


        }
        saida.append(";\n");

        return null;
    }

    @Override
    public Void visitTipo(laParser.TipoContext ctx) {
        if(ctx.registro() != null){
            visitRegistro(ctx.registro());
        }


        return null;
    }

    @Override
    public Void visitRegistro(laParser.RegistroContext ctx) {
        for (int i = 0; i<ctx.variavel().size();i++){
            visitVariavel(ctx.variavel(i));
        }

        return null;
    }

    @Override
    public Void visitCmd(laParser.CmdContext ctx) {
        if(ctx.cmdLeia() != null){
            visitCmdLeia(ctx.cmdLeia());
        }
        else if (ctx.cmdEscreva() != null){
            visitCmdEscreva(ctx.cmdEscreva());
        }
        else if(ctx.cmdAtribuicao() != null){
            visitCmdAtribuicao(ctx.cmdAtribuicao());
        }
        else if(ctx.cmdSe() != null){
            visitCmdSe(ctx.cmdSe());
        }
        else if(ctx.cmdPara() != null){
            visitCmdPara(ctx.cmdPara());
        }
        else if(ctx.cmdEnquanto() != null){
            visitCmdEnquanto(ctx.cmdEnquanto());
        }
        else if(ctx.cmdFaca() != null){
            visitCmdFaca(ctx.cmdFaca());
        }
        else if(ctx.cmdCaso() != null){
            visitCmdCaso(ctx.cmdCaso());
        }

        return null;
    }

    // O tipo lido deve ser escrito de forma diferente de acordo com o tipo da variável.
    @Override
    public Void visitCmdLeia(laParser.CmdLeiaContext ctx) {
        String aux ="";
        for (int i =0;i<ctx.identificador().size();i++){
            String ident = LaSemanticoUtil.verificarIdentificador(ctx.identificador(i));
            String tipo = tabela.verificar(ident);
            if(tipo.equals("inteiro")){
                aux = "\"%d\"";
                saida.append("\tscanf("+aux+",&"+ident+");\n");
            }
            else if(tipo.equals("real")){
                aux = "\"%f\"";
                saida.append("\tscanf("+aux+",&"+ident+");\n");
            }
            else if(tipo.equals("literal")){
                aux = "\"%c\"";
                saida.append("\tgets("+ident+");\n");
            }


        }
        return null;
    }

    // O tipo escrito deve ser escrito de forma diferente dependendo do tipo da variável.
    @Override
    public Void visitCmdEscreva(laParser.CmdEscrevaContext ctx) {
        String tipo,ident,aux = "";
        String textT ="\"",textI ="";
        saida.append("\tprintf(");
        for(int i =0;i<ctx.expressao().size();i++){
            tipo = LaSemanticoUtil.verificarTipo(tabela, ctx.expressao(i));
            ident = ctx.expressao(i).getText();
            if(tipo.equals("inteiro")){
                aux = "%d";
            }
            else if(tipo.equals("real")){
                aux = "%f";
            }
            else if(tipo.equals("literal")){
                if(ident.contains("\"")){
                    ident = ident.replace("\"","");
                    aux = ident;
                    ident ="";
                }
                else {
                    aux = "%s";
                }
                }
            textT +=  aux ;
            textI += ident+ " ";
        }
        textT += "\"";
        saida.append(textT);
        if(!textI.isBlank()){
            saida.append(",");
            saida.append(textI);
        }
        saida.append(");\n");

        return null;
    }
    // Se o tipo da variável for literal então deve-se utilizar o strcpy().
    @Override
    public Void visitCmdAtribuicao(laParser.CmdAtribuicaoContext ctx) {
        String ident = LaSemanticoUtil.verificarIdentificador(ctx.identificador());
        String tipo = LaSemanticoUtil.verificarTipo(tabela,ctx.expressao());
        String exp = ctx.expressao().getText();
        if(ctx.pont != null){
            saida.append("*");
        }

        if(tipo.equals("literal")){
            saida.append("strcpy("+ident+","+exp+");");
        }
        else {
        saida.append(ident + "=" + exp + ";\n");
        }
        return null;
    }

    @Override
    public Void visitCmdSe(laParser.CmdSeContext ctx) {
        saida.append("if (");
        visitExpressao(ctx.expressao());
        saida.append("){\n");
        for (int i =0;i<ctx.en.size();i++){
            visitCmd(ctx.en.get(i));
        }
        saida.append("}\n");
        if(ctx.sen.size() > 0){
            saida.append("else{\n");
            for (int i =0;i<ctx.sen.size();i++){
                visitCmd(ctx.sen.get(i));
            }
            saida.append("}\n");
        }

        return null;
    }

    @Override
    public Void visitExpressao(laParser.ExpressaoContext ctx) {
        visitTermo_logico(ctx.termo_logico(0));
        for(int i=1; i<ctx.termo_logico().size();i++){
            saida.append(" || ");
            visitTermo_logico(ctx.termo_logico(i));
        }


        return null;
    }

    @Override
    public Void visitTermo_logico(laParser.Termo_logicoContext ctx) {
        visitFator_logico(ctx.fator_logico(0));
        for(int i=1; i<ctx.fator_logico().size();i++){
            saida.append(" && ");
            visitFator_logico(ctx.fator_logico(i));
        }

        return null;
    }

    // O operador de negação é diferente entre as duas linguagens.
    @Override
    public Void visitFator_logico(laParser.Fator_logicoContext ctx) {
        if(ctx.not != null){
            saida.append("(!(");
            visitParcela_logica(ctx.parcela_logica());
            saida.append("))");
        }
        else {
            visitParcela_logica(ctx.parcela_logica());
        }
        return null;
    }

    @Override
    public Void visitParcela_logica(laParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
            visitExp_relacional(ctx.exp_relacional());
        }

        return null;
    }

    // Alguns operadores da linguagem La são identicos as da linguagem C, outros não.
    @Override
    public Void visitExp_relacional(laParser.Exp_relacionalContext ctx) {
       visitExp_aritmetica(ctx.exp_aritmetica(0));
        if(ctx.exp_aritmetica().size()>1){

            if(ctx.op_relacional().getText().equals("=")){
                saida.append("==");
            }
            else if(ctx.op_relacional().getText().equals("<>")){
                saida.append("!=");
            }
            else{
                saida.append(ctx.op_relacional().getText());
            }
            visitExp_aritmetica(ctx.exp_aritmetica(1));
            }

        return null;
    }

    @Override
    public Void visitExp_aritmetica(laParser.Exp_aritmeticaContext ctx) {
        visitTermo(ctx.termo(0));
        for (int i =1 ;i<ctx.termo().size();i++){
            saida.append(ctx.op1(i-1).getText());
            visitTermo(ctx.termo(i));
        }

        return null;
    }

    @Override
    public Void visitTermo(laParser.TermoContext ctx) {
        visitFator(ctx.fator(0));
        for (int i =1 ;i<ctx.fator().size();i++){
            saida.append(ctx.op2(i-1).getText());
            visitFator(ctx.fator(i));
        }
        return null;
    }

    @Override
    public Void visitFator(laParser.FatorContext ctx) {
        visitParcela(ctx.parcela(0));
        for (int i =1 ;i<ctx.parcela().size();i++){
            saida.append(ctx.parcela(i-1).getText());
            visitParcela(ctx.parcela(i));
        }

        return null;
    }

    @Override
    public Void visitParcela(laParser.ParcelaContext ctx) {
        if(ctx.parcela_unario() != null){
            visitParcela_unario(ctx.parcela_unario());
        }
        else{
            visitParcela_nao_unario(ctx.parcela_nao_unario());
        }
        return null;
    }

    @Override
    public Void visitParcela_unario(laParser.Parcela_unarioContext ctx) {
        if(ctx.identificador() != null){
            if(ctx.pont !=null){
                saida.append("*"+ctx.identificador().getText());
            }
            else{
                saida.append(ctx.identificador().getText());
            }
        }
        else if(ctx.NUM_INT() != null){
            saida.append(ctx.NUM_INT().getText());
        }
        else if(ctx.NUM_REAL() != null){
            saida.append(ctx.NUM_REAL().getText());
        }
        else if(ctx.newexp != null){
            visitExpressao(ctx.newexp);
        }
        else if(ctx.IDENT() != null){
            saida.append(ctx.IDENT().getText());
            saida.append("(");
            visitExpressao(ctx.expressao(0));
            for (int i = 1;i<ctx.expressao().size();i++){
                saida.append(",");
                visitExpressao(ctx.expressao(i));
            }
            saida.append(")");
        }
        return null;
    }

    @Override
    public Void visitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx) {
        if(ctx.CADEIA() != null){
            saida.append(ctx.CADEIA().getText());
        }
        else{
            saida.append(ctx.getText());
        }
        return null;
    }

    @Override
    public Void visitCmdPara(laParser.CmdParaContext ctx) {
        saida.append("for(");
        saida.append(ctx.IDENT().getText());
        saida.append("="+ctx.exp_aritmetica(0).getText()+";");
        saida.append(ctx.IDENT().getText()+"<="+ctx.exp_aritmetica(1).getText()+";");
        saida.append(ctx.IDENT().getText()+"++){\n");
        for(int i = 0;i<ctx.cmd().size();i++){
            visitCmd(ctx.cmd(i));
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdEnquanto(laParser.CmdEnquantoContext ctx) {
        saida.append("\twhile(");
        visitExpressao(ctx.expressao());
        saida.append("){\n");
        for(int i=0;i<ctx.cmd().size();i++){
            visitCmd(ctx.cmd(i));
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdFaca(laParser.CmdFacaContext ctx) {
        saida.append("\tdo{\n");
        for (int i = 0; i<ctx.cmd().size();i++){
            visitCmd(ctx.cmd(i));
        }
        saida.append("\t} while");
        visitExpressao(ctx.expressao());
        saida.append(";\n");
        return null;
    }

    @Override
    public Void visitCmdCaso(laParser.CmdCasoContext ctx) {
        saida.append("switch(");
        visitExp_aritmetica(ctx.exp_aritmetica());
        saida.append("){\n");
        visitSelecao(ctx.selecao());
        saida.append("default:\n");
        for(int i=0;i<ctx.cmd().size();i++){
            visitCmd(ctx.cmd(i));
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitSelecao(laParser.SelecaoContext ctx) {
        for(int i = 0;i<ctx.item_selecao().size();i++){
            visitItem_selecao(ctx.item_selecao(i));
        }
        return null;
    }

    @Override
    public Void visitItem_selecao(laParser.Item_selecaoContext ctx) {
        visitConstantes(ctx.constantes());
        for (int i = 0;i<ctx.cmd().size();i++){
            visitCmd(ctx.cmd(i));
        }
        saida.append("\tbreak;\n");
        return null;
    }

    @Override
    public Void visitConstantes(laParser.ConstantesContext ctx) {
        visitNumero_intervalo(ctx.numero_intervalo(0));
        for (int i =1;i<ctx.numero_intervalo().size();i++){
            visitNumero_intervalo(ctx.numero_intervalo(i));
        }
        return null;
    }

    // Os comandos e o break só são escritos ao final do intervalo dos numeros.
    @Override
    public Void visitNumero_intervalo(laParser.Numero_intervaloContext ctx) {
        if(ctx.NUM_INT(1) != null){
            String init = ctx.NUM_INT(0).getText();
            String end = ctx.NUM_INT(1).getText();
            int i = Integer.parseInt(init);
            int e = Integer.parseInt(end);
            for(i=i; i<=e ;i++){
                saida.append("case "+i+":\n");
            }

        }
        else {
            saida.append("case " + ctx.NUM_INT(0).getText() + ":\n");
        }
        return null;
    }
}

