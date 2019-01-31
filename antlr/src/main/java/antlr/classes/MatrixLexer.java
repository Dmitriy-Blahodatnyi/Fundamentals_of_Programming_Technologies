// Generated from /home/d_blahodatnyi/Java/Fundamentals_of_Programming_Technologies/antlr/src/main/java/antlr/Matrix.g4 by ANTLR 4.7.2
package antlr.classes;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatrixLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUMBER=2, VECTOR=3, MATRIX=4, EQUAL=5, WHITESPACE=6, LB=7, RB=8, 
		NL=9, PLUS=10, MULTIPLE=11, INVERSE=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "NUMBER", "VECTOR", "MATRIX", "EQUAL", "WHITESPACE", "LB", "RB", 
			"NL", "PLUS", "MULTIPLE", "INVERSE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'='", null, "'('", "')'", "'\n'", "'+'", 
			"'*'", "'^-1'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "NUMBER", "VECTOR", "MATRIX", "EQUAL", "WHITESPACE", "LB", 
			"RB", "NL", "PLUS", "MULTIPLE", "INVERSE"
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


	public MatrixLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Matrix.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\5\3$\n\3\3\3"+
		"\6\3\'\n\3\r\3\16\3(\3\3\6\3,\n\3\r\3\16\3-\3\3\3\3\6\3\62\n\3\r\3\16"+
		"\3\63\5\3\66\n\3\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\7\4B\n\4"+
		"\f\4\16\4E\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\7"+
		"\5S\n\5\f\5\16\5V\13\5\3\5\3\5\3\6\3\6\3\7\6\7]\n\7\r\7\16\7^\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\2\2\16\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\5\2C\\aac"+
		"|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2z\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2"+
		"\2\5#\3\2\2\2\7\67\3\2\2\2\tH\3\2\2\2\13Y\3\2\2\2\r\\\3\2\2\2\17b\3\2"+
		"\2\2\21d\3\2\2\2\23f\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33\37"+
		"\t\2\2\2\34\36\t\3\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2"+
		"\2\2 \4\3\2\2\2!\37\3\2\2\2\"$\7/\2\2#\"\3\2\2\2#$\3\2\2\2$\65\3\2\2\2"+
		"%\'\t\4\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\66\3\2\2\2*,\t\4"+
		"\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\7\60\2\2\60"+
		"\62\t\4\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64"+
		"\66\3\2\2\2\65&\3\2\2\2\65+\3\2\2\2\66\6\3\2\2\2\678\7]\2\28C\5\5\3\2"+
		"9=\7.\2\2:<\5\r\7\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2"+
		"?=\3\2\2\2@B\5\5\3\2A9\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2"+
		"EC\3\2\2\2FG\7_\2\2G\b\3\2\2\2HI\7]\2\2IT\5\7\4\2JN\7.\2\2KM\5\r\7\2L"+
		"K\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QS\5\7\4\2"+
		"RJ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7_\2\2"+
		"X\n\3\2\2\2YZ\7?\2\2Z\f\3\2\2\2[]\t\5\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2"+
		"\2\2^_\3\2\2\2_`\3\2\2\2`a\b\7\2\2a\16\3\2\2\2bc\7*\2\2c\20\3\2\2\2de"+
		"\7+\2\2e\22\3\2\2\2fg\7\f\2\2g\24\3\2\2\2hi\7-\2\2i\26\3\2\2\2jk\7,\2"+
		"\2k\30\3\2\2\2lm\7`\2\2mn\7/\2\2no\7\63\2\2o\32\3\2\2\2\16\2\37#(-\63"+
		"\65=CNT^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}