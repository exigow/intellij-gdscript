// Generated from /home/exigo/projects/intellij-gdscript/src/main/antlr/gdscript/Core.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Core extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQUALS=1, MINUS=2, SEMICOLON=3, SLASH=4, COLON=5, COMMA=6, DOT=7, PARENTHES_LEFT=8, 
		PARENTHES_RIGHT=9, BRACKET_LEFT=10, BRACKET_RIGHT=11, BRACE_LEFT=12, BRACE_RIGHT=13, 
		NL=14, NUMBER=15, IDENTIFIER=16, RESOURCE=17, USER_RESOURCE=18, STRING_MULTILINE=19, 
		STRING_DOUBLE_QUOTE=20, STRING_APHOSTROPHE=21, WHITESPACE=22, ERRCHAR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"EQUALS", "MINUS", "SEMICOLON", "SLASH", "COLON", "COMMA", "DOT", "PARENTHES_LEFT", 
			"PARENTHES_RIGHT", "BRACKET_LEFT", "BRACKET_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", 
			"NL", "NUMBER", "NUMBER_INTEGER", "NUMBER_BINARY", "NUMBER_HEXADECIMAL", 
			"NUMBER_FLOAT", "IDENTIFIER", "LETTER", "LOWER_CASE", "UPPER_CASE", "UNDERSCORE", 
			"DIGIT", "RESOURCE", "USER_RESOURCE", "STRING_MULTILINE", "STRING_DOUBLE_QUOTE", 
			"STRING_APHOSTROPHE", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'-'", "';'", "'/'", "':'", "','", "'.'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EQUALS", "MINUS", "SEMICOLON", "SLASH", "COLON", "COMMA", "DOT", 
			"PARENTHES_LEFT", "PARENTHES_RIGHT", "BRACKET_LEFT", "BRACKET_RIGHT", 
			"BRACE_LEFT", "BRACE_RIGHT", "NL", "NUMBER", "IDENTIFIER", "RESOURCE", 
			"USER_RESOURCE", "STRING_MULTILINE", "STRING_DOUBLE_QUOTE", "STRING_APHOSTROPHE", 
			"WHITESPACE", "ERRCHAR"
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


	public Core(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Core.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00ff\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\5\20d\n\20\3\21\6\21g\n\21\r\21\16\21h\3\22\3\22\3\22\3\22\6\22"+
		"o\n\22\r\22\16\22p\3\23\3\23\3\23\3\23\3\23\6\23x\n\23\r\23\16\23y\3\24"+
		"\7\24}\n\24\f\24\16\24\u0080\13\24\3\24\3\24\6\24\u0084\n\24\r\24\16\24"+
		"\u0085\3\24\3\24\5\24\u008a\n\24\3\24\6\24\u008d\n\24\r\24\16\24\u008e"+
		"\5\24\u0091\n\24\3\25\7\25\u0094\n\25\f\25\16\25\u0097\13\25\3\25\3\25"+
		"\3\25\7\25\u009c\n\25\f\25\16\25\u009f\13\25\3\26\3\26\3\26\5\26\u00a4"+
		"\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\7\33\u00b7\n\33\f\33\16\33\u00ba\13\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u00c8\n\34\f\34"+
		"\16\34\u00cb\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u00d4\n\35"+
		"\f\35\16\35\u00d7\13\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u00df\n\36"+
		"\f\36\16\36\u00e2\13\36\3\36\3\36\3\36\5\36\u00e7\n\36\3\37\3\37\7\37"+
		"\u00eb\n\37\f\37\16\37\u00ee\13\37\3\37\3\37\3\37\5\37\u00f3\n\37\3 \6"+
		" \u00f6\n \r \16 \u00f7\3 \3 \3!\3!\3!\3!\7\u00b8\u00c9\u00d5\u00e0\u00ec"+
		"\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\2#\2%\2\'\2)\22+\2-\2/\2\61\2\63\2\65\23\67\249\25;\26=\27"+
		"?\30A\31\3\2\4\4\2--//\4\2\13\13\"\"\2\u0110\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2)\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2"+
		"\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2"+
		"\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2"+
		"\2\37c\3\2\2\2!f\3\2\2\2#j\3\2\2\2%r\3\2\2\2\'~\3\2\2\2)\u0095\3\2\2\2"+
		"+\u00a3\3\2\2\2-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61\u00a9\3\2\2\2\63\u00ab"+
		"\3\2\2\2\65\u00ad\3\2\2\2\67\u00bd\3\2\2\29\u00ce\3\2\2\2;\u00dc\3\2\2"+
		"\2=\u00e8\3\2\2\2?\u00f5\3\2\2\2A\u00fb\3\2\2\2CD\7?\2\2D\4\3\2\2\2EF"+
		"\7/\2\2F\6\3\2\2\2GH\7=\2\2H\b\3\2\2\2IJ\7\61\2\2J\n\3\2\2\2KL\7<\2\2"+
		"L\f\3\2\2\2MN\7.\2\2N\16\3\2\2\2OP\7\60\2\2P\20\3\2\2\2QR\7*\2\2R\22\3"+
		"\2\2\2ST\7+\2\2T\24\3\2\2\2UV\7]\2\2V\26\3\2\2\2WX\7_\2\2X\30\3\2\2\2"+
		"YZ\7}\2\2Z\32\3\2\2\2[\\\7\177\2\2\\\34\3\2\2\2]^\7\f\2\2^\36\3\2\2\2"+
		"_d\5!\21\2`d\5#\22\2ad\5%\23\2bd\5\'\24\2c_\3\2\2\2c`\3\2\2\2ca\3\2\2"+
		"\2cb\3\2\2\2d \3\2\2\2eg\5\63\32\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2"+
		"\2\2i\"\3\2\2\2jk\7\62\2\2kl\7d\2\2ln\3\2\2\2mo\4\62\63\2nm\3\2\2\2op"+
		"\3\2\2\2pn\3\2\2\2pq\3\2\2\2q$\3\2\2\2rs\7\62\2\2st\7z\2\2tw\3\2\2\2u"+
		"x\5\63\32\2vx\4CH\2wu\3\2\2\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2"+
		"z&\3\2\2\2{}\5\63\32\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2"+
		"\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\5\17\b\2\u0082\u0084\5\63"+
		"\32\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0090\3\2\2\2\u0087\u0089\7g\2\2\u0088\u008a\t\2"+
		"\2\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u008d\5\63\32\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0087\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091(\3\2\2\2\u0092\u0094\5\63\32\2\u0093\u0092\3\2\2"+
		"\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009d\5+\26\2\u0099\u009c\5+\26\2\u009a"+
		"\u009c\5\63\32\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e*\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u00a0\u00a4\5-\27\2\u00a1\u00a4\5/\30\2\u00a2\u00a4\5\61\31\2"+
		"\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4,\3"+
		"\2\2\2\u00a5\u00a6\4c|\2\u00a6.\3\2\2\2\u00a7\u00a8\4C\\\2\u00a8\60\3"+
		"\2\2\2\u00a9\u00aa\7a\2\2\u00aa\62\3\2\2\2\u00ab\u00ac\4\62;\2\u00ac\64"+
		"\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"\u00b1\7u\2\2\u00b1\u00b2\7<\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\7\61"+
		"\2\2\u00b4\u00b8\3\2\2\2\u00b5\u00b7\13\2\2\2\u00b6\u00b5\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7$\2\2\u00bc\66\3\2\2\2\u00bd\u00be"+
		"\7$\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\u00c2\7t\2\2\u00c2\u00c3\7<\2\2\u00c3\u00c4\7\61\2\2\u00c4\u00c5\7\61"+
		"\2\2\u00c5\u00c9\3\2\2\2\u00c6\u00c8\13\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7$\2\2\u00cd8\3\2\2\2\u00ce\u00cf"+
		"\7$\2\2\u00cf\u00d0\7$\2\2\u00d0\u00d1\7$\2\2\u00d1\u00d5\3\2\2\2\u00d2"+
		"\u00d4\13\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00d9\7$\2\2\u00d9\u00da\7$\2\2\u00da\u00db\7$\2\2\u00db:\3\2\2\2\u00dc"+
		"\u00e0\7$\2\2\u00dd\u00df\13\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e6\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e7\7$\2\2\u00e4\u00e7\5\35\17\2\u00e5\u00e7\7"+
		"\2\2\3\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"<\3\2\2\2\u00e8\u00ec\7)\2\2\u00e9\u00eb\13\2\2\2\u00ea\u00e9\3\2\2\2"+
		"\u00eb\u00ee\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00f2"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f3\7)\2\2\u00f0\u00f3\5\35\17\2"+
		"\u00f1\u00f3\7\2\2\3\u00f2\u00ef\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1"+
		"\3\2\2\2\u00f3>\3\2\2\2\u00f4\u00f6\t\3\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\b \2\2\u00fa@\3\2\2\2\u00fb\u00fc\13\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u00fe\b!\2\2\u00feB\3\2\2\2\31\2chpwy~\u0085\u0089\u008e"+
		"\u0090\u0095\u009b\u009d\u00a3\u00b8\u00c9\u00d5\u00e0\u00e6\u00ec\u00f2"+
		"\u00f7\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}