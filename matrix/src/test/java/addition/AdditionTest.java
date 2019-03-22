package addition;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public interface AdditionTest {
    @TestFactory
    default Collection<DynamicTest> dynamicAdditionTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Testing method 'addMatrix' failure!!!",
                        FailedAddition::run
                ),
                DynamicTest.dynamicTest(
                        "Testing method 'addMatrix' success!!!",
                        SuccessfulAddition::run
                )
        );
    }
}