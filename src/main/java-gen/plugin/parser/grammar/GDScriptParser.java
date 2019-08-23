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
		ONREADY=10, VAR=11, SETGET=12, CONST=13, STATIC=14, FUNC=15, CLASS=16, 
		EXTENDS=17, CLASS_NAME=18, ENUM=19, IF=20, ELIF=21, ELSE=22, RETURN=23, 
		IDENTIFIER=24, NUMBER=25, STRING=26, LINE_COMMENT=27, BLOCK_COMMENT=28, 
		NL=29, WHITESPACE=30, ERRCHAR=31;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_var_line = 2, RULE_const_line = 3, 
		RULE_func_line = 4, RULE_class_line = 5, RULE_extends_line = 6, RULE_class_name_line = 7, 
		RULE_enum_line = 8, RULE_if_line = 9, RULE_elif_line = 10, RULE_else_line = 11, 
		RULE_return_line = 12, RULE_expr = 13, RULE_func_invoke_expr = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "const_line", "func_line", "class_line", 
			"extends_line", "class_name_line", "enum_line", "if_line", "elif_line", 
			"else_line", "return_line", "expr", "func_invoke_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'export'", 
			"'onready'", "'var'", "'setget'", "'const'", "'static'", "'func'", "'class'", 
			"'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", "'return'", 
			null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "CLASS", "EXTENDS", "CLASS_NAME", 
			"ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", "STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
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
		public List<TerminalNode> LINE_COMMENT() { return getTokens(GDScriptParser.LINE_COMMENT); }
		public TerminalNode LINE_COMMENT(int i) {
			return getToken(GDScriptParser.LINE_COMMENT, i);
		}
		public List<TerminalNode> BLOCK_COMMENT() { return getTokens(GDScriptParser.BLOCK_COMMENT); }
		public TerminalNode BLOCK_COMMENT(int i) {
			return getToken(GDScriptParser.BLOCK_COMMENT, i);
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
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXPORT:
				case ONREADY:
				case VAR:
				case CONST:
				case STATIC:
				case FUNC:
				case CLASS:
				case EXTENDS:
				case CLASS_NAME:
				case ENUM:
				case IF:
				case ELIF:
				case ELSE:
				case RETURN:
				case IDENTIFIER:
					{
					setState(30);
					line();
					}
					break;
				case LINE_COMMENT:
					{
					setState(31);
					match(LINE_COMMENT);
					}
					break;
				case BLOCK_COMMENT:
					{
					setState(32);
					match(BLOCK_COMMENT);
					}
					break;
				case NL:
					{
					setState(33);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPORT) | (1L << ONREADY) | (1L << VAR) | (1L << CONST) | (1L << STATIC) | (1L << FUNC) | (1L << CLASS) | (1L << EXTENDS) | (1L << CLASS_NAME) | (1L << ENUM) | (1L << IF) | (1L << ELIF) | (1L << ELSE) | (1L << RETURN) | (1L << IDENTIFIER) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL))) != 0) );
			setState(38);
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
		public Const_lineContext const_line() {
			return getRuleContext(Const_lineContext.class,0);
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
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
			case ONREADY:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				var_line();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				const_line();
				}
				break;
			case STATIC:
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				func_line();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				class_line();
				}
				break;
			case EXTENDS:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				extends_line();
				}
				break;
			case CLASS_NAME:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				class_name_line();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				enum_line();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				if_line();
				}
				break;
			case ELIF:
				enterOuterAlt(_localctx, 9);
				{
				setState(48);
				elif_line();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 10);
				{
				setState(49);
				else_line();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 11);
				{
				setState(50);
				return_line();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 12);
				{
				setState(51);
				func_invoke_expr();
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(54);
				match(EXPORT);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(55);
					match(T__0);
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
						{
						setState(56);
						expr();
						}
					}

					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(59);
						match(T__1);
						setState(60);
						expr();
						}
						}
						setState(65);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(66);
					match(T__2);
					}
				}

				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(71);
				match(ONREADY);
				}
			}

			setState(74);
			match(VAR);
			setState(75);
			match(IDENTIFIER);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(76);
				match(T__3);
				setState(77);
				match(IDENTIFIER);
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(80);
				match(T__4);
				setState(81);
				expr();
				}
			}

			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(84);
				match(SETGET);
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(85);
					match(IDENTIFIER);
					}
					break;
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(88);
					match(T__1);
					setState(89);
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

	public static class Const_lineContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDScriptParser.CONST, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GDScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GDScriptParser.IDENTIFIER, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Const_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_line; }
	}

	public final Const_lineContext const_line() throws RecognitionException {
		Const_lineContext _localctx = new Const_lineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_const_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(CONST);
			setState(95);
			match(IDENTIFIER);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(96);
				match(T__3);
				setState(97);
				match(IDENTIFIER);
				}
			}

			setState(100);
			match(T__4);
			setState(101);
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
		enterRule(_localctx, 8, RULE_func_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(103);
				match(STATIC);
				}
			}

			setState(106);
			match(FUNC);
			setState(107);
			match(IDENTIFIER);
			setState(108);
			match(T__0);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(109);
				expr();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(112);
				match(T__1);
				setState(113);
				expr();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(T__2);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(120);
				match(T__5);
				setState(121);
				match(IDENTIFIER);
				}
			}

			setState(124);
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
		enterRule(_localctx, 10, RULE_class_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(CLASS);
			setState(127);
			match(IDENTIFIER);
			setState(128);
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
		public Extends_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_line; }
	}

	public final Extends_lineContext extends_line() throws RecognitionException {
		Extends_lineContext _localctx = new Extends_lineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_extends_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(EXTENDS);
			{
			setState(131);
			match(IDENTIFIER);
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
		enterRule(_localctx, 14, RULE_class_name_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(CLASS_NAME);
			setState(134);
			match(IDENTIFIER);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(135);
				match(T__1);
				setState(136);
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
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Enum_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_line; }
	}

	public final Enum_lineContext enum_line() throws RecognitionException {
		Enum_lineContext _localctx = new Enum_lineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_enum_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ENUM);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(140);
				match(IDENTIFIER);
				}
			}

			setState(143);
			match(T__6);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(144);
				expr();
				}
			}

			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(147);
				match(T__1);
				setState(148);
				expr();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
		enterRule(_localctx, 18, RULE_if_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(IF);
			setState(157);
			expr();
			setState(158);
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
		enterRule(_localctx, 20, RULE_elif_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(ELIF);
			setState(161);
			expr();
			setState(162);
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
		enterRule(_localctx, 22, RULE_else_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(ELSE);
			setState(165);
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
		enterRule(_localctx, 24, RULE_return_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(RETURN);
			setState(168);
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
		public Func_invoke_exprContext func_invoke_expr() {
			return getRuleContext(Func_invoke_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				func_invoke_expr();
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
		enterRule(_localctx, 28, RULE_func_invoke_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(IDENTIFIER);
			setState(177);
			match(T__0);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(178);
				expr();
				}
			}

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(181);
				match(T__1);
				setState(182);
				expr();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00c1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\6\2"+
		"%\n\2\r\2\16\2&\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\67\n\3\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13\4\3\4"+
		"\5\4F\n\4\5\4H\n\4\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\5\4Q\n\4\3\4\3\4\5\4U"+
		"\n\4\3\4\3\4\5\4Y\n\4\3\4\3\4\5\4]\n\4\5\4_\n\4\3\5\3\5\3\5\3\5\5\5e\n"+
		"\5\3\5\3\5\3\5\3\6\5\6k\n\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\7\6u\n\6"+
		"\f\6\16\6x\13\6\3\6\3\6\3\6\5\6}\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\n\3\n\5\n\u0090\n\n\3\n\3\n\5\n\u0094"+
		"\n\n\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5"+
		"\17\u00b1\n\17\3\20\3\20\3\20\5\20\u00b6\n\20\3\20\3\20\7\20\u00ba\n\20"+
		"\f\20\16\20\u00bd\13\20\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36\2\2\2\u00d8\2$\3\2\2\2\4\66\3\2\2\2\6G\3\2\2\2\b`\3\2"+
		"\2\2\nj\3\2\2\2\f\u0080\3\2\2\2\16\u0084\3\2\2\2\20\u0087\3\2\2\2\22\u008d"+
		"\3\2\2\2\24\u009e\3\2\2\2\26\u00a2\3\2\2\2\30\u00a6\3\2\2\2\32\u00a9\3"+
		"\2\2\2\34\u00b0\3\2\2\2\36\u00b2\3\2\2\2 %\5\4\3\2!%\7\35\2\2\"%\7\36"+
		"\2\2#%\7\37\2\2$ \3\2\2\2$!\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3"+
		"\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\2\2\3)\3\3\2\2\2*\67\5\6\4\2+\67\5\b"+
		"\5\2,\67\5\n\6\2-\67\5\f\7\2.\67\5\16\b\2/\67\5\20\t\2\60\67\5\22\n\2"+
		"\61\67\5\24\13\2\62\67\5\26\f\2\63\67\5\30\r\2\64\67\5\32\16\2\65\67\5"+
		"\36\20\2\66*\3\2\2\2\66+\3\2\2\2\66,\3\2\2\2\66-\3\2\2\2\66.\3\2\2\2\66"+
		"/\3\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64"+
		"\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\28E\7\13\2\29;\7\3\2\2:<\5\34\17\2;"+
		":\3\2\2\2;<\3\2\2\2<A\3\2\2\2=>\7\4\2\2>@\5\34\17\2?=\3\2\2\2@C\3\2\2"+
		"\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DF\7\5\2\2E9\3\2\2\2EF\3\2\2"+
		"\2FH\3\2\2\2G8\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IK\7\f\2\2JI\3\2\2\2JK\3\2\2"+
		"\2KL\3\2\2\2LM\7\r\2\2MP\7\32\2\2NO\7\6\2\2OQ\7\32\2\2PN\3\2\2\2PQ\3\2"+
		"\2\2QT\3\2\2\2RS\7\7\2\2SU\5\34\17\2TR\3\2\2\2TU\3\2\2\2U^\3\2\2\2VX\7"+
		"\16\2\2WY\7\32\2\2XW\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2Z[\7\4\2\2[]\7\32\2\2"+
		"\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^V\3\2\2\2^_\3\2\2\2_\7\3\2\2\2`a\7\17"+
		"\2\2ad\7\32\2\2bc\7\6\2\2ce\7\32\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7"+
		"\7\2\2gh\5\34\17\2h\t\3\2\2\2ik\7\20\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2"+
		"lm\7\21\2\2mn\7\32\2\2np\7\3\2\2oq\5\34\17\2po\3\2\2\2pq\3\2\2\2qv\3\2"+
		"\2\2rs\7\4\2\2su\5\34\17\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3"+
		"\2\2\2xv\3\2\2\2y|\7\5\2\2z{\7\b\2\2{}\7\32\2\2|z\3\2\2\2|}\3\2\2\2}~"+
		"\3\2\2\2~\177\7\6\2\2\177\13\3\2\2\2\u0080\u0081\7\22\2\2\u0081\u0082"+
		"\7\32\2\2\u0082\u0083\7\6\2\2\u0083\r\3\2\2\2\u0084\u0085\7\23\2\2\u0085"+
		"\u0086\7\32\2\2\u0086\17\3\2\2\2\u0087\u0088\7\24\2\2\u0088\u008b\7\32"+
		"\2\2\u0089\u008a\7\4\2\2\u008a\u008c\7\34\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\21\3\2\2\2\u008d\u008f\7\25\2\2\u008e\u0090\7\32"+
		"\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\7\t\2\2\u0092\u0094\5\34\17\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0099\3\2\2\2\u0095\u0096\7\4\2\2\u0096\u0098\5\34\17\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\n\2\2\u009d"+
		"\23\3\2\2\2\u009e\u009f\7\26\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\7\6"+
		"\2\2\u00a1\25\3\2\2\2\u00a2\u00a3\7\27\2\2\u00a3\u00a4\5\34\17\2\u00a4"+
		"\u00a5\7\6\2\2\u00a5\27\3\2\2\2\u00a6\u00a7\7\30\2\2\u00a7\u00a8\7\6\2"+
		"\2\u00a8\31\3\2\2\2\u00a9\u00aa\7\31\2\2\u00aa\u00ab\5\34\17\2\u00ab\33"+
		"\3\2\2\2\u00ac\u00b1\7\32\2\2\u00ad\u00b1\7\33\2\2\u00ae\u00b1\7\34\2"+
		"\2\u00af\u00b1\5\36\20\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\35\3\2\2\2\u00b2\u00b3\7\32\2"+
		"\2\u00b3\u00b5\7\3\2\2\u00b4\u00b6\5\34\17\2\u00b5\u00b4\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00bb\3\2\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00ba\5\34"+
		"\17\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\5"+
		"\2\2\u00bf\37\3\2\2\2\33$&\66;AEGJPTX\\^djpv|\u008b\u008f\u0093\u0099"+
		"\u00b0\u00b5\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}