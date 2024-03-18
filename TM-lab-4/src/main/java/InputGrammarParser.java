// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-4/src/main/antlr/InputGrammar.g4 by ANTLR 4.13.1

import grammar.*;
import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InputGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, ARROW=2, COLON=3, SEMICOLON=4, NONTERM=5, TERM=6, ARGS=7, NOTARGS=8, 
		RETURN=9, NOTRETURN=10, CODE=11, NOTCODE=12, REGEX=13, NOTREGEX=14;
	public static final int
		RULE_run = 0, RULE_parseGrammar = 1, RULE_parseRules = 2, RULE_parseStates = 3, 
		RULE_parseNonTerm = 4, RULE_parseTerms = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"run", "parseGrammar", "parseRules", "parseStates", "parseNonTerm", "parseTerms"
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

	@Override
	public String getGrammarFileName() { return "InputGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InputGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RunContext extends ParserRuleContext {
		public Grammar grammar;
		public ParseGrammarContext parseGrammar;
		public ParseGrammarContext parseGrammar() {
			return getRuleContext(ParseGrammarContext.class,0);
		}
		public TerminalNode EOF() { return getToken(InputGrammarParser.EOF, 0); }
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitRun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			((RunContext)_localctx).parseGrammar = parseGrammar();
			 ((RunContext)_localctx).grammar =  ((RunContext)_localctx).parseGrammar.grammar; 
			setState(14);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseGrammarContext extends ParserRuleContext {
		public Grammar grammar;
		public ParseRulesContext parseRules;
		public ParseTermsContext parseTerms;
		public ParseRulesContext parseRules() {
			return getRuleContext(ParseRulesContext.class,0);
		}
		public ParseTermsContext parseTerms() {
			return getRuleContext(ParseTermsContext.class,0);
		}
		public ParseGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterParseGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitParseGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitParseGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseGrammarContext parseGrammar() throws RecognitionException {
		ParseGrammarContext _localctx = new ParseGrammarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parseGrammar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((ParseGrammarContext)_localctx).parseRules = parseRules();
			setState(17);
			((ParseGrammarContext)_localctx).parseTerms = parseTerms();
			 ((ParseGrammarContext)_localctx).grammar =  new Grammar(((ParseGrammarContext)_localctx).parseRules.rules, ((ParseGrammarContext)_localctx).parseRules.nonTerms, ((ParseGrammarContext)_localctx).parseTerms.terms); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseRulesContext extends ParserRuleContext {
		public List<Rule> rules;
		public List<NonTerm> nonTerms;
		public Token NONTERM;
		public Token ARGS;
		public Token RETURN;
		public ParseStatesContext parseStates;
		public List<TerminalNode> NONTERM() { return getTokens(InputGrammarParser.NONTERM); }
		public TerminalNode NONTERM(int i) {
			return getToken(InputGrammarParser.NONTERM, i);
		}
		public List<TerminalNode> ARROW() { return getTokens(InputGrammarParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(InputGrammarParser.ARROW, i);
		}
		public List<ParseStatesContext> parseStates() {
			return getRuleContexts(ParseStatesContext.class);
		}
		public ParseStatesContext parseStates(int i) {
			return getRuleContext(ParseStatesContext.class,i);
		}
		public List<TerminalNode> ARGS() { return getTokens(InputGrammarParser.ARGS); }
		public TerminalNode ARGS(int i) {
			return getToken(InputGrammarParser.ARGS, i);
		}
		public List<TerminalNode> RETURN() { return getTokens(InputGrammarParser.RETURN); }
		public TerminalNode RETURN(int i) {
			return getToken(InputGrammarParser.RETURN, i);
		}
		public ParseRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterParseRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitParseRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitParseRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseRulesContext parseRules() throws RecognitionException {
		ParseRulesContext _localctx = new ParseRulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parseRules);

		    ((ParseRulesContext)_localctx).rules =  new ArrayList<Rule>();
		    ((ParseRulesContext)_localctx).nonTerms =  new ArrayList<NonTerm>();
		    String args = null;
		    String ret = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				((ParseRulesContext)_localctx).NONTERM = match(NONTERM);
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARGS) {
					{
					setState(21);
					((ParseRulesContext)_localctx).ARGS = match(ARGS);
					 args = (((ParseRulesContext)_localctx).ARGS!=null?((ParseRulesContext)_localctx).ARGS.getText():null); 
					}
				}

				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETURN) {
					{
					setState(25);
					((ParseRulesContext)_localctx).RETURN = match(RETURN);
					 ret = (((ParseRulesContext)_localctx).RETURN!=null?((ParseRulesContext)_localctx).RETURN.getText():null); 
					}
				}


				            _localctx.nonTerms.add(new NonTerm((((ParseRulesContext)_localctx).NONTERM!=null?((ParseRulesContext)_localctx).NONTERM.getText():null), args, ret));
				            args = null;
				            ret = null;
				        
				setState(30);
				match(ARROW);
				setState(31);
				((ParseRulesContext)_localctx).parseStates = parseStates();
				 _localctx.rules.add(new Rule((((ParseRulesContext)_localctx).NONTERM!=null?((ParseRulesContext)_localctx).NONTERM.getText():null), ((ParseRulesContext)_localctx).parseStates.states, ((ParseRulesContext)_localctx).parseStates.args, ((ParseRulesContext)_localctx).parseStates.codes));
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NONTERM );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseStatesContext extends ParserRuleContext {
		public List<String> states;
		public List<String> args;
		public ArrayList<String> codes;
		public ParseNonTermContext parseNonTerm;
		public Token TERM;
		public Token CODE;
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParser.SEMICOLON, 0); }
		public List<ParseNonTermContext> parseNonTerm() {
			return getRuleContexts(ParseNonTermContext.class);
		}
		public ParseNonTermContext parseNonTerm(int i) {
			return getRuleContext(ParseNonTermContext.class,i);
		}
		public List<TerminalNode> TERM() { return getTokens(InputGrammarParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(InputGrammarParser.TERM, i);
		}
		public List<TerminalNode> CODE() { return getTokens(InputGrammarParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(InputGrammarParser.CODE, i);
		}
		public ParseStatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseStates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterParseStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitParseStates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitParseStates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseStatesContext parseStates() throws RecognitionException {
		ParseStatesContext _localctx = new ParseStatesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parseStates);

		    ((ParseStatesContext)_localctx).states =  new ArrayList<String>();
		    ((ParseStatesContext)_localctx).args =  new ArrayList<String>();
		    ((ParseStatesContext)_localctx).codes =  new ArrayList<String>();
		    String code = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NONTERM:
					{
					setState(38);
					((ParseStatesContext)_localctx).parseNonTerm = parseNonTerm();
					 _localctx.states.add(((ParseStatesContext)_localctx).parseNonTerm.nonTermName); _localctx.args.add(((ParseStatesContext)_localctx).parseNonTerm.arg); 
					}
					break;
				case TERM:
					{
					setState(41);
					((ParseStatesContext)_localctx).TERM = match(TERM);
					 _localctx.states.add((((ParseStatesContext)_localctx).TERM!=null?((ParseStatesContext)_localctx).TERM.getText():null)); _localctx.args.add(null); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(45);
					((ParseStatesContext)_localctx).CODE = match(CODE);
					 code = (((ParseStatesContext)_localctx).CODE!=null?((ParseStatesContext)_localctx).CODE.getText():null); 
					}
				}

				 _localctx.codes.add(code); code = null; 
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NONTERM || _la==TERM );
			setState(54);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseNonTermContext extends ParserRuleContext {
		public String nonTermName;
		public String arg;
		public Token NONTERM;
		public Token ARGS;
		public TerminalNode NONTERM() { return getToken(InputGrammarParser.NONTERM, 0); }
		public TerminalNode ARGS() { return getToken(InputGrammarParser.ARGS, 0); }
		public ParseNonTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseNonTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterParseNonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitParseNonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitParseNonTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseNonTermContext parseNonTerm() throws RecognitionException {
		ParseNonTermContext _localctx = new ParseNonTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parseNonTerm);

		     String args = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((ParseNonTermContext)_localctx).NONTERM = match(NONTERM);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARGS) {
				{
				setState(57);
				((ParseNonTermContext)_localctx).ARGS = match(ARGS);
				 args = (((ParseNonTermContext)_localctx).ARGS!=null?((ParseNonTermContext)_localctx).ARGS.getText():null); 
				}
			}

			 ((ParseNonTermContext)_localctx).nonTermName =  (((ParseNonTermContext)_localctx).NONTERM!=null?((ParseNonTermContext)_localctx).NONTERM.getText():null); ((ParseNonTermContext)_localctx).arg =  args; args = null; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseTermsContext extends ParserRuleContext {
		public HashMap<String, String> terms;
		public Token TERM;
		public Token REGEX;
		public List<TerminalNode> TERM() { return getTokens(InputGrammarParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(InputGrammarParser.TERM, i);
		}
		public List<TerminalNode> COLON() { return getTokens(InputGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(InputGrammarParser.COLON, i);
		}
		public List<TerminalNode> REGEX() { return getTokens(InputGrammarParser.REGEX); }
		public TerminalNode REGEX(int i) {
			return getToken(InputGrammarParser.REGEX, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InputGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InputGrammarParser.SEMICOLON, i);
		}
		public ParseTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseTerms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterParseTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitParseTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitParseTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseTermsContext parseTerms() throws RecognitionException {
		ParseTermsContext _localctx = new ParseTermsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parseTerms);

		    ((ParseTermsContext)_localctx).terms =  new HashMap<String, String>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				((ParseTermsContext)_localctx).TERM = match(TERM);
				setState(64);
				match(COLON);
				setState(65);
				((ParseTermsContext)_localctx).REGEX = match(REGEX);
				setState(66);
				match(SEMICOLON);
				 _localctx.terms.put((((ParseTermsContext)_localctx).TERM!=null?((ParseTermsContext)_localctx).TERM.getText():null), (((ParseTermsContext)_localctx).REGEX!=null?((ParseTermsContext)_localctx).REGEX.getText():null)); 
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TERM );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000eI\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u0018\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001c"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002#\b\u0002\u000b\u0002\f\u0002$\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003,\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00030\b\u0003\u0001\u0003\u0004\u00033\b\u0003\u000b\u0003\f\u0003"+
		"4\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"<\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005E\b\u0005\u000b\u0005\f\u0005F\u0001"+
		"\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0000J\u0000"+
		"\f\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000\u0004\""+
		"\u0001\u0000\u0000\u0000\u00062\u0001\u0000\u0000\u0000\b8\u0001\u0000"+
		"\u0000\u0000\nD\u0001\u0000\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r"+
		"\u000e\u0006\u0000\uffff\uffff\u0000\u000e\u000f\u0005\u0000\u0000\u0001"+
		"\u000f\u0001\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0004\u0002\u0000"+
		"\u0011\u0012\u0003\n\u0005\u0000\u0012\u0013\u0006\u0001\uffff\uffff\u0000"+
		"\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0017\u0005\u0005\u0000\u0000"+
		"\u0015\u0016\u0005\u0007\u0000\u0000\u0016\u0018\u0006\u0002\uffff\uffff"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u001a\u0005\t\u0000\u0000"+
		"\u001a\u001c\u0006\u0002\uffff\uffff\u0000\u001b\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0006\u0002\uffff\uffff\u0000\u001e\u001f\u0005\u0002"+
		"\u0000\u0000\u001f \u0003\u0006\u0003\u0000 !\u0006\u0002\uffff\uffff"+
		"\u0000!#\u0001\u0000\u0000\u0000\"\u0014\u0001\u0000\u0000\u0000#$\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%\u0005\u0001\u0000\u0000\u0000&\'\u0003\b\u0004\u0000\'(\u0006\u0003"+
		"\uffff\uffff\u0000(,\u0001\u0000\u0000\u0000)*\u0005\u0006\u0000\u0000"+
		"*,\u0006\u0003\uffff\uffff\u0000+&\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000,/\u0001\u0000\u0000\u0000-.\u0005\u000b\u0000\u0000.0\u0006"+
		"\u0003\uffff\uffff\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000013\u0006\u0003\uffff\uffff\u00002+\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0005\u0004\u0000"+
		"\u00007\u0007\u0001\u0000\u0000\u00008;\u0005\u0005\u0000\u00009:\u0005"+
		"\u0007\u0000\u0000:<\u0006\u0004\uffff\uffff\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0006\u0004"+
		"\uffff\uffff\u0000>\t\u0001\u0000\u0000\u0000?@\u0005\u0006\u0000\u0000"+
		"@A\u0005\u0003\u0000\u0000AB\u0005\r\u0000\u0000BC\u0005\u0004\u0000\u0000"+
		"CE\u0006\u0005\uffff\uffff\u0000D?\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u000b"+
		"\u0001\u0000\u0000\u0000\b\u0017\u001b$+/4;F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}