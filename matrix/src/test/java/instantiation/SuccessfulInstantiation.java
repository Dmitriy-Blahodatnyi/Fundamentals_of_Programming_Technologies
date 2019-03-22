package instantiation;

import com.project.matrix.Matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class SuccessfulInstantiation {
    static void run() {
        var matrix = new double[][]{{1}, {11.2}, {3}};
        var mx = new Matrix(matrix);

        assertSame(matrix, mx.getMatrix());
        assertArrayEquals(matrix, mx.getMatrix());

        matrix = new double[][]{{1}};
        assertNotSame(matrix, mx.getMatrix());
        mx.setMatrix(matrix);
        assertArrayEquals(matrix, mx.getMatrix());
    }
}