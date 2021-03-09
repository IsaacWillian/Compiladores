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
            
            //cria arquivo de saida
            // args[1] é o segundo argumento da linha de comando
            PrintWriter output = new PrintWriter(args[1]);        
            
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            
            laLexer lex = new laLexer(cs);
            Token t = null;
            
            // enquanto os tokens não chegam ao fim
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                if (laLexer.VOCABULARY.getDisplayName(t.getType()) == "CHAVE" | laLexer.VOCABULARY.getDisplayName(t.getType()) == "OP" ) {
                    //imprime palavras-chaves
                    output.println("<'"+t.getText() + "','" + t.getText() +"'>");
                }else{
                    //imprime texto e o TIPO
                    output.println("<'"+t.getText() + "'," + laLexer.VOCABULARY.getDisplayName(t.getType())+">");
                    
                }
                
            }
            //flush para esvaziar o buffer de saída
            output.flush();
            }
         catch (IOException ex) {
        }
    }
    
}
