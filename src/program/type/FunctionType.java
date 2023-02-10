package program.type;

import program.AbstractASTNode;
import program.definition.VariableDefinition;

import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    public Type returnType;
    public List<VariableDefinition> parameters;

    public FunctionType(int line, int column, Type returnType, List<VariableDefinition> parameters) {
        super(line, column);
    }
}
