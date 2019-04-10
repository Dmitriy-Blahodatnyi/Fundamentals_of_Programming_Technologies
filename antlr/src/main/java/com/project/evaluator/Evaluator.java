package com.project.evaluator;

import com.project.antlr.MatrixLexer;
import com.project.antlr.MatrixParser;
import com.project.interpreter.Interpreter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Evaluator {
    private Interpreter interpreter = new Interpreter();

    public String evaluate(String str) {
        return interpreter.visit(
                new MatrixParser(
                        new CommonTokenStream(
                                new MatrixLexer(CharStreams.fromString(str))
                        )
                ).input()
        ).toString();
    }
}