package instantiation;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public interface InstantiationTest {
    @TestFactory
    default Collection<DynamicTest> dynamicConstructorTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Matrix failed instantiation check!!!",
                        FailedInstantiation::run
                ),
                DynamicTest.dynamicTest(
                        "Matrix successful instantiation check!!!",
                        SuccessfulInstantiation::run
                )
        );
    }
}