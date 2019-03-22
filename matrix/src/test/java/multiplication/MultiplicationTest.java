package multiplication;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public interface MultiplicationTest {
    @TestFactory
    default Collection<DynamicTest> dynamicMultiplicationTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Testing method 'multiply(Matrix mtr)' failure!!!",
                        FailedMultiplicationByMatrix::run
                ),
                DynamicTest.dynamicTest(
                        "Testing method 'multiply(Matrix mtr)' success!!!",
                        SuccessfulMultiplicationByMatrix::run
                ),
                DynamicTest.dynamicTest(
                        "Testing method 'multiply(double number)'!!!",
                        MultiplicationByNumber::run
                )
        );
    }
}