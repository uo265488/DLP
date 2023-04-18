package codegeneration;

import semantic.Visitor;

public class ValueCGVisitor extends DefaultCGVisitorImpl<Void, Void> {

    /**
     *  value[[ IntLiteral : exp -> INT_CONSTANT ]] =
     *          <pushi > exp.value
     */

    /**
     *  value[[ DoubleLiteral : exp -> REAL_CONSTANT ]] =
     *          <pushf > exp.value
     */

    /**
     *  value[[ CharLiteral : exp -> CHAR_CONSTANT ]] =
     *          <pushb > (int) exp.value
     */

    /**
     *  value[[ Variable : exp -> ID ]] =
     *          address[[exp]]
     *          <load> exp.type.suffix()
     */

    /**
     *  value[[ Arithmetic : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          value[[exp3]]
     *          cg.convert(exp3.type, exp1.type)
     *          cg.arithmetic(exp1.operator)
     */

    /**
     *  value[[ Modulus : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          value[[exp3]]
     *          cg.convert(exp3.type, exp1.type)
     *          <mod>
     */

    /**
     *  value[[ Comparison : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          value[[exp3]]
     *          cg.comparison(exp1.operator)
     */

    /**
     *  value[[ Logical : exp1 -> exp2 exp3 ]] =
     *          value[[exp2]]
     *          value[[exp3]]
     *          cg.logical(exp1.operator)
     */

    /**
     *  value[[ UnaryMinus : exp1 -> exp2 ]] =
     *          <pushi 0>
     *          value[[exp2]]
     *          cg.convert(exp2.type, exp1.type)
     *          <subi>
     */

    /**
     *  value[[ UnaryNot : exp1 -> exp2 ]] =
     *          value[[exp2]]
     *          <not>
     */

    /**
     * value[[ Cast : exp1 -> type exp2 ]] =
     *          value[[exp2]]
     *          cg.convert(exp2.type, type)
     */
}
