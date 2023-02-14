package program.type;

import program.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class Record extends AbstractASTNode implements Type{

    public List<RecordField> recordFields;


    public Record(int line, int column, List<RecordField> recordFields) {
        super(line, column);

        this.recordFields = new ArrayList<>(recordFields);
    }
}
