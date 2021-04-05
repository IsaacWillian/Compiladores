
package br.ufscar.dc.compiladores.la.semantico;
import java.util.*;

/**
 * A classe TabelaDeSimbolos armazena um Map que armazena uma chave (nome da variavável)
 * e um EntradaTabelaDeSimbolos que armazena o nome e tipo da variável.
 *
 * Com essa classe é possível verificar a existência de uma variavel e retornar seu tipo.
 *
 *
 * @author isaacwillian
 */
public class TabelaDeSimbolos {
    
    
    class EntradaTabelaDeSimbolos{
        String nome;
        String tipo;
    
        private EntradaTabelaDeSimbolos(String nome,String tipo){
            this.nome = nome;
            this.tipo = tipo;
        }
        
    }
        
    private final Map<String,EntradaTabelaDeSimbolos> tabela;
        
    public TabelaDeSimbolos(){
          this.tabela = new HashMap<>();    
    }

    public void adicionar(String nome, String tipo){
        System.out.println("Adicionado" + nome + "," + tipo);
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome,tipo));
    }
        
    public boolean existe(String nome){
        return tabela.containsKey(nome);
    }

    public String verificar(String nome){
        return tabela.get(nome).tipo;
    }


        
    
}
