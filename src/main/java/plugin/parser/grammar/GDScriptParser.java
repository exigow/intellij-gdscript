// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GDScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, EXPORT=44, ONREADY=45, 
		VAR=46, SETGET=47, CONST=48, STATIC=49, FUNC=50, FOR=51, IN=52, WHILE=53, 
		CLASS=54, EXTENDS=55, CLASS_NAME=56, ENUM=57, IF=58, ELIF=59, ELSE=60, 
		RETURN=61, IDENTIFIER=62, NUMBER=63, HEX=64, STRING=65, LINE_COMMENT=66, 
		BLOCK_COMMENT=67, NL=68, WHITESPACE=69, ERRCHAR=70;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_var_line = 2, RULE_const_line = 3, 
		RULE_func_line = 4, RULE_for_line = 5, RULE_while_line = 6, RULE_class_line = 7, 
		RULE_extends_line = 8, RULE_class_name_line = 9, RULE_enum_line = 10, 
		RULE_if_line = 11, RULE_elif_line = 12, RULE_else_line = 13, RULE_return_line = 14, 
		RULE_assign_line = 15, RULE_expr = 16, RULE_func_invoke_expr = 17, RULE_array_subscription_expr = 18, 
		RULE_array_expr = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "const_line", "func_line", "for_line", "while_line", 
			"class_line", "extends_line", "class_name_line", "enum_line", "if_line", 
			"elif_line", "else_line", "return_line", "assign_line", "expr", "func_invoke_expr", 
			"array_subscription_expr", "array_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'.'", "'is'", "'as'", 
			"'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&'", "'^'", 
			"'|'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'!'", "'&&'", "'||'", 
			"'not'", "'and'", "'or'", "'['", "']'", "'export'", "'onready'", "'var'", 
			"'setget'", "'const'", "'static'", "'func'", "'for'", "'in'", "'while'", 
			"'class'", "'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", 
			"'return'", null, null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", 
			"EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", 
			"NUMBER", "HEX", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", 
			"ERRCHAR"
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
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__41:
				case EXPORT:
				case ONREADY:
				case VAR:
				case CONST:
				case STATIC:
				case FUNC:
				case FOR:
				case WHILE:
				case CLASS:
				case EXTENDS:
				case CLASS_NAME:
				case ENUM:
				case IF:
				case ELIF:
				case ELSE:
				case RETURN:
				case IDENTIFIER:
				case NUMBER:
				case HEX:
				case STRING:
					{
					setState(40);
					line();
					}
					break;
				case LINE_COMMENT:
					{
					setState(41);
					match(LINE_COMMENT);
					}
					break;
				case BLOCK_COMMENT:
					{
					setState(42);
					match(BLOCK_COMMENT);
					}
					break;
				case NL:
					{
					setState(43);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__41) | (1L << EXPORT) | (1L << ONREADY) | (1L << VAR) | (1L << CONST) | (1L << STATIC) | (1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << CLASS) | (1L << EXTENDS) | (1L << CLASS_NAME) | (1L << ENUM) | (1L << IF) | (1L << ELIF) | (1L << ELSE) | (1L << RETURN) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (HEX - 64)) | (1L << (STRING - 64)) | (1L << (LINE_COMMENT - 64)) | (1L << (BLOCK_COMMENT - 64)) | (1L << (NL - 64)))) != 0) );
			setState(48);
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
		public For_lineContext for_line() {
			return getRuleContext(For_lineContext.class,0);
		}
		public While_lineContext while_line() {
			return getRuleContext(While_lineContext.class,0);
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
		public Assign_lineContext assign_line() {
			return getRuleContext(Assign_lineContext.class,0);
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				var_line();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				const_line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				func_line();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				for_line();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				while_line();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				class_line();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(56);
				extends_line();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(57);
				class_name_line();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(58);
				enum_line();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(59);
				if_line();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(60);
				elif_line();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(61);
				else_line();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(62);
				return_line();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(63);
				assign_line();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(64);
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
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(67);
				match(EXPORT);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(68);
					match(T__0);
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__41) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0) || _la==HEX || _la==STRING) {
						{
						setState(69);
						expr(0);
						}
					}

					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(72);
						match(T__1);
						setState(73);
						expr(0);
						}
						}
						setState(78);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(79);
					match(T__2);
					}
				}

				}
			}

			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(84);
				match(ONREADY);
				}
			}

			setState(87);
			match(VAR);
			setState(88);
			match(IDENTIFIER);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(89);
				match(T__3);
				setState(90);
				match(IDENTIFIER);
				}
			}

			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(93);
				match(T__4);
				setState(94);
				expr(0);
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(97);
				match(SETGET);
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(98);
					match(IDENTIFIER);
					}
					break;
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(101);
					match(T__1);
					setState(102);
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
			setState(107);
			match(CONST);
			setState(108);
			match(IDENTIFIER);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(109);
				match(T__3);
				setState(110);
				match(IDENTIFIER);
				}
			}

			setState(113);
			match(T__4);
			setState(114);
			expr(0);
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
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(116);
				match(STATIC);
				}
			}

			setState(119);
			match(FUNC);
			setState(120);
			match(IDENTIFIER);
			setState(121);
			match(T__0);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(122);
				match(IDENTIFIER);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(123);
					match(T__3);
					setState(124);
					match(IDENTIFIER);
					}
				}

				}
			}

			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(129);
				match(T__1);
				{
				setState(130);
				match(IDENTIFIER);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(131);
					match(T__3);
					setState(132);
					match(IDENTIFIER);
					}
				}

				}
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(T__2);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(141);
				match(T__5);
				setState(142);
				match(IDENTIFIER);
				}
			}

			setState(145);
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

	public static class For_lineContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(GDScriptParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(GDScriptParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_line; }
	}

	public final For_lineContext for_line() throws RecognitionException {
		For_lineContext _localctx = new For_lineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FOR);
			setState(148);
			match(IDENTIFIER);
			setState(149);
			match(IN);
			setState(150);
			expr(0);
			setState(151);
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

	public static class While_lineContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GDScriptParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public While_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_line; }
	}

	public final While_lineContext while_line() throws RecognitionException {
		While_lineContext _localctx = new While_lineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(WHILE);
			setState(154);
			expr(0);
			setState(155);
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
		enterRule(_localctx, 14, RULE_class_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(CLASS);
			setState(158);
			match(IDENTIFIER);
			setState(159);
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
		enterRule(_localctx, 16, RULE_extends_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(EXTENDS);
			{
			setState(162);
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
		enterRule(_localctx, 18, RULE_class_name_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(CLASS_NAME);
			setState(165);
			match(IDENTIFIER);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(166);
				match(T__1);
				setState(167);
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
		enterRule(_localctx, 20, RULE_enum_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ENUM);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(171);
				match(IDENTIFIER);
				}
			}

			setState(174);
			match(T__6);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__41) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0) || _la==HEX || _la==STRING) {
				{
				setState(175);
				expr(0);
				}
			}

			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(178);
				match(T__1);
				setState(179);
				expr(0);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
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
		enterRule(_localctx, 22, RULE_if_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(IF);
			setState(188);
			expr(0);
			setState(189);
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
		enterRule(_localctx, 24, RULE_elif_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(ELIF);
			setState(192);
			expr(0);
			setState(193);
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
		enterRule(_localctx, 26, RULE_else_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ELSE);
			setState(196);
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
		enterRule(_localctx, 28, RULE_return_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(RETURN);
			setState(199);
			expr(0);
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

	public static class Assign_lineContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Assign_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_line; }
	}

	public final Assign_lineContext assign_line() throws RecognitionException {
		Assign_lineContext _localctx = new Assign_lineContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assign_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			expr(0);
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(203);
			expr(0);
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
		public TerminalNode HEX() { return getToken(GDScriptParser.HEX, 0); }
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public Func_invoke_exprContext func_invoke_expr() {
			return getRuleContext(Func_invoke_exprContext.class,0);
		}
		public Array_subscription_exprContext array_subscription_expr() {
			return getRuleContext(Array_subscription_exprContext.class,0);
		}
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(GDScriptParser.IN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(206);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(207);
				match(NUMBER);
				}
				break;
			case 3:
				{
				setState(208);
				match(HEX);
				}
				break;
			case 4:
				{
				setState(209);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(210);
				func_invoke_expr();
				}
				break;
			case 6:
				{
				setState(211);
				array_subscription_expr();
				}
				break;
			case 7:
				{
				setState(212);
				array_expr();
				}
				break;
			case 8:
				{
				setState(213);
				match(T__0);
				setState(214);
				expr(0);
				setState(215);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(219);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(220);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << IN))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(221);
					expr(3);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 34, RULE_func_invoke_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(IDENTIFIER);
			setState(228);
			match(T__0);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__41) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0) || _la==HEX || _la==STRING) {
				{
				setState(229);
				expr(0);
				}
			}

			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(232);
				match(T__1);
				setState(233);
				expr(0);
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
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

	public static class Array_subscription_exprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_subscription_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_subscription_expr; }
	}

	public final Array_subscription_exprContext array_subscription_expr() throws RecognitionException {
		Array_subscription_exprContext _localctx = new Array_subscription_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_array_subscription_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(IDENTIFIER);
			setState(242);
			match(T__41);
			setState(243);
			expr(0);
			setState(244);
			match(T__42);
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

	public static class Array_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
	}

	public final Array_exprContext array_expr() throws RecognitionException {
		Array_exprContext _localctx = new Array_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__41);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__41) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0) || _la==HEX || _la==STRING) {
				{
				setState(247);
				expr(0);
				}
			}

			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(250);
				match(T__1);
				setState(251);
				expr(0);
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
			match(T__42);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3H\u0106\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\6\2/\n\2\r\2\16\2\60\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"D\n\3\3\4\3\4\3\4\5\4I\n\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\4\5\4S\n"+
		"\4\5\4U\n\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\5\4b\n\4\3\4"+
		"\3\4\5\4f\n\4\3\4\3\4\5\4j\n\4\5\4l\n\4\3\5\3\5\3\5\3\5\5\5r\n\5\3\5\3"+
		"\5\3\5\3\6\5\6x\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0080\n\6\5\6\u0082\n"+
		"\6\3\6\3\6\3\6\3\6\5\6\u0088\n\6\7\6\u008a\n\6\f\6\16\6\u008d\13\6\3\6"+
		"\3\6\3\6\5\6\u0092\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\f\3"+
		"\f\5\f\u00af\n\f\3\f\3\f\5\f\u00b3\n\f\3\f\3\f\7\f\u00b7\n\f\f\f\16\f"+
		"\u00ba\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00dc\n\22\3\22\3\22\3\22\7\22\u00e1\n"+
		"\22\f\22\16\22\u00e4\13\22\3\23\3\23\3\23\5\23\u00e9\n\23\3\23\3\23\7"+
		"\23\u00ed\n\23\f\23\16\23\u00f0\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\5\25\u00fb\n\25\3\25\3\25\7\25\u00ff\n\25\f\25\16\25\u0102"+
		"\13\25\3\25\3\25\3\25\2\3\"\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(\2\4\4\2\7\7\13\21\4\2\22+\66\66\2\u0124\2.\3\2\2\2\4C\3\2\2\2\6"+
		"T\3\2\2\2\bm\3\2\2\2\nw\3\2\2\2\f\u0095\3\2\2\2\16\u009b\3\2\2\2\20\u009f"+
		"\3\2\2\2\22\u00a3\3\2\2\2\24\u00a6\3\2\2\2\26\u00ac\3\2\2\2\30\u00bd\3"+
		"\2\2\2\32\u00c1\3\2\2\2\34\u00c5\3\2\2\2\36\u00c8\3\2\2\2 \u00cb\3\2\2"+
		"\2\"\u00db\3\2\2\2$\u00e5\3\2\2\2&\u00f3\3\2\2\2(\u00f8\3\2\2\2*/\5\4"+
		"\3\2+/\7D\2\2,/\7E\2\2-/\7F\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2"+
		"\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\2\2\3\63"+
		"\3\3\2\2\2\64D\5\6\4\2\65D\5\b\5\2\66D\5\n\6\2\67D\5\f\7\28D\5\16\b\2"+
		"9D\5\20\t\2:D\5\22\n\2;D\5\24\13\2<D\5\26\f\2=D\5\30\r\2>D\5\32\16\2?"+
		"D\5\34\17\2@D\5\36\20\2AD\5 \21\2BD\5$\23\2C\64\3\2\2\2C\65\3\2\2\2C\66"+
		"\3\2\2\2C\67\3\2\2\2C8\3\2\2\2C9\3\2\2\2C:\3\2\2\2C;\3\2\2\2C<\3\2\2\2"+
		"C=\3\2\2\2C>\3\2\2\2C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2"+
		"\2ER\7.\2\2FH\7\3\2\2GI\5\"\22\2HG\3\2\2\2HI\3\2\2\2IN\3\2\2\2JK\7\4\2"+
		"\2KM\5\"\22\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2"+
		"\2\2QS\7\5\2\2RF\3\2\2\2RS\3\2\2\2SU\3\2\2\2TE\3\2\2\2TU\3\2\2\2UW\3\2"+
		"\2\2VX\7/\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\60\2\2Z]\7@\2\2[\\\7\6"+
		"\2\2\\^\7@\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2\2_`\7\7\2\2`b\5\"\22\2a_\3"+
		"\2\2\2ab\3\2\2\2bk\3\2\2\2ce\7\61\2\2df\7@\2\2ed\3\2\2\2ef\3\2\2\2fi\3"+
		"\2\2\2gh\7\4\2\2hj\7@\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2kc\3\2\2\2kl\3"+
		"\2\2\2l\7\3\2\2\2mn\7\62\2\2nq\7@\2\2op\7\6\2\2pr\7@\2\2qo\3\2\2\2qr\3"+
		"\2\2\2rs\3\2\2\2st\7\7\2\2tu\5\"\22\2u\t\3\2\2\2vx\7\63\2\2wv\3\2\2\2"+
		"wx\3\2\2\2xy\3\2\2\2yz\7\64\2\2z{\7@\2\2{\u0081\7\3\2\2|\177\7@\2\2}~"+
		"\7\6\2\2~\u0080\7@\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2"+
		"\2\2\u0081|\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u008b\3\2\2\2\u0083\u0084"+
		"\7\4\2\2\u0084\u0087\7@\2\2\u0085\u0086\7\6\2\2\u0086\u0088\7@\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0083\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0091\7\5\2\2\u008f\u0090\7\b"+
		"\2\2\u0090\u0092\7@\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\7\6\2\2\u0094\13\3\2\2\2\u0095\u0096\7\65\2"+
		"\2\u0096\u0097\7@\2\2\u0097\u0098\7\66\2\2\u0098\u0099\5\"\22\2\u0099"+
		"\u009a\7\6\2\2\u009a\r\3\2\2\2\u009b\u009c\7\67\2\2\u009c\u009d\5\"\22"+
		"\2\u009d\u009e\7\6\2\2\u009e\17\3\2\2\2\u009f\u00a0\78\2\2\u00a0\u00a1"+
		"\7@\2\2\u00a1\u00a2\7\6\2\2\u00a2\21\3\2\2\2\u00a3\u00a4\79\2\2\u00a4"+
		"\u00a5\7@\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\7:\2\2\u00a7\u00aa\7@\2\2\u00a8"+
		"\u00a9\7\4\2\2\u00a9\u00ab\7C\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\25\3\2\2\2\u00ac\u00ae\7;\2\2\u00ad\u00af\7@\2\2\u00ae\u00ad"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\7\t\2\2\u00b1"+
		"\u00b3\5\"\22\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b8\3"+
		"\2\2\2\u00b4\u00b5\7\4\2\2\u00b5\u00b7\5\"\22\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\n\2\2\u00bc\27\3\2\2\2\u00bd\u00be"+
		"\7<\2\2\u00be\u00bf\5\"\22\2\u00bf\u00c0\7\6\2\2\u00c0\31\3\2\2\2\u00c1"+
		"\u00c2\7=\2\2\u00c2\u00c3\5\"\22\2\u00c3\u00c4\7\6\2\2\u00c4\33\3\2\2"+
		"\2\u00c5\u00c6\7>\2\2\u00c6\u00c7\7\6\2\2\u00c7\35\3\2\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9\u00ca\5\"\22\2\u00ca\37\3\2\2\2\u00cb\u00cc\5\"\22\2\u00cc"+
		"\u00cd\t\2\2\2\u00cd\u00ce\5\"\22\2\u00ce!\3\2\2\2\u00cf\u00d0\b\22\1"+
		"\2\u00d0\u00dc\7@\2\2\u00d1\u00dc\7A\2\2\u00d2\u00dc\7B\2\2\u00d3\u00dc"+
		"\7C\2\2\u00d4\u00dc\5$\23\2\u00d5\u00dc\5&\24\2\u00d6\u00dc\5(\25\2\u00d7"+
		"\u00d8\7\3\2\2\u00d8\u00d9\5\"\22\2\u00d9\u00da\7\5\2\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00cf\3\2\2\2\u00db\u00d1\3\2\2\2\u00db\u00d2\3\2\2\2\u00db"+
		"\u00d3\3\2\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2"+
		"\2\2\u00db\u00d7\3\2\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00de\f\4\2\2\u00de"+
		"\u00df\t\3\2\2\u00df\u00e1\5\"\22\5\u00e0\u00dd\3\2\2\2\u00e1\u00e4\3"+
		"\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3#\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5\u00e6\7@\2\2\u00e6\u00e8\7\3\2\2\u00e7\u00e9\5\"\22\2\u00e8"+
		"\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ee\3\2\2\2\u00ea\u00eb\7\4"+
		"\2\2\u00eb\u00ed\5\"\22\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f1\u00f2\7\5\2\2\u00f2%\3\2\2\2\u00f3\u00f4\7@\2\2\u00f4\u00f5"+
		"\7,\2\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\7-\2\2\u00f7\'\3\2\2\2\u00f8"+
		"\u00fa\7,\2\2\u00f9\u00fb\5\"\22\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u0100\3\2\2\2\u00fc\u00fd\7\4\2\2\u00fd\u00ff\5\"\22\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7-\2\2\u0104"+
		")\3\2\2\2 .\60CHNRTW]aeikqw\177\u0081\u0087\u008b\u0091\u00aa\u00ae\u00b2"+
		"\u00b8\u00db\u00e2\u00e8\u00ee\u00fa\u0100";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}