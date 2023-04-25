package codegeneration;

import ast.definition.VarDefinition;
import ast.expression.ArrayAccess;
import ast.expression.FieldAccess;
import ast.expression.Variable;
import ast.type.Struct;

public class AddressCGVisitor extends DefaultCGVisitorImpl<Void, Void> {

    private CodeGenerator cg;
    private ValueCGVisitor valueCGVisitor;
    public AddressCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }
    public CodeGenerator getCodeGenerator() {
        return this.cg;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    /**
     *  address[[ Variable : exp -> ID ]] =
     *          if ( exp.definition.scope == 0) {
     *              <pusha > exp.type.offset
     *          } else {
     *              <push bp>
     *              <pushi > exp.definition.offset
     *              <addi >
     *          }
     */
    public Void visit(Variable variable, Void param) {
        if(variable.definition instanceof VarDefinition varDefinition){
            if(variable.definition.getScope() == 0) {    //For global variables
                cg.pushAddress(varDefinition.offset);
            } else {
                cg.pushBp();
                cg.push(variable.type.getSuffix(), varDefinition.offset);
                cg.add(variable.type.getSuffix());
            }
        }
        return null;
    }

    /**
     *  address[[ Indexing: exp1 -> exp2 exp3 ]] =
     *          address[[exp2]]
     *          value[[exp3]]
     *          <pushi > exp1.type.numberOfBytes()
     *          <muli>
     *          <addi>
     */
    public Void visit(ArrayAccess arrayAccess, Void param) {
        arrayAccess.array.accept(this, null);
        arrayAccess.position.accept(valueCGVisitor, null);
        cg.push('i', arrayAccess.type.getNumberOfBytes());
        cg.mul('i');
        cg.add('i');

        return null;
    }

    /**
     *   address[[ FieldAccess : exp1 -> exp2 ID ]] =
     *           address[[exp2]]
     *           <pushi > exp2.type.getRecordField(ID.value).offset()
     *           <addi> (check if OK)
     */
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.expression.accept(this, null);
        cg.push('i', ((Struct)(fieldAccess.expression.getType())).getRecordField(fieldAccess.fieldname).offset);
        cg.add('i');
        return null;
    }

}
