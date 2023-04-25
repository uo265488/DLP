package codegeneration;

public class ExecuteCGVisitor extends DefaultCGVisitorImpl<ReturnSequenceDto, ReturnSequenceDto> {

    /**
     *  execute[[ VariableDefinition : vardefinition -> type ID ]] =
     *          if( vardefinition.scope() == 0) {
     *
     *          }
     *
     */

    /**
     *  execute[[ Read : stmnt -> exp ]] =
     *          address[[exp]]
     *          <in> exp.type.sufix()
     *          <store> exp.type.suffix()
     */

    /**
     *  execute[[ Write : stmnt -> exp ]] =
     *          value[[exp]]
     *          <out> exp.type.sufix()
     */

    /**
     *  execute[[ Assignment : exp1 -> exp2 exp3 ]] =
     *          address[[exp2]]
     *          value[[exp3]]
     *          <store> exp1.type.suffix()
     */



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
     *
     */
}
