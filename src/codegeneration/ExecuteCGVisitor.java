package codegeneration;

public class ExecuteCGVisitor extends DefaultCGVisitorImpl<ReturnSequenceDto, ReturnSequenceDto> {

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
     *  execute[[ VariableDefinition : vardefinition -> type ID ]] =
     *
     */
}
