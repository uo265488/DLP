package ast.type;

import ast.ASTNode;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Struct extends AbstractTypeImpl {

    public List<RecordField> recordFields;


    public Struct(int line, int column, List<RecordField> recordFields) {
        super(line, column);

        setRecordFields(recordFields);
    }

    private void setRecordFields(List<RecordField> recordFields) {
        this.recordFields = new ArrayList<>();
        for(RecordField f : recordFields) {
            if(this.recordFields.contains(f)) {
                new ErrorType(f.getLine(), f.getColumn(), "Duplicated variable -> " + f.name);
            } else {
                this.recordFields.add(f);
            }
        }
    }
    @Override
    public String toString() {
        return "Struct {\n\t" + recordFields.stream().map(s -> s.toString()).reduce((j, k) -> j + ", " + k)  ;
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }

    @Override
    public Type dot(String fieldName, ASTNode astNode) {
        for (RecordField rf : recordFields) {
            if(rf.name.equals(fieldName))
                return rf.type;
        }
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "No recordField with such name: " + fieldName);
    }

    @Override
    public int getNumberOfBytes() {
        return recordFields.stream().map(r -> r.type.getNumberOfBytes()).reduce((n1, n2) -> n1 + n2).get();
    }

    public RecordField getRecordField(String fieldname) {
        RecordField recordField = null;
        for (RecordField rf : recordFields) {
            if(rf.name.equals(fieldname)) {
                recordField = rf;
            }
        }
        return recordField;
    }
}
