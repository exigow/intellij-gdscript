// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser.grammar;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, ELSE=7, FOR=8, WHILE=9, 
		EXTENDS=10, CONST=11, VAR=12, FUNC=13, RETURN=14, OPERATOR=15, CONTINUE_BREAK_PASS=16, 
		TRUE_FALSE=17, PRIMITIVE_TYPE=18, CLASS=19, CLASS_NAME=20, PARAMETER=21, 
		NUMBER=22, STRING=23, NEWLINE=24, WHITESPACE=25, LINE_COMMENT=26, ERRCHAR=27, 
		INDENT=28, DEDENT=29;
	public static final int
		RULE_file = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_compound_stmt = 3, 
		RULE_parameter = 4, RULE_type = 5, RULE_suite = 6, RULE_primary = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stmt", "simple_stmt", "compound_stmt", "parameter", "type", 
			"suite", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'('", "','", "')'", "'if'", "'else'", "'for'", "'while'", 
			"'extends'", "'const'", "'var'", "'func'", "'return'", null, null, null, 
			null, "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "FOR", "WHILE", "EXTENDS", 
			"CONST", "VAR", "FUNC", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "CLASS", "CLASS_NAME", "PARAMETER", "NUMBER", 
			"STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", "ERRCHAR", "INDENT", 
			"DEDENT"
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << CONTINUE_BREAK_PASS) | (1L << CLASS) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(16);
				stmt();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
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
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				simple_stmt();
				}
				break;
			case IF:
			case FOR:
			case WHILE:
			case FUNC:
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				compound_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
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
		public TerminalNode CONTINUE_BREAK_PASS() { return getToken(GDScriptParser.CONTINUE_BREAK_PASS, 0); }
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
				setState(29);
				match(EXTENDS);
				setState(30);
				match(CLASS_NAME);
				setState(31);
				match(NEWLINE);
				}
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(32);
				match(VAR);
				setState(33);
				match(PARAMETER);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(34);
					type();
					}
				}

				setState(37);
				match(T__0);
				setState(38);
				primary();
				setState(39);
				match(NEWLINE);
				}
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(41);
				match(CONST);
				setState(42);
				match(PARAMETER);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(43);
					type();
					}
				}

				setState(46);
				match(T__0);
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
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(54);
				match(CONTINUE_BREAK_PASS);
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
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(GDScriptParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(GDScriptParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(GDScriptParser.FOR, 0); }
		public TerminalNode FUNC() { return getToken(GDScriptParser.FUNC, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode CLASS() { return getToken(GDScriptParser.CLASS, 0); }
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
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
			setState(98);
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
				match(T__1);
				setState(61);
				suite();
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(62);
					match(ELSE);
					setState(63);
					match(T__1);
					setState(64);
					suite();
					}
				}

				}
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(67);
				match(WHILE);
				setState(68);
				primary();
				setState(69);
				match(T__1);
				setState(70);
				suite();
				}
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(72);
				match(FOR);
				setState(73);
				primary();
				setState(74);
				match(T__1);
				setState(75);
				suite();
				}
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(77);
				match(FUNC);
				setState(78);
				primary();
				setState(79);
				match(T__2);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE_FALSE) | (1L << PARAMETER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
					{
					setState(80);
					parameter();
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(81);
						match(T__3);
						setState(82);
						parameter();
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(90);
				match(T__4);
				setState(91);
				match(T__1);
				setState(92);
				suite();
				}
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(94);
				match(CLASS);
				setState(95);
				match(CLASS_NAME);
				setState(96);
				match(T__1);
				setState(97);
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

	public static class ParameterContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			primary();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(101);
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
		public TerminalNode PRIMITIVE_TYPE() { return getToken(GDScriptParser.PRIMITIVE_TYPE, 0); }
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__1);
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==PRIMITIVE_TYPE || _la==CLASS_NAME) ) {
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
		enterRule(_localctx, 12, RULE_suite);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(NEWLINE);
				setState(109);
				match(INDENT);
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(110);
					stmt();
					}
					}
					setState(113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << CONTINUE_BREAK_PASS) | (1L << CLASS) | (1L << NEWLINE))) != 0) );
				setState(115);
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
		public TerminalNode TRUE_FALSE() { return getToken(GDScriptParser.TRUE_FALSE, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE_FALSE) | (1L << PARAMETER) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37|\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4&\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5V\n\5\f\5\16"+
		"\5Y\13\5\5\5[\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5e\n\5\3\6\3\6\5\6"+
		"i\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\6\br\n\b\r\b\16\bs\3\b\3\b\5\bx\n\b"+
		"\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\4\4\2\24\24\26\26\4\2\23\23\27"+
		"\31\2\u0086\2\25\3\2\2\2\4\35\3\2\2\2\6:\3\2\2\2\bd\3\2\2\2\nf\3\2\2\2"+
		"\fj\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\27"+
		"\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31"+
		"\7\2\2\3\31\3\3\2\2\2\32\36\5\6\4\2\33\36\5\b\5\2\34\36\7\32\2\2\35\32"+
		"\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7\f\2\2 !\7\26\2"+
		"\2!;\7\32\2\2\"#\7\16\2\2#%\7\27\2\2$&\5\f\7\2%$\3\2\2\2%&\3\2\2\2&\'"+
		"\3\2\2\2\'(\7\3\2\2()\5\20\t\2)*\7\32\2\2*;\3\2\2\2+,\7\r\2\2,.\7\27\2"+
		"\2-/\5\f\7\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\7\3\2\2\61\62\5\20"+
		"\t\2\62\63\7\32\2\2\63;\3\2\2\2\64\65\7\20\2\2\65\66\5\20\t\2\66\67\7"+
		"\32\2\2\67;\3\2\2\289\7\22\2\29;\7\32\2\2:\37\3\2\2\2:\"\3\2\2\2:+\3\2"+
		"\2\2:\64\3\2\2\2:8\3\2\2\2;\7\3\2\2\2<=\7\b\2\2=>\5\20\t\2>?\7\4\2\2?"+
		"C\5\16\b\2@A\7\t\2\2AB\7\4\2\2BD\5\16\b\2C@\3\2\2\2CD\3\2\2\2De\3\2\2"+
		"\2EF\7\13\2\2FG\5\20\t\2GH\7\4\2\2HI\5\16\b\2Ie\3\2\2\2JK\7\n\2\2KL\5"+
		"\20\t\2LM\7\4\2\2MN\5\16\b\2Ne\3\2\2\2OP\7\17\2\2PQ\5\20\t\2QZ\7\5\2\2"+
		"RW\5\n\6\2ST\7\6\2\2TV\5\n\6\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\7\2\2]^\7\4\2"+
		"\2^_\5\16\b\2_e\3\2\2\2`a\7\25\2\2ab\7\26\2\2bc\7\4\2\2ce\5\16\b\2d<\3"+
		"\2\2\2dE\3\2\2\2dJ\3\2\2\2dO\3\2\2\2d`\3\2\2\2e\t\3\2\2\2fh\5\20\t\2g"+
		"i\5\f\7\2hg\3\2\2\2hi\3\2\2\2i\13\3\2\2\2jk\7\4\2\2kl\t\2\2\2l\r\3\2\2"+
		"\2mx\5\6\4\2no\7\32\2\2oq\7\36\2\2pr\5\4\3\2qp\3\2\2\2rs\3\2\2\2sq\3\2"+
		"\2\2st\3\2\2\2tu\3\2\2\2uv\7\37\2\2vx\3\2\2\2wm\3\2\2\2wn\3\2\2\2x\17"+
		"\3\2\2\2yz\t\3\2\2z\21\3\2\2\2\16\25\35%.:CWZdhsw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}