package codegeneration;

import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.Variable;
import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.RecordField;
import ast.type.Struct;
import semantic.DefaultVisitorImpl;

public class OffsetVisitor extends DefaultVisitorImpl<Void, Void> {

    int globalBytesSum = 0;

    /**
     * Global Variables:
     *
     * R: (1) VarDefinition : vardefinition -> type ID
     *
     * P: (1) globalBytesSum = 0; (As a global variable)
     *        if(vardefinition.scope == 0) {
     *            globalBytesSum += type.numberOfBytes;
     *            vardefinition.offset = globalBytesSum;
     *        }
     */
    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        if(varDefinition.scope == 0) {
            varDefinition.offset = globalBytesSum;
            globalBytesSum += varDefinition.type.getNumberOfBytes();

        }

        varDefinition.type.accept(this, null);
        return null;
    }

    /**
     * Local Variables:
     *
     * R: (1) FunctionDefinition : funcdefinition → type ID statement*
     *
     * P: (1) int localBytesSum = 0;
     *        for(Statement st : statement*) {
     *            if(st instanceof VarDefinition varDef) {
     *                localBytesSum += type.numberOfBytes;
     *                varDef.offset = localBytesSum;
     *            }
     *        }
     */
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        int localBytesSum = 0;
        for(int i = 0; i <= functionDefinition.body.size() - 1; i++) {
            Statement st = functionDefinition.body.get(i);
            if(st instanceof VarDefinition vd) {
                localBytesSum += vd.type.getNumberOfBytes();
                vd.offset = -localBytesSum;
            }
        }
        functionDefinition.type.accept(this, null);
        functionDefinition.body.forEach(f -> f.accept(this, null));

        return null;
    }

    /**
     * Parameters:
     *
     *    (2) FunctionType: type1 → type2 vardefinition*
     * P:
     *    (2) int paramBytesSum = 0;
     *        for(int i = vardefinition*.size() - 1; i > 0; i--) {
     *            VarDefintion vd = vardefinition*.get(i);
     *            vd.offset = paramByteSum + 4;
     *            paramBytesSum += vd.type.numberOfBytes();
     *        }
     *
     */
    public Void visit(FunctionType functionType, Void param) {
        int paramBytesSum = 0;
        for(int i = functionType.parameters.size() - 1; i >= 0; i--) {
            VarDefinition vd = functionType.parameters.get(i);
            vd.offset = paramBytesSum + 4;
            paramBytesSum += vd.type.getNumberOfBytes();
        }
        functionType.parameters.forEach(f -> f.accept(this, null));
        return null;
    }

     /**
     * RecordFields:
     *  R: (1) Struct: struct -> recordfield*
     *
     *  P: (1) int recordfieldBytesSum = 0;
     *         for(RecordField rf : recorfields*) {
     *             rf.offset = struct.offset + recordfieldBytesSum;
     *             recordfieldBytesSum += rf.type.numberOfBytes();
     *         }
     *
     */
     public Void visit(Struct struct, Void param) {
         int recordfieldBytesSum = 0;
         for(RecordField rf : struct.recordFields) {
             rf.offset = recordfieldBytesSum;
             recordfieldBytesSum += rf.type.getNumberOfBytes();
         }
         struct.recordFields.forEach(f -> f.accept(this, null));
         return null;
     }
}
