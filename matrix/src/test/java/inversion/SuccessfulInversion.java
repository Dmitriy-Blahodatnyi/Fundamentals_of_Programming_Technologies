package inversion;

import com.project.matrix.Matrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SuccessfulInversion {
    static void run() {
        var matrix = new double[][][]{
                {{1.1, 34.65, 97.12}, {0.3, 1.2, 4}, {5.55, 6.56, 0.1}},
                {{3, 4}, {2, 1}}
        };
        assertArrayEquals(
                new double[][]{{4.4}},
                new Matrix(new double[][]{{4.4}}).findInvertibleMatrix()
                        .getMatrix()
        );

        for (var doubles : matrix) {
            RealMatrix realMatrix = new Array2DRowRealMatrix(doubles);

            var inverted =
                    new Matrix(doubles).findInvertibleMatrix().getMatrix();
            var real = new LUDecomposition(realMatrix).getSolver()
                    .getInverse()
                    .getData();
            for (var i = 0; i < inverted.length; i++)
                for (var j = 0; j < inverted[0].length; j++)
                    assertEquals(
                            real[i][j],
                            inverted[i][j],
                            0.00000000000001d
                    );
        }
    }
}