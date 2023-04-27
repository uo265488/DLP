package codegeneration;


import ast.expression.*;
import semantic.Visitor;
public class ValueCGVisitor extends DefaultCGVisitorImpl<Void, Void> {

    private CodeGenerator cg;
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
        this.cg = addressCGVisitor.getCodeGenerator();
        addressCGVisitor.setValueCGVisitor(this);
    }


    /**
     * value[[Invocation: exp 1 → exp 2 exp 3 *]] =
     *      exp3*.forEach(exp -> value[[exp]])
     *      call exp2.name
     */
    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {

        functionInvocation.arguments.forEach(a -> a.accept(this, null));
        cg.call(functionInvocation.functionVariable.name);

        return param;
    }

    public AddressCGVisitor getAddressCGVisitor() {
        return this.addressCGVisitor;
    }

    /**
     *  value[[ IntLiteral : exp -> INT_CONSTANT ]] =
     *          <pushi > exp.value
     */
    public Void visit(IntLiteral intLiteral, Void param) {
        cg.push('i', intLiteral.value);

        return null;
    }

    /**
     *  value[[ DoubleLiteral : exp -> REAL_CONSTANT ]] =
     *          <pushf > exp.value
     */
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        cg.pushf(doubleLiteral.value);

        return null;
    }

    /**
     *  value[[ CharLiteral : exp -> CHAR_CONSTANT ]] =
     *          <pushb > (int) exp.value
     */
    public Void visit(CharLiteral charLiteral, Void param) {
        cg.push('b', charLiteral.value);

        return null;
    }

    /**
     *  value[[ Variable : exp -> ID ]] =
     *          address[[exp]]
     *          <load> exp.type.suffix()
     */
    public Void visit(Variable variable, Void param) {
        variable.accept(addressCGVisitor, null);
        cg.load(variable.type.getSuffix());

        return null;
    }

    /**
     *  value[[ Arithmetic : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          value[[exp3]]
     *          cg.convert(exp3.type, exp1.type)
     *          cg.arithmetic(exp1.operator)
     */
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.op1.accept(this, null);
        cg.convert(arithmetic.op1.getType(), arithmetic.type);
        arithmetic.op2.accept(this, null);
        cg.convert(arithmetic.op2.getType(), null);
        cg.arithmetic(arithmetic);

        return null;
    }

    /**
     *  value[[ Modulus : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          value[[exp3]]
     *          cg.convert(exp3.type, exp1.type)
     *          <mod>
     */
    public Void visit(Modulus modulus, Void param) {
        modulus.op1.accept(this, null);
        cg.convert(modulus.op1.getType(), modulus.type);
        modulus.op2.accept(this, null);
        cg.convert(modulus.op2.getType(), modulus.type);
        cg.modulus();
        return null;
    }
    /**
     *  value[[ Comparison : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          value[[exp3]]
     *          cg.comparison(exp1.operator)
     */
    public Void visit(Relational relational, Void param) {
        relational.op1.accept(this, null);
        relational.op2.accept(this, null);
        cg.relational(relational);
        return null;
    }

    /**
     *  value[[ Logical : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          value[[exp3]]
     *          cg.logical(exp1.operator)
     */
    public Void visit(Logic logic, Void param) {
        logic.op1.accept(this, null);
        logic.op2.accept(this, null);
        cg.logic(logic);

        return null;
    }

    /**
     *  value[[ UnaryMinus : exp1 -> exp2 ]] =
     *          <pushi 0>
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          <subi>
     */
    public Void visit(UnaryMinus unaryMinus, Void param) {
        cg.push('i', 0);
        unaryMinus.expression.accept(this, null);
        cg.convert(unaryMinus.expression.getType(), unaryMinus.type);
        cg.sub('i');

        return null;
    }

    /**
     *  value[[ UnaryNot : exp1 -> exp2 ]] =
     *          value[[exp2]]
     *          <not>
     */
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.expression.accept(this, null);
        cg.not();
        return null;
    }

    /**
     * value[[ Cast : exp1 -> type exp2 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, type)
     */
    public Void visit(Cast cast, Void param) {
        cast.expression.accept(this, null);
        cg.convert(cast.expression.getType(), cast.castTo);

        return null;
    }

    /**
     *  value[[ Indexing: exp1 -> exp2 exp3 ]] =
     *          address[[exp1]]
     *          <load> exp1.type.suffix
     */
    public Void visit(ArrayAccess arrayAccess, Void param) {
        arrayAccess.accept(addressCGVisitor, null);
        cg.load(arrayAccess.type.getSuffix());

        return null;
    }

    /**
     *   value[[ FieldAccess : exp1 -> exp2 ID ]] =
     *          address[[exp1]]
     *          <load> exp1.type.suffix
     */
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.accept(addressCGVisitor, null);
        cg.load(fieldAccess.type.getSuffix());

        return null;
    }
}
