package ast.type;

import ast.AbstractASTNode;
import ast.definition.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    public Type returnType;
    public List<VarDefinition> parameters;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> parameters) {
        super(line, column);

        this.parameters = new ArrayList<>(parameters);
    }
}
