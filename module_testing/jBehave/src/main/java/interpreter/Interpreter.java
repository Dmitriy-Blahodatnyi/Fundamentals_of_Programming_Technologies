package interpreter;

import antlr.classes.MatrixBaseVisitor;
import antlr.classes.MatrixParser;
import matrix.Matrix;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.MatrixParse;

import java.util.HashMap;

public class Interpreter extends MatrixBaseVisitor<Object> {
    private HashMap<String, Object> variables = new HashMap<>();

    public Object visitRootRule(MatrixParser.RootRuleContext ctx) {
        return visit(ctx.input());
    }

    public Object visitToSetVariable(MatrixParser.ToSetVariableContext ctx) {
        return visit(ctx.assignment());
    }

    public Object visitExecuteExpression(MatrixParser.ExecuteExpressionContext ctx) {
        return visit(ctx.sum());
    }

    public Object visitMakeAssignment(MatrixParser.MakeAssignmentContext ctx) {
        var text = ctx.ID().getText();
        variables.put(text, visit(ctx.sum()));
        return variables.get(text);
    }

    public Object visitToMultiple(MatrixParser.ToMultipleContext ctx) {
        return visit(ctx.multiple());
    }

    public Object visitMakePlus(MatrixParser.MakePlusContext ctx) {
        var var0 = visit(ctx.multiple());
        var var1 = visit(ctx.sum());
        return var0.getClass() != Matrix.class || var1.getClass() != Matrix.class ?
                new ParseCancellationException("Invalid type!!!") :
                ((Matrix) var0).addMatrix((Matrix) var1);
    }

    public Object visitMakeMultiple(MatrixParser.MakeMultipleContext ctx) {
        var var0 = visit(ctx.multiple());
        var var1 = visit(ctx.inverse());
        return var0.getClass() == Matrix.class && var1.getClass() == Double.class ?
                ((Matrix) var0).multiply((Double) var1) :
                var1.getClass() == Matrix.class && var0.getClass() == Double.class ?
                        ((Matrix) var1).multiply((Double) var0) :
                        ((Matrix) var0).multiply((Matrix) var1);
    }

    public Object visitToInverse(MatrixParser.ToInverseContext ctx) {
        return visit(ctx.inverse());
    }

    public Object visitMakeInverse(MatrixParser.MakeInverseContext ctx) {
        return visit(ctx.inverse()).getClass() != Matrix.class ?
                new ParseCancellationException("Operand should be matrix!!!") :
                ((Matrix) visit(ctx.inverse())).findInvertibleMatrix();
    }

    public Object visitToAtom(MatrixParser.ToAtomContext ctx) {
        return visit(ctx.atom());
    }

    public Object visitMakeNumber(MatrixParser.MakeNumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().toString());
    }

    public Object visitMakeMatrix(MatrixParser.MakeMatrixContext ctx) {
        return MatrixParse.parse(ctx.MATRIX().toString());
    }

    public Object visitVariable(MatrixParser.VariableContext ctx) {
        var var = variables.get(ctx.ID().getText());
        return var == null ? new ParseCancellationException("Variable is not defined!!!") : var;
    }

    public Object visitMakeBraces(MatrixParser.MakeBracesContext ctx) {
        return visit(ctx.sum());
    }
}