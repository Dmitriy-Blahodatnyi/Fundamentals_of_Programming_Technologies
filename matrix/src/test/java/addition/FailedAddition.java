package addition;

import com.project.matrix.Matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FailedAddition {
    static void run() {
        assertAll(
                "Assertion of addition exceptions: ",
                () -> assertEquals(
                        "Unable to add matrices!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2, 45},
                                        {11.2, 48, 43.23},
                                        {3, 2.1, 5.6}
                                }).addMatrix(new Matrix(new double[][]{
                                        {1, 2, 45},
                                        {11.2, 48, 43.23}
                                }))
                        ).getMessage()
                ),
                () -> assertEquals(
                        "Unable to add matrices!!!",
                        assertThrows(
                                IllegalArgumentException.class,
                                () -> new Matrix(new double[][]{
                                        {1, 2, 45},
                                        {11.2, 48, 43.23},
                                }).addMatrix(new Matrix(new double[][]{
                                        {1, 2, 45, 0},
                                        {11.2, 48, 43.23, -0.1}
                                }))
                        ).getMessage()
                )
        );
    }
}