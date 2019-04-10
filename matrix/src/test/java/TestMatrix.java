import addition.AdditionTest;
import com.project.logger.TestLifecycleLogger;
import com.project.logger.TimeExecutionLogger;
import com.project.matrix.Matrix;
import instantiation.InstantiationTest;
import inversion.InversionTest;
import multiplication.MultiplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class TestMatrix implements TestLifecycleLogger, TimeExecutionLogger,
        InstantiationTest, MultiplicationTest, AdditionTest, InversionTest {
    @Test
    @DisplayName("Testing method 'toString'!!!")
    void testToString() {
        assertEquals(
                "MATRIX={ [ 1.00 ]  [ 11.20 ]  [ 3.00 ] }",
                new Matrix(new double[][]{{1}, {11.2}, {3}}).toString()
        );
        assertEquals(
                "MATRIX={ [ 1.00 45.50 ]  [ 11.20 67.43 ]  [ 3.00 0.34 ] }",
                new Matrix(new double[][]{
                        {1, 45.5},
                        {11.2, 67.43},
                        {3, 0.34}
                }).toString()
        );
    }

    @Test
    @DisplayName("Testing method 'equals' failure!!!")
    void testEqualsMethodException() {
        var matrix = new Matrix(new double[][]{{1}, {11.2}, {3}});
        var matrix1 = new Matrix(new double[][]{{1}, {11.2}, {34.4}});
        assertNotSame(matrix, matrix1);
        assertNotEquals(matrix, matrix1);
        assertNotEquals(matrix, null);
        assertNotEquals(matrix, new Object());
        assertNotEquals(matrix, new Matrix(new double[][]{{1, 2}, {0, 0}}));
        assertNotEquals(matrix, new Matrix(new double[][]{{1}}));
    }

    @Test
    @DisplayName("Testing method 'equals' success!!!")
    void testEqualsMethodSuccess() {
        var matrix = new Matrix(new double[][]{{1}, {11.2}, {3}});
        var matrix1 = new Matrix(new double[][]{{1}, {11.2}, {3}});
        assertNotSame(matrix, matrix1);
        assertEquals(matrix, matrix1);
        assertEquals(matrix, matrix);
    }
}