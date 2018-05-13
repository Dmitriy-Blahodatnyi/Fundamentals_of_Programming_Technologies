import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestReverseString {
    static class StringProvider implements ArgumentsProvider {
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("123", "321"),
                    Arguments.of("__12__", "__21__"),
                    Arguments.of("Hoha", "ahoH"),
                    Arguments.of("AAAAA", "AAAAA"),
                    Arguments.of("KOKO", "OKOK"),
                    Arguments.of("", ""),
                    Arguments.of(" ", " ")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(StringProvider.class)
    void testReverseStringRight(String str, String res) {
        assertEquals(res, StringReverse.reverse(str));
    }
}