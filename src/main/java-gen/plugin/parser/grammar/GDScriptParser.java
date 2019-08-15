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
		EXTENDS=10, FUNC=11, EXPORT=12, RETURN=13, CLASS=14, VAR_CONST=15, CONTINUE_BREAK_PASS=16, 
		TRUE_FALSE=17, PRIMITIVE_TYPE=18, OPERATOR=19, CLASS_NAME=20, PARAMETER=21, 
		NUMBER=22, STRING=23, LINE_COMMENT=24, NEWLINE=25, WHITESPACE=26, ERRCHAR=27, 
		INDENT=28, DEDENT=29;
	public static final int
		RULE_file = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_compound_stmt = 3, 
		RULE_suite = 4, RULE_typed_primary_list = 5, RULE_typed_primary = 6, RULE_primary = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stmt", "simple_stmt", "compound_stmt", "suite", "typed_primary_list", 
			"typed_primary", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'('", "','", "')'", "'if'", "'else'", "'for'", "'while'", 
			"'extends'", "'func'", "'export'", "'return'", "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "FOR", "WHILE", "EXTENDS", 
			"FUNC", "EXPORT", "RETURN", "CLASS", "VAR_CONST", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "OPERATOR", "CLASS_NAME", "PARAMETER", 
			"NUMBER", "STRING", "LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR", 
			"INDENT", "DEDENT"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << FUNC) | (1L << EXPORT) | (1L << RETURN) | (1L << CLASS) | (1L << VAR_CONST) | (1L << CONTINUE_BREAK_PASS) | (1L << NEWLINE))) != 0)) {
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
			case EXPORT:
			case RETURN:
			case VAR_CONST:
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
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public TerminalNode VAR_CONST() { return getToken(GDScriptParser.VAR_CONST, 0); }
		public Typed_primaryContext typed_primary() {
			return getRuleContext(Typed_primaryContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(GDScriptParser.EXPORT, 0); }
		public Typed_primary_listContext typed_primary_list() {
			return getRuleContext(Typed_primary_listContext.class,0);
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
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(29);
				match(EXTENDS);
				setState(30);
				primary();
				setState(31);
				match(NEWLINE);
				}
				}
				break;
			case EXPORT:
			case VAR_CONST:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(33);
					match(EXPORT);
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(34);
						typed_primary_list();
						}
					}

					}
				}

				setState(39);
				match(VAR_CONST);
				setState(40);
				typed_primary();
				setState(41);
				match(T__0);
				setState(42);
				primary();
				setState(43);
				match(NEWLINE);
				}
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(45);
				match(RETURN);
				setState(46);
				primary();
				setState(47);
				match(NEWLINE);
				}
				}
				break;
			case CONTINUE_BREAK_PASS:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(49);
				match(CONTINUE_BREAK_PASS);
				setState(50);
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
		public Typed_primary_listContext typed_primary_list() {
			return getRuleContext(Typed_primary_listContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(GDScriptParser.CLASS, 0); }
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
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(53);
				match(IF);
				setState(54);
				primary();
				setState(55);
				suite();
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(56);
					match(ELSE);
					setState(57);
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
				setState(60);
				match(WHILE);
				setState(61);
				primary();
				setState(62);
				suite();
				}
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(64);
				match(FOR);
				setState(65);
				primary();
				setState(66);
				suite();
				}
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(68);
				match(FUNC);
				setState(69);
				primary();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(70);
					typed_primary_list();
					}
				}

				setState(73);
				suite();
				}
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(75);
				match(CLASS);
				setState(76);
				primary();
				setState(77);
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
		enterRule(_localctx, 8, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__1);
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case EXPORT:
			case RETURN:
			case VAR_CONST:
			case CONTINUE_BREAK_PASS:
				{
				setState(82);
				simple_stmt();
				}
				break;
			case NEWLINE:
				{
				{
				setState(83);
				match(NEWLINE);
				setState(84);
				match(INDENT);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					stmt();
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << EXTENDS) | (1L << FUNC) | (1L << EXPORT) | (1L << RETURN) | (1L << CLASS) | (1L << VAR_CONST) | (1L << CONTINUE_BREAK_PASS) | (1L << NEWLINE))) != 0) );
				setState(90);
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

	public static class Typed_primary_listContext extends ParserRuleContext {
		public List<Typed_primaryContext> typed_primary() {
			return getRuleContexts(Typed_primaryContext.class);
		}
		public Typed_primaryContext typed_primary(int i) {
			return getRuleContext(Typed_primaryContext.class,i);
		}
		public Typed_primary_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_primary_list; }
	}

	public final Typed_primary_listContext typed_primary_list() throws RecognitionException {
		Typed_primary_listContext _localctx = new Typed_primary_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typed_primary_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(94);
			match(T__2);
			setState(95);
			typed_primary();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(96);
				match(T__3);
				setState(97);
				typed_primary();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(T__4);
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

	public static class Typed_primaryContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public Typed_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_primary; }
	}

	public final Typed_primaryContext typed_primary() throws RecognitionException {
		Typed_primaryContext _localctx = new Typed_primaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typed_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			primary();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(106);
				match(T__1);
				setState(107);
				primary();
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
		enterRule(_localctx, 14, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4&\n\4\5\4(\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\66"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5J\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\6\6Y\n\6\r\6\16\6Z\3\6\3\6\5\6_\n\6\3\7\3\7\3\7\3\7\7\7e\n\7\f\7\16\7"+
		"h\13\7\3\7\3\7\3\b\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20"+
		"\2\3\4\2\23\24\26\31\2|\2\25\3\2\2\2\4\35\3\2\2\2\6\65\3\2\2\2\bQ\3\2"+
		"\2\2\nS\3\2\2\2\f`\3\2\2\2\16k\3\2\2\2\20p\3\2\2\2\22\24\5\4\3\2\23\22"+
		"\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25"+
		"\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\36\5\6\4\2\33\36\5\b\5\2\34\36"+
		"\7\33\2\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7"+
		"\f\2\2 !\5\20\t\2!\"\7\33\2\2\"\66\3\2\2\2#%\7\16\2\2$&\5\f\7\2%$\3\2"+
		"\2\2%&\3\2\2\2&(\3\2\2\2\'#\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\21\2\2*+"+
		"\5\16\b\2+,\7\3\2\2,-\5\20\t\2-.\7\33\2\2.\66\3\2\2\2/\60\7\17\2\2\60"+
		"\61\5\20\t\2\61\62\7\33\2\2\62\66\3\2\2\2\63\64\7\22\2\2\64\66\7\33\2"+
		"\2\65\37\3\2\2\2\65\'\3\2\2\2\65/\3\2\2\2\65\63\3\2\2\2\66\7\3\2\2\2\67"+
		"8\7\b\2\289\5\20\t\29<\5\n\6\2:;\7\t\2\2;=\5\n\6\2<:\3\2\2\2<=\3\2\2\2"+
		"=R\3\2\2\2>?\7\13\2\2?@\5\20\t\2@A\5\n\6\2AR\3\2\2\2BC\7\n\2\2CD\5\20"+
		"\t\2DE\5\n\6\2ER\3\2\2\2FG\7\r\2\2GI\5\20\t\2HJ\5\f\7\2IH\3\2\2\2IJ\3"+
		"\2\2\2JK\3\2\2\2KL\5\n\6\2LR\3\2\2\2MN\7\20\2\2NO\5\20\t\2OP\5\n\6\2P"+
		"R\3\2\2\2Q\67\3\2\2\2Q>\3\2\2\2QB\3\2\2\2QF\3\2\2\2QM\3\2\2\2R\t\3\2\2"+
		"\2S^\7\4\2\2T_\5\6\4\2UV\7\33\2\2VX\7\36\2\2WY\5\4\3\2XW\3\2\2\2YZ\3\2"+
		"\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\37\2\2]_\3\2\2\2^T\3\2\2\2^U"+
		"\3\2\2\2_\13\3\2\2\2`a\7\5\2\2af\5\16\b\2bc\7\6\2\2ce\5\16\b\2db\3\2\2"+
		"\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\7\2\2j\r\3\2"+
		"\2\2kn\5\20\t\2lm\7\4\2\2mo\5\20\t\2nl\3\2\2\2no\3\2\2\2o\17\3\2\2\2p"+
		"q\t\2\2\2q\21\3\2\2\2\16\25\35%\'\65<IQZ^fn";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}