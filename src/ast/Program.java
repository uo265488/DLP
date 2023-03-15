package ast;

import ast.definition.Definition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {


    public List<Definition> definitionList;

    public Program(int line, int column, List<Definition> definitionList) {
        super(line, column);

        this.definitionList = new ArrayList(definitionList);
    }

    @Override
    public String toString() {
        return "Program: \n " + definitionList.stream().map(def -> def.toString()).reduce((d, s) -> d + "\n\t" + s) ;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
