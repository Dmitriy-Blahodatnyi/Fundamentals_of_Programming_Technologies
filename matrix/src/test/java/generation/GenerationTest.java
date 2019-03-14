package generation;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public interface GenerationTest {
    @TestFactory
    default Collection<DynamicTest> dynamicConstructorTests() {
        return Arrays.asList(
                dynamicTest(
                        "Matrix failed generation check!!!",
                        FailedGeneration::run
                ),
                dynamicTest(
                        "Matrix successful generation check!!!",
                        SuccessfulGeneration::run
                )
        );
    }
}