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
		VAR=10, FUNC=11, RETURN=12, PASS=13, BOOL=14, INT=15, FLOAT=16, PARAMETER=17, 
		NUMBER=18, STRING=19, UNTERMINATED_STRING=20, NEWLINE=21, WHITESPACE=22, 
		LINE_COMMENT=23, ERRCHAR=24, INDENT=25, DEDENT=26;
	public static final int
		RULE_file = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_extends_stmt = 3, 
		RULE_variable_stmt = 4, RULE_const_stmt = 5, RULE_return_stmt = 6, RULE_pass_stmt = 7, 
		RULE_compound_stmt = 8, RULE_if_stmt = 9, RULE_while_stmt = 10, RULE_function_stmt = 11, 
		RULE_parameter_list = 12, RULE_parameter = 13, RULE_type = 14, RULE_suite = 15, 
		RULE_primary = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "stmt", "simple_stmt", "extends_stmt", "variable_stmt", "const_stmt", 
			"return_stmt", "pass_stmt", "compound_stmt", "if_stmt", "while_stmt", 
			"function_stmt", "parameter_list", "parameter", "type", "suite", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'('", "')'", "','", "'if'", "'while'", "'extends'", 
			"'const'", "'var'", "'func'", "'return'", "'pass'", "'bool'", "'int'", 
			"'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "BOOL", "INT", "FLOAT", "PARAMETER", 
			"NUMBER", "STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"ERRCHAR", "INDENT", "DEDENT"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << PASS) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(34);
				stmt();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				simple_stmt();
				}
				break;
			case IF:
			case WHILE:
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				compound_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
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
		public Extends_stmtContext extends_stmt() {
			return getRuleContext(Extends_stmtContext.class,0);
		}
		public Variable_stmtContext variable_stmt() {
			return getRuleContext(Variable_stmtContext.class,0);
		}
		public Const_stmtContext const_stmt() {
			return getRuleContext(Const_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Pass_stmtContext pass_stmt() {
			return getRuleContext(Pass_stmtContext.class,0);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simple_stmt);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				extends_stmt();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				variable_stmt();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				const_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				return_stmt();
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				pass_stmt();
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

	public static class Extends_stmtContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(GDScriptParser.EXTENDS, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public Extends_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_stmt; }
	}

	public final Extends_stmtContext extends_stmt() throws RecognitionException {
		Extends_stmtContext _localctx = new Extends_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_extends_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(EXTENDS);
			setState(55);
			match(PARAMETER);
			setState(56);
			match(NEWLINE);
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

	public static class Variable_stmtContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(GDScriptParser.VAR, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public Variable_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_stmt; }
	}

	public final Variable_stmtContext variable_stmt() throws RecognitionException {
		Variable_stmtContext _localctx = new Variable_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(VAR);
			setState(59);
			match(PARAMETER);
			setState(60);
			match(T__0);
			setState(61);
			primary();
			setState(62);
			match(NEWLINE);
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

	public static class Const_stmtContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDScriptParser.CONST, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public Const_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_stmt; }
	}

	public final Const_stmtContext const_stmt() throws RecognitionException {
		Const_stmtContext _localctx = new Const_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_const_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(CONST);
			setState(65);
			match(PARAMETER);
			setState(66);
			match(T__0);
			setState(67);
			primary();
			setState(68);
			match(NEWLINE);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(GDScriptParser.RETURN, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(RETURN);
			setState(71);
			primary();
			setState(72);
			match(NEWLINE);
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

	public static class Pass_stmtContext extends ParserRuleContext {
		public TerminalNode PASS() { return getToken(GDScriptParser.PASS, 0); }
		public TerminalNode NEWLINE() { return getToken(GDScriptParser.NEWLINE, 0); }
		public Pass_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pass_stmt; }
	}

	public final Pass_stmtContext pass_stmt() throws RecognitionException {
		Pass_stmtContext _localctx = new Pass_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pass_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(PASS);
			setState(75);
			match(NEWLINE);
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
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Function_stmtContext function_stmt() {
			return getRuleContext(Function_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compound_stmt);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				while_stmt();
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				function_stmt();
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GDScriptParser.IF, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(IF);
			setState(83);
			primary();
			setState(84);
			match(T__1);
			setState(85);
			suite();
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GDScriptParser.WHILE, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(WHILE);
			setState(88);
			primary();
			setState(89);
			match(T__1);
			setState(90);
			suite();
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

	public static class Function_stmtContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GDScriptParser.FUNC, 0); }
		public TerminalNode PARAMETER() { return getToken(GDScriptParser.PARAMETER, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Function_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_stmt; }
	}

	public final Function_stmtContext function_stmt() throws RecognitionException {
		Function_stmtContext _localctx = new Function_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(FUNC);
			setState(93);
			match(PARAMETER);
			setState(94);
			match(T__2);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARAMETER) {
				{
				setState(95);
				parameter_list();
				}
			}

			setState(98);
			match(T__3);
			setState(99);
			match(T__1);
			setState(100);
			suite();
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
		enterRule(_localctx, 24, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			parameter();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(103);
				match(T__4);
				setState(104);
				parameter();
				}
				}
				setState(109);
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
		enterRule(_localctx, 26, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(PARAMETER);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(111);
				match(T__1);
				setState(112);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_suite);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
			case CONST:
			case VAR:
			case RETURN:
			case PASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(NEWLINE);
				setState(119);
				match(INDENT);
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(120);
					stmt();
					}
					}
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << EXTENDS) | (1L << CONST) | (1L << VAR) | (1L << FUNC) | (1L << RETURN) | (1L << PASS) | (1L << NEWLINE))) != 0) );
				setState(125);
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
		enterRule(_localctx, 32, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0086\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\nS\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\rc\n\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\7\16l\n\16\f\16\16\16o\13\16\3\17\3\17\3\17"+
		"\5\17t\n\17\3\20\3\20\3\21\3\21\3\21\3\21\6\21|\n\21\r\21\16\21}\3\21"+
		"\3\21\5\21\u0082\n\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\4\3\2\20\22\3\2\23\25\2\u0082\2\'\3\2\2\2\4/\3\2\2\2"+
		"\6\66\3\2\2\2\b8\3\2\2\2\n<\3\2\2\2\fB\3\2\2\2\16H\3\2\2\2\20L\3\2\2\2"+
		"\22R\3\2\2\2\24T\3\2\2\2\26Y\3\2\2\2\30^\3\2\2\2\32h\3\2\2\2\34p\3\2\2"+
		"\2\36u\3\2\2\2 \u0081\3\2\2\2\"\u0083\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3"+
		"\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\2\2\3+\3\3\2\2\2"+
		",\60\5\6\4\2-\60\5\22\n\2.\60\7\27\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60"+
		"\5\3\2\2\2\61\67\5\b\5\2\62\67\5\n\6\2\63\67\5\f\7\2\64\67\5\16\b\2\65"+
		"\67\5\20\t\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66"+
		"\65\3\2\2\2\67\7\3\2\2\289\7\n\2\29:\7\23\2\2:;\7\27\2\2;\t\3\2\2\2<="+
		"\7\f\2\2=>\7\23\2\2>?\7\3\2\2?@\5\"\22\2@A\7\27\2\2A\13\3\2\2\2BC\7\13"+
		"\2\2CD\7\23\2\2DE\7\3\2\2EF\5\"\22\2FG\7\27\2\2G\r\3\2\2\2HI\7\16\2\2"+
		"IJ\5\"\22\2JK\7\27\2\2K\17\3\2\2\2LM\7\17\2\2MN\7\27\2\2N\21\3\2\2\2O"+
		"S\5\24\13\2PS\5\26\f\2QS\5\30\r\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\23\3"+
		"\2\2\2TU\7\b\2\2UV\5\"\22\2VW\7\4\2\2WX\5 \21\2X\25\3\2\2\2YZ\7\t\2\2"+
		"Z[\5\"\22\2[\\\7\4\2\2\\]\5 \21\2]\27\3\2\2\2^_\7\r\2\2_`\7\23\2\2`b\7"+
		"\5\2\2ac\5\32\16\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\6\2\2ef\7\4\2\2f"+
		"g\5 \21\2g\31\3\2\2\2hm\5\34\17\2ij\7\7\2\2jl\5\34\17\2ki\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2n\33\3\2\2\2om\3\2\2\2ps\7\23\2\2qr\7\4\2\2"+
		"rt\5\36\20\2sq\3\2\2\2st\3\2\2\2t\35\3\2\2\2uv\t\2\2\2v\37\3\2\2\2w\u0082"+
		"\5\6\4\2xy\7\27\2\2y{\7\33\2\2z|\5\4\3\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2"+
		"}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\34\2\2\u0080\u0082\3\2\2\2\u0081w"+
		"\3\2\2\2\u0081x\3\2\2\2\u0082!\3\2\2\2\u0083\u0084\t\3\2\2\u0084#\3\2"+
		"\2\2\13\'/\66Rbms}\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}