
package br.ufscar.dc.compiladores.iprocess;
import java.util.*;

/**
 * A classe TabelaDeSimbolos armazena um Map que armazena uma chave (nome da variavável)
 * e um EntradaTabelaDeSimbolos que armazena o nome, tipo da variável e tamanho do grupo.
 *
 * Com essa classe é possível verificar a existência de uma variavel, retornar seu tipo e o tamanho do grupo.
 *
 *
 * @author isaacwillian
 */
public class TabelaDeSimbolos {


    class EntradaTabelaDeSimbolos{
        String nome;
        String tipo;
        int tam;

        private EntradaTabelaDeSimbolos(String nome,String tipo, int tam){
            this.nome = nome;
            this.tipo = tipo;
            this.tam = tam;
        }

    }

    private final Map<String,EntradaTabelaDeSimbolos> tabela;

    public TabelaDeSimbolos(){
        this.tabela = new HashMap<>();
    }

    public void adicionar(String nome, String tipo, int tam){
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome,tipo,tam));
    }

    public boolean existe(String nome){
        return tabela.containsKey(nome);
    }

    public String verificar(String nome){
        return tabela.get(nome).tipo;
    }

    public int getTam(String nome){return tabela.get(nome).tam; }


}
