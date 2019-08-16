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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, KEYWORD=8, NUMBER=9, 
		STRING=10, IDENTIFIER=11, BRACKET=12, COMMA_SEPARATOR=13, LINE_COMMENT=14, 
		NEWLINE=15, WHITESPACE=16, ERRCHAR=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "KEYWORD", "NUMBER", 
			"STRING", "UNTERMINATED_STRING", "IDENTIFIER", "BRACKET", "COMMA_SEPARATOR", 
			"LINE_COMMENT", "NEWLINE", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'='", "'->'", "':'", null, null, null, 
			null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "KEYWORD", "NUMBER", 
			"STRING", "IDENTIFIER", "BRACKET", "COMMA_SEPARATOR", "LINE_COMMENT", 
			"NEWLINE", "WHITESPACE", "ERRCHAR"
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
		case 15:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00f4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u00b0\n\t\3\n\5\n\u00b3\n\n\3\n\6\n\u00b6\n\n\r\n\16\n\u00b7\3\n"+
		"\3\n\6\n\u00bc\n\n\r\n\16\n\u00bd\5\n\u00c0\n\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00ca\n\f\7\f\u00cc\n\f\f\f\16\f\u00cf\13\f\3\r\6\r\u00d2"+
		"\n\r\r\r\16\r\u00d3\3\16\3\16\3\17\3\17\3\20\3\20\7\20\u00dc\n\20\f\20"+
		"\16\20\u00df\13\20\3\21\5\21\u00e2\n\21\3\21\3\21\5\21\u00e6\n\21\3\21"+
		"\3\21\3\22\6\22\u00eb\n\22\r\22\16\22\u00ec\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r\33"+
		"\16\35\17\37\20!\21#\22%\23\3\2\b\3\2\62;\6\2\f\f\17\17$$^^\6\2\62;C\\"+
		"aac|\7\2*+]]__}}\177\177\4\2\f\f\16\17\4\2\13\13\"\"\2\u0117\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2"+
		"\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\64\3"+
		"\2\2\2\21\u00af\3\2\2\2\23\u00b2\3\2\2\2\25\u00c1\3\2\2\2\27\u00c4\3\2"+
		"\2\2\31\u00d1\3\2\2\2\33\u00d5\3\2\2\2\35\u00d7\3\2\2\2\37\u00d9\3\2\2"+
		"\2!\u00e5\3\2\2\2#\u00ea\3\2\2\2%\u00f0\3\2\2\2\'(\7,\2\2(\4\3\2\2\2)"+
		"*\7\61\2\2*\6\3\2\2\2+,\7-\2\2,\b\3\2\2\2-.\7/\2\2.\n\3\2\2\2/\60\7?\2"+
		"\2\60\f\3\2\2\2\61\62\7/\2\2\62\63\7@\2\2\63\16\3\2\2\2\64\65\7<\2\2\65"+
		"\20\3\2\2\2\66\67\7g\2\2\678\7z\2\289\7v\2\29:\7g\2\2:;\7p\2\2;<\7f\2"+
		"\2<\u00b0\7u\2\2=>\7h\2\2>?\7w\2\2?@\7p\2\2@\u00b0\7e\2\2AB\7t\2\2BC\7"+
		"g\2\2CD\7v\2\2DE\7w\2\2EF\7t\2\2F\u00b0\7p\2\2GH\7e\2\2HI\7n\2\2IJ\7c"+
		"\2\2JK\7u\2\2K\u00b0\7u\2\2LM\7q\2\2MN\7p\2\2NO\7t\2\2OP\7g\2\2PQ\7c\2"+
		"\2QR\7f\2\2R\u00b0\7{\2\2ST\7g\2\2TU\7z\2\2UV\7r\2\2VW\7q\2\2WX\7t\2\2"+
		"X\u00b0\7v\2\2YZ\7e\2\2Z[\7q\2\2[\\\7p\2\2\\]\7u\2\2]\u00b0\7v\2\2^_\7"+
		"x\2\2_`\7c\2\2`\u00b0\7t\2\2ab\7v\2\2bc\7t\2\2cd\7w\2\2d\u00b0\7g\2\2"+
		"ef\7h\2\2fg\7c\2\2gh\7n\2\2hi\7u\2\2i\u00b0\7g\2\2jk\7p\2\2kl\7w\2\2l"+
		"m\7n\2\2m\u00b0\7n\2\2no\7g\2\2op\7p\2\2pq\7w\2\2q\u00b0\7o\2\2rs\7k\2"+
		"\2s\u00b0\7p\2\2tu\7d\2\2uv\7q\2\2vw\7q\2\2w\u00b0\7n\2\2xy\7k\2\2yz\7"+
		"p\2\2z\u00b0\7v\2\2{|\7h\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u00b0\7"+
		"v\2\2\u0080\u0081\7e\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u00b0\7g\2\2\u0088\u0089\7d\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2"+
		"\u008b\u008c\7c\2\2\u008c\u00b0\7m\2\2\u008d\u008e\7r\2\2\u008e\u008f"+
		"\7c\2\2\u008f\u0090\7u\2\2\u0090\u00b0\7u\2\2\u0091\u0092\7k\2\2\u0092"+
		"\u00b0\7h\2\2\u0093\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095\u0096\7u\2\2"+
		"\u0096\u00b0\7g\2\2\u0097\u0098\7g\2\2\u0098\u0099\7n\2\2\u0099\u009a"+
		"\7k\2\2\u009a\u00b0\7h\2\2\u009b\u009c\7h\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u00b0\7t\2\2\u009e\u009f\7y\2\2\u009f\u00a0\7j\2\2\u00a0\u00a1\7k\2\2"+
		"\u00a1\u00a2\7n\2\2\u00a2\u00b0\7g\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5"+
		"\7g\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7i\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\u00b0\7v\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7i\2\2"+
		"\u00ac\u00ad\7p\2\2\u00ad\u00ae\7c\2\2\u00ae\u00b0\7n\2\2\u00af\66\3\2"+
		"\2\2\u00af=\3\2\2\2\u00afA\3\2\2\2\u00afG\3\2\2\2\u00afL\3\2\2\2\u00af"+
		"S\3\2\2\2\u00afY\3\2\2\2\u00af^\3\2\2\2\u00afa\3\2\2\2\u00afe\3\2\2\2"+
		"\u00afj\3\2\2\2\u00afn\3\2\2\2\u00afr\3\2\2\2\u00aft\3\2\2\2\u00afx\3"+
		"\2\2\2\u00af{\3\2\2\2\u00af\u0080\3\2\2\2\u00af\u0088\3\2\2\2\u00af\u008d"+
		"\3\2\2\2\u00af\u0091\3\2\2\2\u00af\u0093\3\2\2\2\u00af\u0097\3\2\2\2\u00af"+
		"\u009b\3\2\2\2\u00af\u009e\3\2\2\2\u00af\u00a3\3\2\2\2\u00af\u00a9\3\2"+
		"\2\2\u00b0\22\3\2\2\2\u00b1\u00b3\7/\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b6\t\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bf\3\2"+
		"\2\2\u00b9\u00bb\7\60\2\2\u00ba\u00bc\t\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\24\3\2\2\2\u00c1\u00c2"+
		"\5\27\f\2\u00c2\u00c3\7$\2\2\u00c3\26\3\2\2\2\u00c4\u00cd\7$\2\2\u00c5"+
		"\u00cc\n\3\2\2\u00c6\u00c9\7^\2\2\u00c7\u00ca\13\2\2\2\u00c8\u00ca\7\2"+
		"\2\3\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c5\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\30\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2"+
		"\t\4\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\32\3\2\2\2\u00d5\u00d6\t\5\2\2\u00d6\34\3\2\2\2\u00d7"+
		"\u00d8\7.\2\2\u00d8\36\3\2\2\2\u00d9\u00dd\7%\2\2\u00da\u00dc\n\6\2\2"+
		"\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de \3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\7\17\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\7\f"+
		"\2\2\u00e4\u00e6\7\17\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\b\21\2\2\u00e8\"\3\2\2\2\u00e9\u00eb\t\7\2"+
		"\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b\22\3\2\u00ef$\3\2\2\2\u00f0"+
		"\u00f1\13\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\23\4\2\u00f3&\3\2\2"+
		"\2\20\2\u00af\u00b2\u00b7\u00bd\u00bf\u00c9\u00cb\u00cd\u00d3\u00dd\u00e1"+
		"\u00e5\u00ec\5\3\21\2\3\22\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}