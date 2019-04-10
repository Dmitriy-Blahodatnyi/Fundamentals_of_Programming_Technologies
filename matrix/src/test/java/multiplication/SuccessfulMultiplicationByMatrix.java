package multiplication;

import com.project.matrix.Matrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SuccessfulMultiplicationByMatrix {
    static void run() {
        var multiplicand =
                new double[][]{{12.3, 56.45, 87.67}, {52.87, 0, -64.24},};
        var multiplier =
                new double[][]{{14.87, 90.5}, {-81.4, 76.56}, {83.4, 71.12}};

        assertArrayEquals(
                new Array2DRowRealMatrix(multiplicand).multiply(
                        new Array2DRowRealMatrix(multiplier)).getData(),
                new Matrix(multiplicand).multiply(
                        new Matrix(multiplier)).getMatrix()
        );
    }
}