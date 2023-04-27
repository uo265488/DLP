package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

import java.util.Objects;

public class RecordField extends AbstractTypeImpl {

    public Type type;
    public String name;
    public int offset;
    public RecordField(int line, int column, Type type, String name) {
        super(line, column);

        this.type = type;
        this.name = name;
    }
    @Override
    public String toString() {
        return "(" + type.toString() + " " + name + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordField that = (RecordField) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
