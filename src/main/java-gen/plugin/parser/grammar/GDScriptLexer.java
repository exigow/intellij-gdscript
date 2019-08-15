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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, ELSE=7, FOR=8, WHILE=9, 
		EXTENDS=10, FUNC=11, EXPORT=12, RETURN=13, CLASS=14, VAR_CONST=15, CONTINUE_BREAK_PASS=16, 
		TRUE_FALSE=17, PRIMITIVE_TYPE=18, OPERATOR=19, CLASS_NAME=20, PARAMETER=21, 
		NUMBER=22, STRING=23, LINE_COMMENT=24, NEWLINE=25, WHITESPACE=26, ERRCHAR=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "ELSE", "FOR", "WHILE", 
			"EXTENDS", "FUNC", "EXPORT", "RETURN", "CLASS", "VAR_CONST", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "OPERATOR", "CLASS_NAME", "PARAMETER", 
			"NUMBER", "STRING", "LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
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
			"NUMBER", "STRING", "LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
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
		case 24:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00fe\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\177"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u0092\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a1\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00af\n\23\3\24\3\24\3\24\5\24"+
		"\u00b4\n\24\3\25\6\25\u00b7\n\25\r\25\16\25\u00b8\3\25\7\25\u00bc\n\25"+
		"\f\25\16\25\u00bf\13\25\3\26\6\26\u00c2\n\26\r\26\16\26\u00c3\3\27\5\27"+
		"\u00c7\n\27\3\27\6\27\u00ca\n\27\r\27\16\27\u00cb\3\27\3\27\6\27\u00d0"+
		"\n\27\r\27\16\27\u00d1\5\27\u00d4\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u00db"+
		"\n\30\7\30\u00dd\n\30\f\30\16\30\u00e0\13\30\3\30\3\30\3\31\3\31\7\31"+
		"\u00e6\n\31\f\31\16\31\u00e9\13\31\3\32\5\32\u00ec\n\32\3\32\3\32\5\32"+
		"\u00f0\n\32\3\32\3\32\3\33\6\33\u00f5\n\33\r\33\16\33\u00f6\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\35\3\2\n\5\2,-//\61\61\3\2C\\\5\2\62;C\\c|\5\2C\\aac|"+
		"\3\2\62;\6\2\f\f\17\17$$^^\4\2\f\f\16\17\4\2\13\13\"\"\2\u0113\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7"+
		"=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17F\3\2\2\2\21K\3\2\2\2\23"+
		"O\3\2\2\2\25U\3\2\2\2\27]\3\2\2\2\31b\3\2\2\2\33i\3\2\2\2\35p\3\2\2\2"+
		"\37~\3\2\2\2!\u0091\3\2\2\2#\u00a0\3\2\2\2%\u00ae\3\2\2\2\'\u00b3\3\2"+
		"\2\2)\u00b6\3\2\2\2+\u00c1\3\2\2\2-\u00c6\3\2\2\2/\u00d5\3\2\2\2\61\u00e3"+
		"\3\2\2\2\63\u00ef\3\2\2\2\65\u00f4\3\2\2\2\67\u00fa\3\2\2\29:\7?\2\2:"+
		"\4\3\2\2\2;<\7<\2\2<\6\3\2\2\2=>\7*\2\2>\b\3\2\2\2?@\7.\2\2@\n\3\2\2\2"+
		"AB\7+\2\2B\f\3\2\2\2CD\7k\2\2DE\7h\2\2E\16\3\2\2\2FG\7g\2\2GH\7n\2\2H"+
		"I\7u\2\2IJ\7g\2\2J\20\3\2\2\2KL\7h\2\2LM\7q\2\2MN\7t\2\2N\22\3\2\2\2O"+
		"P\7y\2\2PQ\7j\2\2QR\7k\2\2RS\7n\2\2ST\7g\2\2T\24\3\2\2\2UV\7g\2\2VW\7"+
		"z\2\2WX\7v\2\2XY\7g\2\2YZ\7p\2\2Z[\7f\2\2[\\\7u\2\2\\\26\3\2\2\2]^\7h"+
		"\2\2^_\7w\2\2_`\7p\2\2`a\7e\2\2a\30\3\2\2\2bc\7g\2\2cd\7z\2\2de\7r\2\2"+
		"ef\7q\2\2fg\7t\2\2gh\7v\2\2h\32\3\2\2\2ij\7t\2\2jk\7g\2\2kl\7v\2\2lm\7"+
		"w\2\2mn\7t\2\2no\7p\2\2o\34\3\2\2\2pq\7e\2\2qr\7n\2\2rs\7c\2\2st\7u\2"+
		"\2tu\7u\2\2u\36\3\2\2\2vw\7e\2\2wx\7q\2\2xy\7p\2\2yz\7u\2\2z\177\7v\2"+
		"\2{|\7x\2\2|}\7c\2\2}\177\7t\2\2~v\3\2\2\2~{\3\2\2\2\177 \3\2\2\2\u0080"+
		"\u0081\7e\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2"+
		"\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7w\2\2\u0087\u0092"+
		"\7g\2\2\u0088\u0089\7d\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008c\7c\2\2\u008c\u0092\7m\2\2\u008d\u008e\7r\2\2\u008e\u008f\7c\2\2"+
		"\u008f\u0090\7u\2\2\u0090\u0092\7u\2\2\u0091\u0080\3\2\2\2\u0091\u0088"+
		"\3\2\2\2\u0091\u008d\3\2\2\2\u0092\"\3\2\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7t\2\2\u0095\u0096\7w\2\2\u0096\u00a1\7g\2\2\u0097\u0098\7h\2\2"+
		"\u0098\u0099\7c\2\2\u0099\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b\u00a1"+
		"\7g\2\2\u009c\u009d\7p\2\2\u009d\u009e\7w\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a1\7n\2\2\u00a0\u0093\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0\u009c\3\2"+
		"\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5"+
		"\7q\2\2\u00a5\u00af\7n\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8"+
		"\u00af\7v\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7q\2\2"+
		"\u00ac\u00ad\7c\2\2\u00ad\u00af\7v\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a6"+
		"\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af&\3\2\2\2\u00b0\u00b4\t\2\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b4\7u\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2"+
		"\2\u00b4(\3\2\2\2\u00b5\u00b7\t\3\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\3\2\2\2\u00ba"+
		"\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be*\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2"+
		"\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4,\3\2\2\2\u00c5\u00c7\7/\2\2\u00c6\u00c5\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ca\t\6\2\2\u00c9\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00d3\3\2\2\2\u00cd\u00cf\7\60\2\2\u00ce\u00d0\t\6\2\2\u00cf\u00ce\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4.\3\2\2\2"+
		"\u00d5\u00de\7$\2\2\u00d6\u00dd\n\7\2\2\u00d7\u00da\7^\2\2\u00d8\u00db"+
		"\13\2\2\2\u00d9\u00db\7\2\2\3\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2"+
		"\u00db\u00dd\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\7$\2\2\u00e2\60\3\2\2\2\u00e3\u00e7\7%\2\2"+
		"\u00e4\u00e6\n\b\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\62\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00ec\7\17\2\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3"+
		"\2\2\2\u00ed\u00f0\7\f\2\2\u00ee\u00f0\7\17\2\2\u00ef\u00eb\3\2\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\32\2\2\u00f2\64\3\2\2"+
		"\2\u00f3\u00f5\t\t\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b\33\3\2"+
		"\u00f9\66\3\2\2\2\u00fa\u00fb\13\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd"+
		"\b\34\4\2\u00fd8\3\2\2\2\26\2~\u0091\u00a0\u00ae\u00b3\u00b8\u00bd\u00c3"+
		"\u00c6\u00cb\u00d1\u00d3\u00da\u00dc\u00de\u00e7\u00eb\u00ef\u00f6\5\3"+
		"\32\2\3\33\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}