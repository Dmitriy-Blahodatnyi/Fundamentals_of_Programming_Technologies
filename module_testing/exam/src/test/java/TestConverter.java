import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestConverter {
    static class StringProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(32, 0),
                    Arguments.of(98, 37),
                    Arguments.of(212, 100)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(StringProvider.class)
    void shouldConvertCelsiusToFahrenheit(int val, int value) {
        assertEquals(val, Converter.toFahrenheit(value));
    }

    @Test
    void shouldConvertFahrenheitToCelsius() {
        assertEquals(0, Converter.toCelsius(32));
        assertEquals(37, Converter.toCelsius(100));
        assertEquals(100, Converter.toCelsius(212));
    }
}