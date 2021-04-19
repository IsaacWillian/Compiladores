// Generated from br/ufscar/dc/compiladores/la/lexico/laLexer.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class laLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, ERRO_COMENTARIO=2, COMENTARIO=3, CHAVE=4, NUM_INT=5, NUM_REAL=6, 
		OP=7, IDENT=8, ERRO_CADEIA=9, CADEIA=10, ERRO=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "ERRO_COMENTARIO", "COMENTARIO", "CHAVE", "NUM_INT", "NUM_REAL", 
			"OP", "IDENT", "ERRO_CADEIA", "CADEIA", "ERRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "ERRO_COMENTARIO", "COMENTARIO", "CHAVE", "NUM_INT", "NUM_REAL", 
			"OP", "IDENT", "ERRO_CADEIA", "CADEIA", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public laLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "laLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u016a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\4\3\4"+
		"\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0132\n\5\3\6\6\6\u0135\n\6\r\6\16\6\u0136"+
		"\3\7\6\7\u013a\n\7\r\7\16\7\u013b\3\7\3\7\6\7\u0140\n\7\r\7\16\7\u0141"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0150\n\b\3\t\3\t"+
		"\7\t\u0154\n\t\f\t\16\t\u0157\13\t\3\n\3\n\7\n\u015b\n\n\f\n\16\n\u015e"+
		"\13\n\3\13\3\13\7\13\u0162\n\13\f\13\16\13\u0165\13\13\3\13\3\13\3\f\3"+
		"\f\6!(\u015c\u0163\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\3\2\n\5\2\13\f\17\17\"\"\3\2\f\f\6\2*+..\60\60<<\4\2]]__\5\2,-//\61"+
		"\61\4\2\'(``\4\2C\\c|\6\2\62;C\\aac|\2\u01a0\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\35\3\2\2\2"+
		"\7$\3\2\2\2\t\u0131\3\2\2\2\13\u0134\3\2\2\2\r\u0139\3\2\2\2\17\u014f"+
		"\3\2\2\2\21\u0151\3\2\2\2\23\u0158\3\2\2\2\25\u015f\3\2\2\2\27\u0168\3"+
		"\2\2\2\31\32\t\2\2\2\32\33\3\2\2\2\33\34\b\2\2\2\34\4\3\2\2\2\35!\7}\2"+
		"\2\36 \n\3\2\2\37\36\3\2\2\2 #\3\2\2\2!\"\3\2\2\2!\37\3\2\2\2\"\6\3\2"+
		"\2\2#!\3\2\2\2$(\7}\2\2%\'\n\3\2\2&%\3\2\2\2\'*\3\2\2\2()\3\2\2\2(&\3"+
		"\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\177\2\2,-\3\2\2\2-.\b\4\2\2.\b\3\2\2\2"+
		"/\60\7c\2\2\60\61\7n\2\2\61\62\7i\2\2\62\63\7q\2\2\63\64\7t\2\2\64\65"+
		"\7k\2\2\65\66\7v\2\2\66\67\7o\2\2\67\u0132\7q\2\289\7f\2\29:\7g\2\2:;"+
		"\7e\2\2;<\7n\2\2<=\7c\2\2=>\7t\2\2>\u0132\7g\2\2?@\7n\2\2@A\7k\2\2AB\7"+
		"v\2\2BC\7g\2\2CD\7t\2\2DE\7c\2\2E\u0132\7n\2\2FG\7k\2\2GH\7p\2\2HI\7v"+
		"\2\2IJ\7g\2\2JK\7k\2\2KL\7t\2\2L\u0132\7q\2\2MN\7n\2\2NO\7g\2\2OP\7k\2"+
		"\2P\u0132\7c\2\2QR\7g\2\2RS\7u\2\2ST\7e\2\2TU\7t\2\2UV\7g\2\2VW\7x\2\2"+
		"W\u0132\7c\2\2X\u0132\t\4\2\2YZ\7h\2\2Z[\7k\2\2[\\\7o\2\2\\]\7a\2\2]^"+
		"\7c\2\2^_\7n\2\2_`\7i\2\2`a\7q\2\2ab\7t\2\2bc\7k\2\2cd\7v\2\2de\7o\2\2"+
		"e\u0132\7q\2\2fg\7t\2\2gh\7g\2\2hi\7c\2\2i\u0132\7n\2\2jk\7n\2\2kl\7q"+
		"\2\2lm\7i\2\2mn\7k\2\2no\7e\2\2o\u0132\7q\2\2p\u0132\7g\2\2qr\7p\2\2r"+
		"s\7c\2\2s\u0132\7q\2\2tu\7q\2\2u\u0132\7w\2\2vw\7u\2\2w\u0132\7g\2\2x"+
		"y\7@\2\2y\u0132\7?\2\2z{\7g\2\2{|\7p\2\2|}\7v\2\2}~\7c\2\2~\u0132\7q\2"+
		"\2\177\u0080\7u\2\2\u0080\u0081\7g\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0132\7q\2\2\u0084\u0085\7h\2\2\u0085\u0086\7k\2\2\u0086"+
		"\u0087\7o\2\2\u0087\u0088\7a\2\2\u0088\u0089\7u\2\2\u0089\u0132\7g\2\2"+
		"\u008a\u008b\7e\2\2\u008b\u008c\7c\2\2\u008c\u008d\7u\2\2\u008d\u0132"+
		"\7q\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\u0091\7l\2\2\u0091"+
		"\u0132\7c\2\2\u0092\u0093\7h\2\2\u0093\u0094\7k\2\2\u0094\u0095\7o\2\2"+
		"\u0095\u0096\7a\2\2\u0096\u0097\7e\2\2\u0097\u0098\7c\2\2\u0098\u0099"+
		"\7u\2\2\u0099\u0132\7q\2\2\u009a\u009b\7r\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7t\2\2\u009d\u0132\7c\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\u0132\7g\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4"+
		"\7e\2\2\u00a4\u0132\7c\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7\7k\2\2\u00a7"+
		"\u00a8\7o\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa\7r\2\2\u00aa\u00ab\7c\2\2"+
		"\u00ab\u00ac\7t\2\2\u00ac\u0132\7c\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af"+
		"\7p\2\2\u00af\u00b0\7s\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7c\2\2\u00b2"+
		"\u00b3\7p\2\2\u00b3\u00b4\7v\2\2\u00b4\u0132\7q\2\2\u00b5\u00b6\7h\2\2"+
		"\u00b6\u00b7\7k\2\2\u00b7\u00b8\7o\2\2\u00b8\u00b9\7a\2\2\u00b9\u00ba"+
		"\7g\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7s\2\2\u00bc\u00bd\7w\2\2\u00bd"+
		"\u00be\7c\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7v\2\2\u00c0\u0132\7q\2\2"+
		"\u00c1\u00c2\7t\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7i\2\2\u00c4\u00c5"+
		"\7k\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7t\2\2\u00c8"+
		"\u0132\7q\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7o\2\2"+
		"\u00cc\u00cd\7a\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7i\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\u00d4\7t\2\2\u00d4\u0132\7q\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7k\2\2"+
		"\u00d7\u00d8\7r\2\2\u00d8\u0132\7q\2\2\u00d9\u00da\7r\2\2\u00da\u00db"+
		"\7t\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7e\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7f\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7o\2\2\u00e1\u00e2\7g\2\2"+
		"\u00e2\u00e3\7p\2\2\u00e3\u00e4\7v\2\2\u00e4\u0132\7q\2\2\u00e5\u00e6"+
		"\7x\2\2\u00e6\u00e7\7c\2\2\u00e7\u0132\7t\2\2\u00e8\u00e9\7h\2\2\u00e9"+
		"\u00ea\7k\2\2\u00ea\u00eb\7o\2\2\u00eb\u00ec\7a\2\2\u00ec\u00ed\7r\2\2"+
		"\u00ed\u00ee\7t\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1"+
		"\7g\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7o\2\2\u00f4"+
		"\u00f5\7g\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7v\2\2\u00f7\u0132\7q\2\2"+
		"\u00f8\u00f9\7h\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7o\2\2\u00fb\u00fc"+
		"\7a\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7w\2\2\u00fe\u00ff\7p\2\2\u00ff"+
		"\u0100\7e\2\2\u0100\u0101\7c\2\2\u0101\u0132\7q\2\2\u0102\u0103\7h\2\2"+
		"\u0103\u0104\7w\2\2\u0104\u0105\7p\2\2\u0105\u0106\7e\2\2\u0106\u0107"+
		"\7c\2\2\u0107\u0132\7q\2\2\u0108\u0109\7t\2\2\u0109\u010a\7g\2\2\u010a"+
		"\u010b\7v\2\2\u010b\u010c\7q\2\2\u010c\u010d\7t\2\2\u010d\u010e\7p\2\2"+
		"\u010e\u0132\7g\2\2\u010f\u0132\t\5\2\2\u0110\u0111\7e\2\2\u0111\u0112"+
		"\7q\2\2\u0112\u0113\7p\2\2\u0113\u0114\7u\2\2\u0114\u0115\7v\2\2\u0115"+
		"\u0116\7c\2\2\u0116\u0117\7p\2\2\u0117\u0118\7v\2\2\u0118\u0132\7g\2\2"+
		"\u0119\u011a\7e\2\2\u011a\u011b\7q\2\2\u011b\u011c\7u\2\2\u011c\u011d"+
		"\7p\2\2\u011d\u011e\7v\2\2\u011e\u011f\7c\2\2\u011f\u0120\7p\2\2\u0120"+
		"\u0121\7v\2\2\u0121\u0132\7g\2\2\u0122\u0123\7h\2\2\u0123\u0124\7c\2\2"+
		"\u0124\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126\u0132\7q\2\2\u0127\u0128"+
		"\7x\2\2\u0128\u0129\7g\2\2\u0129\u012a\7t\2\2\u012a\u012b\7f\2\2\u012b"+
		"\u012c\7c\2\2\u012c\u012d\7f\2\2\u012d\u012e\7g\2\2\u012e\u012f\7k\2\2"+
		"\u012f\u0130\7t\2\2\u0130\u0132\7q\2\2\u0131/\3\2\2\2\u01318\3\2\2\2\u0131"+
		"?\3\2\2\2\u0131F\3\2\2\2\u0131M\3\2\2\2\u0131Q\3\2\2\2\u0131X\3\2\2\2"+
		"\u0131Y\3\2\2\2\u0131f\3\2\2\2\u0131j\3\2\2\2\u0131p\3\2\2\2\u0131q\3"+
		"\2\2\2\u0131t\3\2\2\2\u0131v\3\2\2\2\u0131x\3\2\2\2\u0131z\3\2\2\2\u0131"+
		"\177\3\2\2\2\u0131\u0084\3\2\2\2\u0131\u008a\3\2\2\2\u0131\u008e\3\2\2"+
		"\2\u0131\u0092\3\2\2\2\u0131\u009a\3\2\2\2\u0131\u009e\3\2\2\2\u0131\u00a1"+
		"\3\2\2\2\u0131\u00a5\3\2\2\2\u0131\u00ad\3\2\2\2\u0131\u00b5\3\2\2\2\u0131"+
		"\u00c1\3\2\2\2\u0131\u00c9\3\2\2\2\u0131\u00d5\3\2\2\2\u0131\u00d9\3\2"+
		"\2\2\u0131\u00e5\3\2\2\2\u0131\u00e8\3\2\2\2\u0131\u00f8\3\2\2\2\u0131"+
		"\u0102\3\2\2\2\u0131\u0108\3\2\2\2\u0131\u010f\3\2\2\2\u0131\u0110\3\2"+
		"\2\2\u0131\u0119\3\2\2\2\u0131\u0122\3\2\2\2\u0131\u0127\3\2\2\2\u0132"+
		"\n\3\2\2\2\u0133\u0135\4\62;\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2"+
		"\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\f\3\2\2\2\u0138\u013a\4"+
		"\62;\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\7\60\2\2\u013e\u0140\4"+
		"\62;\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\16\3\2\2\2\u0143\u0150\t\6\2\2\u0144\u0145\7>\2\2"+
		"\u0145\u0150\7/\2\2\u0146\u0150\4>?\2\u0147\u0148\7>\2\2\u0148\u0150\7"+
		"?\2\2\u0149\u014a\7\60\2\2\u014a\u0150\7\60\2\2\u014b\u0150\7@\2\2\u014c"+
		"\u014d\7>\2\2\u014d\u0150\7@\2\2\u014e\u0150\t\7\2\2\u014f\u0143\3\2\2"+
		"\2\u014f\u0144\3\2\2\2\u014f\u0146\3\2\2\2\u014f\u0147\3\2\2\2\u014f\u0149"+
		"\3\2\2\2\u014f\u014b\3\2\2\2\u014f\u014c\3\2\2\2\u014f\u014e\3\2\2\2\u0150"+
		"\20\3\2\2\2\u0151\u0155\t\b\2\2\u0152\u0154\t\t\2\2\u0153\u0152\3\2\2"+
		"\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\22"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015c\7$\2\2\u0159\u015b\n\3\2\2\u015a"+
		"\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015d\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\24\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0163\7$\2\2\u0160\u0162"+
		"\n\3\2\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0164\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\7$"+
		"\2\2\u0167\26\3\2\2\2\u0168\u0169\n\3\2\2\u0169\30\3\2\2\2\r\2!(\u0131"+
		"\u0136\u013b\u0141\u014f\u0155\u015c\u0163\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}