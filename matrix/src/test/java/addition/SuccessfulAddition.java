package addition;

import com.project.matrix.Matrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SuccessfulAddition {
    static void run() {
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
}