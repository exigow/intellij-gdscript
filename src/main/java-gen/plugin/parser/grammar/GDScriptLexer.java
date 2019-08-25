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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, EXPORT=16, 
		ONREADY=17, VAR=18, SETGET=19, CONST=20, STATIC=21, FUNC=22, FOR=23, IN=24, 
		WHILE=25, CLASS=26, EXTENDS=27, CLASS_NAME=28, ENUM=29, IF=30, ELIF=31, 
		ELSE=32, RETURN=33, IDENTIFIER=34, NUMBER=35, STRING=36, LINE_COMMENT=37, 
		BLOCK_COMMENT=38, NL=39, WHITESPACE=40, ERRCHAR=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", 
			"EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", 
			"NUMBER", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", 
			"ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'export'", "'onready'", 
			"'var'", "'setget'", "'const'", "'static'", "'func'", "'for'", "'in'", 
			"'while'", "'class'", "'extends'", "'class_name'", "'enum'", "'if'", 
			"'elif'", "'else'", "'return'", null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "EXPORT", "ONREADY", "VAR", "SETGET", "CONST", 
			"STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", "EXTENDS", "CLASS_NAME", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0128\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\7#\u00e9\n#\f#\16#\u00ec\13#"+
		"\3$\5$\u00ef\n$\3$\6$\u00f2\n$\r$\16$\u00f3\3$\3$\6$\u00f8\n$\r$\16$\u00f9"+
		"\5$\u00fc\n$\3%\3%\7%\u0100\n%\f%\16%\u0103\13%\3%\3%\3&\3&\7&\u0109\n"+
		"&\f&\16&\u010c\13&\3\'\3\'\3\'\3\'\3\'\7\'\u0113\n\'\f\'\16\'\u0116\13"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3)\6)\u011f\n)\r)\16)\u0120\3)\3)\3*\3*\3*\3"+
		"*\3\u0114\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\7\5\2C\\aac|\6\2\62;C\\a"+
		"ac|\3\2\62;\4\2\f\f$$\4\2\f\f\16\17\2\u0130\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7Y\3"+
		"\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17b\3\2\2\2\21d\3\2\2\2\23f\3"+
		"\2\2\2\25i\3\2\2\2\27l\3\2\2\2\31o\3\2\2\2\33r\3\2\2\2\35u\3\2\2\2\37"+
		"x\3\2\2\2!{\3\2\2\2#\u0082\3\2\2\2%\u008a\3\2\2\2\'\u008e\3\2\2\2)\u0095"+
		"\3\2\2\2+\u009b\3\2\2\2-\u00a2\3\2\2\2/\u00a7\3\2\2\2\61\u00ab\3\2\2\2"+
		"\63\u00ae\3\2\2\2\65\u00b4\3\2\2\2\67\u00ba\3\2\2\29\u00c2\3\2\2\2;\u00cd"+
		"\3\2\2\2=\u00d2\3\2\2\2?\u00d5\3\2\2\2A\u00da\3\2\2\2C\u00df\3\2\2\2E"+
		"\u00e6\3\2\2\2G\u00ee\3\2\2\2I\u00fd\3\2\2\2K\u0106\3\2\2\2M\u010d\3\2"+
		"\2\2O\u011b\3\2\2\2Q\u011e\3\2\2\2S\u0124\3\2\2\2UV\7*\2\2V\4\3\2\2\2"+
		"WX\7.\2\2X\6\3\2\2\2YZ\7+\2\2Z\b\3\2\2\2[\\\7<\2\2\\\n\3\2\2\2]^\7?\2"+
		"\2^\f\3\2\2\2_`\7/\2\2`a\7@\2\2a\16\3\2\2\2bc\7}\2\2c\20\3\2\2\2de\7\177"+
		"\2\2e\22\3\2\2\2fg\7-\2\2gh\7?\2\2h\24\3\2\2\2ij\7/\2\2jk\7?\2\2k\26\3"+
		"\2\2\2lm\7,\2\2mn\7?\2\2n\30\3\2\2\2op\7\61\2\2pq\7?\2\2q\32\3\2\2\2r"+
		"s\7\'\2\2st\7?\2\2t\34\3\2\2\2uv\7(\2\2vw\7?\2\2w\36\3\2\2\2xy\7~\2\2"+
		"yz\7?\2\2z \3\2\2\2{|\7g\2\2|}\7z\2\2}~\7r\2\2~\177\7q\2\2\177\u0080\7"+
		"t\2\2\u0080\u0081\7v\2\2\u0081\"\3\2\2\2\u0082\u0083\7q\2\2\u0083\u0084"+
		"\7p\2\2\u0084\u0085\7t\2\2\u0085\u0086\7g\2\2\u0086\u0087\7c\2\2\u0087"+
		"\u0088\7f\2\2\u0088\u0089\7{\2\2\u0089$\3\2\2\2\u008a\u008b\7x\2\2\u008b"+
		"\u008c\7c\2\2\u008c\u008d\7t\2\2\u008d&\3\2\2\2\u008e\u008f\7u\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091\u0092\7i\2\2\u0092\u0093\7g\2\2"+
		"\u0093\u0094\7v\2\2\u0094(\3\2\2\2\u0095\u0096\7e\2\2\u0096\u0097\7q\2"+
		"\2\u0097\u0098\7p\2\2\u0098\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a*\3\2"+
		"\2\2\u009b\u009c\7u\2\2\u009c\u009d\7v\2\2\u009d\u009e\7c\2\2\u009e\u009f"+
		"\7v\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7e\2\2\u00a1,\3\2\2\2\u00a2\u00a3"+
		"\7h\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7e\2\2\u00a6"+
		".\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7t\2\2\u00aa"+
		"\60\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7p\2\2\u00ad\62\3\2\2\2\u00ae"+
		"\u00af\7y\2\2\u00af\u00b0\7j\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7n\2\2"+
		"\u00b2\u00b3\7g\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7"+
		"n\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7u\2\2\u00b9\66"+
		"\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7z\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7u\2\2"+
		"\u00c18\3\2\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7c\2"+
		"\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7a\2\2\u00c8\u00c9"+
		"\7p\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7o\2\2\u00cb\u00cc\7g\2\2\u00cc"+
		":\3\2\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7w\2\2\u00d0"+
		"\u00d1\7o\2\2\u00d1<\3\2\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7h\2\2\u00d4"+
		">\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7k\2\2\u00d8"+
		"\u00d9\7h\2\2\u00d9@\3\2\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7n\2\2\u00dc"+
		"\u00dd\7u\2\2\u00dd\u00de\7g\2\2\u00deB\3\2\2\2\u00df\u00e0\7t\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7t\2\2"+
		"\u00e4\u00e5\7p\2\2\u00e5D\3\2\2\2\u00e6\u00ea\t\2\2\2\u00e7\u00e9\t\3"+
		"\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00ebF\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\7/\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00f2\t\4"+
		"\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00fb\3\2\2\2\u00f5\u00f7\7\60\2\2\u00f6\u00f8\t"+
		"\4\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fcH\3\2\2\2\u00fd\u0101\7$\2\2\u00fe\u0100\n\5\2\2\u00ff\u00fe"+
		"\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7$\2\2\u0105J\3\2\2\2\u0106"+
		"\u010a\7%\2\2\u0107\u0109\n\6\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010bL\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010d\u010e\7$\2\2\u010e\u010f\7$\2\2\u010f\u0110\7$\2\2\u0110"+
		"\u0114\3\2\2\2\u0111\u0113\13\2\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3"+
		"\2\2\2\u0114\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0117\u0118\7$\2\2\u0118\u0119\7$\2\2\u0119\u011a\7$\2"+
		"\2\u011aN\3\2\2\2\u011b\u011c\7\f\2\2\u011cP\3\2\2\2\u011d\u011f\7\"\2"+
		"\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\b)\2\2\u0123R\3\2\2\2\u0124\u0125"+
		"\13\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\b*\2\2\u0127T\3\2\2\2\f\2\u00ea"+
		"\u00ee\u00f3\u00f9\u00fb\u0101\u010a\u0114\u0120\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}