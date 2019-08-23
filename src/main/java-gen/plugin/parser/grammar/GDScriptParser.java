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
		RULE_return_line = 12, RULE_expr = 13, RULE_func_invoke_expr = 14, RULE_dictionary_expr = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "const_line", "func_line", "class_line", 
			"extends_line", "class_name_line", "enum_line", "if_line", "elif_line", 
			"else_line", "return_line", "expr", "func_invoke_expr", "dictionary_expr"
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					line();
					}
					break;
				case 2:
					{
					setState(33);
					expr();
					}
					break;
				case 3:
					{
					setState(34);
					match(NL);
					}
					break;
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << EXPORT) | (1L << ONREADY) | (1L << VAR) | (1L << CONST) | (1L << STATIC) | (1L << FUNC) | (1L << CLASS) | (1L << EXTENDS) | (1L << CLASS_NAME) | (1L << ENUM) | (1L << IF) | (1L << ELIF) | (1L << ELSE) | (1L << RETURN) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL))) != 0) );
			setState(39);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
			case ONREADY:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				var_line();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				const_line();
				}
				break;
			case STATIC:
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				func_line();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				class_line();
				}
				break;
			case EXTENDS:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				extends_line();
				}
				break;
			case CLASS_NAME:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				class_name_line();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				enum_line();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 8);
				{
				setState(48);
				if_line();
				}
				break;
			case ELIF:
				enterOuterAlt(_localctx, 9);
				{
				setState(49);
				elif_line();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 10);
				{
				setState(50);
				else_line();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 11);
				{
				setState(51);
				return_line();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 12);
				{
				setState(52);
				func_invoke_expr();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 13);
				{
				setState(53);
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
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(56);
				match(EXPORT);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(57);
					match(T__0);
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT))) != 0)) {
						{
						setState(58);
						expr();
						}
					}

					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(61);
						match(T__1);
						setState(62);
						expr();
						}
						}
						setState(67);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(68);
					match(T__2);
					}
				}

				}
			}

			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(73);
				match(ONREADY);
				}
			}

			setState(76);
			match(VAR);
			setState(77);
			match(IDENTIFIER);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(78);
				match(T__3);
				setState(79);
				match(IDENTIFIER);
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(82);
				match(T__4);
				setState(83);
				expr();
				}
			}

			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(86);
				match(SETGET);
				setState(88);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(87);
					match(IDENTIFIER);
					}
					break;
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(90);
					match(T__1);
					setState(91);
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
		public TerminalNode IDENTIFIER() { return getToken(GDScriptParser.IDENTIFIER, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(CONST);
			setState(97);
			match(IDENTIFIER);
			setState(98);
			match(T__4);
			setState(99);
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
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(101);
				match(STATIC);
				}
			}

			setState(104);
			match(FUNC);
			setState(105);
			match(IDENTIFIER);
			setState(106);
			match(T__0);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT))) != 0)) {
				{
				setState(107);
				expr();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(110);
				match(T__1);
				setState(111);
				expr();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__2);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(118);
				match(T__5);
				setState(119);
				match(IDENTIFIER);
				}
			}

			setState(122);
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
			setState(124);
			match(CLASS);
			setState(125);
			match(IDENTIFIER);
			setState(126);
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
		enterRule(_localctx, 12, RULE_extends_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(EXTENDS);
			setState(129);
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
		enterRule(_localctx, 14, RULE_class_name_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(CLASS_NAME);
			setState(132);
			match(IDENTIFIER);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(133);
				match(T__1);
				setState(134);
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
		enterRule(_localctx, 16, RULE_enum_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ENUM);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(138);
				match(IDENTIFIER);
				}
			}

			setState(141);
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
		enterRule(_localctx, 18, RULE_if_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(IF);
			setState(144);
			expr();
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
			setState(147);
			match(ELIF);
			setState(148);
			expr();
			setState(149);
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
			setState(151);
			match(ELSE);
			setState(152);
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
			setState(154);
			match(RETURN);
			setState(155);
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
		public TerminalNode BLOCK_COMMENT() { return getToken(GDScriptParser.BLOCK_COMMENT, 0); }
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
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(LINE_COMMENT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				match(BLOCK_COMMENT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				func_invoke_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
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
		enterRule(_localctx, 28, RULE_func_invoke_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(IDENTIFIER);
			setState(167);
			match(T__0);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT))) != 0)) {
				{
				setState(168);
				expr();
				}
			}

			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(171);
				match(T__1);
				setState(172);
				expr();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
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
		enterRule(_localctx, 30, RULE_dictionary_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__6);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT))) != 0)) {
				{
				setState(181);
				expr();
				}
			}

			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(184);
				match(T__1);
				setState(185);
				expr();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00c4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\7\4B\n\4\f\4\16\4E"+
		"\13\4\3\4\5\4H\n\4\5\4J\n\4\3\4\5\4M\n\4\3\4\3\4\3\4\3\4\5\4S\n\4\3\4"+
		"\3\4\5\4W\n\4\3\4\3\4\5\4[\n\4\3\4\3\4\5\4_\n\4\5\4a\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\5\6i\n\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\7\6s\n\6\f\6\16\6"+
		"v\13\6\3\6\3\6\3\6\5\6{\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\5\t\u008a\n\t\3\n\3\n\5\n\u008e\n\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00a7\n\17\3\20\3\20\3\20\5\20\u00ac\n\20\3\20\3\20"+
		"\7\20\u00b0\n\20\f\20\16\20\u00b3\13\20\3\20\3\20\3\21\3\21\5\21\u00b9"+
		"\n\21\3\21\3\21\7\21\u00bd\n\21\f\21\16\21\u00c0\13\21\3\21\3\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\4\2\32\32\34\34\2"+
		"\u00dc\2%\3\2\2\2\48\3\2\2\2\6I\3\2\2\2\bb\3\2\2\2\nh\3\2\2\2\f~\3\2\2"+
		"\2\16\u0082\3\2\2\2\20\u0085\3\2\2\2\22\u008b\3\2\2\2\24\u0091\3\2\2\2"+
		"\26\u0095\3\2\2\2\30\u0099\3\2\2\2\32\u009c\3\2\2\2\34\u00a6\3\2\2\2\36"+
		"\u00a8\3\2\2\2 \u00b6\3\2\2\2\"&\5\4\3\2#&\5\34\17\2$&\7\37\2\2%\"\3\2"+
		"\2\2%#\3\2\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*"+
		"\7\2\2\3*\3\3\2\2\2+9\5\6\4\2,9\5\b\5\2-9\5\n\6\2.9\5\f\7\2/9\5\16\b\2"+
		"\609\5\20\t\2\619\5\22\n\2\629\5\24\13\2\639\5\26\f\2\649\5\30\r\2\65"+
		"9\5\32\16\2\669\5\36\20\2\679\5 \21\28+\3\2\2\28,\3\2\2\28-\3\2\2\28."+
		"\3\2\2\28/\3\2\2\28\60\3\2\2\28\61\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64"+
		"\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\5\3\2\2\2:G\7\13\2\2;=\7"+
		"\3\2\2<>\5\34\17\2=<\3\2\2\2=>\3\2\2\2>C\3\2\2\2?@\7\4\2\2@B\5\34\17\2"+
		"A?\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FH\7\5\2\2"+
		"G;\3\2\2\2GH\3\2\2\2HJ\3\2\2\2I:\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KM\7\f\2\2"+
		"LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\r\2\2OR\7\32\2\2PQ\7\6\2\2QS\7\32\2"+
		"\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TU\7\7\2\2UW\5\34\17\2VT\3\2\2\2VW\3\2"+
		"\2\2W`\3\2\2\2XZ\7\16\2\2Y[\7\32\2\2ZY\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\]"+
		"\7\4\2\2]_\7\32\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`X\3\2\2\2`a\3\2\2\2"+
		"a\7\3\2\2\2bc\7\17\2\2cd\7\32\2\2de\7\7\2\2ef\5\34\17\2f\t\3\2\2\2gi\7"+
		"\20\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\21\2\2kl\7\32\2\2ln\7\3\2\2"+
		"mo\5\34\17\2nm\3\2\2\2no\3\2\2\2ot\3\2\2\2pq\7\4\2\2qs\5\34\17\2rp\3\2"+
		"\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wz\7\5\2\2xy\7\b"+
		"\2\2y{\7\32\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\6\2\2}\13\3\2\2\2~\177"+
		"\7\22\2\2\177\u0080\7\32\2\2\u0080\u0081\7\6\2\2\u0081\r\3\2\2\2\u0082"+
		"\u0083\7\23\2\2\u0083\u0084\t\2\2\2\u0084\17\3\2\2\2\u0085\u0086\7\24"+
		"\2\2\u0086\u0089\7\32\2\2\u0087\u0088\7\4\2\2\u0088\u008a\7\34\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\21\3\2\2\2\u008b\u008d\7\25\2"+
		"\2\u008c\u008e\7\32\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\5 \21\2\u0090\23\3\2\2\2\u0091\u0092\7\26\2"+
		"\2\u0092\u0093\5\34\17\2\u0093\u0094\7\6\2\2\u0094\25\3\2\2\2\u0095\u0096"+
		"\7\27\2\2\u0096\u0097\5\34\17\2\u0097\u0098\7\6\2\2\u0098\27\3\2\2\2\u0099"+
		"\u009a\7\30\2\2\u009a\u009b\7\6\2\2\u009b\31\3\2\2\2\u009c\u009d\7\31"+
		"\2\2\u009d\u009e\5\34\17\2\u009e\33\3\2\2\2\u009f\u00a7\7\32\2\2\u00a0"+
		"\u00a7\7\33\2\2\u00a1\u00a7\7\34\2\2\u00a2\u00a7\7\35\2\2\u00a3\u00a7"+
		"\7\36\2\2\u00a4\u00a7\5\36\20\2\u00a5\u00a7\5 \21\2\u00a6\u009f\3\2\2"+
		"\2\u00a6\u00a0\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\35\3\2\2\2\u00a8"+
		"\u00a9\7\32\2\2\u00a9\u00ab\7\3\2\2\u00aa\u00ac\5\34\17\2\u00ab\u00aa"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b1\3\2\2\2\u00ad\u00ae\7\4\2\2\u00ae"+
		"\u00b0\5\34\17\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b5\7\5\2\2\u00b5\37\3\2\2\2\u00b6\u00b8\7\t\2\2\u00b7\u00b9\5\34\17"+
		"\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00be\3\2\2\2\u00ba\u00bb"+
		"\7\4\2\2\u00bb\u00bd\5\34\17\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\7\n\2\2\u00c2!\3\2\2\2\32%\'8=CGILRVZ^`hntz\u0089"+
		"\u008d\u00a6\u00ab\u00b1\u00b8\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}