package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Struct extends AbstractASTNode implements Type{

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
}
