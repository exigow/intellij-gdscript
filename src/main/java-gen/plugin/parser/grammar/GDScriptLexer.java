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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, KEYWORD=6, NUMBER=7, STRING=8, 
		IDENTIFIER=9, BRACKET=10, COMMA_SEPARATOR=11, LINE_COMMENT=12, NEWLINE=13, 
		WHITESPACE=14, ERRCHAR=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "KEYWORD", "NUMBER", "STRING", 
			"UNTERMINATED_STRING", "IDENTIFIER", "BRACKET", "COMMA_SEPARATOR", "LINE_COMMENT", 
			"NEWLINE", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'='", null, null, null, null, null, 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "KEYWORD", "NUMBER", "STRING", "IDENTIFIER", 
			"BRACKET", "COMMA_SEPARATOR", "LINE_COMMENT", "NEWLINE", "WHITESPACE", 
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
		case 13:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 14:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u00eb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a7\n\7\3\b\5\b\u00aa\n\b\3\b\6\b\u00ad"+
		"\n\b\r\b\16\b\u00ae\3\b\3\b\6\b\u00b3\n\b\r\b\16\b\u00b4\5\b\u00b7\n\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c1\n\n\7\n\u00c3\n\n\f\n\16\n"+
		"\u00c6\13\n\3\13\6\13\u00c9\n\13\r\13\16\13\u00ca\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\7\16\u00d3\n\16\f\16\16\16\u00d6\13\16\3\17\5\17\u00d9\n\17\3\17"+
		"\3\17\5\17\u00dd\n\17\3\17\3\17\3\20\6\20\u00e2\n\20\r\20\16\20\u00e3"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\2\25\13\27\f\31\r\33\16\35\17\37\20!\21\3\2\b\3\2\62;\6\2\f\f\17"+
		"\17$$^^\6\2\62;C\\aac|\7\2*+]]__}}\177\177\4\2\f\f\16\17\4\2\13\13\"\""+
		"\2\u010e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2"+
		"\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r\u00a6\3\2\2\2\17\u00a9"+
		"\3\2\2\2\21\u00b8\3\2\2\2\23\u00bb\3\2\2\2\25\u00c8\3\2\2\2\27\u00cc\3"+
		"\2\2\2\31\u00ce\3\2\2\2\33\u00d0\3\2\2\2\35\u00dc\3\2\2\2\37\u00e1\3\2"+
		"\2\2!\u00e7\3\2\2\2#$\7,\2\2$\4\3\2\2\2%&\7\61\2\2&\6\3\2\2\2\'(\7-\2"+
		"\2(\b\3\2\2\2)*\7/\2\2*\n\3\2\2\2+,\7?\2\2,\f\3\2\2\2-.\7g\2\2./\7z\2"+
		"\2/\60\7v\2\2\60\61\7g\2\2\61\62\7p\2\2\62\63\7f\2\2\63\u00a7\7u\2\2\64"+
		"\65\7h\2\2\65\66\7w\2\2\66\67\7p\2\2\67\u00a7\7e\2\289\7t\2\29:\7g\2\2"+
		":;\7v\2\2;<\7w\2\2<=\7t\2\2=\u00a7\7p\2\2>?\7e\2\2?@\7n\2\2@A\7c\2\2A"+
		"B\7u\2\2B\u00a7\7u\2\2CD\7q\2\2DE\7p\2\2EF\7t\2\2FG\7g\2\2GH\7c\2\2HI"+
		"\7f\2\2I\u00a7\7{\2\2JK\7g\2\2KL\7z\2\2LM\7r\2\2MN\7q\2\2NO\7t\2\2O\u00a7"+
		"\7v\2\2PQ\7e\2\2QR\7q\2\2RS\7p\2\2ST\7u\2\2T\u00a7\7v\2\2UV\7x\2\2VW\7"+
		"c\2\2W\u00a7\7t\2\2XY\7v\2\2YZ\7t\2\2Z[\7w\2\2[\u00a7\7g\2\2\\]\7h\2\2"+
		"]^\7c\2\2^_\7n\2\2_`\7u\2\2`\u00a7\7g\2\2ab\7p\2\2bc\7w\2\2cd\7n\2\2d"+
		"\u00a7\7n\2\2ef\7g\2\2fg\7p\2\2gh\7w\2\2h\u00a7\7o\2\2ij\7k\2\2j\u00a7"+
		"\7p\2\2kl\7d\2\2lm\7q\2\2mn\7q\2\2n\u00a7\7n\2\2op\7k\2\2pq\7p\2\2q\u00a7"+
		"\7v\2\2rs\7h\2\2st\7n\2\2tu\7q\2\2uv\7c\2\2v\u00a7\7v\2\2wx\7e\2\2xy\7"+
		"q\2\2yz\7p\2\2z{\7v\2\2{|\7k\2\2|}\7p\2\2}~\7w\2\2~\u00a7\7g\2\2\177\u0080"+
		"\7d\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083"+
		"\u00a7\7m\2\2\u0084\u0085\7r\2\2\u0085\u0086\7c\2\2\u0086\u0087\7u\2\2"+
		"\u0087\u00a7\7u\2\2\u0088\u0089\7k\2\2\u0089\u00a7\7h\2\2\u008a\u008b"+
		"\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d\u00a7\7g\2\2\u008e"+
		"\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7k\2\2\u0091\u00a7\7h\2\2"+
		"\u0092\u0093\7h\2\2\u0093\u0094\7q\2\2\u0094\u00a7\7t\2\2\u0095\u0096"+
		"\7y\2\2\u0096\u0097\7j\2\2\u0097\u0098\7k\2\2\u0098\u0099\7n\2\2\u0099"+
		"\u00a7\7g\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\u009d\7v\2\2"+
		"\u009d\u009e\7i\2\2\u009e\u009f\7g\2\2\u009f\u00a7\7v\2\2\u00a0\u00a1"+
		"\7u\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7i\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00a7\7n\2\2\u00a6-\3\2\2\2\u00a6\64\3\2\2\2\u00a6"+
		"8\3\2\2\2\u00a6>\3\2\2\2\u00a6C\3\2\2\2\u00a6J\3\2\2\2\u00a6P\3\2\2\2"+
		"\u00a6U\3\2\2\2\u00a6X\3\2\2\2\u00a6\\\3\2\2\2\u00a6a\3\2\2\2\u00a6e\3"+
		"\2\2\2\u00a6i\3\2\2\2\u00a6k\3\2\2\2\u00a6o\3\2\2\2\u00a6r\3\2\2\2\u00a6"+
		"w\3\2\2\2\u00a6\177\3\2\2\2\u00a6\u0084\3\2\2\2\u00a6\u0088\3\2\2\2\u00a6"+
		"\u008a\3\2\2\2\u00a6\u008e\3\2\2\2\u00a6\u0092\3\2\2\2\u00a6\u0095\3\2"+
		"\2\2\u00a6\u009a\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a7\16\3\2\2\2\u00a8\u00aa"+
		"\7/\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6\3\2\2\2\u00b0\u00b2\7\60\2\2\u00b1"+
		"\u00b3\t\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\20\3\2\2\2\u00b8\u00b9\5\23\n\2\u00b9\u00ba\7$\2"+
		"\2\u00ba\22\3\2\2\2\u00bb\u00c4\7$\2\2\u00bc\u00c3\n\3\2\2\u00bd\u00c0"+
		"\7^\2\2\u00be\u00c1\13\2\2\2\u00bf\u00c1\7\2\2\3\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3\2"+
		"\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\24\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c9\t\4\2\2\u00c8\u00c7\3\2\2"+
		"\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\26"+
		"\3\2\2\2\u00cc\u00cd\t\5\2\2\u00cd\30\3\2\2\2\u00ce\u00cf\7.\2\2\u00cf"+
		"\32\3\2\2\2\u00d0\u00d4\7%\2\2\u00d1\u00d3\n\6\2\2\u00d2\u00d1\3\2\2\2"+
		"\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\34"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\7\17\2\2\u00d8\u00d7\3\2\2\2"+
		"\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dd\7\f\2\2\u00db\u00dd"+
		"\7\17\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2"+
		"\u00de\u00df\b\17\2\2\u00df\36\3\2\2\2\u00e0\u00e2\t\7\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\b\20\3\2\u00e6 \3\2\2\2\u00e7\u00e8\13\2\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\21\4\2\u00ea\"\3\2\2\2\20\2\u00a6"+
		"\u00a9\u00ae\u00b4\u00b6\u00c0\u00c2\u00c4\u00ca\u00d4\u00d8\u00dc\u00e3"+
		"\5\3\17\2\3\20\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}