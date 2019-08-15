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
		EXTENDS=10, VAR_CONST=11, FUNC=12, EXPORT=13, RETURN=14, OPERATOR=15, 
		CONTINUE_BREAK_PASS=16, TRUE_FALSE=17, PRIMITIVE_TYPE=18, CLASS=19, CLASS_NAME=20, 
		PARAMETER=21, NUMBER=22, STRING=23, NEWLINE=24, WHITESPACE=25, LINE_COMMENT=26, 
		ERRCHAR=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "ELSE", "FOR", "WHILE", 
			"EXTENDS", "VAR_CONST", "FUNC", "EXPORT", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "CLASS", "CLASS_NAME", "PARAMETER", "NUMBER", 
			"STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "','", "')'", "':'", "'if'", "'else'", "'for'", "'while'", 
			"'extends'", null, "'func'", "'export'", "'return'", null, null, null, 
			null, "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "FOR", "WHILE", "EXTENDS", 
			"VAR_CONST", "FUNC", "EXPORT", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "CLASS", "CLASS_NAME", "PARAMETER", "NUMBER", 
			"STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", "ERRCHAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00fd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\fh\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20"+
		"\u0080\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0093\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u009e\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00ac\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\6\25\u00b5\n\25\r\25\16\25\u00b6\3\25\7\25\u00ba\n\25\f\25\16\25\u00bd"+
		"\13\25\3\26\6\26\u00c0\n\26\r\26\16\26\u00c1\3\27\5\27\u00c5\n\27\3\27"+
		"\6\27\u00c8\n\27\r\27\16\27\u00c9\3\27\3\27\6\27\u00ce\n\27\r\27\16\27"+
		"\u00cf\5\27\u00d2\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00dc"+
		"\n\31\7\31\u00de\n\31\f\31\16\31\u00e1\13\31\3\32\5\32\u00e4\n\32\3\32"+
		"\3\32\5\32\u00e8\n\32\3\32\3\32\3\33\6\33\u00ed\n\33\r\33\16\33\u00ee"+
		"\3\33\3\33\3\34\3\34\7\34\u00f5\n\34\f\34\16\34\u00f8\13\34\3\35\3\35"+
		"\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\32\65\33"+
		"\67\349\35\3\2\n\5\2,-//\61\61\3\2C\\\5\2\62;C\\c|\5\2C\\aac|\3\2\62;"+
		"\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\16\17\2\u0110\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\t"+
		"A\3\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17H\3\2\2\2\21M\3\2\2\2\23Q\3\2\2\2\25"+
		"W\3\2\2\2\27g\3\2\2\2\31i\3\2\2\2\33n\3\2\2\2\35u\3\2\2\2\37\177\3\2\2"+
		"\2!\u0092\3\2\2\2#\u009d\3\2\2\2%\u00ab\3\2\2\2\'\u00ad\3\2\2\2)\u00b4"+
		"\3\2\2\2+\u00bf\3\2\2\2-\u00c4\3\2\2\2/\u00d3\3\2\2\2\61\u00d6\3\2\2\2"+
		"\63\u00e7\3\2\2\2\65\u00ec\3\2\2\2\67\u00f2\3\2\2\29\u00f9\3\2\2\2;<\7"+
		"?\2\2<\4\3\2\2\2=>\7*\2\2>\6\3\2\2\2?@\7.\2\2@\b\3\2\2\2AB\7+\2\2B\n\3"+
		"\2\2\2CD\7<\2\2D\f\3\2\2\2EF\7k\2\2FG\7h\2\2G\16\3\2\2\2HI\7g\2\2IJ\7"+
		"n\2\2JK\7u\2\2KL\7g\2\2L\20\3\2\2\2MN\7h\2\2NO\7q\2\2OP\7t\2\2P\22\3\2"+
		"\2\2QR\7y\2\2RS\7j\2\2ST\7k\2\2TU\7n\2\2UV\7g\2\2V\24\3\2\2\2WX\7g\2\2"+
		"XY\7z\2\2YZ\7v\2\2Z[\7g\2\2[\\\7p\2\2\\]\7f\2\2]^\7u\2\2^\26\3\2\2\2_"+
		"`\7e\2\2`a\7q\2\2ab\7p\2\2bc\7u\2\2ch\7v\2\2de\7x\2\2ef\7c\2\2fh\7t\2"+
		"\2g_\3\2\2\2gd\3\2\2\2h\30\3\2\2\2ij\7h\2\2jk\7w\2\2kl\7p\2\2lm\7e\2\2"+
		"m\32\3\2\2\2no\7g\2\2op\7z\2\2pq\7r\2\2qr\7q\2\2rs\7t\2\2st\7v\2\2t\34"+
		"\3\2\2\2uv\7t\2\2vw\7g\2\2wx\7v\2\2xy\7w\2\2yz\7t\2\2z{\7p\2\2{\36\3\2"+
		"\2\2|\u0080\t\2\2\2}~\7k\2\2~\u0080\7u\2\2\177|\3\2\2\2\177}\3\2\2\2\u0080"+
		" \3\2\2\2\u0081\u0082\7e\2\2\u0082\u0083\7q\2\2\u0083\u0084\7p\2\2\u0084"+
		"\u0085\7v\2\2\u0085\u0086\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7w\2\2"+
		"\u0088\u0093\7g\2\2\u0089\u008a\7d\2\2\u008a\u008b\7t\2\2\u008b\u008c"+
		"\7g\2\2\u008c\u008d\7c\2\2\u008d\u0093\7m\2\2\u008e\u008f\7r\2\2\u008f"+
		"\u0090\7c\2\2\u0090\u0091\7u\2\2\u0091\u0093\7u\2\2\u0092\u0081\3\2\2"+
		"\2\u0092\u0089\3\2\2\2\u0092\u008e\3\2\2\2\u0093\"\3\2\2\2\u0094\u0095"+
		"\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7w\2\2\u0097\u009e\7g\2\2\u0098"+
		"\u0099\7h\2\2\u0099\u009a\7c\2\2\u009a\u009b\7n\2\2\u009b\u009c\7u\2\2"+
		"\u009c\u009e\7g\2\2\u009d\u0094\3\2\2\2\u009d\u0098\3\2\2\2\u009e$\3\2"+
		"\2\2\u009f\u00a0\7d\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7q\2\2\u00a2\u00ac"+
		"\7n\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5\u00ac\7v\2\2\u00a6"+
		"\u00a7\7h\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7c\2\2"+
		"\u00aa\u00ac\7v\2\2\u00ab\u009f\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab\u00a6"+
		"\3\2\2\2\u00ac&\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7n\2\2\u00af\u00b0"+
		"\7c\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7u\2\2\u00b2(\3\2\2\2\u00b3\u00b5"+
		"\t\3\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00ba\t\4\2\2\u00b9\u00b8\3\2"+
		"\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"*\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\t\5\2\2\u00bf\u00be\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2,\3"+
		"\2\2\2\u00c3\u00c5\7/\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c8\t\6\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d1\3\2\2\2\u00cb"+
		"\u00cd\7\60\2\2\u00cc\u00ce\t\6\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00cb\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2.\3\2\2\2\u00d3\u00d4\5\61\31"+
		"\2\u00d4\u00d5\7$\2\2\u00d5\60\3\2\2\2\u00d6\u00df\7$\2\2\u00d7\u00de"+
		"\n\7\2\2\u00d8\u00db\7^\2\2\u00d9\u00dc\13\2\2\2\u00da\u00dc\7\2\2\3\u00db"+
		"\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d7\3\2"+
		"\2\2\u00dd\u00d8\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\62\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\7\17\2"+
		"\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8"+
		"\7\f\2\2\u00e6\u00e8\7\17\2\2\u00e7\u00e3\3\2\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\32\2\2\u00ea\64\3\2\2\2\u00eb\u00ed"+
		"\t\b\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\b\33\3\2\u00f1\66\3\2\2"+
		"\2\u00f2\u00f6\7%\2\2\u00f3\u00f5\n\t\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f78\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fa\13\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b"+
		"\35\4\2\u00fc:\3\2\2\2\26\2g\177\u0092\u009d\u00ab\u00b6\u00bb\u00c1\u00c4"+
		"\u00c9\u00cf\u00d1\u00db\u00dd\u00df\u00e3\u00e7\u00ee\u00f6\5\3\32\2"+
		"\3\33\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}