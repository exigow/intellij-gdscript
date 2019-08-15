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
		EXTENDS=10, VAR_CONST=11, FUNC=12, EXPORT=13, RETURN=14, OPERATOR=15, 
		CONTINUE_BREAK_PASS=16, TRUE_FALSE=17, PRIMITIVE_TYPE=18, CLASS=19, CLASS_NAME=20, 
		PARAMETER=21, NUMBER=22, STRING=23, NEWLINE=24, WHITESPACE=25, LINE_COMMENT=26, 
		ERRCHAR=27, INDENT=28, DEDENT=29;
	public static final int
		RULE_file = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_export = 3, RULE_compound_stmt = 4, 
		RULE_typed_primaries = 5, RULE_type = 6, RULE_suite = 7, RULE_primary = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stmt", "simple_stmt", "export", "compound_stmt", "typed_primaries", 
			"type", "suite", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "','", "')'", "':'", "'if'", "'else'", "'for'", "'while'", 
			"'extends'", null, "'func'", "'export'", "'return'", null, null, null, 
			null, "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "FOR", "WHILE", "EXTENDS", 
			"VAR_CONST", "FUNC", "EXPORT", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << VAR_CONST) | (1L << FUNC) | (1L << EXPORT) | (1L << RETURN) | (1L << CONTINUE_BREAK_PASS) | (1L << CLASS) | (1L << NEWLINE))) != 0)) {
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
			case VAR_CONST:
			case EXPORT:
			case RETURN:
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
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
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public TerminalNode VAR_CONST() { return getToken(GDScriptParser.VAR_CONST, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(31);
				match(EXTENDS);
				setState(32);
				primary();
				setState(33);
				match(NEWLINE);
				}
				}
				break;
			case VAR_CONST:
			case EXPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(35);
					export();
					}
				}

				setState(38);
				match(VAR_CONST);
				setState(39);
				match(PARAMETER);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(40);
					type();
					}
				}

				setState(43);
				match(T__0);
				setState(44);
				primary();
				setState(45);
				match(NEWLINE);
				}
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(47);
				match(RETURN);
				setState(48);
				primary();
				setState(49);
				match(NEWLINE);
				}
				}
				break;
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(51);
				match(CONTINUE_BREAK_PASS);
				setState(52);
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

	public static class ExportContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(GDScriptParser.EXPORT, 0); }
		public Typed_primariesContext typed_primaries() {
			return getRuleContext(Typed_primariesContext.class,0);
		}
		public ExportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_export; }
	}

	public final ExportContext export() throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_export);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(EXPORT);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(56);
				typed_primaries();
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
		public Typed_primariesContext typed_primaries() {
			return getRuleContext(Typed_primariesContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(GDScriptParser.CLASS, 0); }
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compound_stmt);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(59);
				match(IF);
				setState(60);
				primary();
				setState(61);
				suite();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(62);
					match(ELSE);
					setState(63);
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
				setState(66);
				match(WHILE);
				setState(67);
				primary();
				setState(68);
				suite();
				}
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(70);
				match(FOR);
				setState(71);
				primary();
				setState(72);
				suite();
				}
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(74);
				match(FUNC);
				setState(75);
				primary();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(76);
					typed_primaries();
					}
				}

				setState(79);
				suite();
				}
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(81);
				match(CLASS);
				setState(82);
				primary();
				setState(83);
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

	public static class Typed_primariesContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Typed_primariesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_primaries; }
	}

	public final Typed_primariesContext typed_primaries() throws RecognitionException {
		Typed_primariesContext _localctx = new Typed_primariesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typed_primaries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(87);
			match(T__1);
			setState(88);
			primary();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(89);
				type();
				}
			}

			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(92);
				match(T__2);
				setState(93);
				primary();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(94);
					type();
					}
				}

				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(T__3);
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
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__4);
			setState(105);
			primary();
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
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__4);
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case VAR_CONST:
			case EXPORT:
			case RETURN:
			case CONTINUE_BREAK_PASS:
				{
				setState(108);
				simple_stmt();
				}
				break;
			case NEWLINE:
				{
				{
				setState(109);
				match(NEWLINE);
				setState(110);
				match(INDENT);
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					stmt();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << VAR_CONST) | (1L << FUNC) | (1L << EXPORT) | (1L << RETURN) | (1L << CONTINUE_BREAK_PASS) | (1L << CLASS) | (1L << NEWLINE))) != 0) );
				setState(116);
				match(DEDENT);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public TerminalNode NUMBER() { return getToken(GDScriptParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public TerminalNode TRUE_FALSE() { return getToken(GDScriptParser.TRUE_FALSE, 0); }
		public TerminalNode PRIMITIVE_TYPE() { return getToken(GDScriptParser.PRIMITIVE_TYPE, 0); }
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
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
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE_FALSE) | (1L << PRIMITIVE_TYPE) | (1L << CLASS_NAME) | (1L << PARAMETER) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\'\n\4\3\4\3\4\3\4\5\4,\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\48\n\4\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\5\6C\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"X\n\6\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\3\7\5\7b\n\7\7\7d\n\7\f\7\16\7g\13"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\6\ts\n\t\r\t\16\tt\3\t\3\t"+
		"\5\ty\n\t\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\4\2\23\24\26\31"+
		"\2\u0087\2\27\3\2\2\2\4\37\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\nW\3\2\2\2"+
		"\fY\3\2\2\2\16j\3\2\2\2\20m\3\2\2\2\22z\3\2\2\2\24\26\5\4\3\2\25\24\3"+
		"\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3"+
		"\2\2\2\32\33\7\2\2\3\33\3\3\2\2\2\34 \5\6\4\2\35 \5\n\6\2\36 \7\32\2\2"+
		"\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 \5\3\2\2\2!\"\7\f\2\2\"#\5"+
		"\22\n\2#$\7\32\2\2$8\3\2\2\2%\'\5\b\5\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2"+
		"\2()\7\r\2\2)+\7\27\2\2*,\5\16\b\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\3"+
		"\2\2./\5\22\n\2/\60\7\32\2\2\608\3\2\2\2\61\62\7\20\2\2\62\63\5\22\n\2"+
		"\63\64\7\32\2\2\648\3\2\2\2\65\66\7\22\2\2\668\7\32\2\2\67!\3\2\2\2\67"+
		"&\3\2\2\2\67\61\3\2\2\2\67\65\3\2\2\28\7\3\2\2\29;\7\17\2\2:<\5\f\7\2"+
		";:\3\2\2\2;<\3\2\2\2<\t\3\2\2\2=>\7\b\2\2>?\5\22\n\2?B\5\20\t\2@A\7\t"+
		"\2\2AC\5\20\t\2B@\3\2\2\2BC\3\2\2\2CX\3\2\2\2DE\7\13\2\2EF\5\22\n\2FG"+
		"\5\20\t\2GX\3\2\2\2HI\7\n\2\2IJ\5\22\n\2JK\5\20\t\2KX\3\2\2\2LM\7\16\2"+
		"\2MO\5\22\n\2NP\5\f\7\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\5\20\t\2RX\3\2"+
		"\2\2ST\7\25\2\2TU\5\22\n\2UV\5\20\t\2VX\3\2\2\2W=\3\2\2\2WD\3\2\2\2WH"+
		"\3\2\2\2WL\3\2\2\2WS\3\2\2\2X\13\3\2\2\2YZ\7\4\2\2Z\\\5\22\n\2[]\5\16"+
		"\b\2\\[\3\2\2\2\\]\3\2\2\2]e\3\2\2\2^_\7\5\2\2_a\5\22\n\2`b\5\16\b\2a"+
		"`\3\2\2\2ab\3\2\2\2bd\3\2\2\2c^\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"fh\3\2\2\2ge\3\2\2\2hi\7\6\2\2i\r\3\2\2\2jk\7\7\2\2kl\5\22\n\2l\17\3\2"+
		"\2\2mx\7\7\2\2ny\5\6\4\2op\7\32\2\2pr\7\36\2\2qs\5\4\3\2rq\3\2\2\2st\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\37\2\2wy\3\2\2\2xn\3\2\2\2xo"+
		"\3\2\2\2y\21\3\2\2\2z{\t\2\2\2{\23\3\2\2\2\20\27\37&+\67;BOW\\aetx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}