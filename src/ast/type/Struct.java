package ast.type;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class Struct extends AbstractASTNode implements Type{

    public List<RecordField> recordFields;


    public Struct(int line, int column, List<RecordField> recordFields) {
        super(line, column);

        this.recordFields = new ArrayList<>(recordFields);
    }
}
