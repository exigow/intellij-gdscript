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
		VAR=10, FUNC=11, RETURN=12, PASS=13, BOOL=14, INT=15, FLOAT=16, PARAMETER=17, 
		NUMBER=18, STRING=19, UNTERMINATED_STRING=20, NEWLINE=21, WHITESPACE=22, 
		LINE_COMMENT=23, ERRCHAR=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "BOOL", "INT", "FLOAT", "PARAMETER", 
			"NUMBER", "STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"ERRCHAR"
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
		case 20:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00b7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\6\22z\n\22\r\22\16\22{\3\23\5\23\177\n"+
		"\23\3\23\6\23\u0082\n\23\r\23\16\23\u0083\3\23\3\23\6\23\u0088\n\23\r"+
		"\23\16\23\u0089\5\23\u008c\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0096\n\25\7\25\u0098\n\25\f\25\16\25\u009b\13\25\3\26\5\26\u009e"+
		"\n\26\3\26\3\26\5\26\u00a2\n\26\3\26\3\26\3\27\6\27\u00a7\n\27\r\27\16"+
		"\27\u00a8\3\27\3\27\3\30\3\30\7\30\u00af\n\30\f\30\16\30\u00b2\13\30\3"+
		"\31\3\31\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\3\2\7\4\2C\\c|\3\2\62;\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\16\17"+
		"\2\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2"+
		"\2\2\13;\3\2\2\2\r=\3\2\2\2\17@\3\2\2\2\21F\3\2\2\2\23N\3\2\2\2\25T\3"+
		"\2\2\2\27X\3\2\2\2\31]\3\2\2\2\33d\3\2\2\2\35i\3\2\2\2\37n\3\2\2\2!r\3"+
		"\2\2\2#y\3\2\2\2%~\3\2\2\2\'\u008d\3\2\2\2)\u0090\3\2\2\2+\u00a1\3\2\2"+
		"\2-\u00a6\3\2\2\2/\u00ac\3\2\2\2\61\u00b3\3\2\2\2\63\64\7?\2\2\64\4\3"+
		"\2\2\2\65\66\7<\2\2\66\6\3\2\2\2\678\7*\2\28\b\3\2\2\29:\7+\2\2:\n\3\2"+
		"\2\2;<\7.\2\2<\f\3\2\2\2=>\7k\2\2>?\7h\2\2?\16\3\2\2\2@A\7y\2\2AB\7j\2"+
		"\2BC\7k\2\2CD\7n\2\2DE\7g\2\2E\20\3\2\2\2FG\7g\2\2GH\7z\2\2HI\7v\2\2I"+
		"J\7g\2\2JK\7p\2\2KL\7f\2\2LM\7u\2\2M\22\3\2\2\2NO\7e\2\2OP\7q\2\2PQ\7"+
		"p\2\2QR\7u\2\2RS\7v\2\2S\24\3\2\2\2TU\7x\2\2UV\7c\2\2VW\7t\2\2W\26\3\2"+
		"\2\2XY\7h\2\2YZ\7w\2\2Z[\7p\2\2[\\\7e\2\2\\\30\3\2\2\2]^\7t\2\2^_\7g\2"+
		"\2_`\7v\2\2`a\7w\2\2ab\7t\2\2bc\7p\2\2c\32\3\2\2\2de\7r\2\2ef\7c\2\2f"+
		"g\7u\2\2gh\7u\2\2h\34\3\2\2\2ij\7d\2\2jk\7q\2\2kl\7q\2\2lm\7n\2\2m\36"+
		"\3\2\2\2no\7k\2\2op\7p\2\2pq\7v\2\2q \3\2\2\2rs\7h\2\2st\7n\2\2tu\7q\2"+
		"\2uv\7c\2\2vw\7v\2\2w\"\3\2\2\2xz\t\2\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|$\3\2\2\2}\177\7/\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3"+
		"\2\2\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008b\3\2\2\2\u0085\u0087\7\60"+
		"\2\2\u0086\u0088\t\3\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0085\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c&\3\2\2\2\u008d\u008e\5)\25\2\u008e\u008f"+
		"\7$\2\2\u008f(\3\2\2\2\u0090\u0099\7$\2\2\u0091\u0098\n\4\2\2\u0092\u0095"+
		"\7^\2\2\u0093\u0096\13\2\2\2\u0094\u0096\7\2\2\3\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0092\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"*\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\7\17\2\2\u009d\u009c\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\7\f\2\2\u00a0\u00a2"+
		"\7\17\2\2\u00a1\u009d\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2"+
		"\u00a3\u00a4\b\26\2\2\u00a4,\3\2\2\2\u00a5\u00a7\t\5\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\b\27\3\2\u00ab.\3\2\2\2\u00ac\u00b0\7%\2\2"+
		"\u00ad\u00af\n\6\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\60\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b4\13\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\31\4\2\u00b6\62\3\2"+
		"\2\2\17\2{~\u0083\u0089\u008b\u0095\u0097\u0099\u009d\u00a1\u00a8\u00b0"+
		"\5\3\26\2\3\27\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}