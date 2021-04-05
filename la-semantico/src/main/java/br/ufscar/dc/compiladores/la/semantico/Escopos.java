
package br.ufscar.dc.compiladores.la.semantico;
import java.util.*;
/**
 * A classe Escopos armazena uma lista ligada em que são armazenados as tabelas de simbolos
 * para cada novo escopo acessado no código.
 * Cada escopo equivale a uma tabela, que pode ser criada, acessada ou abandonada.
 *
 * @author isaacwillian
 */
public class Escopos {
    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;
    
    public Escopos(){
        pilhaDeTabelas = new LinkedList<>();
    }

    public void criarNovoEscopo(){
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }
    
    public TabelaDeSimbolos obterEscopoAtual(){
        return pilhaDeTabelas.peek();
    }
    
    public List<TabelaDeSimbolos> percorrerEscoposAninhados(){
        return pilhaDeTabelas;
    } 

    public void abandonarEscopo(){
        pilhaDeTabelas.pop();
    }
    
}
