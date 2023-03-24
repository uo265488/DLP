package semantic;

import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;

import ast.expression.FunctionInvocation;
import ast.expression.Variable;
import ast.statement.IfElse;
import ast.statement.While;
import ast.type.ErrorType;
import errorhandler.ErrorHandler;
import symboltable.SymbolTable;

public class IdentificationVisitor extends DefaultVisitorImpl<Void, Void> {

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void TP) {
        symbolTable.insert(functionDefinition);
        symbolTable.set();
        //Should I check if the scope is 2?? that should be detected before but maybe to ensure...
        functionDefinition.type.accept(this, null);
        functionDefinition.body.stream().forEach(b -> b.accept(this, null));

        symbolTable.reset();
        return null;
    }

    @Override
    public Void visit(VarDefinition variableDefinition, Void TP) {
        symbolTable.insert(variableDefinition);

        variableDefinition.type.accept(this, null);
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void TP) {
        ifElse.condition.accept(this, null);
        symbolTable.set();
        ifElse.ifBody.stream().forEach(i -> i.accept(this, null));
        ifElse.elseBody.stream().forEach(e -> e.accept(this, null));
        symbolTable.reset();

        return null;
    }

    @Override
    public Void visit(While whileST, Void TP) {
        whileST.condition.accept(this, null);
        symbolTable.set();
        whileST.body.stream().forEach(b -> b.accept(this, null));
        symbolTable.reset();

        return null;
    }

    @Override
    public Void visit(Variable var, Void TP) {
        var.definition = symbolTable.find(var.name);
        if (var.definition == null)
            new ErrorType(var.getLine(), var.getColumn(), "Variable not found in the program. ");

        return null;
    }
}
