package ast.type;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.definition.VarDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractTypeImpl {

    public Type returnType;
    public List<VarDefinition> parameters;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> parameters) {
        super(line, column);

        this.parameters = new ArrayList<>(parameters);
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "FunctionType ->\n\treturnType: " + returnType + " (" +
                parameters.stream().map(s -> s.toString()).reduce((j, k) -> j + ", " + k) ;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }

    @Override
    public Type parenthesis(List<Type> types, ASTNode astNode) {
        if(types.size() != parameters.size()) return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Number of arguments doesnt match the number of parameters. ");
        int accumulator = 0;
        for(VarDefinition varDefinition : this.parameters) {
            if(!varDefinition.type.getClass().equals(types.get(accumulator).getClass())) {
                return new ErrorType(types.get(accumulator).getLine(), types.get(accumulator).getColumn(),
                        "Argument type doesnt match parameter type for argument in position " + accumulator);
            }
            accumulator++;
        }
        return returnType; // IS THIS TRUE??????
    }
}
