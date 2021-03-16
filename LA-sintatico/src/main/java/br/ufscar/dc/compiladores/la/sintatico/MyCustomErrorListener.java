/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.sintatico;

/**
 *
 * @author isaacwillian
 */
import org.antlr.v4.runtime.ANTLRErrorListener; // cuidado para importar a versão 4
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.Parser;
import java.util.BitSet;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;
import org.antlr.v4.runtime.misc.ParseCancellationException;

// Vamos também precisar de Token
// Outros imports vão ser necessários aqui. O NetBeans ou IntelliJ fazem isso automaticamente

public class MyCustomErrorListener implements ANTLRErrorListener {
    PrintWriter pw;
    public MyCustomErrorListener(PrintWriter pw) {       
      this.pw = pw;    
   }
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado

        Token t = (Token) offendingSymbol;
        
        String tipoErro = new String(laLexer.VOCABULARY.getDisplayName(t.getType()));
        
        if(t.getType() == Token.EOF){
            pw.println("Linha "+line+": erro sintatico proximo a EOF");
            
        }
        else if(tipoErro.equals("ERRO")){
            pw.println("Linha "+line+": " + t.getText() + " - simbolo nao identificado");
        }
        else if(tipoErro.equals("ERRO_COMENTARIO")){
            pw.println("Linha "+line+": comentario nao fechado");
            
        }
        else if(tipoErro.equals("ERRO_CADEIA")){
            pw.println("Linha "+line+": cadeia literal nao fechada");
            
        }
        else{
             pw.println("Linha "+line+": erro sintatico proximo a "+t.getText());
        }
        
        pw.println("Fim da compilacao");
        
       throw new ParseCancellationException();
       
    }
}