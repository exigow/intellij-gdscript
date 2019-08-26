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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, EXPORT=41, ONREADY=42, VAR=43, SETGET=44, CONST=45, 
		STATIC=46, FUNC=47, FOR=48, IN=49, WHILE=50, CLASS=51, EXTENDS=52, CLASS_NAME=53, 
		ENUM=54, IF=55, ELIF=56, ELSE=57, RETURN=58, IDENTIFIER=59, NUMBER=60, 
		HEX=61, STRING=62, LINE_COMMENT=63, BLOCK_COMMENT=64, NL=65, WHITESPACE=66, 
		ERRCHAR=67;
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
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "EXPORT", 
			"ONREADY", "VAR", "SETGET", "CONST", "STATIC", "FUNC", "FOR", "IN", "WHILE", 
			"CLASS", "EXTENDS", "CLASS_NAME", "ENUM", "IF", "ELIF", "ELSE", "RETURN", 
			"IDENTIFIER", "NUMBER", "HEX", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", 
			"NL", "WHITESPACE", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'='", "'->'", "'{'", "'}'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'.'", "'is'", "'~'", 
			"'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&'", "'^'", "'|'", 
			"'<'", "'>'", "'=='", "'!='", "'>='", "'<='", "'!'", "'&&'", "'||'", 
			"'not'", "'and'", "'or'", "'export'", "'onready'", "'var'", "'setget'", 
			"'const'", "'static'", "'func'", "'for'", "'in'", "'while'", "'class'", 
			"'extends'", "'class_name'", "'enum'", "'if'", "'elif'", "'else'", "'return'", 
			null, null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "EXPORT", "ONREADY", "VAR", "SETGET", "CONST", 
			"STATIC", "FUNC", "FOR", "IN", "WHILE", "CLASS", "EXTENDS", "CLASS_NAME", 
			"ENUM", "IF", "ELIF", "ELSE", "RETURN", "IDENTIFIER", "NUMBER", "HEX", 
			"STRING", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "WHITESPACE", "ERRCHAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u01a6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3"+
		"*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38"+
		"\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\5<\u015c\n<\3<"+
		"\3<\7<\u0160\n<\f<\16<\u0163\13<\3=\5=\u0166\n=\3=\6=\u0169\n=\r=\16="+
		"\u016a\3=\3=\6=\u016f\n=\r=\16=\u0170\5=\u0173\n=\3>\3>\3>\6>\u0178\n"+
		">\r>\16>\u0179\3?\3?\7?\u017e\n?\f?\16?\u0181\13?\3?\3?\3@\3@\7@\u0187"+
		"\n@\f@\16@\u018a\13@\3A\3A\3A\3A\3A\7A\u0191\nA\fA\16A\u0194\13A\3A\3"+
		"A\3A\3A\3B\3B\3C\6C\u019d\nC\rC\16C\u019e\3C\3C\3D\3D\3D\3D\3\u0192\2"+
		"E\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\3\2\b\5\2C\\aac|\6\2"+
		"\62;C\\aac|\3\2\62;\4\2\62;CH\4\2\f\f$$\4\2\f\f\16\17\2\u01b0\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2"+
		"\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3"+
		"\2\2\2\2\u0087\3\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u008d\3\2\2\2"+
		"\t\u008f\3\2\2\2\13\u0091\3\2\2\2\r\u0093\3\2\2\2\17\u0096\3\2\2\2\21"+
		"\u0098\3\2\2\2\23\u009a\3\2\2\2\25\u009d\3\2\2\2\27\u00a0\3\2\2\2\31\u00a3"+
		"\3\2\2\2\33\u00a6\3\2\2\2\35\u00a9\3\2\2\2\37\u00ac\3\2\2\2!\u00af\3\2"+
		"\2\2#\u00b1\3\2\2\2%\u00b4\3\2\2\2\'\u00b6\3\2\2\2)\u00b8\3\2\2\2+\u00ba"+
		"\3\2\2\2-\u00bc\3\2\2\2/\u00be\3\2\2\2\61\u00c0\3\2\2\2\63\u00c3\3\2\2"+
		"\2\65\u00c6\3\2\2\2\67\u00c8\3\2\2\29\u00ca\3\2\2\2;\u00cc\3\2\2\2=\u00ce"+
		"\3\2\2\2?\u00d0\3\2\2\2A\u00d3\3\2\2\2C\u00d6\3\2\2\2E\u00d9\3\2\2\2G"+
		"\u00dc\3\2\2\2I\u00de\3\2\2\2K\u00e1\3\2\2\2M\u00e4\3\2\2\2O\u00e8\3\2"+
		"\2\2Q\u00ec\3\2\2\2S\u00ef\3\2\2\2U\u00f6\3\2\2\2W\u00fe\3\2\2\2Y\u0102"+
		"\3\2\2\2[\u0109\3\2\2\2]\u010f\3\2\2\2_\u0116\3\2\2\2a\u011b\3\2\2\2c"+
		"\u011f\3\2\2\2e\u0122\3\2\2\2g\u0128\3\2\2\2i\u012e\3\2\2\2k\u0136\3\2"+
		"\2\2m\u0141\3\2\2\2o\u0146\3\2\2\2q\u0149\3\2\2\2s\u014e\3\2\2\2u\u0153"+
		"\3\2\2\2w\u015b\3\2\2\2y\u0165\3\2\2\2{\u0174\3\2\2\2}\u017b\3\2\2\2\177"+
		"\u0184\3\2\2\2\u0081\u018b\3\2\2\2\u0083\u0199\3\2\2\2\u0085\u019c\3\2"+
		"\2\2\u0087\u01a2\3\2\2\2\u0089\u008a\7*\2\2\u008a\4\3\2\2\2\u008b\u008c"+
		"\7.\2\2\u008c\6\3\2\2\2\u008d\u008e\7+\2\2\u008e\b\3\2\2\2\u008f\u0090"+
		"\7<\2\2\u0090\n\3\2\2\2\u0091\u0092\7?\2\2\u0092\f\3\2\2\2\u0093\u0094"+
		"\7/\2\2\u0094\u0095\7@\2\2\u0095\16\3\2\2\2\u0096\u0097\7}\2\2\u0097\20"+
		"\3\2\2\2\u0098\u0099\7\177\2\2\u0099\22\3\2\2\2\u009a\u009b\7-\2\2\u009b"+
		"\u009c\7?\2\2\u009c\24\3\2\2\2\u009d\u009e\7/\2\2\u009e\u009f\7?\2\2\u009f"+
		"\26\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\7?\2\2\u00a2\30\3\2\2\2\u00a3"+
		"\u00a4\7\61\2\2\u00a4\u00a5\7?\2\2\u00a5\32\3\2\2\2\u00a6\u00a7\7\'\2"+
		"\2\u00a7\u00a8\7?\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\7(\2\2\u00aa\u00ab"+
		"\7?\2\2\u00ab\36\3\2\2\2\u00ac\u00ad\7~\2\2\u00ad\u00ae\7?\2\2\u00ae "+
		"\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0\"\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2"+
		"\u00b3\7u\2\2\u00b3$\3\2\2\2\u00b4\u00b5\7\u0080\2\2\u00b5&\3\2\2\2\u00b6"+
		"\u00b7\7,\2\2\u00b7(\3\2\2\2\u00b8\u00b9\7\61\2\2\u00b9*\3\2\2\2\u00ba"+
		"\u00bb\7\'\2\2\u00bb,\3\2\2\2\u00bc\u00bd\7-\2\2\u00bd.\3\2\2\2\u00be"+
		"\u00bf\7/\2\2\u00bf\60\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2\7>\2\2\u00c2"+
		"\62\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\u00c5\7@\2\2\u00c5\64\3\2\2\2\u00c6"+
		"\u00c7\7(\2\2\u00c7\66\3\2\2\2\u00c8\u00c9\7`\2\2\u00c98\3\2\2\2\u00ca"+
		"\u00cb\7~\2\2\u00cb:\3\2\2\2\u00cc\u00cd\7>\2\2\u00cd<\3\2\2\2\u00ce\u00cf"+
		"\7@\2\2\u00cf>\3\2\2\2\u00d0\u00d1\7?\2\2\u00d1\u00d2\7?\2\2\u00d2@\3"+
		"\2\2\2\u00d3\u00d4\7#\2\2\u00d4\u00d5\7?\2\2\u00d5B\3\2\2\2\u00d6\u00d7"+
		"\7@\2\2\u00d7\u00d8\7?\2\2\u00d8D\3\2\2\2\u00d9\u00da\7>\2\2\u00da\u00db"+
		"\7?\2\2\u00dbF\3\2\2\2\u00dc\u00dd\7#\2\2\u00ddH\3\2\2\2\u00de\u00df\7"+
		"(\2\2\u00df\u00e0\7(\2\2\u00e0J\3\2\2\2\u00e1\u00e2\7~\2\2\u00e2\u00e3"+
		"\7~\2\2\u00e3L\3\2\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7"+
		"\7v\2\2\u00e7N\3\2\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb"+
		"\7f\2\2\u00ebP\3\2\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7t\2\2\u00eeR\3"+
		"\2\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7z\2\2\u00f1\u00f2\7r\2\2\u00f2"+
		"\u00f3\7q\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7v\2\2\u00f5T\3\2\2\2\u00f6"+
		"\u00f7\7q\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7g\2\2"+
		"\u00fa\u00fb\7c\2\2\u00fb\u00fc\7f\2\2\u00fc\u00fd\7{\2\2\u00fdV\3\2\2"+
		"\2\u00fe\u00ff\7x\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7t\2\2\u0101X\3\2"+
		"\2\2\u0102\u0103\7u\2\2\u0103\u0104\7g\2\2\u0104\u0105\7v\2\2\u0105\u0106"+
		"\7i\2\2\u0106\u0107\7g\2\2\u0107\u0108\7v\2\2\u0108Z\3\2\2\2\u0109\u010a"+
		"\7e\2\2\u010a\u010b\7q\2\2\u010b\u010c\7p\2\2\u010c\u010d\7u\2\2\u010d"+
		"\u010e\7v\2\2\u010e\\\3\2\2\2\u010f\u0110\7u\2\2\u0110\u0111\7v\2\2\u0111"+
		"\u0112\7c\2\2\u0112\u0113\7v\2\2\u0113\u0114\7k\2\2\u0114\u0115\7e\2\2"+
		"\u0115^\3\2\2\2\u0116\u0117\7h\2\2\u0117\u0118\7w\2\2\u0118\u0119\7p\2"+
		"\2\u0119\u011a\7e\2\2\u011a`\3\2\2\2\u011b\u011c\7h\2\2\u011c\u011d\7"+
		"q\2\2\u011d\u011e\7t\2\2\u011eb\3\2\2\2\u011f\u0120\7k\2\2\u0120\u0121"+
		"\7p\2\2\u0121d\3\2\2\2\u0122\u0123\7y\2\2\u0123\u0124\7j\2\2\u0124\u0125"+
		"\7k\2\2\u0125\u0126\7n\2\2\u0126\u0127\7g\2\2\u0127f\3\2\2\2\u0128\u0129"+
		"\7e\2\2\u0129\u012a\7n\2\2\u012a\u012b\7c\2\2\u012b\u012c\7u\2\2\u012c"+
		"\u012d\7u\2\2\u012dh\3\2\2\2\u012e\u012f\7g\2\2\u012f\u0130\7z\2\2\u0130"+
		"\u0131\7v\2\2\u0131\u0132\7g\2\2\u0132\u0133\7p\2\2\u0133\u0134\7f\2\2"+
		"\u0134\u0135\7u\2\2\u0135j\3\2\2\2\u0136\u0137\7e\2\2\u0137\u0138\7n\2"+
		"\2\u0138\u0139\7c\2\2\u0139\u013a\7u\2\2\u013a\u013b\7u\2\2\u013b\u013c"+
		"\7a\2\2\u013c\u013d\7p\2\2\u013d\u013e\7c\2\2\u013e\u013f\7o\2\2\u013f"+
		"\u0140\7g\2\2\u0140l\3\2\2\2\u0141\u0142\7g\2\2\u0142\u0143\7p\2\2\u0143"+
		"\u0144\7w\2\2\u0144\u0145\7o\2\2\u0145n\3\2\2\2\u0146\u0147\7k\2\2\u0147"+
		"\u0148\7h\2\2\u0148p\3\2\2\2\u0149\u014a\7g\2\2\u014a\u014b\7n\2\2\u014b"+
		"\u014c\7k\2\2\u014c\u014d\7h\2\2\u014dr\3\2\2\2\u014e\u014f\7g\2\2\u014f"+
		"\u0150\7n\2\2\u0150\u0151\7u\2\2\u0151\u0152\7g\2\2\u0152t\3\2\2\2\u0153"+
		"\u0154\7t\2\2\u0154\u0155\7g\2\2\u0155\u0156\7v\2\2\u0156\u0157\7w\2\2"+
		"\u0157\u0158\7t\2\2\u0158\u0159\7p\2\2\u0159v\3\2\2\2\u015a\u015c\7&\2"+
		"\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0161"+
		"\t\2\2\2\u015e\u0160\t\3\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162x\3\2\2\2\u0163\u0161\3\2\2\2"+
		"\u0164\u0166\7/\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168"+
		"\3\2\2\2\u0167\u0169\t\4\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0172\3\2\2\2\u016c\u016e\7\60"+
		"\2\2\u016d\u016f\t\4\2\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u016c\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173z\3\2\2\2\u0174\u0175\7\62\2\2\u0175\u0177"+
		"\7z\2\2\u0176\u0178\t\5\2\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a|\3\2\2\2\u017b\u017f\7$\2\2\u017c"+
		"\u017e\n\6\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0183\7$\2\2\u0183~\3\2\2\2\u0184\u0188\7%\2\2\u0185\u0187\n\7\2\2\u0186"+
		"\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u0080\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\7$\2\2\u018c"+
		"\u018d\7$\2\2\u018d\u018e\7$\2\2\u018e\u0192\3\2\2\2\u018f\u0191\13\2"+
		"\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0193\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7$"+
		"\2\2\u0196\u0197\7$\2\2\u0197\u0198\7$\2\2\u0198\u0082\3\2\2\2\u0199\u019a"+
		"\7\f\2\2\u019a\u0084\3\2\2\2\u019b\u019d\7\"\2\2\u019c\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u01a1\bC\2\2\u01a1\u0086\3\2\2\2\u01a2\u01a3\13\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a5\bD\2\2\u01a5\u0088\3\2\2\2\16\2\u015b\u0161"+
		"\u0165\u016a\u0170\u0172\u0179\u017f\u0188\u0192\u019e\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}