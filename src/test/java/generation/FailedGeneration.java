package generation;

import matrix.Matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FailedGeneration {
    static void run() {
        assertAll(
                "Assertion all of these exceptions: ",
                () -> assertEquals(
                        "The matrix is null!!!",
                        assertThrows(
                                NullPointerException.class,
                                () -> new Matrix(null)
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The matrix is empty or has empty row(s)!!!",
                        assertThrows(
                                IllegalStateException.class,
                                () -> new Matrix(new double[][]{})
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The matrix is empty or has empty row(s)!!!",
                        assertThrows(
                                IllegalStateException.class,
                                () -> new Matrix(new double[][]{{}, {}, {}})
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The matrix is empty or has empty row(s)!!!",
                        assertThrows(
                                IllegalStateException.class,
                                () -> new Matrix(new double[][]{
                                        {},
                                        {1, 2},
                                        {3, 4.56}
                                })
                        ).getMessage()
                ),
                () -> assertEquals(
                        "The 2-dimensional array is not a matrix!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2, 3},
                                        {2},
                                        {1}
                                })
                        ).getMessage()
                )
        );
    }
}