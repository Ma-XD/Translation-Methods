// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-4/src/main/antlr/InputGrammar.g4 by ANTLR 4.13.1

import grammar.*;
import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InputGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, ARROW=2, COLON=3, SEMICOLON=4, NONTERM=5, TERM=6, ARGS=7, NOTARGS=8, 
		RETURN=9, NOTRETURN=10, CODE=11, NOTCODE=12, REGEX=13, NOTREGEX=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "ARROW", "COLON", "SEMICOLON", "NONTERM", "TERM", "ARGS", "NOTARGS", 
			"RETURN", "NOTRETURN", "CODE", "NOTCODE", "REGEX", "NOTREGEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'->'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "ARROW", "COLON", "SEMICOLON", "NONTERM", "TERM", "ARGS", 
			"NOTARGS", "RETURN", "NOTRETURN", "CODE", "NOTCODE", "REGEX", "NOTREGEX"
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


	public InputGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InputGrammar.g4"; }

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
		"\u0004\u0000\u000ec\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001f"+
		"\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0005\u0004.\b\u0004\n\u0004\f\u00041\t\u0004\u0001"+
		"\u0005\u0004\u00054\b\u0005\u000b\u0005\f\u00055\u0001\u0006\u0001\u0006"+
		"\u0005\u0006:\b\u0006\n\u0006\f\u0006=\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bE\b\b\n\b\f\bH\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nP\b\n\n\n\f\nS\t\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\f[\b\f\n\f\f"+
		"\f^\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000"+
		"\b\u0003\u0000\t\n\r\r  \u0001\u0000AZ\u0002\u000009AZ\u0001\u0000az\u0001"+
		"\u0000))\u0001\u0000]]\u0001\u0000}}\u0003\u0000\n\n\r\r\"\"i\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001e\u0001\u0000"+
		"\u0000\u0000\u0003$\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000"+
		"\u0000\u0007)\u0001\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b"+
		"3\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f@\u0001\u0000"+
		"\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013K\u0001\u0000\u0000\u0000"+
		"\u0015M\u0001\u0000\u0000\u0000\u0017V\u0001\u0000\u0000\u0000\u0019X"+
		"\u0001\u0000\u0000\u0000\u001ba\u0001\u0000\u0000\u0000\u001d\u001f\u0007"+
		"\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000"+
		"\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"#\u0006\u0000\u0000\u0000#\u0002\u0001\u0000"+
		"\u0000\u0000$%\u0005-\u0000\u0000%&\u0005>\u0000\u0000&\u0004\u0001\u0000"+
		"\u0000\u0000\'(\u0005:\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005"+
		";\u0000\u0000*\b\u0001\u0000\u0000\u0000+/\u0007\u0001\u0000\u0000,.\u0007"+
		"\u0002\u0000\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\n\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000024\u0007\u0003\u0000\u000032\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006\f\u0001\u0000\u0000\u00007;\u0005(\u0000\u00008:\u0003"+
		"\u000f\u0007\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>?\u0005)\u0000\u0000?\u000e\u0001\u0000"+
		"\u0000\u0000@A\b\u0004\u0000\u0000A\u0010\u0001\u0000\u0000\u0000BF\u0005"+
		"[\u0000\u0000CE\u0003\u0013\t\u0000DC\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005]\u0000\u0000"+
		"J\u0012\u0001\u0000\u0000\u0000KL\b\u0005\u0000\u0000L\u0014\u0001\u0000"+
		"\u0000\u0000MQ\u0005{\u0000\u0000NP\u0003\u0017\u000b\u0000ON\u0001\u0000"+
		"\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"TU\u0005}\u0000\u0000U\u0016\u0001\u0000\u0000\u0000VW\b\u0006\u0000\u0000"+
		"W\u0018\u0001\u0000\u0000\u0000X\\\u0005\"\u0000\u0000Y[\u0003\u001b\r"+
		"\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000_`\u0005\"\u0000\u0000`\u001a\u0001\u0000\u0000\u0000"+
		"ab\b\u0007\u0000\u0000b\u001c\u0001\u0000\u0000\u0000\b\u0000 /5;FQ\\"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}