/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.iprocess;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.PrintWriter;

/**
 * @author isaacwillian
 */
public class Principal {
    public static void main(String args[]) throws IOException {
        try (PrintWriter pw = new PrintWriter(args[1])) {

            CharStream cs = CharStreams.fromFileName(args[0]);
            iprocessLexer lexer = new iprocessLexer(cs);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            iprocessParser parser = new iprocessParser(tokens);

            // Substitui o ErrorListener do parser parar possibilitar mensagens de erros personalizadas
            parser.removeErrorListeners();
            MyCustomErrorListener mcel = new MyCustomErrorListener();
            parser.addErrorListener(mcel);

            try {
                // Inicia a análise sintatica
                iprocessParser.ProgramaContext arvore = parser.programa();

                //Inicia a análise semântica
                IprocessSemantico seman = new IprocessSemantico();
                seman.visitPrograma(arvore);
                Util.errosSemanticos.forEach((s) -> pw.println(s));

                //Caso não possua erros sintáticos ou semânticos é iniciado a geração do código Python
                if(Util.errosSemanticos.size() == 0) {
                    IprocessGerador g = new IprocessGerador();
                    g.visitPrograma(arvore);
                    pw.println(g.codigo.toString());
                }
            }catch (ParseCancellationException e) {
                Util.errosSintaticos.forEach((s) -> pw.println(s));
            }


        }

    }
}
