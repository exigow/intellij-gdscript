// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, WHILE=7, EXTENDS=8, CONST=9, 
		VAR=10, FUNC=11, RETURN=12, PASS=13, BOOL=14, INT=15, FLOAT=16, CLASS_NAME=17, 
		PARAMETER=18, NUMBER=19, STRING=20, UNTERMINATED_STRING=21, NEWLINE=22, 
		WHITESPACE=23, LINE_COMMENT=24, ERRCHAR=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "BOOL", "INT", "FLOAT", "CLASS_NAME", 
			"PARAMETER", "NUMBER", "STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", 
			"LINE_COMMENT", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'('", "')'", "','", "'if'", "'while'", "'extends'", 
			"'const'", "'var'", "'func'", "'return'", "'pass'", "'bool'", "'int'", 
			"'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "BOOL", "INT", "FLOAT", "CLASS_NAME", 
			"PARAMETER", "NUMBER", "STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", 
			"LINE_COMMENT", "ERRCHAR"
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
		case 21:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\6\22|\n\22\r\22\16\22}\3\22\7"+
		"\22\u0081\n\22\f\22\16\22\u0084\13\22\3\23\6\23\u0087\n\23\r\23\16\23"+
		"\u0088\3\24\5\24\u008c\n\24\3\24\6\24\u008f\n\24\r\24\16\24\u0090\3\24"+
		"\3\24\6\24\u0095\n\24\r\24\16\24\u0096\5\24\u0099\n\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00a3\n\26\7\26\u00a5\n\26\f\26\16\26\u00a8"+
		"\13\26\3\27\5\27\u00ab\n\27\3\27\3\27\5\27\u00af\n\27\3\27\3\27\3\30\6"+
		"\30\u00b4\n\30\r\30\16\30\u00b5\3\30\3\30\3\31\3\31\7\31\u00bc\n\31\f"+
		"\31\16\31\u00bf\13\31\3\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\3\2\t\3\2C\\\5\2\62;C\\c|\4\2C\\c|\3\2\62"+
		";\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\16\17\2\u00d1\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2"+
		"\2\2\r?\3\2\2\2\17B\3\2\2\2\21H\3\2\2\2\23P\3\2\2\2\25V\3\2\2\2\27Z\3"+
		"\2\2\2\31_\3\2\2\2\33f\3\2\2\2\35k\3\2\2\2\37p\3\2\2\2!t\3\2\2\2#{\3\2"+
		"\2\2%\u0086\3\2\2\2\'\u008b\3\2\2\2)\u009a\3\2\2\2+\u009d\3\2\2\2-\u00ae"+
		"\3\2\2\2/\u00b3\3\2\2\2\61\u00b9\3\2\2\2\63\u00c0\3\2\2\2\65\66\7<\2\2"+
		"\66\4\3\2\2\2\678\7?\2\28\6\3\2\2\29:\7*\2\2:\b\3\2\2\2;<\7+\2\2<\n\3"+
		"\2\2\2=>\7.\2\2>\f\3\2\2\2?@\7k\2\2@A\7h\2\2A\16\3\2\2\2BC\7y\2\2CD\7"+
		"j\2\2DE\7k\2\2EF\7n\2\2FG\7g\2\2G\20\3\2\2\2HI\7g\2\2IJ\7z\2\2JK\7v\2"+
		"\2KL\7g\2\2LM\7p\2\2MN\7f\2\2NO\7u\2\2O\22\3\2\2\2PQ\7e\2\2QR\7q\2\2R"+
		"S\7p\2\2ST\7u\2\2TU\7v\2\2U\24\3\2\2\2VW\7x\2\2WX\7c\2\2XY\7t\2\2Y\26"+
		"\3\2\2\2Z[\7h\2\2[\\\7w\2\2\\]\7p\2\2]^\7e\2\2^\30\3\2\2\2_`\7t\2\2`a"+
		"\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2de\7p\2\2e\32\3\2\2\2fg\7r\2\2gh\7c"+
		"\2\2hi\7u\2\2ij\7u\2\2j\34\3\2\2\2kl\7d\2\2lm\7q\2\2mn\7q\2\2no\7n\2\2"+
		"o\36\3\2\2\2pq\7k\2\2qr\7p\2\2rs\7v\2\2s \3\2\2\2tu\7h\2\2uv\7n\2\2vw"+
		"\7q\2\2wx\7c\2\2xy\7v\2\2y\"\3\2\2\2z|\t\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3"+
		"\2\2\2}~\3\2\2\2~\u0082\3\2\2\2\177\u0081\t\3\2\2\u0080\177\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083$\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0085\u0087\t\4\2\2\u0086\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089&\3\2\2\2\u008a"+
		"\u008c\7/\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u008f\t\5\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0098\3\2\2\2\u0092\u0094\7\60"+
		"\2\2\u0093\u0095\t\5\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0092\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099(\3\2\2\2\u009a\u009b\5+\26\2\u009b\u009c"+
		"\7$\2\2\u009c*\3\2\2\2\u009d\u00a6\7$\2\2\u009e\u00a5\n\6\2\2\u009f\u00a2"+
		"\7^\2\2\u00a0\u00a3\13\2\2\2\u00a1\u00a3\7\2\2\3\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u009f\3\2"+
		"\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		",\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\7\17\2\2\u00aa\u00a9\3\2\2\2"+
		"\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\7\f\2\2\u00ad\u00af"+
		"\7\17\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2"+
		"\u00b0\u00b1\b\27\2\2\u00b1.\3\2\2\2\u00b2\u00b4\t\7\2\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\b\30\3\2\u00b8\60\3\2\2\2\u00b9\u00bd\7%\2"+
		"\2\u00ba\u00bc\n\b\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\62\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c1\13\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\32\4\2\u00c3\64\3\2"+
		"\2\2\21\2}\u0082\u0088\u008b\u0090\u0096\u0098\u00a2\u00a4\u00a6\u00aa"+
		"\u00ae\u00b5\u00bd\5\3\27\2\3\30\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}