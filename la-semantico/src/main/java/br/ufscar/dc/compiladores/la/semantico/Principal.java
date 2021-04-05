package br.ufscar.dc.compiladores.la.semantico;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

/**
 *
 * @author isaacwillian
 */
public class Principal {
    public static void main(String args[]) throws IOException {
        try(PrintWriter pw = new PrintWriter(args[1])) {

            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lexer = new laLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            laParser parser = new laParser(tokens);
            laParser.ProgramaContext arvore = parser.programa();
            LaSemantico as = new LaSemantico();
            as.visitPrograma(arvore);
            LaSemanticoUtil.errosSemanticos.forEach((s) -> pw.println(s));
            if(LaSemanticoUtil.errosSemanticos.size() == 0){
                LaGerador g = new LaGerador();
                g.visitPrograma(arvore);
                pw.println(g.saida.toString());
            }
            else {
                pw.println("Fim da compilacao");
            }



        }
    }

}
