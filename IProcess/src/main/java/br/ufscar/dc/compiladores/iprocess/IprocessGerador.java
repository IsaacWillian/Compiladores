package br.ufscar.dc.compiladores.iprocess;

public class IprocessGerador extends iprocessBaseVisitor<Void> {

    StringBuilder codigo;
    TabelaDeSimbolos tabela;

    public IprocessGerador(){
        codigo = new StringBuilder();
        tabela = new TabelaDeSimbolos();
    }

    // Gera o inicio do código python, importando os pacotes necessários
    @Override
    public Void visitPrograma(iprocessParser.ProgramaContext ctx) {
        codigo.append("import matplotlib.pyplot as plt\n");
        codigo.append("import numpy as np\n");
        codigo.append("import skimage.filters as skifilters\n");
        codigo.append("import skimage.morphology as skimorph\n");


        for (int i=0;i<ctx.declaracoes().size();i++){
            visitDeclaracoes(ctx.declaracoes(i));
        }

        for (int i=0;i<ctx.process().size();i++){
            visitProcess(ctx.process(i));
        }

        for (int i=0;i<ctx.show().size();i++){
            visitShow(ctx.show(i));
        }


        return null;
    }

    @Override
    public Void visitDeclaracoes(iprocessParser.DeclaracoesContext ctx) {
        codigo.append("\n");
        if(ctx.decl_group() != null){
            visitDecl_group(ctx.decl_group());
        }
        else {
            visitDecl_one(ctx.decl_one());
        }
            return null;
    }

    // Declara uma lista vazia e lê e adiciona todas as imagens que vão sendo lidas, por meio do plt.imread().
    // Obtém o primeiro canal das imagens já que elas possuem 3 ou 4 canais
    @Override
    public Void visitDecl_group(iprocessParser.Decl_groupContext ctx) {
        String ident = ctx.IDENT().getText();
        tabela.adicionar(ident,"group",ctx.PATH().size());
        codigo.append(ident+"=[]\n");
        for (int i=0;i<ctx.PATH().size();i++){
            codigo.append(ident+".append(plt.imread("+ctx.PATH().get(i).getText()+")[:,:,0])\n");
        }

        return null;
    }

    // Lê a imagem e armazena por meio do plt.imread()
    @Override
    public Void visitDecl_one(iprocessParser.Decl_oneContext ctx) {
        String ident = ctx.IDENT().getText();
        tabela.adicionar(ident,"one",1);
        codigo.append(ident+" = plt.imread("+ctx.PATH().getText()+")[:,:,0]\n");

        return null;
    }

    @Override
    public Void visitProcess(iprocessParser.ProcessContext ctx) {
        codigo.append("\n");
        if (ctx.cmdFilter() != null){
            visitCmdFilter(ctx.cmdFilter());
        }
        else if ( ctx.cmdMorpho() != null){
            visitCmdMorpho(ctx.cmdMorpho());
        }
        else {
            visitCmdThreshold(ctx.cmdThreshold());
        }


        return null;
    }

    // Escreve o comando para aplicar o threshold na imagem ou no grupo
    @Override
    public Void visitCmdThreshold(iprocessParser.CmdThresholdContext ctx) {
        String var = ctx.IDENT().getText();
        String thresholdType = ctx.type.getText();
        String value = ctx.NUM_INT().getText();
        String type = tabela.verificar(var);
        if (thresholdType.equals("above")){
            thresholdType = ">";
        }
        else{
            thresholdType = "<";
        }


        if(type.equals("one")){
            codigo.append(var+" = "+var+thresholdType+value+"\n");
        }
        else{
            int tamGroup = tabela.getTam(var);
            String varWithIndex = "";
            for (int i = 0 ; i<tamGroup;i++){
                varWithIndex = var+"["+i+"]";
                codigo.append(varWithIndex+" = "+varWithIndex+thresholdType+value+"\n");
            }


        }


        return null;
    }

    // Escreve o comando para aplicar os filtros nas variáveis passadas
    public void writeFilter(String varWithIndex,String filterType, int size){
        if(filterType.equals("mean")){
            codigo.append(varWithIndex +" = " + "skifilters.rank.mean("+varWithIndex+","+"skimorph.square("+size+"))\n");

        }
        else if(filterType.equals("median")){
            codigo.append(varWithIndex +" = " + "skifilters.rank.median("+varWithIndex+","+"skimorph.square("+size+"))\n");


        }
        else if (filterType.equals("tophat")){
            codigo.append(varWithIndex +" = " + "skifilters.rank.tophat("+varWithIndex+","+"skimorph.square("+size+"))\n");

        }
        else {
            codigo.append(varWithIndex +" = " + "skifilters.gaussian("+varWithIndex+","+size+")\n");


        }

    }

    // Obtém as informações para posterior escrita dos comando para aplicar os filtros na imagem ou no grupo
    @Override
    public Void visitCmdFilter(iprocessParser.CmdFilterContext ctx) {
       String var = ctx.IDENT().getText();
       String type = tabela.verificar(var);
       String filterType = ctx.filterType().getText();
        int size = 3;
        if(ctx.elem != null) {
            size = Integer.parseInt(ctx.elem.getText());
        }
       if(type.equals("one")){
           writeFilter(var,filterType,size);
       }
       else{
           int tamGroup = tabela.getTam(var);
           String varWithIndex = "";
           for(int i = 0;i<tamGroup;i++){
               varWithIndex = var +"["+i+"]";
               writeFilter(varWithIndex,filterType,size);

           }
        }
        return null;
    }

    //Escreve o comando para aplicar os filtros morfológicos nas variáveis passadas
    public void writeMorphFilter(String varWithIndex,String filterType, int size){
        if(filterType.equals("erosion")){
            codigo.append(varWithIndex +" = " + "skimorph.erosion("+varWithIndex+")\n");

        }
        else if(filterType.equals("dilation")){
            codigo.append(varWithIndex +" = " + "skimorph.dilation("+varWithIndex+","+"skimorph.square("+size+"))\n");


        }
        else {
            codigo.append(varWithIndex +" = " + "skimorph.skeletonize("+varWithIndex+")\n");

        }


    }

    // Obtém as informações para posterior escrita dos comando para aplicar os filtros morfológicos na imagem ou no grupo
    @Override
    public Void visitCmdMorpho(iprocessParser.CmdMorphoContext ctx) {
        String var = ctx.IDENT().getText();
        String type = tabela.verificar(var);
        String filterType = ctx.morphfilterType().getText();
        int size = 3;
        if(ctx.elem != null) {
            size = Integer.parseInt(ctx.elem.getText());
        }

        if(type.equals("one")){
            writeMorphFilter(var,filterType,size);
        }
        else{
            int tamGroup = tabela.getTam(var);
            String varWithIndex = "";
            for(int i = 0;i<tamGroup;i++){
                varWithIndex = var +"["+i+"]";
                writeMorphFilter(varWithIndex,filterType,size);

            }
        }

        return null;
    }


    @Override
    public Void visitShow(iprocessParser.ShowContext ctx) {
        codigo.append("\n");
        if (ctx.showGrid() != null){
            visitShowGrid(ctx.showGrid());
        }
        else {
            visitShowSimple(ctx.showSimple());
        }

        return null;
    }

    // Escreve o comando para mostrar uma única imagem
    @Override
    public Void visitShowSimple(iprocessParser.ShowSimpleContext ctx) {
        String image = ctx.IDENT().getText();
        codigo.append("plt.figure(figsize=(15,15))\n");
        codigo.append("plt.imshow("+image+",\"gray\")\n");
        codigo.append("plt.axis(\"off\")\n\n");
        codigo.append("plt.show()\n");


        return null;
    }

    // Escreve o comando para mostrar o grupo de imagens
    @Override
    public Void visitShowGrid(iprocessParser.ShowGridContext ctx) {
        String var = ctx.IDENT().getText();
        String varWithIndex = "";
        codigo.append(("plt.figure(figsize=(30,30))\n"));

        int tamGroup = tabela.getTam(var);
        String nCols = (ctx.col!=null)? ctx.col.getText() : "3";
        int nr = (tamGroup/Integer.parseInt(nCols))+1;
        String nRows = (ctx.row!=null)? ctx.row.getText() : String.valueOf(nr) ;


        for (int i = 0;i<tamGroup;i++){
            varWithIndex = var + "["+i+"]";
            codigo.append("plt.subplot("+nRows+","+nCols+","+(i+1)+")\n");
            codigo.append("plt.imshow("+varWithIndex+",\"gray\")\n");
            codigo.append("plt.axis(\"off\")\n\n");

        }
        codigo.append("plt.show()\n");

        return null;
    }


}
