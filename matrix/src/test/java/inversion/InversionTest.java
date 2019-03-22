package inversion;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public interface InversionTest {
    @TestFactory
    default Collection<DynamicTest> dynamicInversionTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Testing method 'findInvertibleMatrix' failure!!!",
                        FailedInversion::run
                ),
                DynamicTest.dynamicTest(
                        "Testing method 'findInvertibleMatrix' success!!!",
                        SuccessfulInversion::run
                )
        );
    }
}