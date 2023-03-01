package ast;

import ast.definition.Definition;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {


    public List<Definition> definitionList;

    public Program(int line, int column, List<Definition> definitionList) {
        super(line, column);

        this.definitionList = new ArrayList(definitionList);
    }
}
