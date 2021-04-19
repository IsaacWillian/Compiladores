grammar iprocess;

//Principal estrutura da linguagem
programa: 'LOAD:' (declaracoes)* 'PROCESS:' (process)* 'SHOW:' (show)* EOF;

// Formas de declaração disponíveis
declaracoes: decl_group | decl_one;

//Declaração de grupo, não possui limite da path
decl_group: 'GROUP' IDENT ':' ('('PATH')') (',' '('PATH')')*;

//Declaração individual, máximo de um path
decl_one: 'ONE' IDENT ':' '('PATH')';

// Identificador de imagem, inicia com letras
IDENT : ('a'..'z'|'A'..'Z')  ('a'..'z'|'A'..'Z'|'0'..'9'| '_')*;

// Caminhos das imagens, necessariamente entre aspas como uma cadeia de caracteres
PATH : '"' ( ~('\n') )*? '"';

// Processos disponíveis
process: cmdFilter | cmdMorpho | cmdThreshold;

// Formas de mostrar disponíveis
show: showGrid | showSimple;

// Declaração da aplicação de um filtro em uma imagem
cmdFilter : 'filter' filterType ('size' elem=NUM_INT)? 'in' IDENT;

// Tipos de filtros para aplicar em uma imagem
filterType: ('mean'|'median'|'tophat'|'gaussian');

// Declaração da aplicação de um filtro morfológico em uma imagem
cmdMorpho: 'morphfilter' morphfilterType ('size'  elem=NUM_INT)? 'in' IDENT;

// Tipos de filtros morfológico para aplicar em uma imagem
morphfilterType: ('erosion' | 'dilation' | 'skeletonization');

// Declaração de um threshold em uma imagem
cmdThreshold: 'threshold' 'in' IDENT type=('above'|'below') NUM_INT;

//Numerios interiros disponíveis
NUM_INT: ('0'..'9')+;

// Declaração para mostrar imagens de um grupo
showGrid: 'show' 'in' 'grid' (row=NUM_INT)? ('rows')? (col=NUM_INT)? ('cols')?  IDENT;

//Declaração para mostrar imagens individuais
showSimple: 'show' IDENT;

// Erro de cadeia não fechada
ERRO_CADEIA: '"' ( ~('\n') )*? ;

// Declaração de um comentário
COMENTARIO : '//' ( ~('\n') )*? '\n' -> skip;

// Caracteres para pular
WS  :   ( ' '| '\t'| '\r'| '\n') -> skip;

// Caracteres soltos
ERRO: ~('\n');
