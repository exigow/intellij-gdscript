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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, EXPORT=41, ONREADY=42, VAR=43, SETGET=44, CONST=45, 
		STATIC=46, FUNC=47, FOR=48, IN=49, WHILE=50, CLASS=51, EXTENDS=52, CLASS_NAME=53, 
		ENUM=54, IF=55, ELIF=56, ELSE=57, RETURN=58, IDENTIFIER=59, NUMBER=60, 
		STRING=61, LINE_COMMENT=62, BLOCK_COMMENT=63, NL=64, WHITESPACE=65, ERRCHAR=66;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_var_line = 2, RULE_const_line = 3, 
		RULE_func_line = 4, RULE_for_line = 5, RULE_while_line = 6, RULE_class_line = 7, 
		RULE_extends_line = 8, RULE_class_name_line = 9, RULE_enum_line = 10, 
		RULE_if_line = 11, RULE_elif_line = 12, RULE_else_line = 13, RULE_return_line = 14, 
		RULE_assign_line = 15, RULE_expr = 16, RULE_func_invoke_expr = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "var_line", "const_line", "func_line", "for_line", "while_line", 
			"class_line", "extends_line", "class_name_line", "enum_line", "if_line", 
			"elif_line", "else_line", "return_line", "assign_line", "expr", "func_invoke_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'.'", "'is'", "'~'", 
			"'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&'", "'^'", "'|'", 
			"'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'!'", "'&&'", "'||'", 
			"'not'", "'and'", "'or'", "'export'", "'onready'", "'var'", "'setget'", 
			"'const'", "'static'", "'func'", "'for'", "'in'", "'while'", "'class'", 
			"'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", "'return'", 
			null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "EXPORT", "ONREADY", "VAR", "SETGET", "CONST", 
			"STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", "EXTENDS", "CLASS_NAME", 
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
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
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
				case STRING:
					{
					setState(36);
					line();
					}
					break;
				case LINE_COMMENT:
					{
					setState(37);
					match(LINE_COMMENT);
					}
					break;
				case BLOCK_COMMENT:
					{
					setState(38);
					match(BLOCK_COMMENT);
					}
					break;
				case NL:
					{
					setState(39);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (EXPORT - 1)) | (1L << (ONREADY - 1)) | (1L << (VAR - 1)) | (1L << (CONST - 1)) | (1L << (STATIC - 1)) | (1L << (FUNC - 1)) | (1L << (FOR - 1)) | (1L << (WHILE - 1)) | (1L << (CLASS - 1)) | (1L << (EXTENDS - 1)) | (1L << (CLASS_NAME - 1)) | (1L << (ENUM - 1)) | (1L << (IF - 1)) | (1L << (ELIF - 1)) | (1L << (ELSE - 1)) | (1L << (RETURN - 1)) | (1L << (IDENTIFIER - 1)) | (1L << (NUMBER - 1)) | (1L << (STRING - 1)) | (1L << (LINE_COMMENT - 1)) | (1L << (BLOCK_COMMENT - 1)) | (1L << (NL - 1)))) != 0) );
			setState(44);
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
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				var_line();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				const_line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				func_line();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				for_line();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				while_line();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				class_line();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				extends_line();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				class_name_line();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				enum_line();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(55);
				if_line();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(56);
				elif_line();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(57);
				else_line();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(58);
				return_line();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(59);
				assign_line();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(60);
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
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(63);
				match(EXPORT);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(64);
					match(T__0);
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
						{
						setState(65);
						expr(0);
						}
					}

					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(68);
						match(T__1);
						setState(69);
						expr(0);
						}
						}
						setState(74);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(75);
					match(T__2);
					}
				}

				}
			}

			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONREADY) {
				{
				setState(80);
				match(ONREADY);
				}
			}

			setState(83);
			match(VAR);
			setState(84);
			match(IDENTIFIER);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(85);
				match(T__3);
				setState(86);
				match(IDENTIFIER);
				}
			}

			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(89);
				match(T__4);
				setState(90);
				expr(0);
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SETGET) {
				{
				setState(93);
				match(SETGET);
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(94);
					match(IDENTIFIER);
					}
					break;
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(97);
					match(T__1);
					setState(98);
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
			setState(103);
			match(CONST);
			setState(104);
			match(IDENTIFIER);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(105);
				match(T__3);
				setState(106);
				match(IDENTIFIER);
				}
			}

			setState(109);
			match(T__4);
			setState(110);
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
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(112);
				match(STATIC);
				}
			}

			setState(115);
			match(FUNC);
			setState(116);
			match(IDENTIFIER);
			setState(117);
			match(T__0);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(118);
				expr(0);
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(121);
				match(T__1);
				setState(122);
				expr(0);
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__2);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(129);
				match(T__5);
				setState(130);
				match(IDENTIFIER);
				}
			}

			setState(133);
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
			setState(135);
			match(FOR);
			setState(136);
			match(IDENTIFIER);
			setState(137);
			match(IN);
			setState(138);
			expr(0);
			setState(139);
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
			setState(141);
			match(WHILE);
			setState(142);
			expr(0);
			setState(143);
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
			setState(145);
			match(CLASS);
			setState(146);
			match(IDENTIFIER);
			setState(147);
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
			setState(149);
			match(EXTENDS);
			{
			setState(150);
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
			setState(152);
			match(CLASS_NAME);
			setState(153);
			match(IDENTIFIER);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(154);
				match(T__1);
				setState(155);
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
			setState(158);
			match(ENUM);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(159);
				match(IDENTIFIER);
				}
			}

			setState(162);
			match(T__6);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(163);
				expr(0);
				}
			}

			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(166);
				match(T__1);
				setState(167);
				expr(0);
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
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
			setState(175);
			match(IF);
			setState(176);
			expr(0);
			setState(177);
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
			setState(179);
			match(ELIF);
			setState(180);
			expr(0);
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
			setState(183);
			match(ELSE);
			setState(184);
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
			setState(186);
			match(RETURN);
			setState(187);
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
			setState(189);
			expr(0);
			setState(190);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(191);
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
		public TerminalNode STRING() { return getToken(GDScriptParser.STRING, 0); }
		public Func_invoke_exprContext func_invoke_expr() {
			return getRuleContext(Func_invoke_exprContext.class,0);
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
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(194);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(195);
				match(NUMBER);
				}
				break;
			case 3:
				{
				setState(196);
				match(STRING);
				}
				break;
			case 4:
				{
				setState(197);
				func_invoke_expr();
				}
				break;
			case 5:
				{
				setState(198);
				match(T__0);
				setState(199);
				expr(0);
				setState(200);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(204);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(205);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << IN))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(206);
					expr(3);
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
			setState(212);
			match(IDENTIFIER);
			setState(213);
			match(T__0);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << STRING))) != 0)) {
				{
				setState(214);
				expr(0);
				}
			}

			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(217);
				match(T__1);
				setState(218);
				expr(0);
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u00e5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\6\2+\n\2\r\2\16\2,\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\4\3\4\3\4\5\4"+
		"E\n\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\5\4O\n\4\5\4Q\n\4\3\4\5\4T\n"+
		"\4\3\4\3\4\3\4\3\4\5\4Z\n\4\3\4\3\4\5\4^\n\4\3\4\3\4\5\4b\n\4\3\4\3\4"+
		"\5\4f\n\4\5\4h\n\4\3\5\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\3\5\3\6\5\6t\n\6\3"+
		"\6\3\6\3\6\3\6\5\6z\n\6\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\6\3\6\3"+
		"\6\5\6\u0086\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\f\3\f\5\f"+
		"\u00a3\n\f\3\f\3\f\5\f\u00a7\n\f\3\f\3\f\7\f\u00ab\n\f\f\f\16\f\u00ae"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00cd\n\22\3\22\3\22\3\22\7\22\u00d2\n\22\f\22\16\22\u00d5"+
		"\13\22\3\23\3\23\3\23\5\23\u00da\n\23\3\23\3\23\7\23\u00de\n\23\f\23\16"+
		"\23\u00e1\13\23\3\23\3\23\3\23\2\3\"\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\4\4\2\7\7\13\21\4\2\22*\63\63\2\u00fe\2*\3\2\2\2\4?\3"+
		"\2\2\2\6P\3\2\2\2\bi\3\2\2\2\ns\3\2\2\2\f\u0089\3\2\2\2\16\u008f\3\2\2"+
		"\2\20\u0093\3\2\2\2\22\u0097\3\2\2\2\24\u009a\3\2\2\2\26\u00a0\3\2\2\2"+
		"\30\u00b1\3\2\2\2\32\u00b5\3\2\2\2\34\u00b9\3\2\2\2\36\u00bc\3\2\2\2 "+
		"\u00bf\3\2\2\2\"\u00cc\3\2\2\2$\u00d6\3\2\2\2&+\5\4\3\2\'+\7@\2\2(+\7"+
		"A\2\2)+\7B\2\2*&\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,*\3"+
		"\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60@\5\6\4\2\61@\5\b\5"+
		"\2\62@\5\n\6\2\63@\5\f\7\2\64@\5\16\b\2\65@\5\20\t\2\66@\5\22\n\2\67@"+
		"\5\24\13\28@\5\26\f\29@\5\30\r\2:@\5\32\16\2;@\5\34\17\2<@\5\36\20\2="+
		"@\5 \21\2>@\5$\23\2?\60\3\2\2\2?\61\3\2\2\2?\62\3\2\2\2?\63\3\2\2\2?\64"+
		"\3\2\2\2?\65\3\2\2\2?\66\3\2\2\2?\67\3\2\2\2?8\3\2\2\2?9\3\2\2\2?:\3\2"+
		"\2\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\5\3\2\2\2AN\7+\2\2BD\7\3"+
		"\2\2CE\5\"\22\2DC\3\2\2\2DE\3\2\2\2EJ\3\2\2\2FG\7\4\2\2GI\5\"\22\2HF\3"+
		"\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MO\7\5\2\2NB\3"+
		"\2\2\2NO\3\2\2\2OQ\3\2\2\2PA\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RT\7,\2\2SR\3"+
		"\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7-\2\2VY\7=\2\2WX\7\6\2\2XZ\7=\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z]\3\2\2\2[\\\7\7\2\2\\^\5\"\22\2][\3\2\2\2]^\3\2\2\2^g"+
		"\3\2\2\2_a\7.\2\2`b\7=\2\2a`\3\2\2\2ab\3\2\2\2be\3\2\2\2cd\7\4\2\2df\7"+
		"=\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2g_\3\2\2\2gh\3\2\2\2h\7\3\2\2\2ij\7"+
		"/\2\2jm\7=\2\2kl\7\6\2\2ln\7=\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\7"+
		"\2\2pq\5\"\22\2q\t\3\2\2\2rt\7\60\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv"+
		"\7\61\2\2vw\7=\2\2wy\7\3\2\2xz\5\"\22\2yx\3\2\2\2yz\3\2\2\2z\177\3\2\2"+
		"\2{|\7\4\2\2|~\5\"\22\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0085\7\5\2\2\u0083"+
		"\u0084\7\b\2\2\u0084\u0086\7=\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\6\2\2\u0088\13\3\2\2\2\u0089\u008a"+
		"\7\62\2\2\u008a\u008b\7=\2\2\u008b\u008c\7\63\2\2\u008c\u008d\5\"\22\2"+
		"\u008d\u008e\7\6\2\2\u008e\r\3\2\2\2\u008f\u0090\7\64\2\2\u0090\u0091"+
		"\5\"\22\2\u0091\u0092\7\6\2\2\u0092\17\3\2\2\2\u0093\u0094\7\65\2\2\u0094"+
		"\u0095\7=\2\2\u0095\u0096\7\6\2\2\u0096\21\3\2\2\2\u0097\u0098\7\66\2"+
		"\2\u0098\u0099\7=\2\2\u0099\23\3\2\2\2\u009a\u009b\7\67\2\2\u009b\u009e"+
		"\7=\2\2\u009c\u009d\7\4\2\2\u009d\u009f\7?\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\25\3\2\2\2\u00a0\u00a2\78\2\2\u00a1\u00a3\7=\2\2"+
		"\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6"+
		"\7\t\2\2\u00a5\u00a7\5\"\22\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00ac\3\2\2\2\u00a8\u00a9\7\4\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\n\2\2\u00b0\27\3\2\2"+
		"\2\u00b1\u00b2\79\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\7\6\2\2\u00b4\31"+
		"\3\2\2\2\u00b5\u00b6\7:\2\2\u00b6\u00b7\5\"\22\2\u00b7\u00b8\7\6\2\2\u00b8"+
		"\33\3\2\2\2\u00b9\u00ba\7;\2\2\u00ba\u00bb\7\6\2\2\u00bb\35\3\2\2\2\u00bc"+
		"\u00bd\7<\2\2\u00bd\u00be\5\"\22\2\u00be\37\3\2\2\2\u00bf\u00c0\5\"\22"+
		"\2\u00c0\u00c1\t\2\2\2\u00c1\u00c2\5\"\22\2\u00c2!\3\2\2\2\u00c3\u00c4"+
		"\b\22\1\2\u00c4\u00cd\7=\2\2\u00c5\u00cd\7>\2\2\u00c6\u00cd\7?\2\2\u00c7"+
		"\u00cd\5$\23\2\u00c8\u00c9\7\3\2\2\u00c9\u00ca\5\"\22\2\u00ca\u00cb\7"+
		"\5\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00c5\3\2\2\2\u00cc"+
		"\u00c6\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\u00d3\3\2"+
		"\2\2\u00ce\u00cf\f\4\2\2\u00cf\u00d0\t\3\2\2\u00d0\u00d2\5\"\22\5\u00d1"+
		"\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4#\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7=\2\2\u00d7\u00d9"+
		"\7\3\2\2\u00d8\u00da\5\"\22\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2"+
		"\u00da\u00df\3\2\2\2\u00db\u00dc\7\4\2\2\u00dc\u00de\5\"\22\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\5\2\2\u00e3%\3\2\2\2"+
		"\34*,?DJNPSY]aegmsy\177\u0085\u009e\u00a2\u00a6\u00ac\u00cc\u00d3\u00d9"+
		"\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}