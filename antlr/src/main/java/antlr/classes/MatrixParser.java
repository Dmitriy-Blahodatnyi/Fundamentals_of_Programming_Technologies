// Generated from /home/d_blahodatnyi/Java/Fundamentals_of_Programming_Technologies/antlr/src/main/java/antlr/Matrix.g4 by ANTLR 4.7.2
package antlr.classes;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatrixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUMBER=2, VECTOR=3, MATRIX=4, EQUAL=5, WHITESPACE=6, LB=7, RB=8, 
		NL=9, PLUS=10, MULTIPLE=11, INVERSE=12;
	public static final int
		RULE_root = 0, RULE_input = 1, RULE_assignment = 2, RULE_sum = 3, RULE_multiple = 4, 
		RULE_inverse = 5, RULE_atom = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "input", "assignment", "sum", "multiple", "inverse", "atom"
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

	@Override
	public String getGrammarFileName() { return "Matrix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MatrixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	 
		public RootContext() { }
		public void copyFrom(RootContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RootRuleContext extends RootContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatrixParser.EOF, 0); }
		public RootRuleContext(RootContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterRootRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitRootRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitRootRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			_localctx = new RootRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			input();
			setState(15);
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

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToSetVariableContext extends InputContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatrixParser.EOF, 0); }
		public ToSetVariableContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterToSetVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitToSetVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitToSetVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExecuteExpressionContext extends InputContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatrixParser.EOF, 0); }
		public TerminalNode NL() { return getToken(MatrixParser.NL, 0); }
		public ExecuteExpressionContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterExecuteExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitExecuteExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitExecuteExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_input);
		int _la;
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ToSetVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				assignment();
				setState(18);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new ExecuteExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				sum(0);
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(21);
					match(NL);
					}
				}

				setState(24);
				match(EOF);
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MatrixParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MatrixParser.EQUAL, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public MakeAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			_localctx = new MakeAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(ID);
			setState(29);
			match(EQUAL);
			setState(30);
			sum(0);
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

	public static class SumContext extends ParserRuleContext {
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
	 
		public SumContext() { }
		public void copyFrom(SumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToMultipleContext extends SumContext {
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public ToMultipleContext(SumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterToMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitToMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitToMultiple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakePlusContext extends SumContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MatrixParser.PLUS, 0); }
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public MakePlusContext(SumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakePlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakePlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakePlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		return sum(0);
	}

	private SumContext sum(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SumContext _localctx = new SumContext(_ctx, _parentState);
		SumContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_sum, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMultipleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(33);
			multiple(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MakePlusContext(new SumContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_sum);
					setState(35);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(36);
					match(PLUS);
					setState(37);
					multiple(0);
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultipleContext extends ParserRuleContext {
		public MultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple; }
	 
		public MultipleContext() { }
		public void copyFrom(MultipleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToInverseContext extends MultipleContext {
		public InverseContext inverse() {
			return getRuleContext(InverseContext.class,0);
		}
		public ToInverseContext(MultipleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterToInverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitToInverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitToInverse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeMultipleContext extends MultipleContext {
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public TerminalNode MULTIPLE() { return getToken(MatrixParser.MULTIPLE, 0); }
		public InverseContext inverse() {
			return getRuleContext(InverseContext.class,0);
		}
		public MakeMultipleContext(MultipleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleContext multiple() throws RecognitionException {
		return multiple(0);
	}

	private MultipleContext multiple(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultipleContext _localctx = new MultipleContext(_ctx, _parentState);
		MultipleContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_multiple, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToInverseContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(44);
			inverse(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MakeMultipleContext(new MultipleContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_multiple);
					setState(46);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(47);
					match(MULTIPLE);
					setState(48);
					inverse(0);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InverseContext extends ParserRuleContext {
		public InverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inverse; }
	 
		public InverseContext() { }
		public void copyFrom(InverseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeInverseContext extends InverseContext {
		public InverseContext inverse() {
			return getRuleContext(InverseContext.class,0);
		}
		public TerminalNode INVERSE() { return getToken(MatrixParser.INVERSE, 0); }
		public MakeInverseContext(InverseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeInverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeInverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeInverse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAtomContext extends InverseContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(InverseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterToAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitToAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InverseContext inverse() throws RecognitionException {
		return inverse(0);
	}

	private InverseContext inverse(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InverseContext _localctx = new InverseContext(_ctx, _parentState);
		InverseContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_inverse, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAtomContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(55);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MakeInverseContext(new InverseContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_inverse);
					setState(57);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(58);
					match(INVERSE);
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeNumberContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(MatrixParser.NUMBER, 0); }
		public MakeNumberContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeBracesContext extends AtomContext {
		public TerminalNode LB() { return getToken(MatrixParser.LB, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode RB() { return getToken(MatrixParser.RB, 0); }
		public MakeBracesContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends AtomContext {
		public TerminalNode ID() { return getToken(MatrixParser.ID, 0); }
		public VariableContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MakeMatrixContext extends AtomContext {
		public TerminalNode MATRIX() { return getToken(MatrixParser.MATRIX, 0); }
		public MakeMatrixContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMakeMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMakeMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMakeMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new MakeNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(NUMBER);
				}
				break;
			case MATRIX:
				_localctx = new MakeMatrixContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(MATRIX);
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(ID);
				}
				break;
			case LB:
				_localctx = new MakeBracesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(LB);
				setState(68);
				sum(0);
				setState(69);
				match(RB);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return sum_sempred((SumContext)_localctx, predIndex);
		case 4:
			return multiple_sempred((MultipleContext)_localctx, predIndex);
		case 5:
			return inverse_sempred((InverseContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sum_sempred(SumContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiple_sempred(MultipleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean inverse_sempred(InverseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16L\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\31\n\3\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5)\n\5\f\5\16\5,\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6\64\n\6\f\6\16"+
		"\6\67\13\6\3\7\3\7\3\7\3\7\3\7\7\7>\n\7\f\7\16\7A\13\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bJ\n\b\3\b\2\5\b\n\f\t\2\4\6\b\n\f\16\2\2\2L\2\20\3\2\2"+
		"\2\4\34\3\2\2\2\6\36\3\2\2\2\b\"\3\2\2\2\n-\3\2\2\2\f8\3\2\2\2\16I\3\2"+
		"\2\2\20\21\5\4\3\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24\5\6\4\2\24\25\7\2"+
		"\2\3\25\35\3\2\2\2\26\30\5\b\5\2\27\31\7\13\2\2\30\27\3\2\2\2\30\31\3"+
		"\2\2\2\31\32\3\2\2\2\32\33\7\2\2\3\33\35\3\2\2\2\34\23\3\2\2\2\34\26\3"+
		"\2\2\2\35\5\3\2\2\2\36\37\7\3\2\2\37 \7\7\2\2 !\5\b\5\2!\7\3\2\2\2\"#"+
		"\b\5\1\2#$\5\n\6\2$*\3\2\2\2%&\f\4\2\2&\'\7\f\2\2\')\5\n\6\2(%\3\2\2\2"+
		"),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\t\3\2\2\2,*\3\2\2\2-.\b\6\1\2./\5\f\7"+
		"\2/\65\3\2\2\2\60\61\f\4\2\2\61\62\7\r\2\2\62\64\5\f\7\2\63\60\3\2\2\2"+
		"\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\13\3\2\2\2\67\65\3\2\2\2"+
		"89\b\7\1\29:\5\16\b\2:?\3\2\2\2;<\f\4\2\2<>\7\16\2\2=;\3\2\2\2>A\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@\r\3\2\2\2A?\3\2\2\2BJ\7\4\2\2CJ\7\6\2\2DJ\7\3"+
		"\2\2EF\7\t\2\2FG\5\b\5\2GH\7\n\2\2HJ\3\2\2\2IB\3\2\2\2IC\3\2\2\2ID\3\2"+
		"\2\2IE\3\2\2\2J\17\3\2\2\2\b\30\34*\65?I";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}