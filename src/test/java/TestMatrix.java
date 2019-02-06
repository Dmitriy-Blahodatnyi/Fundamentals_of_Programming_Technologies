import generation.GenerationTest;
import logger.TestLifecycleLogger;
import logger.TimeExecutionLogger;
import matrix.Matrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestMatrix implements TestLifecycleLogger, TimeExecutionLogger, GenerationTest {
    @Test
    @DisplayName("Testing method 'toString'!!!")
    void testToString() {
        var matrix = new Matrix(new double[][]{{1}, {11.2}, {3}});
        assertEquals(
                "MATRIX=" +
                        "{" +
                        " [ 1.00 ] " +
                        " [ 11.20 ] " +
                        " [ 3.00 ] " +
                        "}",
                matrix.toString()
        );
        matrix = new Matrix(new double[][]{{1, 45.5}, {11.2, 67.43}, {3, 0.34}});
        assertEquals(
                "MATRIX=" +
                        "{" +
                        " [ 1.00 45.50 ] " +
                        " [ 11.20 67.43 ] " +
                        " [ 3.00 0.34 ] " +
                        "}",
                matrix.toString()
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

    @Test
    @DisplayName("Testing method 'multiply by number'!!!")
    void testScalarMultiply() {
        var matrix = new double[][]{{1, 2, 3}, {3, 4, 5}};
        var finalMatrix = matrix;
        var finalMatrix1 = matrix;
        matrix = new double[][]{{1, 2, 3}, {3, 4, 5}, {9.8, 56.6, 78.7}};
        var finalMatrix2 = matrix;
        assertAll(
                "Assertion all of these examples: ",
                () -> assertArrayEquals(
                        new Array2DRowRealMatrix(finalMatrix)
                                .scalarMultiply(2)
                                .getData(),
                        new Matrix(finalMatrix)
                                .multiply(2)
                                .getMatrix()
                ),
                () -> assertArrayEquals(
                        new Array2DRowRealMatrix(finalMatrix1)
                                .scalarMultiply(0)
                                .getData(),
                        new Matrix(finalMatrix1)
                                .multiply(0)
                                .getMatrix()
                ),
                () -> assertArrayEquals(
                        new Array2DRowRealMatrix(finalMatrix2)
                                .scalarMultiply(-2.23)
                                .getData(),
                        new Matrix(finalMatrix2)
                                .multiply(-2.23)
                                .getMatrix()
                )
        );
    }

    @Test
    @DisplayName("Testing method 'multiply by matrix' failure!!!")
    void testMultiplyByMatrixException() {
        var aColumns = 3;
        var bRows = 2;
        assertEquals(
                "Count of columns: " + aColumns +
                        " of matrix-multiplicand IS NOT EQUAL TO count of rows: " + bRows +
                        " of matrix-multiplier => unable to multiply!!!",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Matrix(new double[][]
                                {{13.3, 45.6, 76.4}, {13.2, 56.5, 78.5}}
                        ).multiply(
                                new Matrix(new double[][]{
                                        {67.4}, {43.3}
                                })
                        )
                ).getMessage()
        );
    }

    @Test
    @DisplayName("Testing method 'multiply by matrix' success!!!")
    void testMultiplyByMatrixSuccess() {
        var multiplicand = new double[][]{
                {12.3, 56.45, 87.67},
                {52.87, 0, -64.24},
        };
        var multiplier = new double[][]{
                {14.87, 90.5},
                {-81.4, 76.56},
                {83.4, 71.12}
        };

        assertArrayEquals(
                new Array2DRowRealMatrix(multiplicand)
                        .multiply(new Array2DRowRealMatrix(multiplier))
                        .getData(),
                new Matrix(multiplicand)
                        .multiply(new Matrix(multiplier))
                        .getMatrix()
        );
    }

    @Test
    @DisplayName("Testing method 'addMatrix' failure!!!")
    void testAddMatrixException() {
        assertEquals("Unable to add matrices!!!",
                assertThrows(IllegalArgumentException.class,
                        () -> new Matrix(new double[][]{
                                {1, 2, 45},
                                {11.2, 48, 43.23},
                                {3, 2.1, 5.6}
                        }).addMatrix(
                                new Matrix(new double[][]{
                                        {1, 2, 45}, {11.2, 48, 43.23}
                                })
                        )
                ).getMessage());
    }

    @Test
    @DisplayName("Testing method 'addMatrix' success!!!")
    void testAddMatrixSuccess() {
        var augend = new double[][]{
                {12.3, 56.45, 87.67},
                {52.87, 0, -64.24},
        };
        var addend = new double[][]{
                {14.87, 90.5, -123.987},
                {-81.4, 76.56, 76.45}
        };

        assertArrayEquals(
                new Array2DRowRealMatrix(augend)
                        .add(new Array2DRowRealMatrix(addend))
                        .getData(),
                new Matrix(augend)
                        .addMatrix(new Matrix(addend))
                        .getMatrix()
        );
    }

    @Test
    @DisplayName("Testing method 'findInvertibleMatrix' failure!!!")
    void testInverseMatrixException() {
        assertAll(
                "Assertion all of these exceptions: ",
                () -> assertEquals(
                        "Only in square matrix determinant can be found!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2},
                                        {11.2, 48},
                                        {3, 2.1}
                                }).findInvertibleMatrix()
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The matrix is singular (degenerate) - вироджена",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2, 3},
                                        {4, 5, 6},
                                        {5, 7, 9}
                                }).findInvertibleMatrix()
                        ).getMessage()
                )
        );
    }

    @Test
    @DisplayName("Testing method 'findInvertibleMatrix' success!!!")
    void testInverseMatrixSuccess() {
        var matrix = new double[][]{
                {1.1, 34.65, 97.12},
                {0.3, 1.2, 4},
                {5.55, 6.56, 0.1}
        };
        RealMatrix realMatrix = new Array2DRowRealMatrix(matrix);

        matrix = new Matrix(matrix).findInvertibleMatrix().getMatrix();
        var real = new LUDecomposition(realMatrix).getSolver().getInverse().getData();
        for (var i = 0; i < matrix.length; i++)
            for (var j = 0; j < matrix[0].length; j++)
                assertEquals(real[i][j], matrix[i][j], 0.00000000000001d);
    }
}