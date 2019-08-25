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
		ONREADY=10, VAR=11, SETGET=12, CONST=13, STATIC=14, FUNC=15, FOR=16, IN=17, 
		WHILE=18, CLASS=19, EXTENDS=20, CLASS_NAME=21, ENUM=22, IF=23, ELIF=24, 
		ELSE=25, RETURN=26, IDENTIFIER=27, NUMBER=28, STRING=29, LINE_COMMENT=30, 
		BLOCK_COMMENT=31, NL=32, WHITESPACE=33, ERRCHAR=34;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_var_line = 2, RULE_const_line = 3, 
		RULE_func_line = 4, RULE_for_line = 5, RULE_while_line = 6, RULE_class_line = 7, 
		RULE_extends_line = 8, RULE_class_name_line = 9, RULE_enum_line = 10, 
		RULE_if_line = 11, RULE_elif_line = 12, RULE_else_line = 13, RULE_return_line = 14, 
		RULE_expr = 15, RULE_func_invoke_expr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "const_line", "func_line", "for_line", "while_line", 
			"class_line", "extends_line", "class_name_line", "enum_line", "if_line", 
			"elif_line", "else_line", "return_line", "expr", "func_invoke_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'export'", 
			"'onready'", "'var'", "'setget'", "'const'", "'static'", "'func'", "'for'", 
			"'in'", "'while'", "'class'", "'extends'", "'class_name'", "'enum'", 
			"'if'", "'elif'", "'else'", "'return'", null, null, null, null, null, 
			"'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", 
			"EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", 
			"NUMBER", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", 
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
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
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
					{
					setState(34);
					line();
					}
					break;
				case LINE_COMMENT:
					{
					setState(35);
					match(LINE_COMMENT);
					}
					break;
				case BLOCK_COMMENT:
					{
					setState(36);
					match(BLOCK_COMMENT);
					}
					break;
				case NL:
					{
					setState(37);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPORT) | (1L << ONREADY) | (1L << VAR) | (1L << CONST) | (1L << STATIC) | (1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << CLASS) | (1L << EXTENDS) | (1L << CLASS_NAME) | (1L << ENUM) | (1L << IF) | (1L << ELIF) | (1L << ELSE) | (1L << RETURN) | (1L << IDENTIFIER) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL))) != 0) );
			setState(42);
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
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
			case ONREADY:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				var_line();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				const_line();
				}
				break;
			case STATIC:
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				func_line();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				for_line();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				while_line();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				class_line();
				}
				break;
			case EXTENDS:
				enterOuterAlt(_localctx, 7);
				{
				setState(50);
				extends_line();
				}
				break;
			case CLASS_NAME:
				enterOuterAlt(_localctx, 8);
				{
				setState(51);
				class_name_line();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 9);
				{
				setState(52);
				enum_line();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				if_line();
				}
				break;
			case ELIF:
				enterOuterAlt(_localctx, 11);
				{
				setState(54);
				elif_line();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 12);
				{
				setState(55);
				else_line();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 13);
				{
				setState(56);
				return_line();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 14);
				{
				setState(57);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(60);
				match(EXPORT);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(61);
					match(T__0);
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
						{
						setState(62);
						expr();
						}
					}

					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(65);
						match(T__1);
						setState(66);
						expr();
						}
						}
						setState(71);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(72);
					match(T__2);
					}
				}

				}
			}

			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(77);
				match(ONREADY);
				}
			}

			setState(80);
			match(VAR);
			setState(81);
			match(IDENTIFIER);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(82);
				match(T__3);
				setState(83);
				match(IDENTIFIER);
				}
			}

			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(86);
				match(T__4);
				setState(87);
				expr();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(90);
				match(SETGET);
				setState(92);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(91);
					match(IDENTIFIER);
					}
					break;
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(94);
					match(T__1);
					setState(95);
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
			setState(100);
			match(CONST);
			setState(101);
			match(IDENTIFIER);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(102);
				match(T__3);
				setState(103);
				match(IDENTIFIER);
				}
			}

			setState(106);
			match(T__4);
			setState(107);
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
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(109);
				match(STATIC);
				}
			}

			setState(112);
			match(FUNC);
			setState(113);
			match(IDENTIFIER);
			setState(114);
			match(T__0);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(115);
				expr();
				}
			}

			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(118);
				match(T__1);
				setState(119);
				expr();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(T__2);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(126);
				match(T__5);
				setState(127);
				match(IDENTIFIER);
				}
			}

			setState(130);
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
			setState(132);
			match(FOR);
			setState(133);
			match(IDENTIFIER);
			setState(134);
			match(IN);
			setState(135);
			expr();
			setState(136);
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
			setState(138);
			match(WHILE);
			setState(139);
			expr();
			setState(140);
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
			setState(142);
			match(CLASS);
			setState(143);
			match(IDENTIFIER);
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
			setState(146);
			match(EXTENDS);
			{
			setState(147);
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
			setState(149);
			match(CLASS_NAME);
			setState(150);
			match(IDENTIFIER);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(151);
				match(T__1);
				setState(152);
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
			setState(155);
			match(ENUM);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(156);
				match(IDENTIFIER);
				}
			}

			setState(159);
			match(T__6);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
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
			setState(172);
			match(IF);
			setState(173);
			expr();
			setState(174);
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
			setState(176);
			match(ELIF);
			setState(177);
			expr();
			setState(178);
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
			setState(180);
			match(ELSE);
			setState(181);
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
			setState(183);
			match(RETURN);
			setState(184);
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
		enterRule(_localctx, 30, RULE_expr);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
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
		enterRule(_localctx, 32, RULE_func_invoke_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IDENTIFIER);
			setState(193);
			match(T__0);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(194);
				expr();
				}
			}

			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(197);
				match(T__1);
				setState(198);
				expr();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\6\2)\n\2\r\2\16\2*\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\5\4B\n\4\3\4\3\4\7"+
		"\4F\n\4\f\4\16\4I\13\4\3\4\5\4L\n\4\5\4N\n\4\3\4\5\4Q\n\4\3\4\3\4\3\4"+
		"\3\4\5\4W\n\4\3\4\3\4\5\4[\n\4\3\4\3\4\5\4_\n\4\3\4\3\4\5\4c\n\4\5\4e"+
		"\n\4\3\5\3\5\3\5\3\5\5\5k\n\5\3\5\3\5\3\5\3\6\5\6q\n\6\3\6\3\6\3\6\3\6"+
		"\5\6w\n\6\3\6\3\6\7\6{\n\6\f\6\16\6~\13\6\3\6\3\6\3\6\5\6\u0083\n\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\5\13\u009c\n\13\3\f\3\f\5\f\u00a0\n\f\3\f\3\f"+
		"\5\f\u00a4\n\f\3\f\3\f\7\f\u00a8\n\f\f\f\16\f\u00ab\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\5\21\u00c1\n\21\3\22\3\22\3\22\5\22\u00c6\n\22\3\22\3\22\7"+
		"\22\u00ca\n\22\f\22\16\22\u00cd\13\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"\2\2\2\u00e8\2(\3\2\2\2\4<\3\2\2\2\6M"+
		"\3\2\2\2\bf\3\2\2\2\np\3\2\2\2\f\u0086\3\2\2\2\16\u008c\3\2\2\2\20\u0090"+
		"\3\2\2\2\22\u0094\3\2\2\2\24\u0097\3\2\2\2\26\u009d\3\2\2\2\30\u00ae\3"+
		"\2\2\2\32\u00b2\3\2\2\2\34\u00b6\3\2\2\2\36\u00b9\3\2\2\2 \u00c0\3\2\2"+
		"\2\"\u00c2\3\2\2\2$)\5\4\3\2%)\7 \2\2&)\7!\2\2\')\7\"\2\2($\3\2\2\2(%"+
		"\3\2\2\2(&\3\2\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2"+
		",-\7\2\2\3-\3\3\2\2\2.=\5\6\4\2/=\5\b\5\2\60=\5\n\6\2\61=\5\f\7\2\62="+
		"\5\16\b\2\63=\5\20\t\2\64=\5\22\n\2\65=\5\24\13\2\66=\5\26\f\2\67=\5\30"+
		"\r\28=\5\32\16\29=\5\34\17\2:=\5\36\20\2;=\5\"\22\2<.\3\2\2\2</\3\2\2"+
		"\2<\60\3\2\2\2<\61\3\2\2\2<\62\3\2\2\2<\63\3\2\2\2<\64\3\2\2\2<\65\3\2"+
		"\2\2<\66\3\2\2\2<\67\3\2\2\2<8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2="+
		"\5\3\2\2\2>K\7\13\2\2?A\7\3\2\2@B\5 \21\2A@\3\2\2\2AB\3\2\2\2BG\3\2\2"+
		"\2CD\7\4\2\2DF\5 \21\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2"+
		"\2IG\3\2\2\2JL\7\5\2\2K?\3\2\2\2KL\3\2\2\2LN\3\2\2\2M>\3\2\2\2MN\3\2\2"+
		"\2NP\3\2\2\2OQ\7\f\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\r\2\2SV\7\35"+
		"\2\2TU\7\6\2\2UW\7\35\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XY\7\7\2\2Y[\5"+
		" \21\2ZX\3\2\2\2Z[\3\2\2\2[d\3\2\2\2\\^\7\16\2\2]_\7\35\2\2^]\3\2\2\2"+
		"^_\3\2\2\2_b\3\2\2\2`a\7\4\2\2ac\7\35\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2"+
		"\2d\\\3\2\2\2de\3\2\2\2e\7\3\2\2\2fg\7\17\2\2gj\7\35\2\2hi\7\6\2\2ik\7"+
		"\35\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\7\2\2mn\5 \21\2n\t\3\2\2\2o"+
		"q\7\20\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\21\2\2st\7\35\2\2tv\7\3\2"+
		"\2uw\5 \21\2vu\3\2\2\2vw\3\2\2\2w|\3\2\2\2xy\7\4\2\2y{\5 \21\2zx\3\2\2"+
		"\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0082\7\5"+
		"\2\2\u0080\u0081\7\b\2\2\u0081\u0083\7\35\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\6\2\2\u0085\13\3\2\2"+
		"\2\u0086\u0087\7\22\2\2\u0087\u0088\7\35\2\2\u0088\u0089\7\23\2\2\u0089"+
		"\u008a\5 \21\2\u008a\u008b\7\6\2\2\u008b\r\3\2\2\2\u008c\u008d\7\24\2"+
		"\2\u008d\u008e\5 \21\2\u008e\u008f\7\6\2\2\u008f\17\3\2\2\2\u0090\u0091"+
		"\7\25\2\2\u0091\u0092\7\35\2\2\u0092\u0093\7\6\2\2\u0093\21\3\2\2\2\u0094"+
		"\u0095\7\26\2\2\u0095\u0096\7\35\2\2\u0096\23\3\2\2\2\u0097\u0098\7\27"+
		"\2\2\u0098\u009b\7\35\2\2\u0099\u009a\7\4\2\2\u009a\u009c\7\37\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\25\3\2\2\2\u009d\u009f\7\30\2"+
		"\2\u009e\u00a0\7\35\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\7\t\2\2\u00a2\u00a4\5 \21\2\u00a3\u00a2\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a9\3\2\2\2\u00a5\u00a6\7\4\2\2\u00a6"+
		"\u00a8\5 \21\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ad\7\n\2\2\u00ad\27\3\2\2\2\u00ae\u00af\7\31\2\2\u00af\u00b0\5 \21"+
		"\2\u00b0\u00b1\7\6\2\2\u00b1\31\3\2\2\2\u00b2\u00b3\7\32\2\2\u00b3\u00b4"+
		"\5 \21\2\u00b4\u00b5\7\6\2\2\u00b5\33\3\2\2\2\u00b6\u00b7\7\33\2\2\u00b7"+
		"\u00b8\7\6\2\2\u00b8\35\3\2\2\2\u00b9\u00ba\7\34\2\2\u00ba\u00bb\5 \21"+
		"\2\u00bb\37\3\2\2\2\u00bc\u00c1\7\35\2\2\u00bd\u00c1\7\36\2\2\u00be\u00c1"+
		"\7\37\2\2\u00bf\u00c1\5\"\22\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1!\3\2\2\2\u00c2\u00c3\7"+
		"\35\2\2\u00c3\u00c5\7\3\2\2\u00c4\u00c6\5 \21\2\u00c5\u00c4\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00cb\3\2\2\2\u00c7\u00c8\7\4\2\2\u00c8\u00ca\5 "+
		"\21\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7\5"+
		"\2\2\u00cf#\3\2\2\2\33(*<AGKMPVZ^bdjpv|\u0082\u009b\u009f\u00a3\u00a9"+
		"\u00c0\u00c5\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}