package br.ufscar.dc.compiladores.iprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * A Classe Util é utilizada para guardar erros sintáticos ou semânticos
 *
 * @author isaacwillian
 */

public class Util {


        public static List<String> errosSintaticos = new ArrayList<>();

        public static void addErrosSintatico(int line, String mensagem ){
            errosSintaticos.add(String.format("Linha %d: %s",line,mensagem));

        }

        public static List<String> errosSemanticos = new ArrayList<>();

        public static void addErrosSemanticos( int line ,String mensagem ){
            errosSemanticos.add(String.format("Linha %d: %s",line,mensagem));

        }




}
