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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, EXPORT=9, 
		ONREADY=10, VAR=11, SETGET=12, CONST=13, STATIC=14, FUNC=15, FOR=16, IN=17, 
		WHILE=18, CLASS=19, EXTENDS=20, CLASS_NAME=21, ENUM=22, IF=23, ELIF=24, 
		ELSE=25, RETURN=26, IDENTIFIER=27, NUMBER=28, STRING=29, LINE_COMMENT=30, 
		BLOCK_COMMENT=31, NL=32, WHITESPACE=33, ERRCHAR=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "EXPORT", 
			"ONREADY", "VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", 
			"CLASS", "EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", 
			"IDENTIFIER", "NUMBER", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", 
			"WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'export'", 
			"'onready'", "'var'", "'setget'", "'const'", "'static'", "'func'", "'for'", 
			"'in'", "'while'", "'class'", "'extends'", "'class_name'", "'enum'", 
			"'if'", "'elif'", "'else'", "'return'", null, null, null, null, null, 
			"'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", 
			"EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", 
			"NUMBER", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0105\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\7\34\u00c6\n\34"+
		"\f\34\16\34\u00c9\13\34\3\35\5\35\u00cc\n\35\3\35\6\35\u00cf\n\35\r\35"+
		"\16\35\u00d0\3\35\3\35\6\35\u00d5\n\35\r\35\16\35\u00d6\5\35\u00d9\n\35"+
		"\3\36\3\36\7\36\u00dd\n\36\f\36\16\36\u00e0\13\36\3\36\3\36\3\37\3\37"+
		"\7\37\u00e6\n\37\f\37\16\37\u00e9\13\37\3 \3 \3 \3 \3 \7 \u00f0\n \f "+
		"\16 \u00f3\13 \3 \3 \3 \3 \3!\3!\3\"\6\"\u00fc\n\"\r\"\16\"\u00fd\3\""+
		"\3\"\3#\3#\3#\3#\3\u00f1\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\7\5\2C\\aac|\6\2\62;C\\aac|"+
		"\3\2\62;\4\2\f\f$$\4\2\f\f\16\17\2\u010d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3"+
		"\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21V\3\2\2\2\23X\3\2\2\2\25_"+
		"\3\2\2\2\27g\3\2\2\2\31k\3\2\2\2\33r\3\2\2\2\35x\3\2\2\2\37\177\3\2\2"+
		"\2!\u0084\3\2\2\2#\u0088\3\2\2\2%\u008b\3\2\2\2\'\u0091\3\2\2\2)\u0097"+
		"\3\2\2\2+\u009f\3\2\2\2-\u00aa\3\2\2\2/\u00af\3\2\2\2\61\u00b2\3\2\2\2"+
		"\63\u00b7\3\2\2\2\65\u00bc\3\2\2\2\67\u00c3\3\2\2\29\u00cb\3\2\2\2;\u00da"+
		"\3\2\2\2=\u00e3\3\2\2\2?\u00ea\3\2\2\2A\u00f8\3\2\2\2C\u00fb\3\2\2\2E"+
		"\u0101\3\2\2\2GH\7*\2\2H\4\3\2\2\2IJ\7.\2\2J\6\3\2\2\2KL\7+\2\2L\b\3\2"+
		"\2\2MN\7<\2\2N\n\3\2\2\2OP\7?\2\2P\f\3\2\2\2QR\7/\2\2RS\7@\2\2S\16\3\2"+
		"\2\2TU\7}\2\2U\20\3\2\2\2VW\7\177\2\2W\22\3\2\2\2XY\7g\2\2YZ\7z\2\2Z["+
		"\7r\2\2[\\\7q\2\2\\]\7t\2\2]^\7v\2\2^\24\3\2\2\2_`\7q\2\2`a\7p\2\2ab\7"+
		"t\2\2bc\7g\2\2cd\7c\2\2de\7f\2\2ef\7{\2\2f\26\3\2\2\2gh\7x\2\2hi\7c\2"+
		"\2ij\7t\2\2j\30\3\2\2\2kl\7u\2\2lm\7g\2\2mn\7v\2\2no\7i\2\2op\7g\2\2p"+
		"q\7v\2\2q\32\3\2\2\2rs\7e\2\2st\7q\2\2tu\7p\2\2uv\7u\2\2vw\7v\2\2w\34"+
		"\3\2\2\2xy\7u\2\2yz\7v\2\2z{\7c\2\2{|\7v\2\2|}\7k\2\2}~\7e\2\2~\36\3\2"+
		"\2\2\177\u0080\7h\2\2\u0080\u0081\7w\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7e\2\2\u0083 \3\2\2\2\u0084\u0085\7h\2\2\u0085\u0086\7q\2\2\u0086\u0087"+
		"\7t\2\2\u0087\"\3\2\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a$\3"+
		"\2\2\2\u008b\u008c\7y\2\2\u008c\u008d\7j\2\2\u008d\u008e\7k\2\2\u008e"+
		"\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090&\3\2\2\2\u0091\u0092\7e\2\2\u0092"+
		"\u0093\7n\2\2\u0093\u0094\7c\2\2\u0094\u0095\7u\2\2\u0095\u0096\7u\2\2"+
		"\u0096(\3\2\2\2\u0097\u0098\7g\2\2\u0098\u0099\7z\2\2\u0099\u009a\7v\2"+
		"\2\u009a\u009b\7g\2\2\u009b\u009c\7p\2\2\u009c\u009d\7f\2\2\u009d\u009e"+
		"\7u\2\2\u009e*\3\2\2\2\u009f\u00a0\7e\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2"+
		"\7c\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7a\2\2\u00a5"+
		"\u00a6\7p\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7g\2\2"+
		"\u00a9,\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7w\2"+
		"\2\u00ad\u00ae\7o\2\2\u00ae.\3\2\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7"+
		"h\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5"+
		"\7k\2\2\u00b5\u00b6\7h\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9"+
		"\7n\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb\64\3\2\2\2\u00bc\u00bd"+
		"\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7w\2\2\u00c0"+
		"\u00c1\7t\2\2\u00c1\u00c2\7p\2\2\u00c2\66\3\2\2\2\u00c3\u00c7\t\2\2\2"+
		"\u00c4\u00c6\t\3\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c88\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cc\7/\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2"+
		"\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d8\3\2\2\2\u00d2\u00d4\7\60"+
		"\2\2\u00d3\u00d5\t\4\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d2\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9:\3\2\2\2\u00da\u00de\7$\2\2\u00db\u00dd"+
		"\n\5\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7$"+
		"\2\2\u00e2<\3\2\2\2\u00e3\u00e7\7%\2\2\u00e4\u00e6\n\6\2\2\u00e5\u00e4"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		">\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7$\2\2\u00eb\u00ec\7$\2\2\u00ec"+
		"\u00ed\7$\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00f0\13\2\2\2\u00ef\u00ee\3\2"+
		"\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7$\2\2\u00f5\u00f6\7$\2"+
		"\2\u00f6\u00f7\7$\2\2\u00f7@\3\2\2\2\u00f8\u00f9\7\f\2\2\u00f9B\3\2\2"+
		"\2\u00fa\u00fc\7\"\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b\"\2\2\u0100"+
		"D\3\2\2\2\u0101\u0102\13\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\b#\2\2"+
		"\u0104F\3\2\2\2\f\2\u00c7\u00cb\u00d0\u00d6\u00d8\u00de\u00e7\u00f1\u00fd"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}