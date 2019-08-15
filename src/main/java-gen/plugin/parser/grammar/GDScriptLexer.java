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
		EXTENDS=10, CONST=11, VAR=12, FUNC=13, RETURN=14, OPERATOR=15, CONTINUE_BREAK_PASS=16, 
		TRUE_FALSE=17, PRIMITIVE_TYPE=18, CLASS=19, CLASS_NAME=20, PARAMETER=21, 
		NUMBER=22, STRING=23, NEWLINE=24, WHITESPACE=25, LINE_COMMENT=26, ERRCHAR=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "ELSE", "FOR", "WHILE", 
			"EXTENDS", "CONST", "VAR", "FUNC", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
			"TRUE_FALSE", "PRIMITIVE_TYPE", "CLASS", "CLASS_NAME", "PARAMETER", "NUMBER", 
			"STRING", "UNTERMINATED_STRING", "NEWLINE", "WHITESPACE", "LINE_COMMENT", 
			"ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'('", "','", "')'", "'if'", "'else'", "'for'", "'while'", 
			"'extends'", "'const'", "'var'", "'func'", "'return'", null, null, null, 
			null, "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "FOR", "WHILE", "EXTENDS", 
			"CONST", "VAR", "FUNC", "RETURN", "OPERATOR", "CONTINUE_BREAK_PASS", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00f6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20y\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u008c"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0097\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00a5\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u00ae\n\25\r\25\16\25\u00af\3"+
		"\25\7\25\u00b3\n\25\f\25\16\25\u00b6\13\25\3\26\6\26\u00b9\n\26\r\26\16"+
		"\26\u00ba\3\27\5\27\u00be\n\27\3\27\6\27\u00c1\n\27\r\27\16\27\u00c2\3"+
		"\27\3\27\6\27\u00c7\n\27\r\27\16\27\u00c8\5\27\u00cb\n\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\5\31\u00d5\n\31\7\31\u00d7\n\31\f\31\16\31"+
		"\u00da\13\31\3\32\5\32\u00dd\n\32\3\32\3\32\5\32\u00e1\n\32\3\32\3\32"+
		"\3\33\6\33\u00e6\n\33\r\33\16\33\u00e7\3\33\3\33\3\34\3\34\7\34\u00ee"+
		"\n\34\f\34\16\34\u00f1\13\34\3\35\3\35\3\35\3\35\2\2\36\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\2\63\32\65\33\67\349\35\3\2\n\5\2,-//\61"+
		"\61\3\2C\\\5\2\62;C\\c|\5\2C\\aac|\3\2\62;\6\2\f\f\17\17$$^^\4\2\13\13"+
		"\"\"\4\2\f\f\16\17\2\u0108\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2\rE\3\2"+
		"\2\2\17H\3\2\2\2\21M\3\2\2\2\23Q\3\2\2\2\25W\3\2\2\2\27_\3\2\2\2\31e\3"+
		"\2\2\2\33i\3\2\2\2\35n\3\2\2\2\37x\3\2\2\2!\u008b\3\2\2\2#\u0096\3\2\2"+
		"\2%\u00a4\3\2\2\2\'\u00a6\3\2\2\2)\u00ad\3\2\2\2+\u00b8\3\2\2\2-\u00bd"+
		"\3\2\2\2/\u00cc\3\2\2\2\61\u00cf\3\2\2\2\63\u00e0\3\2\2\2\65\u00e5\3\2"+
		"\2\2\67\u00eb\3\2\2\29\u00f2\3\2\2\2;<\7?\2\2<\4\3\2\2\2=>\7<\2\2>\6\3"+
		"\2\2\2?@\7*\2\2@\b\3\2\2\2AB\7.\2\2B\n\3\2\2\2CD\7+\2\2D\f\3\2\2\2EF\7"+
		"k\2\2FG\7h\2\2G\16\3\2\2\2HI\7g\2\2IJ\7n\2\2JK\7u\2\2KL\7g\2\2L\20\3\2"+
		"\2\2MN\7h\2\2NO\7q\2\2OP\7t\2\2P\22\3\2\2\2QR\7y\2\2RS\7j\2\2ST\7k\2\2"+
		"TU\7n\2\2UV\7g\2\2V\24\3\2\2\2WX\7g\2\2XY\7z\2\2YZ\7v\2\2Z[\7g\2\2[\\"+
		"\7p\2\2\\]\7f\2\2]^\7u\2\2^\26\3\2\2\2_`\7e\2\2`a\7q\2\2ab\7p\2\2bc\7"+
		"u\2\2cd\7v\2\2d\30\3\2\2\2ef\7x\2\2fg\7c\2\2gh\7t\2\2h\32\3\2\2\2ij\7"+
		"h\2\2jk\7w\2\2kl\7p\2\2lm\7e\2\2m\34\3\2\2\2no\7t\2\2op\7g\2\2pq\7v\2"+
		"\2qr\7w\2\2rs\7t\2\2st\7p\2\2t\36\3\2\2\2uy\t\2\2\2vw\7k\2\2wy\7u\2\2"+
		"xu\3\2\2\2xv\3\2\2\2y \3\2\2\2z{\7e\2\2{|\7q\2\2|}\7p\2\2}~\7v\2\2~\177"+
		"\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7w\2\2\u0081\u008c\7g\2\2\u0082\u0083"+
		"\7d\2\2\u0083\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086\7c\2\2\u0086"+
		"\u008c\7m\2\2\u0087\u0088\7r\2\2\u0088\u0089\7c\2\2\u0089\u008a\7u\2\2"+
		"\u008a\u008c\7u\2\2\u008bz\3\2\2\2\u008b\u0082\3\2\2\2\u008b\u0087\3\2"+
		"\2\2\u008c\"\3\2\2\2\u008d\u008e\7v\2\2\u008e\u008f\7t\2\2\u008f\u0090"+
		"\7w\2\2\u0090\u0097\7g\2\2\u0091\u0092\7h\2\2\u0092\u0093\7c\2\2\u0093"+
		"\u0094\7n\2\2\u0094\u0095\7u\2\2\u0095\u0097\7g\2\2\u0096\u008d\3\2\2"+
		"\2\u0096\u0091\3\2\2\2\u0097$\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a\7"+
		"q\2\2\u009a\u009b\7q\2\2\u009b\u00a5\7n\2\2\u009c\u009d\7k\2\2\u009d\u009e"+
		"\7p\2\2\u009e\u00a5\7v\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7n\2\2\u00a1"+
		"\u00a2\7q\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a5\7v\2\2\u00a4\u0098\3\2\2"+
		"\2\u00a4\u009c\3\2\2\2\u00a4\u009f\3\2\2\2\u00a5&\3\2\2\2\u00a6\u00a7"+
		"\7e\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7u\2\2\u00aa"+
		"\u00ab\7u\2\2\u00ab(\3\2\2\2\u00ac\u00ae\t\3\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b4\3\2"+
		"\2\2\u00b1\u00b3\t\4\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5*\3\2\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b7\u00b9\t\5\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb,\3\2\2\2\u00bc\u00be\7/\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00c1\t\6\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00ca\3\2\2\2\u00c4\u00c6\7\60\2\2\u00c5\u00c7\t\6\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		".\3\2\2\2\u00cc\u00cd\5\61\31\2\u00cd\u00ce\7$\2\2\u00ce\60\3\2\2\2\u00cf"+
		"\u00d8\7$\2\2\u00d0\u00d7\n\7\2\2\u00d1\u00d4\7^\2\2\u00d2\u00d5\13\2"+
		"\2\2\u00d3\u00d5\7\2\2\3\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d7\u00da\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\62\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00db\u00dd\7\17\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00e1\7\f\2\2\u00df\u00e1\7\17\2\2\u00e0\u00dc"+
		"\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\32\2\2"+
		"\u00e3\64\3\2\2\2\u00e4\u00e6\t\b\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ea\b\33\3\2\u00ea\66\3\2\2\2\u00eb\u00ef\7%\2\2\u00ec\u00ee\n\t\2"+
		"\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f08\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\13\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\b\35\4\2\u00f5:\3\2\2\2\25\2x\u008b\u0096\u00a4"+
		"\u00af\u00b4\u00ba\u00bd\u00c2\u00c8\u00ca\u00d4\u00d6\u00d8\u00dc\u00e0"+
		"\u00e7\u00ef\5\3\32\2\3\33\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}