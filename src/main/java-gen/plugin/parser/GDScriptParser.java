// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GDScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, WHILE=7, EXTENDS=8, CONST=9, 
		VAR=10, FUNC=11, RETURN=12, PASS=13, BOOL=14, INT=15, FLOAT=16, CLASS_NAME=17, 
		PARAMETER=18, NUMBER=19, STRING=20, UNTERMINATED_STRING=21, NEWLINE=22, 
		WHITESPACE=23, LINE_COMMENT=24, ERRCHAR=25, INDENT=26, DEDENT=27;
	public static final int
		RULE_file = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_compound_stmt = 3, 
		RULE_parameter_list = 4, RULE_parameter = 5, RULE_type = 6, RULE_suite = 7, 
		RULE_primary = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stmt", "simple_stmt", "compound_stmt", "parameter_list", "parameter", 
			"type", "suite", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'('", "')'", "','", "'if'", "'while'", "'extends'", 
			"'const'", "'var'", "'func'", "'return'", "'pass'", "'bool'", "'int'", 
			"'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "BOOL", "INT", "FLOAT", "CLASS_NAME", 
			"PARAMETER", "NUMBER", "STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", 
			"LINE_COMMENT", "ERRCHAR", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "GDScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GDScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GDScriptParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << PASS) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(18);
				stmt();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				simple_stmt();
				}
				break;
			case IF:
			case WHILE:
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				compound_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				match(NEWLINE);
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

	public static class Simple_stmtContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(GDScriptParser.EXTENDS, 0); }
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public TerminalNode VAR() { return getToken(GDScriptParser.VAR, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CONST() { return getToken(GDScriptParser.CONST, 0); }
		public TerminalNode RETURN() { return getToken(GDScriptParser.RETURN, 0); }
		public TerminalNode PASS() { return getToken(GDScriptParser.PASS, 0); }
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simple_stmt);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(31);
				match(EXTENDS);
				setState(32);
				match(CLASS_NAME);
				setState(33);
				match(NEWLINE);
				}
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(34);
				match(VAR);
				setState(35);
				match(PARAMETER);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(36);
					match(T__0);
					setState(37);
					type();
					}
				}

				setState(40);
				match(T__1);
				setState(41);
				primary();
				setState(42);
				match(NEWLINE);
				}
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(44);
				match(CONST);
				setState(45);
				match(PARAMETER);
				setState(46);
				match(T__1);
				setState(47);
				primary();
				setState(48);
				match(NEWLINE);
				}
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(50);
				match(RETURN);
				setState(51);
				primary();
				setState(52);
				match(NEWLINE);
				}
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(54);
				match(PASS);
				setState(55);
				match(NEWLINE);
				}
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GDScriptParser.IF, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(GDScriptParser.WHILE, 0); }
		public TerminalNode FUNC() { return getToken(GDScriptParser.FUNC, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compound_stmt);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(58);
				match(IF);
				setState(59);
				primary();
				setState(60);
				match(T__0);
				setState(61);
				suite();
				}
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(63);
				match(WHILE);
				setState(64);
				primary();
				setState(65);
				match(T__0);
				setState(66);
				suite();
				}
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(68);
				match(FUNC);
				setState(69);
				match(PARAMETER);
				setState(70);
				match(T__2);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARAMETER) {
					{
					setState(71);
					parameter_list();
					}
				}

				setState(74);
				match(T__3);
				setState(75);
				match(T__0);
				setState(76);
				suite();
				}
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

	public static class Parameter_listContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			parameter();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(80);
				match(T__4);
				setState(81);
				parameter();
				}
				}
				setState(86);
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PARAMETER);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(88);
				match(T__0);
				setState(89);
				type();
				}
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(GDScriptParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(GDScriptParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(GDScriptParser.FLOAT, 0); }
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << FLOAT) | (1L << CLASS_NAME))) != 0)) ) {
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

	public static class SuiteContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(GDScriptParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(GDScriptParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_suite);
		int _la;
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(NEWLINE);
				setState(96);
				match(INDENT);
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(97);
					stmt();
					}
					}
					setState(100); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << PASS) | (1L << NEWLINE))) != 0) );
				setState(102);
				match(DEDENT);
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public TerminalNode NUMBER() { return getToken(GDScriptParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARAMETER) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4)\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3\6\7\6U\n\6\f\6\16\6X"+
		"\13\6\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\t\3\t\3\t\3\t\6\te\n\t\r\t\16\tf"+
		"\3\t\3\t\5\tk\n\t\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\4\3\2\20\23"+
		"\3\2\24\26\2t\2\27\3\2\2\2\4\37\3\2\2\2\6:\3\2\2\2\bO\3\2\2\2\nQ\3\2\2"+
		"\2\fY\3\2\2\2\16^\3\2\2\2\20j\3\2\2\2\22l\3\2\2\2\24\26\5\4\3\2\25\24"+
		"\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27"+
		"\3\2\2\2\32\33\7\2\2\3\33\3\3\2\2\2\34 \5\6\4\2\35 \5\b\5\2\36 \7\30\2"+
		"\2\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 \5\3\2\2\2!\"\7\n\2\2\"#"+
		"\7\23\2\2#;\7\30\2\2$%\7\f\2\2%(\7\24\2\2&\'\7\3\2\2\')\5\16\b\2(&\3\2"+
		"\2\2()\3\2\2\2)*\3\2\2\2*+\7\4\2\2+,\5\22\n\2,-\7\30\2\2-;\3\2\2\2./\7"+
		"\13\2\2/\60\7\24\2\2\60\61\7\4\2\2\61\62\5\22\n\2\62\63\7\30\2\2\63;\3"+
		"\2\2\2\64\65\7\16\2\2\65\66\5\22\n\2\66\67\7\30\2\2\67;\3\2\2\289\7\17"+
		"\2\29;\7\30\2\2:!\3\2\2\2:$\3\2\2\2:.\3\2\2\2:\64\3\2\2\2:8\3\2\2\2;\7"+
		"\3\2\2\2<=\7\b\2\2=>\5\22\n\2>?\7\3\2\2?@\5\20\t\2@P\3\2\2\2AB\7\t\2\2"+
		"BC\5\22\n\2CD\7\3\2\2DE\5\20\t\2EP\3\2\2\2FG\7\r\2\2GH\7\24\2\2HJ\7\5"+
		"\2\2IK\5\n\6\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\6\2\2MN\7\3\2\2NP\5\20"+
		"\t\2O<\3\2\2\2OA\3\2\2\2OF\3\2\2\2P\t\3\2\2\2QV\5\f\7\2RS\7\7\2\2SU\5"+
		"\f\7\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2\2Y"+
		"\\\7\24\2\2Z[\7\3\2\2[]\5\16\b\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^_\t"+
		"\2\2\2_\17\3\2\2\2`k\5\6\4\2ab\7\30\2\2bd\7\34\2\2ce\5\4\3\2dc\3\2\2\2"+
		"ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\35\2\2ik\3\2\2\2j`\3\2\2"+
		"\2ja\3\2\2\2k\21\3\2\2\2lm\t\3\2\2m\23\3\2\2\2\f\27\37(:JOV\\fj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}