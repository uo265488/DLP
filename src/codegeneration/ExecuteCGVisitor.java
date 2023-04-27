package codegeneration;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.FunctionInvocation;
import ast.statement.*;
import ast.type.FunctionType;
import ast.type.VoidType;

import java.util.List;

public class ExecuteCGVisitor extends DefaultCGVisitorImpl<ReturnSequenceDto, ReturnSequenceDto> {

    private final CodeGenerator cg;
    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;

    public ExecuteCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
        this.addressCGVisitor = valueCGVisitor.getAddressCGVisitor();
        this.cg = addressCGVisitor.getCodeGenerator();
    }

    /**
     *  execute [[Program: program -> definition* ]] =
     *      <call main>
     *      <halt>
     *      definition*.forEach(st -> execute[[st]])
     */
    @Override
    public ReturnSequenceDto visit(Program program, ReturnSequenceDto param) {
        program.definitionList.stream().filter(d -> d instanceof VarDefinition)
                .forEach(def -> def.accept(this, param));

        cg.comment("\n\nInvocation to the main function");
        cg.call("main");
        cg.halt();

        program.definitionList.stream().filter(d -> !(d instanceof VarDefinition))
                .forEach(def -> def.accept(this, param));
        return param;
    }


    @Override
    public ReturnSequenceDto visit(VarDefinition varDefinition, ReturnSequenceDto param) {
        cg.comment(varDefinition.toString());

        return param;
    }

    @Override
    public ReturnSequenceDto visit(FunctionDefinition functionDefinition, ReturnSequenceDto param) {
        List<VarDefinition> locals = functionDefinition.body.stream()
                .filter(f -> f instanceof VarDefinition).map(l -> (VarDefinition) l).toList();

        int bytesLocals = locals.isEmpty() ? 0 : - locals.get(locals.size() - 1).offset;
        int bytesParams = functionDefinition.type.parameters.size() == 0
                ? 0
                : functionDefinition.type.parameters.get(0).offset;

        ReturnSequenceDto ret = new ReturnSequenceDto(
                functionDefinition.type.returnType.getNumberOfBytes(),
                bytesLocals,
                bytesParams);

        cg.line(functionDefinition.getLine());
        cg.functionName(functionDefinition.name);
        cg.comment("Parameters");
        functionDefinition.type.parameters.forEach(p -> p.accept(this, ret));
        cg.comment("Local variables");
        locals.forEach(varDef -> varDef.accept(this, ret));

        cg.enter(bytesLocals);

        functionDefinition.body.stream()
                .filter(fd -> !(fd instanceof VarDefinition))
                .forEach(st -> st.accept(this, ret));

        cg.ret(ret);

        return ret;
    }


    /**
     * execute[[Invocation: statement → exp1 exp2*]] =
     *      exp2*.forEach(exp -> value[[exp]])
     *      call exp1.name
     *      if(!(exp1.type.returnType instanceof VoidType))
     *          pop exp1.type.returnType.suffix()
     */
    @Override
    public ReturnSequenceDto visit(FunctionInvocation functionInvocation, ReturnSequenceDto param) {
        cg.line(functionInvocation.getLine());
        functionInvocation.arguments.forEach(a -> a.accept(valueCGVisitor, null));
        cg.call(functionInvocation.functionVariable.name);
        if(!(((FunctionType)(functionInvocation.functionVariable.type)).returnType instanceof VoidType)) {
            cg.pop(((FunctionType)(functionInvocation.functionVariable.type)).returnType.getSuffix());
        }


        return param;
    }


    /**
     *  execute[[ Read : stmnt -> exp ]] =
     *          address[[exp]]
     *          <in> exp.type.sufix()
     *          <store> exp.type.suffix()
     */
    @Override
    public ReturnSequenceDto visit(Input input, ReturnSequenceDto param) {
        cg.line(input.getLine());
        cg.comment("Read");

        input.expression.accept(addressCGVisitor, null);
        cg.in(input.expression.getType().getSuffix());
        cg.store(input.expression.getType().getSuffix());

        return param;
    }

    /**
     *  execute[[ Write : stmnt -> exp ]] =
     *          value[[exp]]
     *          <out> exp.type.sufix()
     */
    @Override
    public ReturnSequenceDto visit(Print print, ReturnSequenceDto returnSequenceDto) {
        cg.line(print.getLine());
        cg.comment("Write");

        print.expression.accept(valueCGVisitor, null);
        cg.out(print.expression.getType().getSuffix());

        return returnSequenceDto;

    }

    /**
     *  execute[[ Assignment : exp1 -> exp2 exp3 ]] =
     *          address[[exp2]]
     *          value[[exp3]]
     *          <store> exp1.type.suffix()
     */
    @Override
    public ReturnSequenceDto visit(Assignment assignment, ReturnSequenceDto param) {
        cg.line(assignment.getLine());

        assignment.leftExpression.accept(addressCGVisitor, null);
        assignment.rightExpression.accept(valueCGVisitor, null);
        cg.store(assignment.leftExpression.getType().getSuffix());

        return param;
    }

    /**
     *  execute[[While: statement -> expression statement1*]]
     *      String conditionLabel = cg.nextLabel(),
     *              exitLabel = cg.nextLabel();
     *      conditionLabel <:>
     *      value[[expression]]
     *      <jz > exitLabel
     *      statement1*.forEach(stmt -> execute[[stmt]])
     *      <jmp > conditionLabel
     *      exitLabel<:>
     *
     */
    @Override
    public ReturnSequenceDto visit(While whileStmnt, ReturnSequenceDto param) {
        cg.comment("While");
        String conditionLabel = "" + cg.nextLabel(),
                exitLabel = "" + cg.nextLabel();
        cg.putLabel(conditionLabel);
        whileStmnt.condition.accept(valueCGVisitor, null);
        cg.jz(exitLabel);
        cg.comment("Body of the while statement");
        whileStmnt.body.forEach(stmnt -> stmnt.accept(this, param));
        cg.jmp(conditionLabel);
        cg.putLabel(exitLabel);

        return param;
    }
    /**
     *  execute [[IfElse : statement -> exp statement2* statement3*]] =
     *      String elseLabel = cg.nextLabel(),
     *             exitLabel = cg.nextLabel();
     *      value[[expression]]
     *      <jz > elseLabel
     *      statement2*.forEach(stmnt -> execute[[stmnt]]);
     *      <jmp > exitLabel
     *      elseLabel <:>
     *      statement3*.forEach(stmnt -> execute[[stmnt]]);
     *      exitLabel <:>
     */
    @Override
    public ReturnSequenceDto visit(IfElse ifElse, ReturnSequenceDto param) {
        cg.comment("If statement");
        cg.line(ifElse.getLine());
        String elseLabel = cg.nextLabel() + "",
                exitLabel = cg.nextLabel() + "";
        ifElse.condition.accept(valueCGVisitor, null);
        cg.jz(elseLabel);
        cg.comment("Body of the if branch");
        ifElse.ifBody.forEach(stmnt -> stmnt.accept(this, param));
        cg.jmp(exitLabel);
        cg.putLabel(elseLabel);
        cg.comment("Body of the else branch");
        ifElse.elseBody.forEach(st -> st.accept(this, param));
        cg.putLabel(exitLabel);

        return param;
    }

    /**
     *  execute[[Return : stmnt -> exp ]] =
     *      value[[exp]]
     *      ret
     */
    @Override
    public ReturnSequenceDto visit(Return returnStmnt, ReturnSequenceDto param) {
        cg.line(returnStmnt.getLine());
        cg.comment("Return");
        returnStmnt.expression.accept(valueCGVisitor, null);

        return param;
    }

}
