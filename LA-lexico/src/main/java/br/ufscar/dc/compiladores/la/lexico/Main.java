/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.lexico;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

/**
 *
 * @author isaacwillian
 */
public class Main {
    public static void main(String[] args) {
        try {
            // args[0] é o primeiro argumento da linha de comando
            PrintWriter output = new PrintWriter(args[1]);        
            
            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lex = new laLexer(cs);
            Token t = null;
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                if (laLexer.VOCABULARY.getDisplayName(t.getType()) == "CHAVE" | laLexer.VOCABULARY.getDisplayName(t.getType()) == "OP" ) {
                    output.println("<'"+t.getText() + "','" + t.getText() +"'>");
                }else{
                    output.println("<'"+t.getText() + "'," + laLexer.VOCABULARY.getDisplayName(t.getType())+">");
                    
                }
                
            }
            output.flush();
            }
         catch (IOException ex) {
        }
    }
    
}
