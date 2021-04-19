/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.iprocess;

/**
 * Classe que substitui o ErrorListener padrão do Antlr por um ErrorListener personalizado
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

    public MyCustomErrorListener() {

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
        
        String tipoErro = new String(iprocessLexer.VOCABULARY.getDisplayName(t.getType()));
        
        if(t.getType() == Token.EOF){
            Util.addErrosSintatico(line, "erro sintatico proximo a EOF");

        }
        else if(tipoErro.equals("ERRO")){
            Util.addErrosSintatico(line," simbolo "+ t.getText() +" nao identificado");
        }
        else if(tipoErro.equals("ERRO_CADEIA")){
            Util.addErrosSintatico(line," declaração de caminho nao fechada");
            
        }
        else{
            Util.addErrosSintatico(line," erro sintatico proximo a "+t.getText());
        }

        Util.addErrosSintatico(0,"Fim da compilacao");
        
       throw new ParseCancellationException();
       
    }
}