// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GDScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, KEYWORD=36, NUMBER=37, STRING=38, 
		IDENTIFIER=39, BRACKET=40, COMMA_SEPARATOR=41, LINE_COMMENT=42, NEWLINE=43, 
		WHITESPACE=44, ERRCHAR=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "KEYWORD", "NUMBER", "STRING", "UNTERMINATED_STRING", 
			"IDENTIFIER", "BRACKET", "COMMA_SEPARATOR", "LINE_COMMENT", "NEWLINE", 
			"WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'is'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<<'", "'>>'", 
			"'&'", "'^'", "'|'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'in'", 
			"'!'", "'not'", "'and'", "'&&'", "'or'", "'||'", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'&='", "'|='", "'->'", "':'", null, null, null, 
			null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"KEYWORD", "NUMBER", "STRING", "IDENTIFIER", "BRACKET", "COMMA_SEPARATOR", 
			"LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
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


	// Initializing `pendingDent` to true means any whitespace at the beginning
	// of the file will trigger an INDENT, which will probably be a syntax error,
	// as it is in Python.
	private boolean pendingDent = true;
	private int indentCount = 0;
	private java.util.LinkedList<Token> tokenQueue = new java.util.LinkedList<>();
	private java.util.Stack<Integer> indentStack = new java.util.Stack<>();
	private Token initialIndentToken = null;
	private int getSavedIndent() { return indentStack.isEmpty() ? 0 : indentStack.peek(); }

	private CommonToken createToken(int type, String text, Token next) {
	    CommonToken token = new CommonToken(type, text);
	    if (null != initialIndentToken) {
	        token.setStartIndex(initialIndentToken.getStartIndex());
	        token.setLine(initialIndentToken.getLine());
	        token.setCharPositionInLine(initialIndentToken.getCharPositionInLine());
	        token.setStopIndex(next.getStartIndex()-1);
	    }
	    return token;
	}

	@Override
	public Token nextToken() {
	    // Return tokens from the queue if it is not empty.
	    if (!tokenQueue.isEmpty()) { return tokenQueue.poll(); }

	    // Grab the next token and if nothing special is needed, simply return it.
	    // Initialize `initialIndentToken` if needed.
	    Token next = super.nextToken();
	    //NOTE: This could be an appropriate spot to count whitespace or deal with
	    //NEWLINES, but it is already handled with custom actions down in the
	    //lexer rules.
	    if (pendingDent && null == initialIndentToken && NEWLINE != next.getType()) { initialIndentToken = next; }
	    if (null == next || HIDDEN == next.getChannel() || NEWLINE == next.getType()) { return next; }

	    // Handle EOF. In particular, handle an abrupt EOF that comes without an
	    // immediately preceding NEWLINE.
	    if (next.getType() == EOF) {
	        indentCount = 0;
	        // EOF outside of `pendingDent` state means input did not have a final
	        // NEWLINE before end of file.
	        if (!pendingDent) {
	            initialIndentToken = next;
	            tokenQueue.offer(createToken(NEWLINE, "NEWLINE", next));
	        }
	    }

	    // Before exiting `pendingDent` state queue up proper INDENTS and DEDENTS.
	    while (indentCount != getSavedIndent()) {
	        if (indentCount > getSavedIndent()) {
	            indentStack.push(indentCount);
	            tokenQueue.offer(createToken(GDScriptParser.INDENT, "INDENT" + indentCount, next));
	        } else {
	            indentStack.pop();
	            tokenQueue.offer(createToken(GDScriptParser.DEDENT, "DEDENT"+getSavedIndent(), next));
	        }
	    }
	    pendingDent = false;
	    tokenQueue.offer(next);
	    return tokenQueue.poll();
	}


	public GDScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GDScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 43:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
			WHITESPACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			if (pendingDent) {
			    setChannel(HIDDEN);
			}
			pendingDent = true;
			indentCount = 0;
			initialIndentToken = null;

			break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			setChannel(HIDDEN);
			if (pendingDent) {
			    indentCount += getText().length();
			}

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u01cc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\""+
		"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\5%\u0188\n%\3&\5&\u018b\n&\3&\6&\u018e\n&\r&\16&\u018f\3&\3&\6"+
		"&\u0194\n&\r&\16&\u0195\5&\u0198\n&\3\'\3\'\3\'\3(\3(\3(\3(\3(\5(\u01a2"+
		"\n(\7(\u01a4\n(\f(\16(\u01a7\13(\3)\6)\u01aa\n)\r)\16)\u01ab\3*\3*\3+"+
		"\3+\3,\3,\7,\u01b4\n,\f,\16,\u01b7\13,\3-\5-\u01ba\n-\3-\3-\5-\u01be\n"+
		"-\3-\3-\3.\6.\u01c3\n.\r.\16.\u01c4\3.\3.\3/\3/\3/\3/\2\2\60\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O\2Q)S*U+W,Y-[.]/\3\2\b\3\2\62;\6\2\f\f\17\17$$^^\6\2\62;"+
		"C\\aac|\7\2*+]]__}}\177\177\4\2\f\f\16\17\4\2\13\13\"\"\2\u01f9\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7d\3\2\2\2"+
		"\tf\3\2\2\2\13h\3\2\2\2\rj\3\2\2\2\17l\3\2\2\2\21n\3\2\2\2\23q\3\2\2\2"+
		"\25t\3\2\2\2\27v\3\2\2\2\31x\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37~\3\2\2"+
		"\2!\u0081\3\2\2\2#\u0084\3\2\2\2%\u0087\3\2\2\2\'\u008a\3\2\2\2)\u008d"+
		"\3\2\2\2+\u008f\3\2\2\2-\u0093\3\2\2\2/\u0097\3\2\2\2\61\u009a\3\2\2\2"+
		"\63\u009d\3\2\2\2\65\u00a0\3\2\2\2\67\u00a2\3\2\2\29\u00a5\3\2\2\2;\u00a8"+
		"\3\2\2\2=\u00ab\3\2\2\2?\u00ae\3\2\2\2A\u00b1\3\2\2\2C\u00b4\3\2\2\2E"+
		"\u00b7\3\2\2\2G\u00ba\3\2\2\2I\u0187\3\2\2\2K\u018a\3\2\2\2M\u0199\3\2"+
		"\2\2O\u019c\3\2\2\2Q\u01a9\3\2\2\2S\u01ad\3\2\2\2U\u01af\3\2\2\2W\u01b1"+
		"\3\2\2\2Y\u01bd\3\2\2\2[\u01c2\3\2\2\2]\u01c8\3\2\2\2_`\7\60\2\2`\4\3"+
		"\2\2\2ab\7k\2\2bc\7u\2\2c\6\3\2\2\2de\7/\2\2e\b\3\2\2\2fg\7,\2\2g\n\3"+
		"\2\2\2hi\7\61\2\2i\f\3\2\2\2jk\7\'\2\2k\16\3\2\2\2lm\7-\2\2m\20\3\2\2"+
		"\2no\7>\2\2op\7>\2\2p\22\3\2\2\2qr\7@\2\2rs\7@\2\2s\24\3\2\2\2tu\7(\2"+
		"\2u\26\3\2\2\2vw\7`\2\2w\30\3\2\2\2xy\7~\2\2y\32\3\2\2\2z{\7>\2\2{\34"+
		"\3\2\2\2|}\7@\2\2}\36\3\2\2\2~\177\7?\2\2\177\u0080\7?\2\2\u0080 \3\2"+
		"\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083\"\3\2\2\2\u0084\u0085"+
		"\7@\2\2\u0085\u0086\7?\2\2\u0086$\3\2\2\2\u0087\u0088\7>\2\2\u0088\u0089"+
		"\7?\2\2\u0089&\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c(\3"+
		"\2\2\2\u008d\u008e\7#\2\2\u008e*\3\2\2\2\u008f\u0090\7p\2\2\u0090\u0091"+
		"\7q\2\2\u0091\u0092\7v\2\2\u0092,\3\2\2\2\u0093\u0094\7c\2\2\u0094\u0095"+
		"\7p\2\2\u0095\u0096\7f\2\2\u0096.\3\2\2\2\u0097\u0098\7(\2\2\u0098\u0099"+
		"\7(\2\2\u0099\60\3\2\2\2\u009a\u009b\7q\2\2\u009b\u009c\7t\2\2\u009c\62"+
		"\3\2\2\2\u009d\u009e\7~\2\2\u009e\u009f\7~\2\2\u009f\64\3\2\2\2\u00a0"+
		"\u00a1\7?\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7-\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"8\3\2\2\2\u00a5\u00a6\7/\2\2\u00a6\u00a7\7?\2\2\u00a7:\3\2\2\2\u00a8\u00a9"+
		"\7,\2\2\u00a9\u00aa\7?\2\2\u00aa<\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad"+
		"\7?\2\2\u00ad>\3\2\2\2\u00ae\u00af\7\'\2\2\u00af\u00b0\7?\2\2\u00b0@\3"+
		"\2\2\2\u00b1\u00b2\7(\2\2\u00b2\u00b3\7?\2\2\u00b3B\3\2\2\2\u00b4\u00b5"+
		"\7~\2\2\u00b5\u00b6\7?\2\2\u00b6D\3\2\2\2\u00b7\u00b8\7/\2\2\u00b8\u00b9"+
		"\7@\2\2\u00b9F\3\2\2\2\u00ba\u00bb\7<\2\2\u00bbH\3\2\2\2\u00bc\u00bd\7"+
		"k\2\2\u00bd\u0188\7h\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1"+
		"\7k\2\2\u00c1\u0188\7h\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7u\2\2\u00c5\u0188\7g\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7q\2\2"+
		"\u00c8\u0188\7t\2\2\u00c9\u00ca\7y\2\2\u00ca\u00cb\7j\2\2\u00cb\u00cc"+
		"\7k\2\2\u00cc\u00cd\7n\2\2\u00cd\u0188\7g\2\2\u00ce\u00cf\7o\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7e\2\2\u00d2\u0188\7j\2\2"+
		"\u00d3\u00d4\7d\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7"+
		"\7c\2\2\u00d7\u0188\7m\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7q\2\2\u00da"+
		"\u00db\7p\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2"+
		"\u00de\u00df\7w\2\2\u00df\u0188\7g\2\2\u00e0\u00e1\7r\2\2\u00e1\u00e2"+
		"\7c\2\2\u00e2\u00e3\7u\2\2\u00e3\u0188\7u\2\2\u00e4\u00e5\7t\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7t\2\2"+
		"\u00e9\u0188\7p\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed"+
		"\7c\2\2\u00ed\u00ee\7u\2\2\u00ee\u0188\7u\2\2\u00ef\u00f0\7g\2\2\u00f0"+
		"\u00f1\7z\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7p\2\2"+
		"\u00f4\u00f5\7f\2\2\u00f5\u0188\7u\2\2\u00f6\u00f7\7k\2\2\u00f7\u0188"+
		"\7u\2\2\u00f8\u00f9\7c\2\2\u00f9\u0188\7u\2\2\u00fa\u00fb\7u\2\2\u00fb"+
		"\u00fc\7g\2\2\u00fc\u00fd\7n\2\2\u00fd\u0188\7h\2\2\u00fe\u00ff\7v\2\2"+
		"\u00ff\u0100\7q\2\2\u0100\u0101\7q\2\2\u0101\u0188\7n\2\2\u0102\u0103"+
		"\7u\2\2\u0103\u0104\7k\2\2\u0104\u0105\7i\2\2\u0105\u0106\7p\2\2\u0106"+
		"\u0107\7c\2\2\u0107\u0188\7n\2\2\u0108\u0109\7h\2\2\u0109\u010a\7w\2\2"+
		"\u010a\u010b\7p\2\2\u010b\u0188\7e\2\2\u010c\u010d\7u\2\2\u010d\u010e"+
		"\7v\2\2\u010e\u010f\7c\2\2\u010f\u0110\7v\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0188\7e\2\2\u0112\u0113\7e\2\2\u0113\u0114\7q\2\2\u0114\u0115\7p\2\2"+
		"\u0115\u0116\7u\2\2\u0116\u0188\7v\2\2\u0117\u0118\7g\2\2\u0118\u0119"+
		"\7p\2\2\u0119\u011a\7w\2\2\u011a\u0188\7o\2\2\u011b\u011c\7x\2\2\u011c"+
		"\u011d\7c\2\2\u011d\u0188\7t\2\2\u011e\u011f\7q\2\2\u011f\u0120\7p\2\2"+
		"\u0120\u0121\7t\2\2\u0121\u0122\7g\2\2\u0122\u0123\7c\2\2\u0123\u0124"+
		"\7f\2\2\u0124\u0188\7{\2\2\u0125\u0126\7g\2\2\u0126\u0127\7z\2\2\u0127"+
		"\u0128\7r\2\2\u0128\u0129\7q\2\2\u0129\u012a\7t\2\2\u012a\u0188\7v\2\2"+
		"\u012b\u012c\7u\2\2\u012c\u012d\7g\2\2\u012d\u012e\7v\2\2\u012e\u012f"+
		"\7i\2\2\u012f\u0130\7g\2\2\u0130\u0188\7v\2\2\u0131\u0132\7d\2\2\u0132"+
		"\u0133\7t\2\2\u0133\u0134\7g\2\2\u0134\u0135\7c\2\2\u0135\u0136\7m\2\2"+
		"\u0136\u0137\7r\2\2\u0137\u0138\7q\2\2\u0138\u0139\7k\2\2\u0139\u013a"+
		"\7p\2\2\u013a\u0188\7v\2\2\u013b\u013c\7r\2\2\u013c\u013d\7t\2\2\u013d"+
		"\u013e\7g\2\2\u013e\u013f\7n\2\2\u013f\u0140\7q\2\2\u0140\u0141\7c\2\2"+
		"\u0141\u0188\7f\2\2\u0142\u0143\7{\2\2\u0143\u0144\7k\2\2\u0144\u0145"+
		"\7g\2\2\u0145\u0146\7n\2\2\u0146\u0188\7f\2\2\u0147\u0148\7c\2\2\u0148"+
		"\u0149\7u\2\2\u0149\u014a\7u\2\2\u014a\u014b\7g\2\2\u014b\u014c\7t\2\2"+
		"\u014c\u0188\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f\7g\2\2\u014f\u0150"+
		"\7o\2\2\u0150\u0151\7q\2\2\u0151\u0152\7v\2\2\u0152\u0188\7g\2\2\u0153"+
		"\u0154\7o\2\2\u0154\u0155\7c\2\2\u0155\u0156\7u\2\2\u0156\u0157\7v\2\2"+
		"\u0157\u0158\7g\2\2\u0158\u0188\7t\2\2\u0159\u015a\7r\2\2\u015a\u015b"+
		"\7w\2\2\u015b\u015c\7r\2\2\u015c\u015d\7r\2\2\u015d\u015e\7g\2\2\u015e"+
		"\u0188\7v\2\2\u015f\u0160\7t\2\2\u0160\u0161\7g\2\2\u0161\u0162\7o\2\2"+
		"\u0162\u0163\7q\2\2\u0163\u0164\7v\2\2\u0164\u0165\7g\2\2\u0165\u0166"+
		"\7u\2\2\u0166\u0167\7{\2\2\u0167\u0168\7p\2\2\u0168\u0188\7e\2\2\u0169"+
		"\u016a\7o\2\2\u016a\u016b\7c\2\2\u016b\u016c\7u\2\2\u016c\u016d\7v\2\2"+
		"\u016d\u016e\7g\2\2\u016e\u016f\7t\2\2\u016f\u0170\7u\2\2\u0170\u0171"+
		"\7{\2\2\u0171\u0172\7p\2\2\u0172\u0188\7e\2\2\u0173\u0174\7r\2\2\u0174"+
		"\u0175\7w\2\2\u0175\u0176\7r\2\2\u0176\u0177\7r\2\2\u0177\u0178\7g\2\2"+
		"\u0178\u0179\7v\2\2\u0179\u017a\7u\2\2\u017a\u017b\7{\2\2\u017b\u017c"+
		"\7p\2\2\u017c\u0188\7e\2\2\u017d\u017e\7e\2\2\u017e\u017f\7n\2\2\u017f"+
		"\u0180\7c\2\2\u0180\u0181\7u\2\2\u0181\u0182\7u\2\2\u0182\u0183\7a\2\2"+
		"\u0183\u0184\7p\2\2\u0184\u0185\7c\2\2\u0185\u0186\7o\2\2\u0186\u0188"+
		"\7g\2\2\u0187\u00bc\3\2\2\2\u0187\u00be\3\2\2\2\u0187\u00c2\3\2\2\2\u0187"+
		"\u00c6\3\2\2\2\u0187\u00c9\3\2\2\2\u0187\u00ce\3\2\2\2\u0187\u00d3\3\2"+
		"\2\2\u0187\u00d8\3\2\2\2\u0187\u00e0\3\2\2\2\u0187\u00e4\3\2\2\2\u0187"+
		"\u00ea\3\2\2\2\u0187\u00ef\3\2\2\2\u0187\u00f6\3\2\2\2\u0187\u00f8\3\2"+
		"\2\2\u0187\u00fa\3\2\2\2\u0187\u00fe\3\2\2\2\u0187\u0102\3\2\2\2\u0187"+
		"\u0108\3\2\2\2\u0187\u010c\3\2\2\2\u0187\u0112\3\2\2\2\u0187\u0117\3\2"+
		"\2\2\u0187\u011b\3\2\2\2\u0187\u011e\3\2\2\2\u0187\u0125\3\2\2\2\u0187"+
		"\u012b\3\2\2\2\u0187\u0131\3\2\2\2\u0187\u013b\3\2\2\2\u0187\u0142\3\2"+
		"\2\2\u0187\u0147\3\2\2\2\u0187\u014d\3\2\2\2\u0187\u0153\3\2\2\2\u0187"+
		"\u0159\3\2\2\2\u0187\u015f\3\2\2\2\u0187\u0169\3\2\2\2\u0187\u0173\3\2"+
		"\2\2\u0187\u017d\3\2\2\2\u0188J\3\2\2\2\u0189\u018b\7/\2\2\u018a\u0189"+
		"\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018e\t\2\2\2\u018d"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u0197\3\2\2\2\u0191\u0193\7\60\2\2\u0192\u0194\t\2\2\2\u0193"+
		"\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2"+
		"\2\2\u0196\u0198\3\2\2\2\u0197\u0191\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"L\3\2\2\2\u0199\u019a\5O(\2\u019a\u019b\7$\2\2\u019bN\3\2\2\2\u019c\u01a5"+
		"\7$\2\2\u019d\u01a4\n\3\2\2\u019e\u01a1\7^\2\2\u019f\u01a2\13\2\2\2\u01a0"+
		"\u01a2\7\2\2\3\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a4\3\2"+
		"\2\2\u01a3\u019d\3\2\2\2\u01a3\u019e\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6P\3\2\2\2\u01a7\u01a5\3\2\2\2"+
		"\u01a8\u01aa\t\4\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01a9"+
		"\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acR\3\2\2\2\u01ad\u01ae\t\5\2\2\u01ae"+
		"T\3\2\2\2\u01af\u01b0\7.\2\2\u01b0V\3\2\2\2\u01b1\u01b5\7%\2\2\u01b2\u01b4"+
		"\n\6\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6X\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01ba\7\17\2\2"+
		"\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01be"+
		"\7\f\2\2\u01bc\u01be\7\17\2\2\u01bd\u01b9\3\2\2\2\u01bd\u01bc\3\2\2\2"+
		"\u01be\u01bf\3\2\2\2\u01bf\u01c0\b-\2\2\u01c0Z\3\2\2\2\u01c1\u01c3\t\7"+
		"\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\b.\3\2\u01c7\\\3\2\2\2"+
		"\u01c8\u01c9\13\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\b/\4\2\u01cb^\3"+
		"\2\2\2\20\2\u0187\u018a\u018f\u0195\u0197\u01a1\u01a3\u01a5\u01ab\u01b5"+
		"\u01b9\u01bd\u01c4\5\3-\2\3.\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}