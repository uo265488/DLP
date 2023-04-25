package codegeneration;

import ast.definition.VarDefinition;
import ast.expression.Arithmetic;
import ast.expression.Expression;
import ast.expression.Logic;
import ast.expression.Relational;
import ast.type.Char;
import ast.type.Int;
import ast.type.Real;
import ast.type.Type;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.DoubleAccumulator;

public class CodeGenerator {

    private int label = 0;
    private PrintWriter out;

    public CodeGenerator(String outputFilename, String sourceFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
        } catch (IOException e) {
            System.err.println("Error opening the file " + outputFilename);
            System.exit(-1);
        }
        this.source(sourceFilename);
    }

    public void source(String string_constant) {
        out.println("#source\t \"" + string_constant + "\"");
        out.println();
        out.flush();
    }

    //PUSH INSTRUCTIONS
    public void pushb(int ascii_code) {
        out.println("\tpushb\t" + ascii_code);
        out.flush();
    }

    public void pushAddress(int offset) {
        out.println("pusha " + offset);
        out.flush();
    }

    public void pushBp() {
        out.println("pushbp");
        out.flush();
    }

    public void push(char suffix, Object offset) {
        out.println("push" + suffix + " " + offset);
        out.flush();
    }

    public void load(char suffix) {
        out.println("load" + suffix);
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
        }
    }

    private void i2b() {
        out.println("i2b");
        out.flush();
    }

    private void f2i() {
        out.println("f2i");
        out.flush();
    }

    private void i2f() {
        out.println("i2f");
        out.flush();
    }

    private void b2i() {
        out.println("b2i");
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
        out.println("mod");
        out.flush();
    }

    public void logic(Logic logic) {
        switch (logic.operator) {
            case "&&":
                out.println("and");
                break;
            case "||":
                out.println("or");
                break;
        }
        out.flush();
    }

    public void relational(Relational relational) {
        switch(relational.operator) {
            case "==":
                out.println(relational.type instanceof Real ? "eqf" : "eq");
                break;
            case "<":
                out.println(relational.type instanceof Real ? "lt" : "ltf");
                break;
            case ">":
                out.println(relational.type instanceof Real ? "gt" : "gtf");
                break;
            case ">=":
                out.println(relational.type instanceof Real ? "ge" : "gef");
                break;
            case "<=":
                out.println(relational.type instanceof Real ? "le" : "lef");
                break;
            case "!=":
                out.println(relational.type instanceof Real ? "ne" : "nef");
                break;
        }
        out.flush();
    }


    public void sub(char i) {
        out.println("sub" + i);
        out.flush();
    }

    public void mul(char i) {
        out.println("mul" + i);
        out.flush();
    }
    public void div(char i) {
        out.println("div" + i);
        out.flush();
    }

    public void add(char i) {
        out.println("add" + i);
        out.flush();
    }

}
