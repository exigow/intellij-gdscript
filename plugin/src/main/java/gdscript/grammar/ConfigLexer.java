// Generated from Config.g4 by ANTLR 4.7.2
package gdscript.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		KEYWORD=10, IDENTIFIER=11, STRING=12, NUMBER=13, COMMENT=14, WHITESPACE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"KEYWORD", "IDENTIFIER", "STRING", "NUMBER", "COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'='", "'('", "','", "')'", "'{'", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "KEYWORD", 
			"IDENTIFIER", "STRING", "NUMBER", "COMMENT", "WHITESPACE"
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


	public ConfigLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Config.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13=\n\13\3\f\3\f\7\fA\n\f\f\f\16\fD\13"+
		"\f\3\r\3\r\7\rH\n\r\f\r\16\rK\13\r\3\r\3\r\3\16\6\16P\n\16\r\16\16\16"+
		"Q\3\17\3\17\7\17V\n\17\f\17\16\17Y\13\17\3\17\3\17\3\20\3\20\6\20_\n\20"+
		"\r\20\16\20`\5\20c\n\20\3\20\3\20\4IW\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\5\5\2C\\aac|\6\2\60"+
		";C\\aac|\4\2/\60\62;\2l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2"+
		"\2\17-\3\2\2\2\21/\3\2\2\2\23\61\3\2\2\2\25<\3\2\2\2\27>\3\2\2\2\31E\3"+
		"\2\2\2\33O\3\2\2\2\35S\3\2\2\2\37b\3\2\2\2!\"\7]\2\2\"\4\3\2\2\2#$\7_"+
		"\2\2$\6\3\2\2\2%&\7?\2\2&\b\3\2\2\2\'(\7*\2\2(\n\3\2\2\2)*\7.\2\2*\f\3"+
		"\2\2\2+,\7+\2\2,\16\3\2\2\2-.\7}\2\2.\20\3\2\2\2/\60\7\177\2\2\60\22\3"+
		"\2\2\2\61\62\7<\2\2\62\24\3\2\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7w\2"+
		"\2\66=\7g\2\2\678\7h\2\289\7c\2\29:\7n\2\2:;\7u\2\2;=\7g\2\2<\63\3\2\2"+
		"\2<\67\3\2\2\2=\26\3\2\2\2>B\t\2\2\2?A\t\3\2\2@?\3\2\2\2AD\3\2\2\2B@\3"+
		"\2\2\2BC\3\2\2\2C\30\3\2\2\2DB\3\2\2\2EI\7$\2\2FH\13\2\2\2GF\3\2\2\2H"+
		"K\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7$\2\2M\32\3\2\2\2"+
		"NP\t\4\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\34\3\2\2\2SW\7=\2"+
		"\2TV\13\2\2\2UT\3\2\2\2VY\3\2\2\2WX\3\2\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2"+
		"\2\2Z[\7\f\2\2[\36\3\2\2\2\\c\7\f\2\2]_\7\"\2\2^]\3\2\2\2_`\3\2\2\2`^"+
		"\3\2\2\2`a\3\2\2\2ac\3\2\2\2b\\\3\2\2\2b^\3\2\2\2cd\3\2\2\2de\b\20\2\2"+
		"e \3\2\2\2\n\2<BIQW`b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}