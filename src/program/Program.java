package program;

import program.definition.Definition;

import java.util.List;

public class Program extends AbstractASTNode {


    public List<Definition> definitionList;

    public Program(int line, int column, List<Definition> definitionList) {
        super(line, column);

        this.definitionList = definitionList;
    }
}
