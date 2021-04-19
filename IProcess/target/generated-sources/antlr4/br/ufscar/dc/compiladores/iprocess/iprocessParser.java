// Generated from br/ufscar/dc/compiladores/iprocess/iprocess.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.iprocess;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class iprocessParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, IDENT=28, PATH=29, NUM_INT=30, ERRO_CADEIA=31, 
		COMENTARIO=32, WS=33, ERRO=34;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_decl_group = 2, RULE_decl_one = 3, 
		RULE_process = 4, RULE_show = 5, RULE_cmdFilter = 6, RULE_filterType = 7, 
		RULE_cmdMorpho = 8, RULE_morphfilterType = 9, RULE_cmdThreshold = 10, 
		RULE_showGrid = 11, RULE_showSimple = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracoes", "decl_group", "decl_one", "process", "show", 
			"cmdFilter", "filterType", "cmdMorpho", "morphfilterType", "cmdThreshold", 
			"showGrid", "showSimple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'LOAD:'", "'PROCESS:'", "'SHOW:'", "'GROUP'", "':'", "'('", "')'", 
			"','", "'ONE'", "'filter'", "'size'", "'in'", "'mean'", "'median'", "'tophat'", 
			"'gaussian'", "'morphfilter'", "'erosion'", "'dilation'", "'skeletonization'", 
			"'threshold'", "'above'", "'below'", "'show'", "'grid'", "'rows'", "'cols'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "IDENT", "PATH", "NUM_INT", "ERRO_CADEIA", "COMENTARIO", 
			"WS", "ERRO"
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

	@Override
	public String getGrammarFileName() { return "iprocess.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public iprocessParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(iprocessParser.EOF, 0); }
		public List<DeclaracoesContext> declaracoes() {
			return getRuleContexts(DeclaracoesContext.class);
		}
		public DeclaracoesContext declaracoes(int i) {
			return getRuleContext(DeclaracoesContext.class,i);
		}
		public List<ProcessContext> process() {
			return getRuleContexts(ProcessContext.class);
		}
		public ProcessContext process(int i) {
			return getRuleContext(ProcessContext.class,i);
		}
		public List<ShowContext> show() {
			return getRuleContexts(ShowContext.class);
		}
		public ShowContext show(int i) {
			return getRuleContext(ShowContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__8) {
				{
				{
				setState(27);
				declaracoes();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(T__1);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__20))) != 0)) {
				{
				{
				setState(34);
				process();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(T__2);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(41);
				show();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public Decl_groupContext decl_group() {
			return getRuleContext(Decl_groupContext.class,0);
		}
		public Decl_oneContext decl_one() {
			return getRuleContext(Decl_oneContext.class,0);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				decl_group();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				decl_one();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_groupContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public List<TerminalNode> PATH() { return getTokens(iprocessParser.PATH); }
		public TerminalNode PATH(int i) {
			return getToken(iprocessParser.PATH, i);
		}
		public Decl_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterDecl_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitDecl_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitDecl_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_groupContext decl_group() throws RecognitionException {
		Decl_groupContext _localctx = new Decl_groupContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__3);
			setState(54);
			match(IDENT);
			setState(55);
			match(T__4);
			{
			setState(56);
			match(T__5);
			setState(57);
			match(PATH);
			setState(58);
			match(T__6);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(60);
				match(T__7);
				setState(61);
				match(T__5);
				setState(62);
				match(PATH);
				setState(63);
				match(T__6);
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_oneContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public TerminalNode PATH() { return getToken(iprocessParser.PATH, 0); }
		public Decl_oneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_one; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterDecl_one(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitDecl_one(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitDecl_one(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_oneContext decl_one() throws RecognitionException {
		Decl_oneContext _localctx = new Decl_oneContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl_one);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__8);
			setState(70);
			match(IDENT);
			setState(71);
			match(T__4);
			setState(72);
			match(T__5);
			setState(73);
			match(PATH);
			setState(74);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcessContext extends ParserRuleContext {
		public CmdFilterContext cmdFilter() {
			return getRuleContext(CmdFilterContext.class,0);
		}
		public CmdMorphoContext cmdMorpho() {
			return getRuleContext(CmdMorphoContext.class,0);
		}
		public CmdThresholdContext cmdThreshold() {
			return getRuleContext(CmdThresholdContext.class,0);
		}
		public ProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_process; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitProcess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitProcess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessContext process() throws RecognitionException {
		ProcessContext _localctx = new ProcessContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_process);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				cmdFilter();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				cmdMorpho();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				cmdThreshold();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowContext extends ParserRuleContext {
		public ShowGridContext showGrid() {
			return getRuleContext(ShowGridContext.class,0);
		}
		public ShowSimpleContext showSimple() {
			return getRuleContext(ShowSimpleContext.class,0);
		}
		public ShowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitShow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowContext show() throws RecognitionException {
		ShowContext _localctx = new ShowContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_show);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				showGrid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				showSimple();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdFilterContext extends ParserRuleContext {
		public Token elem;
		public FilterTypeContext filterType() {
			return getRuleContext(FilterTypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public TerminalNode NUM_INT() { return getToken(iprocessParser.NUM_INT, 0); }
		public CmdFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterCmdFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitCmdFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitCmdFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdFilterContext cmdFilter() throws RecognitionException {
		CmdFilterContext _localctx = new CmdFilterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__9);
			setState(86);
			filterType();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(87);
				match(T__10);
				setState(88);
				((CmdFilterContext)_localctx).elem = match(NUM_INT);
				}
			}

			setState(91);
			match(T__11);
			setState(92);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterTypeContext extends ParserRuleContext {
		public FilterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterFilterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitFilterType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitFilterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterTypeContext filterType() throws RecognitionException {
		FilterTypeContext _localctx = new FilterTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_filterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdMorphoContext extends ParserRuleContext {
		public Token elem;
		public MorphfilterTypeContext morphfilterType() {
			return getRuleContext(MorphfilterTypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public TerminalNode NUM_INT() { return getToken(iprocessParser.NUM_INT, 0); }
		public CmdMorphoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdMorpho; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterCmdMorpho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitCmdMorpho(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitCmdMorpho(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdMorphoContext cmdMorpho() throws RecognitionException {
		CmdMorphoContext _localctx = new CmdMorphoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdMorpho);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__16);
			setState(97);
			morphfilterType();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(98);
				match(T__10);
				setState(99);
				((CmdMorphoContext)_localctx).elem = match(NUM_INT);
				}
			}

			setState(102);
			match(T__11);
			setState(103);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MorphfilterTypeContext extends ParserRuleContext {
		public MorphfilterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_morphfilterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterMorphfilterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitMorphfilterType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitMorphfilterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MorphfilterTypeContext morphfilterType() throws RecognitionException {
		MorphfilterTypeContext _localctx = new MorphfilterTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_morphfilterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdThresholdContext extends ParserRuleContext {
		public Token type;
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public TerminalNode NUM_INT() { return getToken(iprocessParser.NUM_INT, 0); }
		public CmdThresholdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdThreshold; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterCmdThreshold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitCmdThreshold(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitCmdThreshold(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdThresholdContext cmdThreshold() throws RecognitionException {
		CmdThresholdContext _localctx = new CmdThresholdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdThreshold);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__20);
			setState(108);
			match(T__11);
			setState(109);
			match(IDENT);
			setState(110);
			((CmdThresholdContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
				((CmdThresholdContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(111);
			match(NUM_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowGridContext extends ParserRuleContext {
		public Token row;
		public Token col;
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public List<TerminalNode> NUM_INT() { return getTokens(iprocessParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(iprocessParser.NUM_INT, i);
		}
		public ShowGridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showGrid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterShowGrid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitShowGrid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitShowGrid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowGridContext showGrid() throws RecognitionException {
		ShowGridContext _localctx = new ShowGridContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_showGrid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__23);
			setState(114);
			match(T__11);
			setState(115);
			match(T__24);
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(116);
				((ShowGridContext)_localctx).row = match(NUM_INT);
				}
				break;
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(119);
				match(T__25);
				}
			}

			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUM_INT) {
				{
				setState(122);
				((ShowGridContext)_localctx).col = match(NUM_INT);
				}
			}

			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(125);
				match(T__26);
				}
			}

			setState(128);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowSimpleContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(iprocessParser.IDENT, 0); }
		public ShowSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).enterShowSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iprocessListener ) ((iprocessListener)listener).exitShowSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iprocessVisitor ) return ((iprocessVisitor<? extends T>)visitor).visitShowSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowSimpleContext showSimple() throws RecognitionException {
		ShowSimpleContext _localctx = new ShowSimpleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_showSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__23);
			setState(131);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0088\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3\2\3"+
		"\3\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4C\n\4"+
		"\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6R\n\6\3\7\3"+
		"\7\5\7V\n\7\3\b\3\b\3\b\3\b\5\b\\\n\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\5\ng\n\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\5\rx\n\r\3\r\5\r{\n\r\3\r\5\r~\n\r\3\r\5\r\u0081\n\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\5\3\2\17"+
		"\22\3\2\24\26\3\2\30\31\2\u0088\2\34\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2"+
		"\bG\3\2\2\2\nQ\3\2\2\2\fU\3\2\2\2\16W\3\2\2\2\20`\3\2\2\2\22b\3\2\2\2"+
		"\24k\3\2\2\2\26m\3\2\2\2\30s\3\2\2\2\32\u0084\3\2\2\2\34 \7\3\2\2\35\37"+
		"\5\4\3\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\""+
		" \3\2\2\2#\'\7\4\2\2$&\5\n\6\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2"+
		"\2(*\3\2\2\2)\'\3\2\2\2*.\7\5\2\2+-\5\f\7\2,+\3\2\2\2-\60\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\2\2\3\62\3\3\2\2\2\63"+
		"\66\5\6\4\2\64\66\5\b\5\2\65\63\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\67"+
		"8\7\6\2\289\7\36\2\29:\7\7\2\2:;\7\b\2\2;<\7\37\2\2<=\7\t\2\2=D\3\2\2"+
		"\2>?\7\n\2\2?@\7\b\2\2@A\7\37\2\2AC\7\t\2\2B>\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GH\7\13\2\2HI\7\36\2\2IJ\7\7\2\2JK"+
		"\7\b\2\2KL\7\37\2\2LM\7\t\2\2M\t\3\2\2\2NR\5\16\b\2OR\5\22\n\2PR\5\26"+
		"\f\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\13\3\2\2\2SV\5\30\r\2TV\5\32\16\2"+
		"US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\7\f\2\2X[\5\20\t\2YZ\7\r\2\2Z\\\7 \2"+
		"\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\16\2\2^_\7\36\2\2_\17\3\2\2\2`"+
		"a\t\2\2\2a\21\3\2\2\2bc\7\23\2\2cf\5\24\13\2de\7\r\2\2eg\7 \2\2fd\3\2"+
		"\2\2fg\3\2\2\2gh\3\2\2\2hi\7\16\2\2ij\7\36\2\2j\23\3\2\2\2kl\t\3\2\2l"+
		"\25\3\2\2\2mn\7\27\2\2no\7\16\2\2op\7\36\2\2pq\t\4\2\2qr\7 \2\2r\27\3"+
		"\2\2\2st\7\32\2\2tu\7\16\2\2uw\7\33\2\2vx\7 \2\2wv\3\2\2\2wx\3\2\2\2x"+
		"z\3\2\2\2y{\7\34\2\2zy\3\2\2\2z{\3\2\2\2{}\3\2\2\2|~\7 \2\2}|\3\2\2\2"+
		"}~\3\2\2\2~\u0080\3\2\2\2\177\u0081\7\35\2\2\u0080\177\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\36\2\2\u0083\31\3\2\2\2\u0084"+
		"\u0085\7\32\2\2\u0085\u0086\7\36\2\2\u0086\33\3\2\2\2\17 \'.\65DQU[fw"+
		"z}\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}