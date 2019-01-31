package evaluator;

import antlr.classes.MatrixLexer;
import antlr.classes.MatrixParser;
import interpreter.Interpreter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Evaluator {
    private Interpreter interpreter = new Interpreter();

    public String evaluate(String str) {
        return interpreter
                .visit(
                        new MatrixParser(
                                new CommonTokenStream(
                                        new MatrixLexer(CharStreams.fromString(str))
                                )
                        ).input()).toString();
    }
}