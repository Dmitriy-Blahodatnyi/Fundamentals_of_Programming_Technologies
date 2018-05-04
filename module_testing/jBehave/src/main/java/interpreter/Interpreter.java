package interpreter;

import antlr.classes.MatrixBaseVisitor;
import antlr.classes.MatrixParser;
import matrix.Matrix;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.MatrixParse;

import java.util.HashMap;

public class Interpreter extends MatrixBaseVisitor<Variable> {
    private HashMap<String, Variable> variables = new HashMap<>();

    public Variable visitRootRule(MatrixParser.RootRuleContext ctx) {
        return visit(ctx.input());
    }

    public Variable visitToSetVariable(MatrixParser.ToSetVariableContext ctx) {
        return visit(ctx.assignment());
    }

    public Variable visitExecuteExpression(MatrixParser.ExecuteExpressionContext ctx) {
        return visit(ctx.sum());
    }

    public Variable visitMakeAssignment(MatrixParser.MakeAssignmentContext ctx) {
        String text = ctx.ID().getText();
        variables.put(text, visit(ctx.sum()));
        return variables.get(text);
    }

    public Variable visitToMultiple(MatrixParser.ToMultipleContext ctx) {
        return visit(ctx.multiple());
    }

    public Variable visitMakePlus(MatrixParser.MakePlusContext ctx) {
        Variable var0 = visit(ctx.multiple());
        Variable var1 = visit(ctx.sum());
        if (var0.getType() != Matrix.class || var1.getType() != Matrix.class)
            throw new ParseCancellationException("Invalid type!!!");
        return new Variable<>(((Matrix) var0.getValue()).addMatrix((Matrix) var1.getValue()));
    }

    public Variable visitMakeMultiple(MatrixParser.MakeMultipleContext ctx) {
        Variable var0 = visit(ctx.multiple());
        Variable var1 = visit(ctx.inverse());
        if (var0.getType() == Matrix.class && var1.getType() == Double.class)
            return new Variable<>(((Matrix) var0.getValue()).multiply((Double) var1.getValue()));
        else if (var1.getType() == Matrix.class && var0.getType() == Double.class)
            return new Variable<>(((Matrix) var1.getValue()).multiply((Double) var0.getValue()));
        else
            return new Variable<>(((Matrix) var0.getValue()).multiply((Matrix) var1.getValue()));
    }

    public Variable visitToInverse(MatrixParser.ToInverseContext ctx) {
        return visit(ctx.inverse());
    }

    public Variable visitMakeInverse(MatrixParser.MakeInverseContext ctx) {
        Variable var = visit(ctx.inverse());
        if (var.getType() != Matrix.class)
            throw new ParseCancellationException("Operand should be matrix!!!");
        return new Variable<>(((Matrix) var.getValue()).findInvertibleMatrix());
    }

    public Variable visitToAtom(MatrixParser.ToAtomContext ctx) {
        return visit(ctx.atom());
    }

    public Variable visitMakeNumber(MatrixParser.MakeNumberContext ctx) {
        return new Variable<>(Double.parseDouble(ctx.NUMBER().toString()));
    }

    public Variable visitMakeMatrix(MatrixParser.MakeMatrixContext ctx) {
        return new Variable<>(MatrixParse.parse(ctx.MATRIX().toString()));
    }

    public Variable visitVariable(MatrixParser.VariableContext ctx) {
        Variable var = variables.get(ctx.ID().getText());
        if (var == null)
            throw new ParseCancellationException("Variable is not defined!!!");
        return var;
    }

    public Variable visitMakeBraces(MatrixParser.MakeBracesContext ctx) {
        return visit(ctx.sum());
    }
}