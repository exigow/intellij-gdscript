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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, EXPORT=9, 
		ONREADY=10, VAR=11, SETGET=12, STATIC=13, FUNC=14, CLASS=15, EXTENDS=16, 
		CLASS_NAME=17, ENUM=18, IF=19, ELIF=20, ELSE=21, RETURN=22, IDENTIFIER=23, 
		NUMBER=24, STRING=25, LINE_COMMENT=26, NL=27, WHITESPACE=28, ERRCHAR=29;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_var_line = 2, RULE_func_line = 3, RULE_class_line = 4, 
		RULE_extends_line = 5, RULE_class_name_line = 6, RULE_enum_line = 7, RULE_if_line = 8, 
		RULE_elif_line = 9, RULE_else_line = 10, RULE_return_line = 11, RULE_expr = 12, 
		RULE_func_invoke_expr = 13, RULE_dictionary_expr = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "func_line", "class_line", "extends_line", 
			"class_name_line", "enum_line", "if_line", "elif_line", "else_line", 
			"return_line", "expr", "func_invoke_expr", "dictionary_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'export'", 
			"'onready'", "'var'", "'setget'", "'static'", "'func'", "'class'", "'extends'", 
			"'class_name'", "'enum'", "'if'", "'elif'", "'else'", "'return'", null, 
			null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "STATIC", "FUNC", "CLASS", "EXTENDS", "CLASS_NAME", 
			"ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", "STRING", 
			"LINE_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
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
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GDScriptParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GDScriptParser.NL, i);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					line();
					}
					break;
				case 2:
					{
					setState(31);
					expr();
					}
					break;
				case 3:
					{
					setState(32);
					match(NL);
					}
					break;
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << EXPORT) | (1L << ONREADY) | (1L << VAR) | (1L << STATIC) | (1L << FUNC) | (1L << CLASS) | (1L << EXTENDS) | (1L << CLASS_NAME) | (1L << ENUM) | (1L << IF) | (1L << ELIF) | (1L << ELSE) | (1L << RETURN) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << NL) | (1L << WHITESPACE))) != 0) );
			setState(37);
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

	public static class LineContext extends ParserRuleContext {
		public Var_lineContext var_line() {
			return getRuleContext(Var_lineContext.class,0);
		}
		public Func_lineContext func_line() {
			return getRuleContext(Func_lineContext.class,0);
		}
		public Class_lineContext class_line() {
			return getRuleContext(Class_lineContext.class,0);
		}
		public Extends_lineContext extends_line() {
			return getRuleContext(Extends_lineContext.class,0);
		}
		public Class_name_lineContext class_name_line() {
			return getRuleContext(Class_name_lineContext.class,0);
		}
		public Enum_lineContext enum_line() {
			return getRuleContext(Enum_lineContext.class,0);
		}
		public If_lineContext if_line() {
			return getRuleContext(If_lineContext.class,0);
		}
		public Elif_lineContext elif_line() {
			return getRuleContext(Elif_lineContext.class,0);
		}
		public Else_lineContext else_line() {
			return getRuleContext(Else_lineContext.class,0);
		}
		public Return_lineContext return_line() {
			return getRuleContext(Return_lineContext.class,0);
		}
		public Func_invoke_exprContext func_invoke_expr() {
			return getRuleContext(Func_invoke_exprContext.class,0);
		}
		public Dictionary_exprContext dictionary_expr() {
			return getRuleContext(Dictionary_exprContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
			case ONREADY:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				var_line();
				}
				break;
			case STATIC:
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				func_line();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				class_line();
				}
				break;
			case EXTENDS:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				extends_line();
				}
				break;
			case CLASS_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				class_name_line();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				enum_line();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				if_line();
				}
				break;
			case ELIF:
				enterOuterAlt(_localctx, 8);
				{
				setState(46);
				elif_line();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 9);
				{
				setState(47);
				else_line();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 10);
				{
				setState(48);
				return_line();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 11);
				{
				setState(49);
				func_invoke_expr();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 12);
				{
				setState(50);
				dictionary_expr();
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

	public static class Var_lineContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(GDScriptParser.VAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GDScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GDScriptParser.IDENTIFIER, i);
		}
		public TerminalNode EXPORT() { return getToken(GDScriptParser.EXPORT, 0); }
		public TerminalNode ONREADY() { return getToken(GDScriptParser.ONREADY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SETGET() { return getToken(GDScriptParser.SETGET, 0); }
		public Var_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_line; }
	}

	public final Var_lineContext var_line() throws RecognitionException {
		Var_lineContext _localctx = new Var_lineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(53);
				match(EXPORT);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(54);
					match(T__0);
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << WHITESPACE))) != 0)) {
						{
						setState(55);
						expr();
						}
					}

					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(58);
						match(T__1);
						setState(59);
						expr();
						}
						}
						setState(64);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(65);
					match(T__2);
					}
				}

				}
			}

			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(70);
				match(ONREADY);
				}
			}

			setState(73);
			match(VAR);
			setState(74);
			match(IDENTIFIER);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(75);
				match(T__3);
				setState(76);
				match(IDENTIFIER);
				}
			}

			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(79);
				match(T__4);
				setState(80);
				expr();
				}
			}

			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(83);
				match(SETGET);
				setState(85);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(84);
					match(IDENTIFIER);
					}
					break;
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(87);
					match(T__1);
					setState(88);
					match(IDENTIFIER);
					}
				}

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

	public static class Func_lineContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GDScriptParser.FUNC, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GDScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GDScriptParser.IDENTIFIER, i);
		}
		public TerminalNode STATIC() { return getToken(GDScriptParser.STATIC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Func_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_line; }
	}

	public final Func_lineContext func_line() throws RecognitionException {
		Func_lineContext _localctx = new Func_lineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(93);
				match(STATIC);
				}
			}

			setState(96);
			match(FUNC);
			setState(97);
			match(IDENTIFIER);
			setState(98);
			match(T__0);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << WHITESPACE))) != 0)) {
				{
				setState(99);
				expr();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(102);
				match(T__1);
				setState(103);
				expr();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__2);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(110);
				match(T__5);
				setState(111);
				match(IDENTIFIER);
				}
			}

			setState(114);
			match(T__3);
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

	public static class Class_lineContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(GDScriptParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public Class_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_line; }
	}

	public final Class_lineContext class_line() throws RecognitionException {
		Class_lineContext _localctx = new Class_lineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(CLASS);
			setState(117);
			match(IDENTIFIER);
			setState(118);
			match(T__3);
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

	public static class Extends_lineContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(GDScriptParser.EXTENDS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public Extends_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_line; }
	}

	public final Extends_lineContext extends_line() throws RecognitionException {
		Extends_lineContext _localctx = new Extends_lineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_extends_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(EXTENDS);
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
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

	public static class Class_name_lineContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(GDScriptParser.CLASS_NAME, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public Class_name_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name_line; }
	}

	public final Class_name_lineContext class_name_line() throws RecognitionException {
		Class_name_lineContext _localctx = new Class_name_lineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class_name_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(CLASS_NAME);
			setState(124);
			match(IDENTIFIER);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(125);
				match(T__1);
				setState(126);
				match(STRING);
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

	public static class Enum_lineContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(GDScriptParser.ENUM, 0); }
		public Dictionary_exprContext dictionary_expr() {
			return getRuleContext(Dictionary_exprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public Enum_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_line; }
	}

	public final Enum_lineContext enum_line() throws RecognitionException {
		Enum_lineContext _localctx = new Enum_lineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_enum_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ENUM);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(130);
				match(IDENTIFIER);
				}
			}

			setState(133);
			dictionary_expr();
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

	public static class If_lineContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GDScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_line; }
	}

	public final If_lineContext if_line() throws RecognitionException {
		If_lineContext _localctx = new If_lineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IF);
			setState(136);
			expr();
			setState(137);
			match(T__3);
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

	public static class Elif_lineContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(GDScriptParser.ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Elif_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_line; }
	}

	public final Elif_lineContext elif_line() throws RecognitionException {
		Elif_lineContext _localctx = new Elif_lineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elif_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ELIF);
			setState(140);
			expr();
			setState(141);
			match(T__3);
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

	public static class Else_lineContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(GDScriptParser.ELSE, 0); }
		public Else_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_line; }
	}

	public final Else_lineContext else_line() throws RecognitionException {
		Else_lineContext _localctx = new Else_lineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_else_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ELSE);
			setState(144);
			match(T__3);
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

	public static class Return_lineContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(GDScriptParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_line; }
	}

	public final Return_lineContext return_line() throws RecognitionException {
		Return_lineContext _localctx = new Return_lineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_return_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(RETURN);
			setState(147);
			expr();
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(GDScriptParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public TerminalNode LINE_COMMENT() { return getToken(GDScriptParser.LINE_COMMENT, 0); }
		public TerminalNode WHITESPACE() { return getToken(GDScriptParser.WHITESPACE, 0); }
		public Func_invoke_exprContext func_invoke_expr() {
			return getRuleContext(Func_invoke_exprContext.class,0);
		}
		public Dictionary_exprContext dictionary_expr() {
			return getRuleContext(Dictionary_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				match(LINE_COMMENT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(153);
				match(WHITESPACE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				func_invoke_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(155);
				dictionary_expr();
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

	public static class Func_invoke_exprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Func_invoke_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_invoke_expr; }
	}

	public final Func_invoke_exprContext func_invoke_expr() throws RecognitionException {
		Func_invoke_exprContext _localctx = new Func_invoke_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_func_invoke_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IDENTIFIER);
			setState(159);
			match(T__0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << WHITESPACE))) != 0)) {
				{
				setState(160);
				expr();
				}
			}

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(163);
				match(T__1);
				setState(164);
				expr();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(T__2);
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

	public static class Dictionary_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Dictionary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionary_expr; }
	}

	public final Dictionary_exprContext dictionary_expr() throws RecognitionException {
		Dictionary_exprContext _localctx = new Dictionary_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dictionary_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__6);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << WHITESPACE))) != 0)) {
				{
				setState(173);
				expr();
				}
			}

			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(176);
				match(T__1);
				setState(177);
				expr();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__7);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00bc\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\6\2$\n"+
		"\2\r\2\16\2%\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\66\n\3\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\3\4\5\4"+
		"E\n\4\5\4G\n\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4\3\4\5\4T\n\4"+
		"\3\4\3\4\5\4X\n\4\3\4\3\4\5\4\\\n\4\5\4^\n\4\3\5\5\5a\n\5\3\5\3\5\3\5"+
		"\3\5\5\5g\n\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\5\3\5\3\5\5\5s\n\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0082\n\b\3\t\3\t"+
		"\5\t\u0086\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009f\n\16\3\17\3"+
		"\17\3\17\5\17\u00a4\n\17\3\17\3\17\7\17\u00a8\n\17\f\17\16\17\u00ab\13"+
		"\17\3\17\3\17\3\20\3\20\5\20\u00b1\n\20\3\20\3\20\7\20\u00b5\n\20\f\20"+
		"\16\20\u00b8\13\20\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36\2\3\4\2\31\31\33\33\2\u00d4\2#\3\2\2\2\4\65\3\2\2\2\6F\3\2\2"+
		"\2\b`\3\2\2\2\nv\3\2\2\2\fz\3\2\2\2\16}\3\2\2\2\20\u0083\3\2\2\2\22\u0089"+
		"\3\2\2\2\24\u008d\3\2\2\2\26\u0091\3\2\2\2\30\u0094\3\2\2\2\32\u009e\3"+
		"\2\2\2\34\u00a0\3\2\2\2\36\u00ae\3\2\2\2 $\5\4\3\2!$\5\32\16\2\"$\7\35"+
		"\2\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3"+
		"\2\2\2\'(\7\2\2\3(\3\3\2\2\2)\66\5\6\4\2*\66\5\b\5\2+\66\5\n\6\2,\66\5"+
		"\f\7\2-\66\5\16\b\2.\66\5\20\t\2/\66\5\22\n\2\60\66\5\24\13\2\61\66\5"+
		"\26\f\2\62\66\5\30\r\2\63\66\5\34\17\2\64\66\5\36\20\2\65)\3\2\2\2\65"+
		"*\3\2\2\2\65+\3\2\2\2\65,\3\2\2\2\65-\3\2\2\2\65.\3\2\2\2\65/\3\2\2\2"+
		"\65\60\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2"+
		"\66\5\3\2\2\2\67D\7\13\2\28:\7\3\2\29;\5\32\16\2:9\3\2\2\2:;\3\2\2\2;"+
		"@\3\2\2\2<=\7\4\2\2=?\5\32\16\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2AC\3\2\2\2B@\3\2\2\2CE\7\5\2\2D8\3\2\2\2DE\3\2\2\2EG\3\2\2\2F\67\3\2"+
		"\2\2FG\3\2\2\2GI\3\2\2\2HJ\7\f\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\r"+
		"\2\2LO\7\31\2\2MN\7\6\2\2NP\7\31\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QR\7"+
		"\7\2\2RT\5\32\16\2SQ\3\2\2\2ST\3\2\2\2T]\3\2\2\2UW\7\16\2\2VX\7\31\2\2"+
		"WV\3\2\2\2WX\3\2\2\2X[\3\2\2\2YZ\7\4\2\2Z\\\7\31\2\2[Y\3\2\2\2[\\\3\2"+
		"\2\2\\^\3\2\2\2]U\3\2\2\2]^\3\2\2\2^\7\3\2\2\2_a\7\17\2\2`_\3\2\2\2`a"+
		"\3\2\2\2ab\3\2\2\2bc\7\20\2\2cd\7\31\2\2df\7\3\2\2eg\5\32\16\2fe\3\2\2"+
		"\2fg\3\2\2\2gl\3\2\2\2hi\7\4\2\2ik\5\32\16\2jh\3\2\2\2kn\3\2\2\2lj\3\2"+
		"\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2or\7\5\2\2pq\7\b\2\2qs\7\31\2\2rp\3"+
		"\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\6\2\2u\t\3\2\2\2vw\7\21\2\2wx\7\31\2\2"+
		"xy\7\6\2\2y\13\3\2\2\2z{\7\22\2\2{|\t\2\2\2|\r\3\2\2\2}~\7\23\2\2~\u0081"+
		"\7\31\2\2\177\u0080\7\4\2\2\u0080\u0082\7\33\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\17\3\2\2\2\u0083\u0085\7\24\2\2\u0084\u0086\7\31"+
		"\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\5\36\20\2\u0088\21\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008b\5\32"+
		"\16\2\u008b\u008c\7\6\2\2\u008c\23\3\2\2\2\u008d\u008e\7\26\2\2\u008e"+
		"\u008f\5\32\16\2\u008f\u0090\7\6\2\2\u0090\25\3\2\2\2\u0091\u0092\7\27"+
		"\2\2\u0092\u0093\7\6\2\2\u0093\27\3\2\2\2\u0094\u0095\7\30\2\2\u0095\u0096"+
		"\5\32\16\2\u0096\31\3\2\2\2\u0097\u009f\7\31\2\2\u0098\u009f\7\32\2\2"+
		"\u0099\u009f\7\33\2\2\u009a\u009f\7\34\2\2\u009b\u009f\7\36\2\2\u009c"+
		"\u009f\5\34\17\2\u009d\u009f\5\36\20\2\u009e\u0097\3\2\2\2\u009e\u0098"+
		"\3\2\2\2\u009e\u0099\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009b\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\33\3\2\2\2\u00a0\u00a1\7\31\2"+
		"\2\u00a1\u00a3\7\3\2\2\u00a2\u00a4\5\32\16\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a9\3\2\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a8\5\32"+
		"\16\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\5"+
		"\2\2\u00ad\35\3\2\2\2\u00ae\u00b0\7\t\2\2\u00af\u00b1\5\32\16\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b6\3\2\2\2\u00b2\u00b3\7\4"+
		"\2\2\u00b3\u00b5\5\32\16\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00ba\7\n\2\2\u00ba\37\3\2\2\2\32#%\65:@DFIOSW[]`flr\u0081"+
		"\u0085\u009e\u00a3\u00a9\u00b0\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}