// Generated from C:/Users/maxdz/IdeaProjects/ITMO/Translation-Methods/TM-lab-3/src/main/antlr/PrefixExpr.g4 by ANTLR 4.13.1
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PrefixExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACKET=1, RBRACKET=2, WHILE=3, IF=4, PRINT=5, ASSIGN=6, BINARY_OP=7, 
		AND=8, OR=9, NOT=10, EQUAL=11, NOT_EQUAL=12, GREATER=13, LESS=14, GREATER_EQUAL=15, 
		LESS_EQUAL=16, PLUS=17, MINUS=18, MULTIPLY=19, DIVIDE=20, NEGATE=21, BOOL=22, 
		VAR=23, INT=24, WS=25;
	public static final int
		RULE_run = 0, RULE_prefixExpr = 1, RULE_section = 2, RULE_action = 3, 
		RULE_ifBranch = 4, RULE_elseBranch = 5, RULE_expr = 6, RULE_operand = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"run", "prefixExpr", "section", "action", "ifBranch", "elseBranch", "expr", 
			"operand"
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

	@Override
	public String getGrammarFileName() { return "PrefixExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PrefixExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RunContext extends ParserRuleContext {
		public String value;
		public PrefixExprContext prefixExpr;
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PrefixExprParser.EOF, 0); }
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitRun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((RunContext)_localctx).prefixExpr = prefixExpr("");
			setState(17);
			match(EOF);
			 ((RunContext)_localctx).value =  ((RunContext)_localctx).prefixExpr.value; 
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
	public static class PrefixExprContext extends ParserRuleContext {
		public String tabs;
		public String value;
		public SectionContext section;
		public PrefixExprContext p;
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public PrefixExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PrefixExprContext(ParserRuleContext parent, int invokingState, String tabs) {
			super(parent, invokingState);
			this.tabs = tabs;
		}
		@Override public int getRuleIndex() { return RULE_prefixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExprContext prefixExpr(String tabs) throws RecognitionException {
		PrefixExprContext _localctx = new PrefixExprContext(_ctx, getState(), tabs);
		enterRule(_localctx, 2, RULE_prefixExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			((PrefixExprContext)_localctx).section = section(_localctx.tabs);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 122L) != 0)) {
				{
				setState(21);
				((PrefixExprContext)_localctx).p = prefixExpr(_localctx.tabs);
				}
			}

			 ((PrefixExprContext)_localctx).value =  ((PrefixExprContext)_localctx).section.value + ((((PrefixExprContext)_localctx).p!=null?_input.getText(((PrefixExprContext)_localctx).p.start,((PrefixExprContext)_localctx).p.stop):null) != null ? "\n" + ((PrefixExprContext)_localctx).p.value : ""); 
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
	public static class SectionContext extends ParserRuleContext {
		public String tabs;
		public String value;
		public ActionContext action;
		public IfBranchContext ifBranch;
		public PrefixExprContext prefixExpr;
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public IfBranchContext ifBranch() {
			return getRuleContext(IfBranchContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(PrefixExprParser.LBRACKET, 0); }
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(PrefixExprParser.RBRACKET, 0); }
		public SectionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SectionContext(ParserRuleContext parent, int invokingState, String tabs) {
			super(parent, invokingState);
			this.tabs = tabs;
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section(String tabs) throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState(), tabs);
		enterRule(_localctx, 4, RULE_section);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
			case PRINT:
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				((SectionContext)_localctx).action = action(_localctx.tabs);
				 ((SectionContext)_localctx).value =  _localctx.tabs + ((SectionContext)_localctx).action.value; 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				((SectionContext)_localctx).ifBranch = ifBranch(_localctx.tabs);
				 ((SectionContext)_localctx).value =  _localctx.tabs + ((SectionContext)_localctx).ifBranch.value; 
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(LBRACKET);
				setState(33);
				((SectionContext)_localctx).prefixExpr = prefixExpr(_localctx.tabs);
				setState(34);
				match(RBRACKET);
				 ((SectionContext)_localctx).value =  ((SectionContext)_localctx).prefixExpr.value; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ActionContext extends ParserRuleContext {
		public String tabs;
		public String value;
		public ExprContext expr;
		public Token VAR;
		public SectionContext section;
		public TerminalNode PRINT() { return getToken(PrefixExprParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PrefixExprParser.ASSIGN, 0); }
		public TerminalNode VAR() { return getToken(PrefixExprParser.VAR, 0); }
		public TerminalNode WHILE() { return getToken(PrefixExprParser.WHILE, 0); }
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ActionContext(ParserRuleContext parent, int invokingState, String tabs) {
			super(parent, invokingState);
			this.tabs = tabs;
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action(String tabs) throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState(), tabs);
		enterRule(_localctx, 6, RULE_action);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(PRINT);
				setState(40);
				((ActionContext)_localctx).expr = expr();
				 ((ActionContext)_localctx).value =  "print(" + ((ActionContext)_localctx).expr.value + ")"; 
				}
				break;
			case ASSIGN:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(ASSIGN);
				setState(44);
				((ActionContext)_localctx).VAR = match(VAR);
				setState(45);
				((ActionContext)_localctx).expr = expr();
				 ((ActionContext)_localctx).value =  (((ActionContext)_localctx).VAR!=null?((ActionContext)_localctx).VAR.getText():null) + " = " + ((ActionContext)_localctx).expr.value; 
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(WHILE);
				setState(49);
				((ActionContext)_localctx).expr = expr();
				setState(50);
				((ActionContext)_localctx).section = section(_localctx.tabs + "\t");
				 ((ActionContext)_localctx).value =  "while " + ((ActionContext)_localctx).expr.value + ":\n" + ((ActionContext)_localctx).section.value; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class IfBranchContext extends ParserRuleContext {
		public String tabs;
		public String value;
		public ExprContext expr;
		public SectionContext section;
		public ElseBranchContext elseBranch;
		public TerminalNode IF() { return getToken(PrefixExprParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public ElseBranchContext elseBranch() {
			return getRuleContext(ElseBranchContext.class,0);
		}
		public IfBranchContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IfBranchContext(ParserRuleContext parent, int invokingState, String tabs) {
			super(parent, invokingState);
			this.tabs = tabs;
		}
		@Override public int getRuleIndex() { return RULE_ifBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterIfBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitIfBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitIfBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBranchContext ifBranch(String tabs) throws RecognitionException {
		IfBranchContext _localctx = new IfBranchContext(_ctx, getState(), tabs);
		enterRule(_localctx, 8, RULE_ifBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(IF);
			setState(56);
			((IfBranchContext)_localctx).expr = expr();
			setState(57);
			((IfBranchContext)_localctx).section = section(_localctx.tabs + "\t");
			setState(58);
			((IfBranchContext)_localctx).elseBranch = elseBranch(_localctx.tabs);
			 ((IfBranchContext)_localctx).value =  "if " + ((IfBranchContext)_localctx).expr.value + ":\n" + ((IfBranchContext)_localctx).section.value + ((IfBranchContext)_localctx).elseBranch.value; 
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
	public static class ElseBranchContext extends ParserRuleContext {
		public String tabs;
		public String value;
		public ActionContext action;
		public IfBranchContext ifBranch;
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public IfBranchContext ifBranch() {
			return getRuleContext(IfBranchContext.class,0);
		}
		public ElseBranchContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ElseBranchContext(ParserRuleContext parent, int invokingState, String tabs) {
			super(parent, invokingState);
			this.tabs = tabs;
		}
		@Override public int getRuleIndex() { return RULE_elseBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterElseBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitElseBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitElseBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBranchContext elseBranch(String tabs) throws RecognitionException {
		ElseBranchContext _localctx = new ElseBranchContext(_ctx, getState(), tabs);
		enterRule(_localctx, 10, RULE_elseBranch);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				((ElseBranchContext)_localctx).action = action(_localctx.tabs + "\t");
				 ((ElseBranchContext)_localctx).value =  "\n" + _localctx.tabs + "else:\n" + _localctx.tabs + "\t" + ((ElseBranchContext)_localctx).action.value; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				((ElseBranchContext)_localctx).ifBranch = ifBranch(_localctx.tabs);
				 ((ElseBranchContext)_localctx).value =  "\n" + _localctx.tabs + "el" + ((ElseBranchContext)_localctx).ifBranch.value; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				 ((ElseBranchContext)_localctx).value =  ""; 
				}
				break;
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
	public static class ExprContext extends ParserRuleContext {
		public String value;
		public Token BINARY_OP;
		public ExprContext a1;
		public ExprContext a2;
		public Token NOT;
		public ExprContext expr;
		public OperandContext operand;
		public TerminalNode BINARY_OP() { return getToken(PrefixExprParser.BINARY_OP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(PrefixExprParser.NOT, 0); }
		public TerminalNode NEGATE() { return getToken(PrefixExprParser.NEGATE, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				((ExprContext)_localctx).BINARY_OP = match(BINARY_OP);
				setState(71);
				((ExprContext)_localctx).a1 = expr();
				setState(72);
				((ExprContext)_localctx).a2 = expr();
				 ((ExprContext)_localctx).value =  "(" + ((ExprContext)_localctx).a1.value + " " + (((ExprContext)_localctx).BINARY_OP!=null?((ExprContext)_localctx).BINARY_OP.getText():null) + " " + ((ExprContext)_localctx).a2.value + ")"; 
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				((ExprContext)_localctx).NOT = match(NOT);
				setState(76);
				((ExprContext)_localctx).expr = expr();
				 ((ExprContext)_localctx).value =  "(" + (((ExprContext)_localctx).NOT!=null?((ExprContext)_localctx).NOT.getText():null) + " " + ((ExprContext)_localctx).expr.value + ")"; 
				}
				break;
			case NEGATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(NEGATE);
				setState(80);
				((ExprContext)_localctx).expr = expr();
				 ((ExprContext)_localctx).value =  "-" + ((ExprContext)_localctx).expr.value; 
				}
				break;
			case BOOL:
			case VAR:
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				((ExprContext)_localctx).operand = operand();
				 ((ExprContext)_localctx).value =  (((ExprContext)_localctx).operand!=null?_input.getText(((ExprContext)_localctx).operand.start,((ExprContext)_localctx).operand.stop):null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class OperandContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(PrefixExprParser.BOOL, 0); }
		public TerminalNode VAR() { return getToken(PrefixExprParser.VAR, 0); }
		public TerminalNode INT() { return getToken(PrefixExprParser.INT, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixExprListener ) ((PrefixExprListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrefixExprVisitor ) return ((PrefixExprVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\u0004\u0001\u0019[\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u0017\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002&\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00036\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005E\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006W\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0000\u0001\u0001\u0000\u0016\u0018\\\u0000\u0010\u0001\u0000"+
		"\u0000\u0000\u0002\u0014\u0001\u0000\u0000\u0000\u0004%\u0001\u0000\u0000"+
		"\u0000\u00065\u0001\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\nD\u0001"+
		"\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000eX\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012\u0005\u0000\u0000"+
		"\u0001\u0012\u0013\u0006\u0000\uffff\uffff\u0000\u0013\u0001\u0001\u0000"+
		"\u0000\u0000\u0014\u0016\u0003\u0004\u0002\u0000\u0015\u0017\u0003\u0002"+
		"\u0001\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0006\u0001"+
		"\uffff\uffff\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b\u0003"+
		"\u0006\u0003\u0000\u001b\u001c\u0006\u0002\uffff\uffff\u0000\u001c&\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u001f\u0006\u0002"+
		"\uffff\uffff\u0000\u001f&\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000"+
		"\u0000!\"\u0003\u0002\u0001\u0000\"#\u0005\u0002\u0000\u0000#$\u0006\u0002"+
		"\uffff\uffff\u0000$&\u0001\u0000\u0000\u0000%\u001a\u0001\u0000\u0000"+
		"\u0000%\u001d\u0001\u0000\u0000\u0000% \u0001\u0000\u0000\u0000&\u0005"+
		"\u0001\u0000\u0000\u0000\'(\u0005\u0005\u0000\u0000()\u0003\f\u0006\u0000"+
		")*\u0006\u0003\uffff\uffff\u0000*6\u0001\u0000\u0000\u0000+,\u0005\u0006"+
		"\u0000\u0000,-\u0005\u0017\u0000\u0000-.\u0003\f\u0006\u0000./\u0006\u0003"+
		"\uffff\uffff\u0000/6\u0001\u0000\u0000\u000001\u0005\u0003\u0000\u0000"+
		"12\u0003\f\u0006\u000023\u0003\u0004\u0002\u000034\u0006\u0003\uffff\uffff"+
		"\u000046\u0001\u0000\u0000\u00005\'\u0001\u0000\u0000\u00005+\u0001\u0000"+
		"\u0000\u000050\u0001\u0000\u0000\u00006\u0007\u0001\u0000\u0000\u0000"+
		"78\u0005\u0004\u0000\u000089\u0003\f\u0006\u00009:\u0003\u0004\u0002\u0000"+
		":;\u0003\n\u0005\u0000;<\u0006\u0004\uffff\uffff\u0000<\t\u0001\u0000"+
		"\u0000\u0000=>\u0003\u0006\u0003\u0000>?\u0006\u0005\uffff\uffff\u0000"+
		"?E\u0001\u0000\u0000\u0000@A\u0003\b\u0004\u0000AB\u0006\u0005\uffff\uffff"+
		"\u0000BE\u0001\u0000\u0000\u0000CE\u0006\u0005\uffff\uffff\u0000D=\u0001"+
		"\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"E\u000b\u0001\u0000\u0000\u0000FG\u0005\u0007\u0000\u0000GH\u0003\f\u0006"+
		"\u0000HI\u0003\f\u0006\u0000IJ\u0006\u0006\uffff\uffff\u0000JW\u0001\u0000"+
		"\u0000\u0000KL\u0005\n\u0000\u0000LM\u0003\f\u0006\u0000MN\u0006\u0006"+
		"\uffff\uffff\u0000NW\u0001\u0000\u0000\u0000OP\u0005\u0015\u0000\u0000"+
		"PQ\u0003\f\u0006\u0000QR\u0006\u0006\uffff\uffff\u0000RW\u0001\u0000\u0000"+
		"\u0000ST\u0003\u000e\u0007\u0000TU\u0006\u0006\uffff\uffff\u0000UW\u0001"+
		"\u0000\u0000\u0000VF\u0001\u0000\u0000\u0000VK\u0001\u0000\u0000\u0000"+
		"VO\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000\u0000W\r\u0001\u0000\u0000"+
		"\u0000XY\u0007\u0000\u0000\u0000Y\u000f\u0001\u0000\u0000\u0000\u0005"+
		"\u0016%5DV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}