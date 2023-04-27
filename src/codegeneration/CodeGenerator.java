package codegeneration;

import ast.expression.Arithmetic;
import ast.expression.Logic;
import ast.expression.Relational;
import ast.type.Char;
import ast.type.Int;
import ast.type.Real;
import ast.type.Type;

import java.io.IOException;
import java.io.PrintWriter;

public class CodeGenerator {

    private int label = 0;
    private PrintWriter out;

    public CodeGenerator(String sourceFilename, String outputFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
        } catch (IOException e) {
            System.err.println("Error opening the file " + outputFilename);
            System.exit(-1);
        }
        this.source(sourceFilename);
    }

    public void source(String source) {
        out.println();
        out.println("#source\t \"" + source + "\"");
        out.println();
        out.flush();
    }


    public void line(int line) {
        out.println();
        out.println("#line\t" + line);
        out.flush();
    }

    public void comment(String comment) {
        out.println("\t' * \t" + comment);
        out.flush();

    }

    public void pushAddress(int offset) {
        out.println("\tpusha " + offset);
        out.flush();
    }

    public void pushBp() {
        out.println("\tpush\tbp");
        out.flush();
    }

    public void push(char suffix, int offset) {
        out.println("\tpush" + suffix + " " + offset);
        out.flush();
    }

    public void pushf(double offset) {
        out.println("\tpushf" + " " + offset);
        out.flush();
    }

    public void load(char suffix) {
        out.println("\tload" + suffix);
        out.flush();
    }

    public void convert(Type from, Type to) {
        if(from instanceof Char && to instanceof Int) {
            b2i();
        } if(from instanceof Int && to instanceof Real) {
            i2f();
        }if(from instanceof Real && to instanceof Int) {
            f2i();
        } if(from instanceof Int && to instanceof Char) {
            i2b();
        } if(from instanceof Char && to instanceof Real) {
            b2i();
            i2f();
        }
    }

    private void i2b() {
        out.println("\ti2b");
        out.flush();
    }

    private void f2i() {
        out.println("\tf2i");
        out.flush();
    }

    private void i2f() {
        out.println("\ti2f");
        out.flush();
    }

    private void b2i() {
        out.println("\tb2i");
        out.flush();
    }

    public void arithmetic(Arithmetic exp) {
        switch (exp.operator) {
            case "+":
                add(exp.getType().getSuffix());
                break;
            case "-":
                sub(exp.getType().getSuffix());
                break;
            case "*":
                mul(exp.getType().getSuffix());
                break;
            case "/":
                div(exp.getType().getSuffix());
                break;
        }
    }

    public void modulus() {
        out.println("\tmod");
        out.flush();
    }

    public void logic(Logic logic) {
        switch (logic.operator) {
            case "&&":
                out.println("\tand");
                break;
            case "||":
                out.println("\tor");
                break;
        }
        out.flush();
    }

    public void relational(Relational relational) {
        out.print("\t");
        switch(relational.operator) {
            case "==":
                out.println(relational.type instanceof Real ? "eqf" : "eq");
                break;
            case "<":
                out.println(relational.type instanceof Real ? "ltf" : "lti");
                break;
            case ">":
                out.println(relational.type instanceof Real ? "gtf" : "gti");
                break;
            case ">=":
                out.println(relational.type instanceof Real ? "gef" : "ge");
                break;
            case "<=":
                out.println(relational.type instanceof Real ? "lef" : "le");
                break;
            case "!=":
                out.println(relational.type instanceof Real ? "nef" : "ne");
                break;
        }
        out.flush();
    }


    public void sub(char i) {
        out.println("\tsub" + i);
        out.flush();
    }

    public void mul(char i) {
        out.println("\tmul" + i);
        out.flush();
    }
    public void div(char i) {
        out.println("\tdiv" + i);
        out.flush();
    }

    public void add(char i) {
        out.println("\tadd" + i);
        out.flush();
    }

    public void not() {
        out.println("\tnot ");
        out.flush();
    }

    public void in(char suffix) {
        out.println("\tin" + suffix);
        out.flush();
    }
    public void out(char suffix) {
        out.println("\tout" + suffix);
        out.flush();
    }

    public void store(char suffix) {
        out.println("\tstore" + suffix);
        out.flush();
    }

    public int nextLabel() {
        return label++;
    }

    public void putLabel(String label) {
        out.println("label" + label + ":");
        out.flush();
    }

    public void jz(String label) {
        out.println("\tjz label" + label);
        out.flush();
    }


    public void jmp(String conditionLabel) {
        out.println("\tjmp label" + conditionLabel);
    }

    public void enter(int offset) {
        out.println("\tenter\t" +  offset);
        out.flush();
    }

    public void ret(ReturnSequenceDto param) {
        out.println("\tret " + param.bytesReturn + ", "
                                + param.bytesLocals + ", "
                                + param.bytesParams);
        out.flush();
    }

    public void call(String functionName) {
        out.println("\tcall " + functionName);
        out.flush();
    }
    public void halt() {
        out.println("halt");
        out.println();
        out.println();
        out.flush();
    }

    public void pop(char suffix) {
        out.println("\tpop" + suffix);
        out.flush();
    }

    public void functionName(String name) {
        out.println("  " + name + ":");
        out.flush();
    }
}
