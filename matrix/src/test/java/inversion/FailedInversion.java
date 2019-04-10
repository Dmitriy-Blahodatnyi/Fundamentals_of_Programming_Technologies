package inversion;

import com.project.matrix.Matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FailedInversion {
    static void run() {
        assertAll(
                "Assertion of inversion exceptions: ",
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
                        "The matrix is singular (degenerate) - вироджена!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2, 3},
                                        {4, 5, 6},
                                        {5, 7, 9}
                                }).findInvertibleMatrix()
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The matrix is singular (degenerate) - вироджена!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{{0}})
                                        .findInvertibleMatrix()
                        ).getMessage()
                )
        );
    }
}