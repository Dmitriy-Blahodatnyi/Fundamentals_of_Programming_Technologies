import FSM.StateFSM;
import FSM.SwitchFSM;
import FSM.TransTableFSM;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestFSM {
    private static SwitchFSM switchFSM;
    private static TransTableFSM transTableFSM;
    private static StateFSM stateFSM;

    @BeforeAll
    static void init() {
        switchFSM = new SwitchFSM();
        transTableFSM = new TransTableFSM();
        stateFSM = new StateFSM();
    }

    static class FSMProvider implements ArgumentsProvider {
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(null, false),
                    Arguments.of("", false),
                    Arguments.of(" ", false),
                    Arguments.of("_132##%", true),
                    Arguments.of("_1#&AXSDCFVGB%", true),
                    Arguments.of("-132##%", false),
                    Arguments.of("_#&% ", false),
                    Arguments.of("_88888888888888888888#&AAAAAAAAAAAAAAAAAAAAA%", true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(FSMProvider.class)
    void TestFSMScanWithMyArguments(String str, boolean res) {
        assertAll(
                "Testing FSMScan with my arguments!!!",
                () -> assertEquals(res, switchFSM.scan(str)),
                () -> assertEquals(res, transTableFSM.scan(str)),
                () -> assertEquals(res, stateFSM.scan(str))
        );
    }

    private static Stream<String> provideCorrectString() {
        return Stream.of(
                "_67483920#&%",
                "_00##TTTTTT%"
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "_11111#&TOLIK%",
            "_8##RRRRRRRRRRRRRRRRRRZZZZZZZZ%"
    })
    @MethodSource("provideCorrectString")
    @CsvFileSource(resources = "CorrectStrings.csv")
    void TestFSMScanCorrect(String str) {
        assertAll(
                "Test FSMScan with correct strings!!!",
                () -> assertTrue(switchFSM.scan(str)),
                () -> assertTrue(transTableFSM.scan(str)),
                () -> assertTrue(stateFSM.scan(str))
        );
    }

    private static Stream<String> provideInCorrectString() {
        return Stream.of(
                "_______%",
                "_##&"
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "_#&#&#&#&#&#&",
            "_%"
    })
    @MethodSource("provideInCorrectString")
    @CsvFileSource(resources = "InCorrectStrings.csv")
    void TestFSMScanInCorrectStrings(String str) {
        assertAll(
                "Test FSMScan with incorrect strings!!!",
                () -> assertFalse(switchFSM.scan(str)),
                () -> assertFalse(transTableFSM.scan(str)),
                () -> assertFalse(stateFSM.scan(str))
        );
    }
}