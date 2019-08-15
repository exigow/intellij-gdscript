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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, KEYWORD=6, PARAMETER=7, NUMBER=8, 
		STRING=9, LINE_COMMENT=10, NEWLINE=11, WHITESPACE=12, ERRCHAR=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "KEYWORD", "PARAMETER", "NUMBER", 
			"STRING", "LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'('", "','", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "KEYWORD", "PARAMETER", "NUMBER", 
			"STRING", "LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
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
		case 10:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0081\n\7\3\b\6\b\u0084\n\b\r\b\16\b\u0085\3\t\5\t\u0089"+
		"\n\t\3\t\6\t\u008c\n\t\r\t\16\t\u008d\3\t\3\t\6\t\u0092\n\t\r\t\16\t\u0093"+
		"\5\t\u0096\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u009d\n\n\7\n\u009f\n\n\f\n\16"+
		"\n\u00a2\13\n\3\n\3\n\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab\13\13"+
		"\3\f\5\f\u00ae\n\f\3\f\3\f\5\f\u00b2\n\f\3\f\3\f\3\r\6\r\u00b7\n\r\r\r"+
		"\16\r\u00b8\3\r\3\r\3\16\3\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\7\6\2\62;C\\aac|\3\2\62;"+
		"\6\2\f\f\17\17$$^^\4\2\f\f\16\17\4\2\13\13\"\"\2\u00dd\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r"+
		"\u0080\3\2\2\2\17\u0083\3\2\2\2\21\u0088\3\2\2\2\23\u0097\3\2\2\2\25\u00a5"+
		"\3\2\2\2\27\u00b1\3\2\2\2\31\u00b6\3\2\2\2\33\u00bc\3\2\2\2\35\36\7?\2"+
		"\2\36\4\3\2\2\2\37 \7<\2\2 \6\3\2\2\2!\"\7*\2\2\"\b\3\2\2\2#$\7.\2\2$"+
		"\n\3\2\2\2%&\7+\2\2&\f\3\2\2\2\'(\7k\2\2(\u0081\7h\2\2)*\7g\2\2*+\7n\2"+
		"\2+,\7u\2\2,\u0081\7g\2\2-.\7y\2\2./\7j\2\2/\60\7k\2\2\60\61\7n\2\2\61"+
		"\u0081\7g\2\2\62\63\7g\2\2\63\64\7z\2\2\64\65\7v\2\2\65\66\7g\2\2\66\67"+
		"\7p\2\2\678\7f\2\28\u0081\7u\2\29:\7h\2\2:;\7w\2\2;<\7p\2\2<\u0081\7e"+
		"\2\2=>\7g\2\2>?\7z\2\2?@\7r\2\2@A\7q\2\2AB\7t\2\2B\u0081\7v\2\2CD\7t\2"+
		"\2DE\7g\2\2EF\7v\2\2FG\7w\2\2GH\7t\2\2H\u0081\7p\2\2IJ\7e\2\2JK\7n\2\2"+
		"KL\7c\2\2LM\7u\2\2M\u0081\7u\2\2NO\7e\2\2OP\7q\2\2PQ\7p\2\2QR\7u\2\2R"+
		"\u0081\7v\2\2ST\7x\2\2TU\7c\2\2U\u0081\7t\2\2VW\7e\2\2WX\7q\2\2XY\7p\2"+
		"\2YZ\7v\2\2Z[\7k\2\2[\\\7p\2\2\\]\7w\2\2]\u0081\7g\2\2^_\7d\2\2_`\7t\2"+
		"\2`a\7g\2\2ab\7c\2\2b\u0081\7m\2\2cd\7r\2\2de\7c\2\2ef\7u\2\2f\u0081\7"+
		"u\2\2gh\7v\2\2hi\7t\2\2ij\7w\2\2j\u0081\7g\2\2kl\7h\2\2lm\7c\2\2mn\7n"+
		"\2\2no\7u\2\2o\u0081\7g\2\2pq\7p\2\2qr\7w\2\2rs\7n\2\2s\u0081\7n\2\2t"+
		"u\7d\2\2uv\7q\2\2vw\7q\2\2w\u0081\7n\2\2xy\7k\2\2yz\7p\2\2z\u0081\7v\2"+
		"\2{|\7h\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u0081\7v\2\2\u0080\'\3\2"+
		"\2\2\u0080)\3\2\2\2\u0080-\3\2\2\2\u0080\62\3\2\2\2\u00809\3\2\2\2\u0080"+
		"=\3\2\2\2\u0080C\3\2\2\2\u0080I\3\2\2\2\u0080N\3\2\2\2\u0080S\3\2\2\2"+
		"\u0080V\3\2\2\2\u0080^\3\2\2\2\u0080c\3\2\2\2\u0080g\3\2\2\2\u0080k\3"+
		"\2\2\2\u0080p\3\2\2\2\u0080t\3\2\2\2\u0080x\3\2\2\2\u0080{\3\2\2\2\u0081"+
		"\16\3\2\2\2\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2"+
		"\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\20\3\2\2\2\u0087\u0089"+
		"\7/\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a"+
		"\u008c\t\3\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0095\3\2\2\2\u008f\u0091\7\60\2\2\u0090"+
		"\u0092\t\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u008f\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\22\3\2\2\2\u0097\u00a0\7$\2\2\u0098\u009f\n\4\2\2"+
		"\u0099\u009c\7^\2\2\u009a\u009d\13\2\2\2\u009b\u009d\7\2\2\3\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e"+
		"\u0099\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4"+
		"\24\3\2\2\2\u00a5\u00a9\7%\2\2\u00a6\u00a8\n\5\2\2\u00a7\u00a6\3\2\2\2"+
		"\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\26"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\7\17\2\2\u00ad\u00ac\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2\7\f\2\2\u00b0\u00b2"+
		"\7\17\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2"+
		"\u00b3\u00b4\b\f\2\2\u00b4\30\3\2\2\2\u00b5\u00b7\t\6\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\b\r\3\2\u00bb\32\3\2\2\2\u00bc\u00bd\13\2\2"+
		"\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\16\4\2\u00bf\34\3\2\2\2\20\2\u0080"+
		"\u0085\u0088\u008d\u0093\u0095\u009c\u009e\u00a0\u00a9\u00ad\u00b1\u00b8"+
		"\5\3\f\2\3\r\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}