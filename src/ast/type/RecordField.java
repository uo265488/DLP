package ast.type;

import ast.AbstractASTNode;

public class RecordField extends AbstractASTNode implements Type{

    public Type type;
    public String name;
    public RecordField(int line, int column, Type type, String name) {
        super(line, column);

        this.type = type;
        this.name = name;
    }
    @Override
    public String toString() {
        return "RecordField -> " + type.toString() + " Name: " + name ;
    }

}
