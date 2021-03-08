lexer grammar laLexer;


// Ignora espaços em branco, tabulações, pulos de linha
WS  :   ( ' '| '\t'| '\r'| '\n') -> skip;
   

//Ignora comentários
COMENTARIO : '{' ( ~('\n') )*? '}' -> skip;


//Identifica palavras-chaves e outras palavras fixas, deve ser separado para melhor compreensão
CHAVE : ('algoritmo' | 'declare' | 'literal' | 'inteiro' | 'leia' | 'escreva' | ':' | '(' | ')' | ',' | '.'
         | 'fim_algoritmo' | 'real'| 'logico' |'e' | 'nao' | 'ou' | 'se' | '>=' | 'entao' | 'senao' | 'fim_se'
         | 'caso' | 'seja' | 'fim_caso' | 'para' | 'ate' | 'faca' | 'fim_para' | 'enquanto' | 'fim_enquanto' | 'registro'
         | 'fim_registro'| 'tipo' | 'procedimento' | 'var' | 'fim_procedimento' | 'fim_funcao' | 'funcao' | 'retorne' | '[' 
         | ']' | 'constante' | 'cosntante' | 'falso' | 'verdadeiro' );




NUM_INT: ('0'..'9')+;

NUM_REAL: ('0'..'9')+  ('.') ('0'..'9')+;

OP: ( '+' | '-' | '*' | '/' | '<-' | '<' |'=' |'<=' | '..'| '>' |'<>' | '%' | '^' |'&');


IDENT : ('a'..'z'|'A'..'Z')  ('a'..'z'|'A'..'Z'|'0'..'9'| '_')* ;

CADEIA 	: '"' ( ~('\n') )*? '"';










