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
		ONREADY=10, VAR=11, SETGET=12, CONST=13, STATIC=14, FUNC=15, CLASS=16, 
		EXTENDS=17, CLASS_NAME=18, ENUM=19, IF=20, ELIF=21, ELSE=22, RETURN=23, 
		IDENTIFIER=24, NUMBER=25, STRING=26, LINE_COMMENT=27, BLOCK_COMMENT=28, 
		NL=29, WHITESPACE=30, ERRCHAR=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "EXPORT", 
			"ONREADY", "VAR", "SETGET", "CONST", "STATIC", "FUNC", "CLASS", "EXTENDS", 
			"CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", 
			"STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'export'", 
			"'onready'", "'var'", "'setget'", "'const'", "'static'", "'func'", "'class'", 
			"'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", "'return'", 
			null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "CLASS", "EXTENDS", "CLASS_NAME", 
			"ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", "STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\6\31\u00b2\n\31\r\31\16\31\u00b3\3\32\5"+
		"\32\u00b7\n\32\3\32\6\32\u00ba\n\32\r\32\16\32\u00bb\3\32\3\32\6\32\u00c0"+
		"\n\32\r\32\16\32\u00c1\5\32\u00c4\n\32\3\33\3\33\7\33\u00c8\n\33\f\33"+
		"\16\33\u00cb\13\33\3\33\3\33\3\34\3\34\7\34\u00d1\n\34\f\34\16\34\u00d4"+
		"\13\34\3\35\3\35\3\35\3\35\3\35\7\35\u00db\n\35\f\35\16\35\u00de\13\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\37\6\37\u00e7\n\37\r\37\16\37\u00e8\3"+
		"\37\3\37\3 \3 \3 \3 \3\u00dc\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\6\6\2\62;C\\aac|\3\2\62;\4\2"+
		"\f\f$$\4\2\f\f\16\17\2\u00f8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C"+
		"\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17N\3\2\2\2\21P"+
		"\3\2\2\2\23R\3\2\2\2\25Y\3\2\2\2\27a\3\2\2\2\31e\3\2\2\2\33l\3\2\2\2\35"+
		"r\3\2\2\2\37y\3\2\2\2!~\3\2\2\2#\u0084\3\2\2\2%\u008c\3\2\2\2\'\u0097"+
		"\3\2\2\2)\u009c\3\2\2\2+\u009f\3\2\2\2-\u00a4\3\2\2\2/\u00a9\3\2\2\2\61"+
		"\u00b1\3\2\2\2\63\u00b6\3\2\2\2\65\u00c5\3\2\2\2\67\u00ce\3\2\2\29\u00d5"+
		"\3\2\2\2;\u00e3\3\2\2\2=\u00e6\3\2\2\2?\u00ec\3\2\2\2AB\7*\2\2B\4\3\2"+
		"\2\2CD\7.\2\2D\6\3\2\2\2EF\7+\2\2F\b\3\2\2\2GH\7<\2\2H\n\3\2\2\2IJ\7?"+
		"\2\2J\f\3\2\2\2KL\7/\2\2LM\7@\2\2M\16\3\2\2\2NO\7}\2\2O\20\3\2\2\2PQ\7"+
		"\177\2\2Q\22\3\2\2\2RS\7g\2\2ST\7z\2\2TU\7r\2\2UV\7q\2\2VW\7t\2\2WX\7"+
		"v\2\2X\24\3\2\2\2YZ\7q\2\2Z[\7p\2\2[\\\7t\2\2\\]\7g\2\2]^\7c\2\2^_\7f"+
		"\2\2_`\7{\2\2`\26\3\2\2\2ab\7x\2\2bc\7c\2\2cd\7t\2\2d\30\3\2\2\2ef\7u"+
		"\2\2fg\7g\2\2gh\7v\2\2hi\7i\2\2ij\7g\2\2jk\7v\2\2k\32\3\2\2\2lm\7e\2\2"+
		"mn\7q\2\2no\7p\2\2op\7u\2\2pq\7v\2\2q\34\3\2\2\2rs\7u\2\2st\7v\2\2tu\7"+
		"c\2\2uv\7v\2\2vw\7k\2\2wx\7e\2\2x\36\3\2\2\2yz\7h\2\2z{\7w\2\2{|\7p\2"+
		"\2|}\7e\2\2} \3\2\2\2~\177\7e\2\2\177\u0080\7n\2\2\u0080\u0081\7c\2\2"+
		"\u0081\u0082\7u\2\2\u0082\u0083\7u\2\2\u0083\"\3\2\2\2\u0084\u0085\7g"+
		"\2\2\u0085\u0086\7z\2\2\u0086\u0087\7v\2\2\u0087\u0088\7g\2\2\u0088\u0089"+
		"\7p\2\2\u0089\u008a\7f\2\2\u008a\u008b\7u\2\2\u008b$\3\2\2\2\u008c\u008d"+
		"\7e\2\2\u008d\u008e\7n\2\2\u008e\u008f\7c\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7u\2\2\u0091\u0092\7a\2\2\u0092\u0093\7p\2\2\u0093\u0094\7c\2\2"+
		"\u0094\u0095\7o\2\2\u0095\u0096\7g\2\2\u0096&\3\2\2\2\u0097\u0098\7g\2"+
		"\2\u0098\u0099\7p\2\2\u0099\u009a\7w\2\2\u009a\u009b\7o\2\2\u009b(\3\2"+
		"\2\2\u009c\u009d\7k\2\2\u009d\u009e\7h\2\2\u009e*\3\2\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7h\2\2\u00a3"+
		",\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8.\3\2\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\60\3\2\2\2\u00b0\u00b2\t\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\62\3\2\2\2\u00b5"+
		"\u00b7\7/\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00ba\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c3\3\2\2\2\u00bd\u00bf\7\60"+
		"\2\2\u00be\u00c0\t\3\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\64\3\2\2\2\u00c5\u00c9\7$\2\2\u00c6\u00c8"+
		"\n\4\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7$"+
		"\2\2\u00cd\66\3\2\2\2\u00ce\u00d2\7%\2\2\u00cf\u00d1\n\5\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"8\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6\u00d7\7$\2\2\u00d7"+
		"\u00d8\7$\2\2\u00d8\u00dc\3\2\2\2\u00d9\u00db\13\2\2\2\u00da\u00d9\3\2"+
		"\2\2\u00db\u00de\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\7$\2\2\u00e0\u00e1\7$\2"+
		"\2\u00e1\u00e2\7$\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7\f\2\2\u00e4<\3\2\2"+
		"\2\u00e5\u00e7\7\"\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b\37\2\2"+
		"\u00eb>\3\2\2\2\u00ec\u00ed\13\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b"+
		" \2\2\u00ef@\3\2\2\2\f\2\u00b3\u00b6\u00bb\u00c1\u00c3\u00c9\u00d2\u00dc"+
		"\u00e8\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}