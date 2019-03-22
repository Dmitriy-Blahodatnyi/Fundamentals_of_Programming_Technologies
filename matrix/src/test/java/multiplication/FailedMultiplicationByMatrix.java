package multiplication;

import com.project.matrix.Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FailedMultiplicationByMatrix {
    static void run() {
        var aColumns = 3;
        var bRows = 2;
        assertEquals(
                "Count of columns: " +
                        aColumns +
                        " of matrix-multiplicand IS NOT EQUAL TO count of rows: " +
                        bRows +
                        " of matrix-multiplier => unable to multiply!!!",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Matrix(new double[][]{
                                {13.3, 45.6, 76.4},
                                {13.2, 56.5, 78.5}
                        }).multiply(
                                new Matrix(new double[][]{
                                        {67.4},
                                        {43.3}
                                })
                        )
                ).getMessage()
        );
    }
}