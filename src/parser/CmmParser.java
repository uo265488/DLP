// Generated from java-escape by ANTLR 4.11.1
package parser;

import ast.*;
import ast.definition.*;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, CHAR_CONSTANT=38, 
		ASCII_CHAR=39, REAL_CONSTANT=40, MANTISSA_AND_EXPONENT=41, FLOATING_POINT=42, 
		INT_CONSTANT=43, SKIP_CHARACTERS=44, ONE_LINE_COMMENT=45, MULTIPLE_LINE_COMMENT=46;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_definition = 2, RULE_functionDefinition = 3, 
		RULE_statement = 4, RULE_ifElse = 5, RULE_block = 6, RULE_expression = 7, 
		RULE_type = 8, RULE_recordFields = 9, RULE_functionInvocation = 10, RULE_parameters = 11, 
		RULE_arguments = 12, RULE_varDefinition = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "definition", "functionDefinition", "statement", "ifElse", 
			"block", "expression", "type", "recordFields", "functionInvocation", 
			"parameters", "arguments", "varDefinition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "';'", "'}'", "'return'", 
			"'while'", "'='", "'write'", "','", "'read'", "'if'", "'else'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", 
			"'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "'struct'", "'int'", "'double'", 
			"'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "CHAR_CONSTANT", "ASCII_CHAR", "REAL_CONSTANT", "MANTISSA_AND_EXPONENT", 
			"FLOATING_POINT", "INT_CONSTANT", "SKIP_CHARACTERS", "ONE_LINE_COMMENT", 
			"MULTIPLE_LINE_COMMENT"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> defs = new ArrayList<Definition>();;
		public DefinitionContext d;
		public MainContext main;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(28);
					((ProgramContext)_localctx).d = definition();
					 ((ProgramContext)_localctx).d.ast.stream().forEach(temp ->
					                                           _localctx.defs.add(temp));    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(33); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(35);
			((ProgramContext)_localctx).main = main();
			 _localctx.defs.add(((ProgramContext)_localctx).main.ast); 
			 ((ProgramContext)_localctx).ast =  new Program(0,0, _localctx.defs); 
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
	public static class MainContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<Statement> sts = new ArrayList<Statement>();
		public VarDefinitionContext v;
		public StatementContext s;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			match(T__1);
			setState(41);
			match(T__2);
			setState(42);
			match(T__3);
			setState(43);
			match(T__4);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				((MainContext)_localctx).v = varDefinition();
				 _localctx.sts.addAll(((MainContext)_localctx).v.ast); 
				setState(46);
				match(T__5);
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018882L) != 0 );
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				((MainContext)_localctx).s = statement();
				 _localctx.sts.addAll(((MainContext)_localctx).s.ast); 
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 10307923110664L) != 0 );
			setState(59);
			match(T__6);
			 ((MainContext)_localctx).ast =  new FunctionDefinition(((MainContext)_localctx).v.ast.get(0).getLine(),
			                                    ((MainContext)_localctx).v.ast.get(0).getColumn(),
			                                    new VoidType(((MainContext)_localctx).v.ast.get(0).getLine(), ((MainContext)_localctx).v.ast.get(0).getColumn()),
			                                    "main",
			                                    _localctx.sts); 
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
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public VarDefinitionContext v;
		public FunctionDefinitionContext functionDefinition;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((DefinitionContext)_localctx).v = varDefinition();
				setState(63);
				match(T__5);
				 ((DefinitionContext)_localctx).v.ast.stream().forEach(
				                                        temp -> _localctx.ast.add(new VarDefinition(temp.getLine(), temp.getColumn(), temp.type, temp.name))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				((DefinitionContext)_localctx).functionDefinition = functionDefinition();
				 _localctx.ast.add(((DefinitionContext)_localctx).functionDefinition.ast); 
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<Statement> sts = new ArrayList<Statement>();
		public TypeContext t;
		public Token ID;
		public ArgumentsContext a;
		public VarDefinitionContext v;
		public StatementContext s;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((FunctionDefinitionContext)_localctx).t = type(0);
			setState(72);
			((FunctionDefinitionContext)_localctx).ID = match(ID);
			setState(73);
			match(T__2);
			setState(74);
			((FunctionDefinitionContext)_localctx).a = arguments();
			setState(75);
			match(T__3);
			setState(76);
			match(T__4);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018882L) != 0) {
				{
				{
				setState(77);
				((FunctionDefinitionContext)_localctx).v = varDefinition();
				 _localctx.sts.addAll(((FunctionDefinitionContext)_localctx).v.ast); 
				setState(79);
				match(T__5);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 10307923110664L) != 0) {
				{
				{
				setState(86);
				((FunctionDefinitionContext)_localctx).s = statement();
				 _localctx.sts.addAll(((FunctionDefinitionContext)_localctx).s.ast); 
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__6);
			 ((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition(((FunctionDefinitionContext)_localctx).t.ast.getLine(),
			                                    ((FunctionDefinitionContext)_localctx).t.ast.getColumn(),
			                                    new FunctionType(((FunctionDefinitionContext)_localctx).t.ast.getLine(), ((FunctionDefinitionContext)_localctx).t.ast.getColumn(), ((FunctionDefinitionContext)_localctx).t.ast, ((FunctionDefinitionContext)_localctx).a.ast),
			                                    (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null),
			                                    _localctx.sts); 
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
	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public FunctionInvocationContext f;
		public ExpressionContext e1;
		public IfElseContext ifElse;
		public BlockContext b1;
		public ExpressionContext e2;
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((StatementContext)_localctx).f = functionInvocation();
				setState(98);
				match(T__5);
				 _localctx.ast.add(((StatementContext)_localctx).f.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(T__7);
				setState(102);
				((StatementContext)_localctx).e1 = expression(0);
				setState(103);
				match(T__5);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				((StatementContext)_localctx).ifElse = ifElse();
				 _localctx.ast.add(((StatementContext)_localctx).ifElse.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(T__8);
				setState(110);
				match(T__2);
				setState(111);
				((StatementContext)_localctx).e1 = expression(0);
				setState(112);
				match(T__3);
				setState(113);
				((StatementContext)_localctx).b1 = block();
				 _localctx.ast.add(new While(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				((StatementContext)_localctx).e1 = expression(0);
				setState(117);
				match(T__9);
				setState(118);
				((StatementContext)_localctx).e2 = expression(0);
				setState(119);
				match(T__5);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(T__10);
				setState(123);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new Input(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast)); 
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(125);
					match(T__11);
					setState(126);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new Input(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast)); 
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				match(T__5);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(136);
				match(T__12);
				setState(137);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new Print(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast)); 
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(139);
					match(T__11);
					setState(140);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new Print(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast)); 
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				match(T__5);
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
	public static class IfElseContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public BlockContext b1;
		public BlockContext b2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifElse);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__13);
				setState(153);
				match(T__2);
				setState(154);
				((IfElseContext)_localctx).e1 = expression(0);
				setState(155);
				match(T__3);
				setState(156);
				((IfElseContext)_localctx).b1 = block();
				 ((IfElseContext)_localctx).ast =  new IfElse(((IfElseContext)_localctx).e1.ast.getLine(), ((IfElseContext)_localctx).e1.ast.getColumn(), ((IfElseContext)_localctx).e1.ast, ((IfElseContext)_localctx).b1.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__13);
				setState(160);
				match(T__2);
				setState(161);
				((IfElseContext)_localctx).e1 = expression(0);
				setState(162);
				match(T__3);
				setState(163);
				((IfElseContext)_localctx).b1 = block();
				setState(164);
				match(T__14);
				setState(165);
				((IfElseContext)_localctx).b2 = block();
				 ((IfElseContext)_localctx).ast =  new IfElse(((IfElseContext)_localctx).e1.ast.getLine(), ((IfElseContext)_localctx).e1.ast.getColumn(), ((IfElseContext)_localctx).e1.ast, ((IfElseContext)_localctx).b1.ast, ((IfElseContext)_localctx).b2.ast); 
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
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext s1;
		public StatementContext s2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__7:
			case T__8:
			case T__10:
			case T__12:
			case T__13:
			case T__18:
			case T__19:
			case ID:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
			case INT_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				((BlockContext)_localctx).s1 = statement();
				 ((BlockContext)_localctx).s1.ast.stream().forEach(temp -> _localctx.ast.add(temp)); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__4);
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					((BlockContext)_localctx).s2 = statement();
					 ((BlockContext)_localctx).s2.ast.stream().forEach(temp -> _localctx.ast.add(temp)); 
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 10307923110664L) != 0 );
				setState(181);
				match(T__6);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public ExpressionContext e;
		public TypeContext t1;
		public Token ID;
		public Token i1;
		public Token r1;
		public Token c1;
		public Token op;
		public ExpressionContext e2;
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(186);
				functionInvocation();
				}
				break;
			case 2:
				{
				setState(187);
				match(T__2);
				setState(188);
				((ExpressionContext)_localctx).t1 = type(0);
				setState(189);
				match(T__3);
				setState(190);
				((ExpressionContext)_localctx).e = expression(11);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).t1.ast.getLine(), ((ExpressionContext)_localctx).t1.ast.getColumn(), ((ExpressionContext)_localctx).t1.ast, ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 3:
				{
				setState(193);
				match(T__18);
				setState(194);
				((ExpressionContext)_localctx).e1 = expression(10);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 4:
				{
				setState(197);
				match(T__19);
				setState(198);
				((ExpressionContext)_localctx).e1 = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 5:
				{
				setState(201);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 6:
				{
				setState(203);
				((ExpressionContext)_localctx).i1 = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).i1.getLine(), ((ExpressionContext)_localctx).i1.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).i1!=null?((ExpressionContext)_localctx).i1.getText():null))); 
				}
				break;
			case 7:
				{
				setState(205);
				((ExpressionContext)_localctx).r1 = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).r1.getLine(), ((ExpressionContext)_localctx).r1.getCharPositionInLine() + 1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).r1!=null?((ExpressionContext)_localctx).r1.getText():null))); 
				}
				break;
			case 8:
				{
				setState(207);
				((ExpressionContext)_localctx).c1 = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).c1.getLine(), ((ExpressionContext)_localctx).c1.getCharPositionInLine() + 1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).c1!=null?((ExpressionContext)_localctx).c1.getText():null))); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(212);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(213);
						((ExpressionContext)_localctx).e2 = expression(9);

						                          ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						                      
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(217);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__23) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(222);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Relational(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(227);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Logic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(232);
						match(T__15);
						setState(233);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(234);
						match(T__16);
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(238);
						match(T__17);
						setState(239);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t1;
		public RecordFieldsContext r;
		public Token s;
		public Token i;
		public RecordFieldsContext recordFields() {
			return getRuleContext(RecordFieldsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				{
				setState(247);
				match(T__32);
				setState(248);
				match(T__4);
				setState(249);
				((TypeContext)_localctx).r = recordFields();
				setState(250);
				match(T__6);
				 ((TypeContext)_localctx).ast =  new Struct(((TypeContext)_localctx).r.ast.get(0).getLine(), ((TypeContext)_localctx).r.ast.get(0).getColumn(), ((TypeContext)_localctx).r.ast); 
				}
				break;
			case T__33:
				{
				setState(253);
				((TypeContext)_localctx).s = match(T__33);
				 ((TypeContext)_localctx).ast =  new Int(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine() + 1); 
				}
				break;
			case T__34:
				{
				setState(255);
				((TypeContext)_localctx).s = match(T__34);
				 ((TypeContext)_localctx).ast =  new Real(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine() + 1); 
				}
				break;
			case T__35:
				{
				setState(257);
				((TypeContext)_localctx).s = match(T__35);
				 ((TypeContext)_localctx).ast =  new Char(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine() + 1); 
				}
				break;
			case T__0:
				{
				setState(259);
				((TypeContext)_localctx).s = match(T__0);
				 ((TypeContext)_localctx).ast =  new VoidType(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine() + 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(263);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(264);
					match(T__15);
					setState(265);
					((TypeContext)_localctx).i = match(INT_CONSTANT);
					setState(266);
					match(T__16);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t1.ast.getLine(), ((TypeContext)_localctx).t1.ast.getColumn(), ((TypeContext)_localctx).t1.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null))); 
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordFieldsContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public RecordFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFields; }
	}

	public final RecordFieldsContext recordFields() throws RecognitionException {
		RecordFieldsContext _localctx = new RecordFieldsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recordFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018882L) != 0) {
				{
				{
				setState(273);
				((RecordFieldsContext)_localctx).t = type(0);
				setState(274);
				match(ID);
				setState(275);
				match(T__5);

				        _localctx.ast.add(new RecordField(((RecordFieldsContext)_localctx).t.ast.getLine(), ((RecordFieldsContext)_localctx).t.ast.getColumn(), ((RecordFieldsContext)_localctx).t.ast));
				    
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionInvocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public List<Expression> params = new ArrayList<Expression>();
		public Token ID;
		public ParametersContext p;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((FunctionInvocationContext)_localctx).ID = match(ID);
			setState(284);
			match(T__2);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 10307923083272L) != 0) {
				{
				setState(285);
				((FunctionInvocationContext)_localctx).p = parameters();
				 _localctx.params.addAll(((FunctionInvocationContext)_localctx).p.ast); 
				}
			}

			setState(290);
			match(T__3);
			 ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1,
			                                                    new Variable(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null)),
			                                                    _localctx.params);
			                    
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
	public static class ParametersContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			((ParametersContext)_localctx).e1 = expression(0);
			 _localctx.ast.add(((ParametersContext)_localctx).e1.ast); 
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(295);
				match(T__11);
				setState(296);
				((ParametersContext)_localctx).e2 = expression(0);
				 _localctx.ast.add(((ParametersContext)_localctx).e2.ast); 
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t;
		public Token id1;
		public TypeContext t2;
		public Token id2;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018882L) != 0) {
				{
				{
				setState(304);
				((ArgumentsContext)_localctx).t = type(0);
				setState(305);
				((ArgumentsContext)_localctx).id1 = match(ID);
				 _localctx.ast.add(new VarDefinition(((ArgumentsContext)_localctx).t.ast.getLine(), ((ArgumentsContext)_localctx).t.ast.getColumn(), ((ArgumentsContext)_localctx).t.ast, (((ArgumentsContext)_localctx).id1!=null?((ArgumentsContext)_localctx).id1.getText():null))); 
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(308);
					match(T__11);
					setState(309);
					((ArgumentsContext)_localctx).t2 = type(0);
					setState(310);
					((ArgumentsContext)_localctx).id2 = match(ID);
					 _localctx.ast.add(new VarDefinition(((ArgumentsContext)_localctx).t2.ast.getLine(), ((ArgumentsContext)_localctx).t2.ast.getColumn(), ((ArgumentsContext)_localctx).t2.ast, (((ArgumentsContext)_localctx).id2!=null?((ArgumentsContext)_localctx).id2.getText():null))); 
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			((VarDefinitionContext)_localctx).t = type(0);
			setState(321);
			((VarDefinitionContext)_localctx).id1 = match(ID);
			 _localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).t.ast.getLine(), ((VarDefinitionContext)_localctx).t.ast.getColumn(), ((VarDefinitionContext)_localctx).t.ast, (((VarDefinitionContext)_localctx).id1!=null?((VarDefinitionContext)_localctx).id1.getText():null))); 
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(323);
				match(T__11);
				setState(324);
				((VarDefinitionContext)_localctx).id2 = match(ID);
				 _localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).t.ast.getLine(), ((VarDefinitionContext)_localctx).t.ast.getColumn(), ((VarDefinitionContext)_localctx).t.ast, (((VarDefinitionContext)_localctx).id2!=null?((VarDefinitionContext)_localctx).id2.getText():null))); 
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u014c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		" \b\u0000\u000b\u0000\f\u0000!\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u00011\b\u0001\u000b"+
		"\u0001\f\u00012\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u00018\b\u0001"+
		"\u000b\u0001\f\u00019\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003R\b\u0003\n\u0003\f\u0003U\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0082\b\u0004"+
		"\n\u0004\f\u0004\u0085\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u0090\b\u0004\n\u0004\f\u0004\u0093\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u0097\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00a9\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00b2\b\u0006\u000b\u0006"+
		"\f\u0006\u00b3\u0001\u0006\u0001\u0006\u0003\u0006\u00b8\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00d2\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u00f2\b\u0007\n\u0007\f\u0007\u00f5\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0106\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u010d\b\b\n\b\f\b\u0110\t\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0117\b\t\n\t\f\t\u011a"+
		"\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0121\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u012c\b\u000b\n\u000b\f\u000b\u012f\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u013a\b\f\n\f\f\f\u013d\t\f\u0003\f\u013f\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0147\b\r\n\r\f\r\u014a\t\r"+
		"\u0001\r\u0000\u0002\u000e\u0010\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\u0015\u0017"+
		"\u0002\u0000\u0013\u0013\u0018\u0018\u0001\u0000\u0019\u001e\u0001\u0000"+
		"\u001f \u0166\u0000\u001f\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000"+
		"\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000"+
		"\b\u0096\u0001\u0000\u0000\u0000\n\u00a8\u0001\u0000\u0000\u0000\f\u00b7"+
		"\u0001\u0000\u0000\u0000\u000e\u00d1\u0001\u0000\u0000\u0000\u0010\u0105"+
		"\u0001\u0000\u0000\u0000\u0012\u0118\u0001\u0000\u0000\u0000\u0014\u011b"+
		"\u0001\u0000\u0000\u0000\u0016\u0125\u0001\u0000\u0000\u0000\u0018\u013e"+
		"\u0001\u0000\u0000\u0000\u001a\u0140\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0003\u0004\u0002\u0000\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e"+
		" \u0001\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#$\u0003\u0002\u0001\u0000$%\u0006\u0000"+
		"\uffff\uffff\u0000%&\u0006\u0000\uffff\uffff\u0000&\u0001\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0005\u0002\u0000\u0000)*\u0005"+
		"\u0003\u0000\u0000*+\u0005\u0004\u0000\u0000+0\u0005\u0005\u0000\u0000"+
		",-\u0003\u001a\r\u0000-.\u0006\u0001\uffff\uffff\u0000./\u0005\u0006\u0000"+
		"\u0000/1\u0001\u0000\u0000\u00000,\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000037\u0001"+
		"\u0000\u0000\u000045\u0003\b\u0004\u000056\u0006\u0001\uffff\uffff\u0000"+
		"68\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;<\u0005\u0007\u0000\u0000<=\u0006\u0001\uffff\uffff\u0000"+
		"=\u0003\u0001\u0000\u0000\u0000>?\u0003\u001a\r\u0000?@\u0005\u0006\u0000"+
		"\u0000@A\u0006\u0002\uffff\uffff\u0000AF\u0001\u0000\u0000\u0000BC\u0003"+
		"\u0006\u0003\u0000CD\u0006\u0002\uffff\uffff\u0000DF\u0001\u0000\u0000"+
		"\u0000E>\u0001\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000F\u0005\u0001"+
		"\u0000\u0000\u0000GH\u0003\u0010\b\u0000HI\u0005%\u0000\u0000IJ\u0005"+
		"\u0003\u0000\u0000JK\u0003\u0018\f\u0000KL\u0005\u0004\u0000\u0000LS\u0005"+
		"\u0005\u0000\u0000MN\u0003\u001a\r\u0000NO\u0006\u0003\uffff\uffff\u0000"+
		"OP\u0005\u0006\u0000\u0000PR\u0001\u0000\u0000\u0000QM\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000T[\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0003"+
		"\b\u0004\u0000WX\u0006\u0003\uffff\uffff\u0000XZ\u0001\u0000\u0000\u0000"+
		"YV\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0007\u0000\u0000_`\u0006\u0003\uffff\uffff\u0000"+
		"`\u0007\u0001\u0000\u0000\u0000ab\u0003\u0014\n\u0000bc\u0005\u0006\u0000"+
		"\u0000cd\u0006\u0004\uffff\uffff\u0000d\u0097\u0001\u0000\u0000\u0000"+
		"ef\u0005\b\u0000\u0000fg\u0003\u000e\u0007\u0000gh\u0005\u0006\u0000\u0000"+
		"hi\u0006\u0004\uffff\uffff\u0000i\u0097\u0001\u0000\u0000\u0000jk\u0003"+
		"\n\u0005\u0000kl\u0006\u0004\uffff\uffff\u0000l\u0097\u0001\u0000\u0000"+
		"\u0000mn\u0005\t\u0000\u0000no\u0005\u0003\u0000\u0000op\u0003\u000e\u0007"+
		"\u0000pq\u0005\u0004\u0000\u0000qr\u0003\f\u0006\u0000rs\u0006\u0004\uffff"+
		"\uffff\u0000s\u0097\u0001\u0000\u0000\u0000tu\u0003\u000e\u0007\u0000"+
		"uv\u0005\n\u0000\u0000vw\u0003\u000e\u0007\u0000wx\u0005\u0006\u0000\u0000"+
		"xy\u0006\u0004\uffff\uffff\u0000y\u0097\u0001\u0000\u0000\u0000z{\u0005"+
		"\u000b\u0000\u0000{|\u0003\u000e\u0007\u0000|\u0083\u0006\u0004\uffff"+
		"\uffff\u0000}~\u0005\f\u0000\u0000~\u007f\u0003\u000e\u0007\u0000\u007f"+
		"\u0080\u0006\u0004\uffff\uffff\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081}\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005\u0006\u0000\u0000\u0087\u0097\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005\r\u0000\u0000\u0089\u008a\u0003\u000e\u0007\u0000\u008a\u0091"+
		"\u0006\u0004\uffff\uffff\u0000\u008b\u008c\u0005\f\u0000\u0000\u008c\u008d"+
		"\u0003\u000e\u0007\u0000\u008d\u008e\u0006\u0004\uffff\uffff\u0000\u008e"+
		"\u0090\u0001\u0000\u0000\u0000\u008f\u008b\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0006\u0000\u0000\u0095"+
		"\u0097\u0001\u0000\u0000\u0000\u0096a\u0001\u0000\u0000\u0000\u0096e\u0001"+
		"\u0000\u0000\u0000\u0096j\u0001\u0000\u0000\u0000\u0096m\u0001\u0000\u0000"+
		"\u0000\u0096t\u0001\u0000\u0000\u0000\u0096z\u0001\u0000\u0000\u0000\u0096"+
		"\u0088\u0001\u0000\u0000\u0000\u0097\t\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u000e\u0000\u0000\u0099\u009a\u0005\u0003\u0000\u0000\u009a\u009b"+
		"\u0003\u000e\u0007\u0000\u009b\u009c\u0005\u0004\u0000\u0000\u009c\u009d"+
		"\u0003\f\u0006\u0000\u009d\u009e\u0006\u0005\uffff\uffff\u0000\u009e\u00a9"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0\u00a1"+
		"\u0005\u0003\u0000\u0000\u00a1\u00a2\u0003\u000e\u0007\u0000\u00a2\u00a3"+
		"\u0005\u0004\u0000\u0000\u00a3\u00a4\u0003\f\u0006\u0000\u00a4\u00a5\u0005"+
		"\u000f\u0000\u0000\u00a5\u00a6\u0003\f\u0006\u0000\u00a6\u00a7\u0006\u0005"+
		"\uffff\uffff\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u0098\u0001"+
		"\u0000\u0000\u0000\u00a8\u009f\u0001\u0000\u0000\u0000\u00a9\u000b\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0003\b\u0004\u0000\u00ab\u00ac\u0006\u0006"+
		"\uffff\uffff\u0000\u00ac\u00b8\u0001\u0000\u0000\u0000\u00ad\u00b1\u0005"+
		"\u0005\u0000\u0000\u00ae\u00af\u0003\b\u0004\u0000\u00af\u00b0\u0006\u0006"+
		"\uffff\uffff\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0005\u0007\u0000\u0000\u00b6\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b7\u00aa\u0001\u0000\u0000\u0000\u00b7\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b8\r\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u0007"+
		"\uffff\uffff\u0000\u00ba\u00d2\u0003\u0014\n\u0000\u00bb\u00bc\u0005\u0003"+
		"\u0000\u0000\u00bc\u00bd\u0003\u0010\b\u0000\u00bd\u00be\u0005\u0004\u0000"+
		"\u0000\u00be\u00bf\u0003\u000e\u0007\u000b\u00bf\u00c0\u0006\u0007\uffff"+
		"\uffff\u0000\u00c0\u00d2\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0013"+
		"\u0000\u0000\u00c2\u00c3\u0003\u000e\u0007\n\u00c3\u00c4\u0006\u0007\uffff"+
		"\uffff\u0000\u00c4\u00d2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0014"+
		"\u0000\u0000\u00c6\u00c7\u0003\u000e\u0007\t\u00c7\u00c8\u0006\u0007\uffff"+
		"\uffff\u0000\u00c8\u00d2\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005%\u0000"+
		"\u0000\u00ca\u00d2\u0006\u0007\uffff\uffff\u0000\u00cb\u00cc\u0005+\u0000"+
		"\u0000\u00cc\u00d2\u0006\u0007\uffff\uffff\u0000\u00cd\u00ce\u0005(\u0000"+
		"\u0000\u00ce\u00d2\u0006\u0007\uffff\uffff\u0000\u00cf\u00d0\u0005&\u0000"+
		"\u0000\u00d0\u00d2\u0006\u0007\uffff\uffff\u0000\u00d1\u00b9\u0001\u0000"+
		"\u0000\u0000\u00d1\u00bb\u0001\u0000\u0000\u0000\u00d1\u00c1\u0001\u0000"+
		"\u0000\u0000\u00d1\u00c5\u0001\u0000\u0000\u0000\u00d1\u00c9\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cb\u0001\u0000\u0000\u0000\u00d1\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00f3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\n\b\u0000\u0000\u00d4\u00d5\u0007\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0003\u000e\u0007\t\u00d6\u00d7\u0006\u0007\uffff\uffff"+
		"\u0000\u00d7\u00f2\u0001\u0000\u0000\u0000\u00d8\u00d9\n\u0007\u0000\u0000"+
		"\u00d9\u00da\u0007\u0001\u0000\u0000\u00da\u00db\u0003\u000e\u0007\b\u00db"+
		"\u00dc\u0006\u0007\uffff\uffff\u0000\u00dc\u00f2\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\n\u0006\u0000\u0000\u00de\u00df\u0007\u0002\u0000\u0000\u00df"+
		"\u00e0\u0003\u000e\u0007\u0007\u00e0\u00e1\u0006\u0007\uffff\uffff\u0000"+
		"\u00e1\u00f2\u0001\u0000\u0000\u0000\u00e2\u00e3\n\u0005\u0000\u0000\u00e3"+
		"\u00e4\u0007\u0003\u0000\u0000\u00e4\u00e5\u0003\u000e\u0007\u0006\u00e5"+
		"\u00e6\u0006\u0007\uffff\uffff\u0000\u00e6\u00f2\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\n\r\u0000\u0000\u00e8\u00e9\u0005\u0010\u0000\u0000\u00e9"+
		"\u00ea\u0003\u000e\u0007\u0000\u00ea\u00eb\u0005\u0011\u0000\u0000\u00eb"+
		"\u00ec\u0006\u0007\uffff\uffff\u0000\u00ec\u00f2\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\n\f\u0000\u0000\u00ee\u00ef\u0005\u0012\u0000\u0000\u00ef"+
		"\u00f0\u0005%\u0000\u0000\u00f0\u00f2\u0006\u0007\uffff\uffff\u0000\u00f1"+
		"\u00d3\u0001\u0000\u0000\u0000\u00f1\u00d8\u0001\u0000\u0000\u0000\u00f1"+
		"\u00dd\u0001\u0000\u0000\u0000\u00f1\u00e2\u0001\u0000\u0000\u0000\u00f1"+
		"\u00e7\u0001\u0000\u0000\u0000\u00f1\u00ed\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u000f\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f7\u0006\b\uffff\uffff\u0000\u00f7"+
		"\u00f8\u0005!\u0000\u0000\u00f8\u00f9\u0005\u0005\u0000\u0000\u00f9\u00fa"+
		"\u0003\u0012\t\u0000\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb\u00fc\u0006"+
		"\b\uffff\uffff\u0000\u00fc\u0106\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005"+
		"\"\u0000\u0000\u00fe\u0106\u0006\b\uffff\uffff\u0000\u00ff\u0100\u0005"+
		"#\u0000\u0000\u0100\u0106\u0006\b\uffff\uffff\u0000\u0101\u0102\u0005"+
		"$\u0000\u0000\u0102\u0106\u0006\b\uffff\uffff\u0000\u0103\u0104\u0005"+
		"\u0001\u0000\u0000\u0104\u0106\u0006\b\uffff\uffff\u0000\u0105\u00f6\u0001"+
		"\u0000\u0000\u0000\u0105\u00fd\u0001\u0000\u0000\u0000\u0105\u00ff\u0001"+
		"\u0000\u0000\u0000\u0105\u0101\u0001\u0000\u0000\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0106\u010e\u0001\u0000\u0000\u0000\u0107\u0108\n\u0005"+
		"\u0000\u0000\u0108\u0109\u0005\u0010\u0000\u0000\u0109\u010a\u0005+\u0000"+
		"\u0000\u010a\u010b\u0005\u0011\u0000\u0000\u010b\u010d\u0006\b\uffff\uffff"+
		"\u0000\u010c\u0107\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000"+
		"\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000"+
		"\u0000\u010f\u0011\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0003\u0010\b\u0000\u0112\u0113\u0005%\u0000\u0000"+
		"\u0113\u0114\u0005\u0006\u0000\u0000\u0114\u0115\u0006\t\uffff\uffff\u0000"+
		"\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0111\u0001\u0000\u0000\u0000"+
		"\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u0013\u0001\u0000\u0000\u0000"+
		"\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011c\u0005%\u0000\u0000\u011c"+
		"\u0120\u0005\u0003\u0000\u0000\u011d\u011e\u0003\u0016\u000b\u0000\u011e"+
		"\u011f\u0006\n\uffff\uffff\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120"+
		"\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"\u0122\u0001\u0000\u0000\u0000\u0122\u0123\u0005\u0004\u0000\u0000\u0123"+
		"\u0124\u0006\n\uffff\uffff\u0000\u0124\u0015\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0003\u000e\u0007\u0000\u0126\u012d\u0006\u000b\uffff\uffff\u0000"+
		"\u0127\u0128\u0005\f\u0000\u0000\u0128\u0129\u0003\u000e\u0007\u0000\u0129"+
		"\u012a\u0006\u000b\uffff\uffff\u0000\u012a\u012c\u0001\u0000\u0000\u0000"+
		"\u012b\u0127\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000"+
		"\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000"+
		"\u012e\u0017\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0003\u0010\b\u0000\u0131\u0132\u0005%\u0000\u0000\u0132"+
		"\u0133\u0006\f\uffff\uffff\u0000\u0133\u013b\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0005\f\u0000\u0000\u0135\u0136\u0003\u0010\b\u0000\u0136\u0137"+
		"\u0005%\u0000\u0000\u0137\u0138\u0006\f\uffff\uffff\u0000\u0138\u013a"+
		"\u0001\u0000\u0000\u0000\u0139\u0134\u0001\u0000\u0000\u0000\u013a\u013d"+
		"\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b"+
		"\u0001\u0000\u0000\u0000\u013e\u0130\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f\u0019\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0003\u0010\b\u0000\u0141\u0142\u0005%\u0000\u0000\u0142\u0148\u0006"+
		"\r\uffff\uffff\u0000\u0143\u0144\u0005\f\u0000\u0000\u0144\u0145\u0005"+
		"%\u0000\u0000\u0145\u0147\u0006\r\uffff\uffff\u0000\u0146\u0143\u0001"+
		"\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u001b\u0001"+
		"\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u0017!29ES[\u0083"+
		"\u0091\u0096\u00a8\u00b3\u00b7\u00d1\u00f1\u00f3\u0105\u010e\u0118\u0120"+
		"\u012d\u013b\u013e\u0148";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}