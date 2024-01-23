// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-3/src/main/antlr/PrefixExpr.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PrefixExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACKET=1, RBRACKET=2, WHILE=3, IF=4, PRINT=5, ASSIGN=6, BINARY_OP=7, 
		AND=8, OR=9, NOT=10, EQUAL=11, NOT_EQUAL=12, GREATER=13, LESS=14, GREATER_EQUAL=15, 
		LESS_EQUAL=16, PLUS=17, MINUS=18, MULTIPLY=19, DIVIDE=20, NEGATE=21, BOOL=22, 
		VAR=23, INT=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACKET", "RBRACKET", "WHILE", "IF", "PRINT", "ASSIGN", "BINARY_OP", 
			"AND", "OR", "NOT", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", "GREATER_EQUAL", 
			"LESS_EQUAL", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "NEGATE", "BOOL", 
			"VAR", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'while'", "'if'", "'print'", "'='", null, "'and'", 
			"'or'", "'not'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACKET", "RBRACKET", "WHILE", "IF", "PRINT", "ASSIGN", "BINARY_OP", 
			"AND", "OR", "NOT", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", "GREATER_EQUAL", 
			"LESS_EQUAL", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "NEGATE", "BOOL", 
			"VAR", "INT", "WS"
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


	public PrefixExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PrefixExpr.g4"; }

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
		"\u0004\u0000\u0019\u0099\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"U\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0085\b\u0015\u0001\u0016\u0001\u0016\u0005\u0016\u0089\b"+
		"\u0016\n\u0016\f\u0016\u008c\t\u0016\u0001\u0017\u0004\u0017\u008f\b\u0017"+
		"\u000b\u0017\f\u0017\u0090\u0001\u0018\u0004\u0018\u0094\b\u0018\u000b"+
		"\u0018\f\u0018\u0095\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u0019\u0001\u0000\u0004\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0000"+
		"09\u0003\u0000\t\n\r\r  \u00a7\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000"+
		"\u00057\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\t@\u0001"+
		"\u0000\u0000\u0000\u000bF\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000"+
		"\u0000\u000fV\u0001\u0000\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000\u0013"+
		"]\u0001\u0000\u0000\u0000\u0015a\u0001\u0000\u0000\u0000\u0017d\u0001"+
		"\u0000\u0000\u0000\u0019g\u0001\u0000\u0000\u0000\u001bi\u0001\u0000\u0000"+
		"\u0000\u001dk\u0001\u0000\u0000\u0000\u001fn\u0001\u0000\u0000\u0000!"+
		"q\u0001\u0000\u0000\u0000#s\u0001\u0000\u0000\u0000%u\u0001\u0000\u0000"+
		"\u0000\'w\u0001\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+\u0084\u0001"+
		"\u0000\u0000\u0000-\u0086\u0001\u0000\u0000\u0000/\u008e\u0001\u0000\u0000"+
		"\u00001\u0093\u0001\u0000\u0000\u000034\u0005{\u0000\u00004\u0002\u0001"+
		"\u0000\u0000\u000056\u0005}\u0000\u00006\u0004\u0001\u0000\u0000\u0000"+
		"78\u0005w\u0000\u000089\u0005h\u0000\u00009:\u0005i\u0000\u0000:;\u0005"+
		"l\u0000\u0000;<\u0005e\u0000\u0000<\u0006\u0001\u0000\u0000\u0000=>\u0005"+
		"i\u0000\u0000>?\u0005f\u0000\u0000?\b\u0001\u0000\u0000\u0000@A\u0005"+
		"p\u0000\u0000AB\u0005r\u0000\u0000BC\u0005i\u0000\u0000CD\u0005n\u0000"+
		"\u0000DE\u0005t\u0000\u0000E\n\u0001\u0000\u0000\u0000FG\u0005=\u0000"+
		"\u0000G\f\u0001\u0000\u0000\u0000HU\u0003\u000f\u0007\u0000IU\u0003\u0011"+
		"\b\u0000JU\u0003\u0015\n\u0000KU\u0003\u0017\u000b\u0000LU\u0003\u0019"+
		"\f\u0000MU\u0003\u001b\r\u0000NU\u0003\u001d\u000e\u0000OU\u0003\u001f"+
		"\u000f\u0000PU\u0003!\u0010\u0000QU\u0003#\u0011\u0000RU\u0003%\u0012"+
		"\u0000SU\u0003\'\u0013\u0000TH\u0001\u0000\u0000\u0000TI\u0001\u0000\u0000"+
		"\u0000TJ\u0001\u0000\u0000\u0000TK\u0001\u0000\u0000\u0000TL\u0001\u0000"+
		"\u0000\u0000TM\u0001\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TO\u0001"+
		"\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\u000e\u0001\u0000"+
		"\u0000\u0000VW\u0005a\u0000\u0000WX\u0005n\u0000\u0000XY\u0005d\u0000"+
		"\u0000Y\u0010\u0001\u0000\u0000\u0000Z[\u0005o\u0000\u0000[\\\u0005r\u0000"+
		"\u0000\\\u0012\u0001\u0000\u0000\u0000]^\u0005n\u0000\u0000^_\u0005o\u0000"+
		"\u0000_`\u0005t\u0000\u0000`\u0014\u0001\u0000\u0000\u0000ab\u0005=\u0000"+
		"\u0000bc\u0005=\u0000\u0000c\u0016\u0001\u0000\u0000\u0000de\u0005!\u0000"+
		"\u0000ef\u0005=\u0000\u0000f\u0018\u0001\u0000\u0000\u0000gh\u0005>\u0000"+
		"\u0000h\u001a\u0001\u0000\u0000\u0000ij\u0005<\u0000\u0000j\u001c\u0001"+
		"\u0000\u0000\u0000kl\u0005>\u0000\u0000lm\u0005=\u0000\u0000m\u001e\u0001"+
		"\u0000\u0000\u0000no\u0005<\u0000\u0000op\u0005=\u0000\u0000p \u0001\u0000"+
		"\u0000\u0000qr\u0005+\u0000\u0000r\"\u0001\u0000\u0000\u0000st\u0005-"+
		"\u0000\u0000t$\u0001\u0000\u0000\u0000uv\u0005*\u0000\u0000v&\u0001\u0000"+
		"\u0000\u0000wx\u0005/\u0000\u0000x(\u0001\u0000\u0000\u0000yz\u0005~\u0000"+
		"\u0000z*\u0001\u0000\u0000\u0000{|\u0005T\u0000\u0000|}\u0005r\u0000\u0000"+
		"}~\u0005u\u0000\u0000~\u0085\u0005e\u0000\u0000\u007f\u0080\u0005F\u0000"+
		"\u0000\u0080\u0081\u0005a\u0000\u0000\u0081\u0082\u0005l\u0000\u0000\u0082"+
		"\u0083\u0005s\u0000\u0000\u0083\u0085\u0005e\u0000\u0000\u0084{\u0001"+
		"\u0000\u0000\u0000\u0084\u007f\u0001\u0000\u0000\u0000\u0085,\u0001\u0000"+
		"\u0000\u0000\u0086\u008a\u0007\u0000\u0000\u0000\u0087\u0089\u0007\u0001"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b.\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u008f\u0007\u0002\u0000\u0000\u008e\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u00910\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u0007\u0003\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0006\u0018\u0000\u0000\u00982\u0001\u0000\u0000\u0000\u0006"+
		"\u0000T\u0084\u008a\u0090\u0095\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}