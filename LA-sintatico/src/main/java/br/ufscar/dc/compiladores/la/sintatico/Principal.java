/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.sintatico;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

/**
 * @author isaacwillian
 */
public class Principal {
    public static void main(String args[]) throws IOException{
        try(PrintWriter pw = new PrintWriter(args[1])) { 
        
            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lexer = new laLexer(cs);


            //Token t = null;
            //while( (t = lexer.nextToken()).getType() != Token.EOF) {
            //   System.out.println("<" + laLexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
           // }

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            laParser parser = new laParser(tokens);
            parser.removeErrorListeners();

            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.addErrorListener(mcel);

            
            parser.programa();
            
       
        
    }
    }
    
}
