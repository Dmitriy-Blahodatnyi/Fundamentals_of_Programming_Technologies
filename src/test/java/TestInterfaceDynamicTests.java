import matrix.Matrix;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

interface TestInterfaceDynamicTests {
    @TestFactory
    default Collection<DynamicTest> dynamicTestsConstructorCheck() {
        return Arrays.asList(
                dynamicTest(
                        "matrix.Matrix failed generation check!!!",
                        () -> assertAll("Assertion all of these exceptions: ",
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
                        )
                ),
                dynamicTest(
                        "matrix.Matrix successful generation check!!!",
                        () -> {
                            var matrix = new double[][]{{1}, {11.2}, {3}};
                            var mx = new Matrix(matrix);

                            assertSame(matrix, mx.getMatrix());
                            assertArrayEquals(matrix, mx.getMatrix());

                            matrix = new double[][]{{1}};
                            assertNotSame(matrix, mx.getMatrix());
                            mx.setMatrix(matrix);
                            assertArrayEquals(matrix, mx.getMatrix());
                        })
        );
    }
}