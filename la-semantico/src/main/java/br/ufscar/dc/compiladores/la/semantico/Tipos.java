/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.semantico;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe Tipos armazena os tipos primários e os tipos criados posteriormente.
 *
 * @author isaacwillian
 */
public class Tipos {

    public static  List<String> listTipos = new ArrayList<String>(List.of("literal","inteiro","cadeia","real","registro","invalido"));


    public static void adicionar(String novoTipo){
            listTipos.add(novoTipo);
            }
    
    public static boolean verificarTipo(String tipo){
        for(String t: listTipos){
            if(t.equals(tipo)){
                return true;
            }
        }
        return false;
    }

}