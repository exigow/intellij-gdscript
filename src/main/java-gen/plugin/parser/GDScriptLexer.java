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
		VAR=10, FUNC=11, RETURN=12, PASS=13, TRUE=14, FALSE=15, BOOL=16, INT=17, 
		FLOAT=18, CLASS_NAME=19, PARAMETER=20, NUMBER=21, STRING=22, UNTERMINATED_STRING=23, 
		NEWLINE=24, WHITESPACE=25, LINE_COMMENT=26, ERRCHAR=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "TRUE", "FALSE", "BOOL", "INT", "FLOAT", 
			"CLASS_NAME", "PARAMETER", "NUMBER", "STRING", "UNTERMINATED_STRING", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'('", "')'", "','", "'if'", "'while'", "'extends'", 
			"'const'", "'var'", "'func'", "'return'", "'pass'", "'true'", "'false'", 
			"'bool'", "'int'", "'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "WHILE", "EXTENDS", "CONST", 
			"VAR", "FUNC", "RETURN", "PASS", "TRUE", "FALSE", "BOOL", "INT", "FLOAT", 
			"CLASS_NAME", "PARAMETER", "NUMBER", "STRING", "UNTERMINATED_STRING", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT", "ERRCHAR"
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
		case 23:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 24:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u008b\n\24\r\24\16"+
		"\24\u008c\3\24\7\24\u0090\n\24\f\24\16\24\u0093\13\24\3\25\6\25\u0096"+
		"\n\25\r\25\16\25\u0097\3\26\5\26\u009b\n\26\3\26\6\26\u009e\n\26\r\26"+
		"\16\26\u009f\3\26\3\26\6\26\u00a4\n\26\r\26\16\26\u00a5\5\26\u00a8\n\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00b2\n\30\7\30\u00b4\n"+
		"\30\f\30\16\30\u00b7\13\30\3\31\5\31\u00ba\n\31\3\31\3\31\5\31\u00be\n"+
		"\31\3\31\3\31\3\32\6\32\u00c3\n\32\r\32\16\32\u00c4\3\32\3\32\3\33\3\33"+
		"\7\33\u00cb\n\33\f\33\16\33\u00ce\13\33\3\34\3\34\3\34\3\34\2\2\35\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\t\3\2C\\"+
		"\5\2\62;C\\c|\4\2C\\c|\3\2\62;\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f"+
		"\16\17\2\u00e0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3"+
		"9\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17F"+
		"\3\2\2\2\21L\3\2\2\2\23T\3\2\2\2\25Z\3\2\2\2\27^\3\2\2\2\31c\3\2\2\2\33"+
		"j\3\2\2\2\35o\3\2\2\2\37t\3\2\2\2!z\3\2\2\2#\177\3\2\2\2%\u0083\3\2\2"+
		"\2\'\u008a\3\2\2\2)\u0095\3\2\2\2+\u009a\3\2\2\2-\u00a9\3\2\2\2/\u00ac"+
		"\3\2\2\2\61\u00bd\3\2\2\2\63\u00c2\3\2\2\2\65\u00c8\3\2\2\2\67\u00cf\3"+
		"\2\2\29:\7<\2\2:\4\3\2\2\2;<\7?\2\2<\6\3\2\2\2=>\7*\2\2>\b\3\2\2\2?@\7"+
		"+\2\2@\n\3\2\2\2AB\7.\2\2B\f\3\2\2\2CD\7k\2\2DE\7h\2\2E\16\3\2\2\2FG\7"+
		"y\2\2GH\7j\2\2HI\7k\2\2IJ\7n\2\2JK\7g\2\2K\20\3\2\2\2LM\7g\2\2MN\7z\2"+
		"\2NO\7v\2\2OP\7g\2\2PQ\7p\2\2QR\7f\2\2RS\7u\2\2S\22\3\2\2\2TU\7e\2\2U"+
		"V\7q\2\2VW\7p\2\2WX\7u\2\2XY\7v\2\2Y\24\3\2\2\2Z[\7x\2\2[\\\7c\2\2\\]"+
		"\7t\2\2]\26\3\2\2\2^_\7h\2\2_`\7w\2\2`a\7p\2\2ab\7e\2\2b\30\3\2\2\2cd"+
		"\7t\2\2de\7g\2\2ef\7v\2\2fg\7w\2\2gh\7t\2\2hi\7p\2\2i\32\3\2\2\2jk\7r"+
		"\2\2kl\7c\2\2lm\7u\2\2mn\7u\2\2n\34\3\2\2\2op\7v\2\2pq\7t\2\2qr\7w\2\2"+
		"rs\7g\2\2s\36\3\2\2\2tu\7h\2\2uv\7c\2\2vw\7n\2\2wx\7u\2\2xy\7g\2\2y \3"+
		"\2\2\2z{\7d\2\2{|\7q\2\2|}\7q\2\2}~\7n\2\2~\"\3\2\2\2\177\u0080\7k\2\2"+
		"\u0080\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082$\3\2\2\2\u0083\u0084\7h\2"+
		"\2\u0084\u0085\7n\2\2\u0085\u0086\7q\2\2\u0086\u0087\7c\2\2\u0087\u0088"+
		"\7v\2\2\u0088&\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0091\3\2\2\2\u008e"+
		"\u0090\t\3\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092(\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096"+
		"\t\4\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098*\3\2\2\2\u0099\u009b\7/\2\2\u009a\u0099\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009e\t\5\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a7\3\2\2\2\u00a1\u00a3\7\60\2\2\u00a2\u00a4\t\5\2\2\u00a3\u00a2\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8,\3\2\2\2"+
		"\u00a9\u00aa\5/\30\2\u00aa\u00ab\7$\2\2\u00ab.\3\2\2\2\u00ac\u00b5\7$"+
		"\2\2\u00ad\u00b4\n\6\2\2\u00ae\u00b1\7^\2\2\u00af\u00b2\13\2\2\2\u00b0"+
		"\u00b2\7\2\2\3\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00ad\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\60\3\2\2\2\u00b7\u00b5\3\2\2"+
		"\2\u00b8\u00ba\7\17\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00be\7\f\2\2\u00bc\u00be\7\17\2\2\u00bd\u00b9\3"+
		"\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\31\2\2\u00c0"+
		"\62\3\2\2\2\u00c1\u00c3\t\7\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2"+
		"\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\b\32\3\2\u00c7\64\3\2\2\2\u00c8\u00cc\7%\2\2\u00c9\u00cb\n\b\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\66\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\13\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\b\34\4\2\u00d28\3\2\2\2\21\2\u008c\u0091\u0097\u009a"+
		"\u009f\u00a5\u00a7\u00b1\u00b3\u00b5\u00b9\u00bd\u00c4\u00cc\5\3\31\2"+
		"\3\32\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}