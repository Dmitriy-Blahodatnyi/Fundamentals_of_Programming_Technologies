package multiplication;

import com.project.matrix.Matrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplicationByNumber {
    static void run() {
        var matrix = new double[][]{{1, 2, 3}, {3, 4, 5}};
        var finalMatrix = matrix;
        var finalMatrix1 = matrix;
        matrix = new double[][]{{1, 2, 3}, {3, 4, 5}, {9.8, 56.6, 78.7}};
        var finalMatrix2 = matrix;
        assertAll(
                "Assertion of multiplication exceptions: ",
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
}