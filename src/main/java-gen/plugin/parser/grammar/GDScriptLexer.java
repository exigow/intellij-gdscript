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
		T__0=1, T__1=2, T__2=3, KEYWORD=4, PARENTHESES=5, NAME=6, NUMBER=7, STRING=8, 
		LINE_COMMENT=9, NEWLINE=10, WHITESPACE=11, ERRCHAR=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "KEYWORD", "PARENTHESES", "NAME", "NUMBER", "STRING", 
			"LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KEYWORD", "PARENTHESES", "NAME", "NUMBER", "STRING", 
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
		case 9:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\6\3"+
		"\6\3\7\6\7\u0080\n\7\r\7\16\7\u0081\3\b\5\b\u0085\n\b\3\b\6\b\u0088\n"+
		"\b\r\b\16\b\u0089\3\b\3\b\6\b\u008e\n\b\r\b\16\b\u008f\5\b\u0092\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0099\n\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t"+
		"\3\t\3\n\3\n\7\n\u00a4\n\n\f\n\16\n\u00a7\13\n\3\13\5\13\u00aa\n\13\3"+
		"\13\3\13\5\13\u00ae\n\13\3\13\3\13\3\f\6\f\u00b3\n\f\r\f\16\f\u00b4\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\3\2\b\5\2*+]]__\6\2\62;C\\aac|\3\2\62;\6\2\f\f\17\17"+
		"$$^^\4\2\f\f\16\17\4\2\13\13\"\"\2\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35"+
		"\3\2\2\2\7\37\3\2\2\2\tz\3\2\2\2\13|\3\2\2\2\r\177\3\2\2\2\17\u0084\3"+
		"\2\2\2\21\u0093\3\2\2\2\23\u00a1\3\2\2\2\25\u00ad\3\2\2\2\27\u00b2\3\2"+
		"\2\2\31\u00b8\3\2\2\2\33\34\7?\2\2\34\4\3\2\2\2\35\36\7<\2\2\36\6\3\2"+
		"\2\2\37 \7.\2\2 \b\3\2\2\2!\"\7k\2\2\"{\7h\2\2#$\7g\2\2$%\7n\2\2%&\7u"+
		"\2\2&{\7g\2\2\'(\7y\2\2()\7j\2\2)*\7k\2\2*+\7n\2\2+{\7g\2\2,-\7g\2\2-"+
		".\7z\2\2./\7v\2\2/\60\7g\2\2\60\61\7p\2\2\61\62\7f\2\2\62{\7u\2\2\63\64"+
		"\7h\2\2\64\65\7w\2\2\65\66\7p\2\2\66{\7e\2\2\678\7g\2\289\7z\2\29:\7r"+
		"\2\2:;\7q\2\2;<\7t\2\2<{\7v\2\2=>\7t\2\2>?\7g\2\2?@\7v\2\2@A\7w\2\2AB"+
		"\7t\2\2B{\7p\2\2CD\7e\2\2DE\7n\2\2EF\7c\2\2FG\7u\2\2G{\7u\2\2HI\7e\2\2"+
		"IJ\7q\2\2JK\7p\2\2KL\7u\2\2L{\7v\2\2MN\7x\2\2NO\7c\2\2O{\7t\2\2PQ\7e\2"+
		"\2QR\7q\2\2RS\7p\2\2ST\7v\2\2TU\7k\2\2UV\7p\2\2VW\7w\2\2W{\7g\2\2XY\7"+
		"d\2\2YZ\7t\2\2Z[\7g\2\2[\\\7c\2\2\\{\7m\2\2]^\7r\2\2^_\7c\2\2_`\7u\2\2"+
		"`{\7u\2\2ab\7v\2\2bc\7t\2\2cd\7w\2\2d{\7g\2\2ef\7h\2\2fg\7c\2\2gh\7n\2"+
		"\2hi\7u\2\2i{\7g\2\2jk\7p\2\2kl\7w\2\2lm\7n\2\2m{\7n\2\2no\7d\2\2op\7"+
		"q\2\2pq\7q\2\2q{\7n\2\2rs\7k\2\2st\7p\2\2t{\7v\2\2uv\7h\2\2vw\7n\2\2w"+
		"x\7q\2\2xy\7c\2\2y{\7v\2\2z!\3\2\2\2z#\3\2\2\2z\'\3\2\2\2z,\3\2\2\2z\63"+
		"\3\2\2\2z\67\3\2\2\2z=\3\2\2\2zC\3\2\2\2zH\3\2\2\2zM\3\2\2\2zP\3\2\2\2"+
		"zX\3\2\2\2z]\3\2\2\2za\3\2\2\2ze\3\2\2\2zj\3\2\2\2zn\3\2\2\2zr\3\2\2\2"+
		"zu\3\2\2\2{\n\3\2\2\2|}\t\2\2\2}\f\3\2\2\2~\u0080\t\3\2\2\177~\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\16\3"+
		"\2\2\2\u0083\u0085\7/\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0088\t\4\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0091\3\2\2\2\u008b"+
		"\u008d\7\60\2\2\u008c\u008e\t\4\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008b\3\2\2\2\u0091\u0092\3\2\2\2\u0092\20\3\2\2\2\u0093\u009c\7$\2\2"+
		"\u0094\u009b\n\5\2\2\u0095\u0098\7^\2\2\u0096\u0099\13\2\2\2\u0097\u0099"+
		"\7\2\2\3\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0094\3\2\2\2\u009a\u0095\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7$\2\2\u00a0\22\3\2\2\2\u00a1\u00a5\7%\2\2\u00a2\u00a4\n\6\2\2"+
		"\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\24\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\7\17\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\7\f"+
		"\2\2\u00ac\u00ae\7\17\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\b\13\2\2\u00b0\26\3\2\2\2\u00b1\u00b3\t\7\2"+
		"\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\f\3\2\u00b7\30\3\2\2\2\u00b8"+
		"\u00b9\13\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\r\4\2\u00bb\32\3\2\2"+
		"\2\20\2z\u0081\u0084\u0089\u008f\u0091\u0098\u009a\u009c\u00a5\u00a9\u00ad"+
		"\u00b4\5\3\13\2\3\f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}