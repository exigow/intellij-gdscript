// Generated from GDScript.g4 by ANTLR 4.7.2
package plugin.parser.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GDScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, EXPORT=44, ONREADY=45, 
		VAR=46, SETGET=47, CONST=48, STATIC=49, FUNC=50, FOR=51, IN=52, WHILE=53, 
		CLASS=54, EXTENDS=55, CLASS_NAME=56, ENUM=57, IF=58, ELIF=59, ELSE=60, 
		RETURN=61, IDENTIFIER=62, NUMBER=63, HEX=64, STRING=65, LINE_COMMENT=66, 
		BLOCK_COMMENT=67, NL=68, WHITESPACE=69, ERRCHAR=70;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "EXPORT", "ONREADY", "VAR", "SETGET", "CONST", "STATIC", 
			"FUNC", "FOR", "IN", "WHILE", "CLASS", "EXTENDS", "CLASS_NAME", "ENUM", 
			"IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", "HEX", "STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'.'", "'is'", "'as'", 
			"'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&'", "'^'", 
			"'|'", "'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'!'", "'&&'", "'||'", 
			"'not'", "'and'", "'or'", "'['", "']'", "'export'", "'onready'", "'var'", 
			"'setget'", "'const'", "'static'", "'func'", "'for'", "'in'", "'while'", 
			"'class'", "'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", 
			"'return'", null, null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "EXPORT", "ONREADY", 
			"VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", 
			"EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", 
			"NUMBER", "HEX", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2H\u01b4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3"+
		"\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		"/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\39\3"+
		"9\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3"+
		">\3>\3>\3>\3>\3?\5?\u0169\n?\3?\3?\7?\u016d\n?\f?\16?\u0170\13?\3@\5@"+
		"\u0173\n@\3@\6@\u0176\n@\r@\16@\u0177\3@\3@\6@\u017c\n@\r@\16@\u017d\5"+
		"@\u0180\n@\3A\3A\3A\7A\u0185\nA\fA\16A\u0188\13A\3B\3B\7B\u018c\nB\fB"+
		"\16B\u018f\13B\3B\3B\3C\3C\7C\u0195\nC\fC\16C\u0198\13C\3D\3D\3D\3D\3"+
		"D\7D\u019f\nD\fD\16D\u01a2\13D\3D\3D\3D\3D\3E\3E\3F\6F\u01ab\nF\rF\16"+
		"F\u01ac\3F\3F\3G\3G\3G\3G\3\u01a0\2H\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\u008dH\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3"+
		"\2\62;\4\2\62;CH\4\2\f\f$$\4\2\f\f\16\17\2\u01be\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3\u008f\3\2\2\2"+
		"\5\u0091\3\2\2\2\7\u0093\3\2\2\2\t\u0095\3\2\2\2\13\u0097\3\2\2\2\r\u0099"+
		"\3\2\2\2\17\u009c\3\2\2\2\21\u009e\3\2\2\2\23\u00a0\3\2\2\2\25\u00a3\3"+
		"\2\2\2\27\u00a6\3\2\2\2\31\u00a9\3\2\2\2\33\u00ac\3\2\2\2\35\u00af\3\2"+
		"\2\2\37\u00b2\3\2\2\2!\u00b5\3\2\2\2#\u00b7\3\2\2\2%\u00ba\3\2\2\2\'\u00bd"+
		"\3\2\2\2)\u00bf\3\2\2\2+\u00c1\3\2\2\2-\u00c3\3\2\2\2/\u00c5\3\2\2\2\61"+
		"\u00c7\3\2\2\2\63\u00c9\3\2\2\2\65\u00cc\3\2\2\2\67\u00cf\3\2\2\29\u00d1"+
		"\3\2\2\2;\u00d3\3\2\2\2=\u00d5\3\2\2\2?\u00d7\3\2\2\2A\u00d9\3\2\2\2C"+
		"\u00dc\3\2\2\2E\u00df\3\2\2\2G\u00e2\3\2\2\2I\u00e5\3\2\2\2K\u00e7\3\2"+
		"\2\2M\u00ea\3\2\2\2O\u00ed\3\2\2\2Q\u00f1\3\2\2\2S\u00f5\3\2\2\2U\u00f8"+
		"\3\2\2\2W\u00fa\3\2\2\2Y\u00fc\3\2\2\2[\u0103\3\2\2\2]\u010b\3\2\2\2_"+
		"\u010f\3\2\2\2a\u0116\3\2\2\2c\u011c\3\2\2\2e\u0123\3\2\2\2g\u0128\3\2"+
		"\2\2i\u012c\3\2\2\2k\u012f\3\2\2\2m\u0135\3\2\2\2o\u013b\3\2\2\2q\u0143"+
		"\3\2\2\2s\u014e\3\2\2\2u\u0153\3\2\2\2w\u0156\3\2\2\2y\u015b\3\2\2\2{"+
		"\u0160\3\2\2\2}\u0168\3\2\2\2\177\u0172\3\2\2\2\u0081\u0181\3\2\2\2\u0083"+
		"\u0189\3\2\2\2\u0085\u0192\3\2\2\2\u0087\u0199\3\2\2\2\u0089\u01a7\3\2"+
		"\2\2\u008b\u01aa\3\2\2\2\u008d\u01b0\3\2\2\2\u008f\u0090\7*\2\2\u0090"+
		"\4\3\2\2\2\u0091\u0092\7.\2\2\u0092\6\3\2\2\2\u0093\u0094\7+\2\2\u0094"+
		"\b\3\2\2\2\u0095\u0096\7<\2\2\u0096\n\3\2\2\2\u0097\u0098\7?\2\2\u0098"+
		"\f\3\2\2\2\u0099\u009a\7/\2\2\u009a\u009b\7@\2\2\u009b\16\3\2\2\2\u009c"+
		"\u009d\7}\2\2\u009d\20\3\2\2\2\u009e\u009f\7\177\2\2\u009f\22\3\2\2\2"+
		"\u00a0\u00a1\7-\2\2\u00a1\u00a2\7?\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7"+
		"/\2\2\u00a4\u00a5\7?\2\2\u00a5\26\3\2\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8\30\3\2\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\7?\2\2\u00ab"+
		"\32\3\2\2\2\u00ac\u00ad\7\'\2\2\u00ad\u00ae\7?\2\2\u00ae\34\3\2\2\2\u00af"+
		"\u00b0\7(\2\2\u00b0\u00b1\7?\2\2\u00b1\36\3\2\2\2\u00b2\u00b3\7~\2\2\u00b3"+
		"\u00b4\7?\2\2\u00b4 \3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6\"\3\2\2\2\u00b7"+
		"\u00b8\7k\2\2\u00b8\u00b9\7u\2\2\u00b9$\3\2\2\2\u00ba\u00bb\7c\2\2\u00bb"+
		"\u00bc\7u\2\2\u00bc&\3\2\2\2\u00bd\u00be\7\u0080\2\2\u00be(\3\2\2\2\u00bf"+
		"\u00c0\7,\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2,\3\2\2\2\u00c3"+
		"\u00c4\7\'\2\2\u00c4.\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\60\3\2\2\2\u00c7"+
		"\u00c8\7/\2\2\u00c8\62\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb\7>\2\2\u00cb"+
		"\64\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd\u00ce\7@\2\2\u00ce\66\3\2\2\2\u00cf"+
		"\u00d0\7(\2\2\u00d08\3\2\2\2\u00d1\u00d2\7`\2\2\u00d2:\3\2\2\2\u00d3\u00d4"+
		"\7~\2\2\u00d4<\3\2\2\2\u00d5\u00d6\7>\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7"+
		"@\2\2\u00d8@\3\2\2\2\u00d9\u00da\7?\2\2\u00da\u00db\7?\2\2\u00dbB\3\2"+
		"\2\2\u00dc\u00dd\7#\2\2\u00dd\u00de\7?\2\2\u00deD\3\2\2\2\u00df\u00e0"+
		"\7@\2\2\u00e0\u00e1\7?\2\2\u00e1F\3\2\2\2\u00e2\u00e3\7>\2\2\u00e3\u00e4"+
		"\7?\2\2\u00e4H\3\2\2\2\u00e5\u00e6\7#\2\2\u00e6J\3\2\2\2\u00e7\u00e8\7"+
		"(\2\2\u00e8\u00e9\7(\2\2\u00e9L\3\2\2\2\u00ea\u00eb\7~\2\2\u00eb\u00ec"+
		"\7~\2\2\u00ecN\3\2\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0"+
		"\7v\2\2\u00f0P\3\2\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4"+
		"\7f\2\2\u00f4R\3\2\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7t\2\2\u00f7T\3"+
		"\2\2\2\u00f8\u00f9\7]\2\2\u00f9V\3\2\2\2\u00fa\u00fb\7_\2\2\u00fbX\3\2"+
		"\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7z\2\2\u00fe\u00ff\7r\2\2\u00ff\u0100"+
		"\7q\2\2\u0100\u0101\7t\2\2\u0101\u0102\7v\2\2\u0102Z\3\2\2\2\u0103\u0104"+
		"\7q\2\2\u0104\u0105\7p\2\2\u0105\u0106\7t\2\2\u0106\u0107\7g\2\2\u0107"+
		"\u0108\7c\2\2\u0108\u0109\7f\2\2\u0109\u010a\7{\2\2\u010a\\\3\2\2\2\u010b"+
		"\u010c\7x\2\2\u010c\u010d\7c\2\2\u010d\u010e\7t\2\2\u010e^\3\2\2\2\u010f"+
		"\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111\u0112\7v\2\2\u0112\u0113\7i\2\2"+
		"\u0113\u0114\7g\2\2\u0114\u0115\7v\2\2\u0115`\3\2\2\2\u0116\u0117\7e\2"+
		"\2\u0117\u0118\7q\2\2\u0118\u0119\7p\2\2\u0119\u011a\7u\2\2\u011a\u011b"+
		"\7v\2\2\u011bb\3\2\2\2\u011c\u011d\7u\2\2\u011d\u011e\7v\2\2\u011e\u011f"+
		"\7c\2\2\u011f\u0120\7v\2\2\u0120\u0121\7k\2\2\u0121\u0122\7e\2\2\u0122"+
		"d\3\2\2\2\u0123\u0124\7h\2\2\u0124\u0125\7w\2\2\u0125\u0126\7p\2\2\u0126"+
		"\u0127\7e\2\2\u0127f\3\2\2\2\u0128\u0129\7h\2\2\u0129\u012a\7q\2\2\u012a"+
		"\u012b\7t\2\2\u012bh\3\2\2\2\u012c\u012d\7k\2\2\u012d\u012e\7p\2\2\u012e"+
		"j\3\2\2\2\u012f\u0130\7y\2\2\u0130\u0131\7j\2\2\u0131\u0132\7k\2\2\u0132"+
		"\u0133\7n\2\2\u0133\u0134\7g\2\2\u0134l\3\2\2\2\u0135\u0136\7e\2\2\u0136"+
		"\u0137\7n\2\2\u0137\u0138\7c\2\2\u0138\u0139\7u\2\2\u0139\u013a\7u\2\2"+
		"\u013an\3\2\2\2\u013b\u013c\7g\2\2\u013c\u013d\7z\2\2\u013d\u013e\7v\2"+
		"\2\u013e\u013f\7g\2\2\u013f\u0140\7p\2\2\u0140\u0141\7f\2\2\u0141\u0142"+
		"\7u\2\2\u0142p\3\2\2\2\u0143\u0144\7e\2\2\u0144\u0145\7n\2\2\u0145\u0146"+
		"\7c\2\2\u0146\u0147\7u\2\2\u0147\u0148\7u\2\2\u0148\u0149\7a\2\2\u0149"+
		"\u014a\7p\2\2\u014a\u014b\7c\2\2\u014b\u014c\7o\2\2\u014c\u014d\7g\2\2"+
		"\u014dr\3\2\2\2\u014e\u014f\7g\2\2\u014f\u0150\7p\2\2\u0150\u0151\7w\2"+
		"\2\u0151\u0152\7o\2\2\u0152t\3\2\2\2\u0153\u0154\7k\2\2\u0154\u0155\7"+
		"h\2\2\u0155v\3\2\2\2\u0156\u0157\7g\2\2\u0157\u0158\7n\2\2\u0158\u0159"+
		"\7k\2\2\u0159\u015a\7h\2\2\u015ax\3\2\2\2\u015b\u015c\7g\2\2\u015c\u015d"+
		"\7n\2\2\u015d\u015e\7u\2\2\u015e\u015f\7g\2\2\u015fz\3\2\2\2\u0160\u0161"+
		"\7t\2\2\u0161\u0162\7g\2\2\u0162\u0163\7v\2\2\u0163\u0164\7w\2\2\u0164"+
		"\u0165\7t\2\2\u0165\u0166\7p\2\2\u0166|\3\2\2\2\u0167\u0169\7&\2\2\u0168"+
		"\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016e\t\2"+
		"\2\2\u016b\u016d\t\3\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f~\3\2\2\2\u0170\u016e\3\2\2\2"+
		"\u0171\u0173\7/\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175"+
		"\3\2\2\2\u0174\u0176\t\4\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017f\3\2\2\2\u0179\u017b\7\60"+
		"\2\2\u017a\u017c\t\4\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0179\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u0080\3\2\2\2\u0181\u0182\7\62\2\2\u0182"+
		"\u0186\7z\2\2\u0183\u0185\t\5\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2"+
		"\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0082\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0189\u018d\7$\2\2\u018a\u018c\n\6\2\2\u018b\u018a\3\2"+
		"\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7$\2\2\u0191\u0084\3\2"+
		"\2\2\u0192\u0196\7%\2\2\u0193\u0195\n\7\2\2\u0194\u0193\3\2\2\2\u0195"+
		"\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0086\3\2"+
		"\2\2\u0198\u0196\3\2\2\2\u0199\u019a\7$\2\2\u019a\u019b\7$\2\2\u019b\u019c"+
		"\7$\2\2\u019c\u01a0\3\2\2\2\u019d\u019f\13\2\2\2\u019e\u019d\3\2\2\2\u019f"+
		"\u01a2\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a3\3\2"+
		"\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a4\7$\2\2\u01a4\u01a5\7$\2\2\u01a5\u01a6"+
		"\7$\2\2\u01a6\u0088\3\2\2\2\u01a7\u01a8\7\f\2\2\u01a8\u008a\3\2\2\2\u01a9"+
		"\u01ab\7\"\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2"+
		"\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\bF\2\2\u01af"+
		"\u008c\3\2\2\2\u01b0\u01b1\13\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\b"+
		"G\2\2\u01b3\u008e\3\2\2\2\16\2\u0168\u016e\u0172\u0177\u017d\u017f\u0186"+
		"\u018d\u0196\u01a0\u01ac\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}