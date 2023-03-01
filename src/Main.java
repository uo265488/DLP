

import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) throws Exception {
        if (args.length<1) {
            System.err.println("Please, pass me the input file.");
            return;
        }

        // create a lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName(args[0]);
        CmmLexer lexer = new CmmLexer(input);

        // create a parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CmmParser parser = new CmmParser(tokens);

        Program ast = parser.program().ast;
        IntrospectorModel model=new IntrospectorModel("Program", ast);
        new IntrospectorView("Introspector", model);
    }
}
