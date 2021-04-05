package br.ufscar.dc.compiladores.la.semantico;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

/**
 * A classe LaSemanticoUtil é responsável por verificar possíveis erros semanticos e armazena os erros em uma Lista
 * que posteriormente será impressa no arquivo de saída.
 *
 *  Todos os métodos são estáticos, o que permite o acesso sem instanciação da classe.
 *
 *  Os métodos verificaTipo são usadas para acessar os contextos e verificar divergência entre tipos, para
 *  posterior utilização ou adição da variável na TabelaDeSimbolos do escopo atual.
 *
 * @author isaacwillian
 */

public class LaSemanticoUtil {
    public static List<String> errosSemanticos = new ArrayList<>();

    //Formata e adiciona a mensagem de erro a lista de mensagens.
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int l = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", l, mensagem));
    }

    // Verifica se os dois tipos passados são equivalentes, verificando as regras de cada tipo.
    public static Boolean equivalenciaDeTipos(String tipo1, String tipo2) {
        if ((tipo1.equals("inteiro") && tipo2.equals("real")) || (tipo1.equals("real") && tipo2.equals("inteiro"))) {
            return true;
        }
        return tipo1.equals(tipo2);
    }

    /**
     * ****** Inicio dos métodos verificaTipo ****
     *
     */
    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.ExpressaoContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.termo_logico(0));
        for (int i = 1; i < ctx.termo_logico().size(); i++) {
            String tipo2 = verificarTipo(tabela, ctx.termo_logico(i));
            boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);

            if (!tipoCheck) {
                return "invalido";
            }
        }
        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Termo_logicoContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.fator_logico(0));
        for (int i = 1; i < ctx.fator_logico().size(); i++) {
            String tipo2 = verificarTipo(tabela, ctx.fator_logico(i));
            boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);
            if (!tipoCheck) {
                return "invalido";
            }
        }

        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Fator_logicoContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.parcela_logica());
        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_logicaContext ctx) {
        String tipo = "";
        if (ctx.exp_relacional() != null) {
            tipo = verificarTipo(tabela, ctx.exp_relacional());
        } else {
            String valor = ctx.logico.getText();
            if (valor.equals("verdadeiro") || valor.equals("falso")) {
                tipo = "logico";
            }
        }
        return tipo;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Exp_relacionalContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.exp_aritmetica(0));
        if (ctx.op_relacional() != null) {
            for (int i = 1; i < ctx.exp_aritmetica().size(); i++) {
                String tipo2 = verificarTipo(tabela, ctx.exp_aritmetica(i));
                boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);

                if (!tipoCheck) {
                    return "invalido";
                } else {
                    return "logico";
                }
            }
        }

        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Exp_aritmeticaContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.termo(0));
        for (int i = 1; i < ctx.termo().size(); i++) {
            String tipo2 = verificarTipo(tabela, ctx.termo(i));
            boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);
            if (!tipoCheck) {
                return "invalido";
            }
        }

        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.TermoContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.fator(0));

        for (int i = 1; i < ctx.fator().size(); i++) {
            String tipo2 = verificarTipo(tabela, ctx.fator(i));
            boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);
            if (!tipoCheck) {
                return "invalido";
            }
        }

        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.FatorContext ctx) {
        String tipo1 = verificarTipo(tabela, ctx.parcela(0));

        for (int i = 1; i < ctx.parcela().size(); i++) {
            String tipo2 = verificarTipo(tabela, ctx.parcela(i));
            boolean tipoCheck = equivalenciaDeTipos(tipo1, tipo2);

            if (!tipoCheck) {
                return "invalido";
            }
        }

        return tipo1;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.ParcelaContext ctx) {
        String tipo = "";
        if (ctx.parcela_unario() != null) {
            tipo = verificarTipo(tabela, ctx.parcela_unario());
        } else {
            tipo = verificarTipo(tabela, ctx.parcela_nao_unario());
        }
        return tipo;
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_unarioContext ctx) {
        String tipo = "";
        String ident = "";
        if (ctx.identificador() != null) {
            ident = verificarIdentificador(ctx.identificador());
            boolean existeIdent = tabela.existe(ident);
            if (existeIdent) {

                return tabela.verificar(ident);
            } else {
                adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ident + " nao declarado");
            }
        } else if (ctx.NUM_INT() != null) {
            return "inteiro";
        } else if (ctx.NUM_REAL() != null) {
            return "real";
        } else if (ctx.IDENT() != null) {
            ident = ctx.IDENT().getText();
            boolean existeIdent = tabela.existe(ident);
            if (existeIdent) {
                return tabela.verificar(ident);
            } else {
                adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ident + " nao declarado");
            }
            for (int i = 0; i < ctx.expressao().size(); i++) {
                return verificarTipo(tabela, ctx.expressao(i));

            }
        } else if (ctx.newexp != null) {
            return verificarTipo(tabela, ctx.newexp);
        }
        return "invalido";
    }

    public static String verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_nao_unarioContext ctx) {
        if (ctx.CADEIA() != null) {
            return "literal";
        }
        String ident = verificarIdentificador(ctx.identificador());
        boolean existeIdent = tabela.existe(ident);
        if (existeIdent) {

            return tabela.verificar(ident);
        } else {
            adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ident + " nao declarado");
        }
        return "invalido";
    }

    public static String verificaTipo(Escopos escope, laParser.VariavelContext ctx) {

        String tipo = verificarTipo(ctx.tipo(), false); // não irá criar a variavel caso não exista

        for (laParser.IdentificadorContext i : ctx.identificador()) {
            String ident = verificarIdentificador(i);
            if (!escope.obterEscopoAtual().existe(ident)) {
                escope.obterEscopoAtual().adicionar(ident, tipo);
            } else {
                LaSemanticoUtil.adicionarErroSemantico(i.getStart(), "identificador " + ident + " ja declarado anteriormente");
            }
        }
        return tipo;
    }

    public static String verificarTipo(laParser.TipoContext ctx, boolean create) {
        String ret = "";
        if (ctx.registro() != null) {
            ret = "registro";
        } else {
            return verificarTipo(ctx.tipo_estendido(), create);
        }
        return ret;


    }

    public static String verificarTipo(laParser.Tipo_estendidoContext ctx, boolean create) {
        String tipo = verificarTipo(ctx.tipo_basico_ident(), create);

        return tipo;

    }

    public static String verificarTipo(laParser.Tipo_basico_identContext ctx, boolean create) {
        if (ctx.IDENT() != null) {
            String ident = ctx.IDENT().getText();
            boolean tipoExiste = Tipos.verificarTipo(ident);
            if (!tipoExiste && !create) {
                adicionarErroSemantico(ctx.IDENT().getSymbol(), "tipo " + ident + " nao declarado");

                return "invalido";
            } else {
                Tipos.adicionar(ident);
                return ident;
            }
        }
        return verificarTipo(ctx.tipo_basico());


    }

    public static String verificarTipo(laParser.Tipo_basicoContext ctx) {
        return (ctx.getText());
    }

    // Método que obtém o identificador passado.
    public static String verificarIdentificador(laParser.IdentificadorContext ctx) {
        String ret = "";
        ret += ctx.IDENT(0).getText();

        for (int i = 1; i < ctx.IDENT().size(); i++) {
            ret = "." + ctx.IDENT(i).getText();
        }
        return ret;

    }
}