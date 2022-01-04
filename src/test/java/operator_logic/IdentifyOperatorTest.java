package operator_logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IdentifyOperatorTest {

    @ParameterizedTest
    @DisplayName("Testing recognition of operand in function")
    @CsvSource({"+, TRUE", "-,TRUE", "/,TRUE", "*,TRUE", "!,FALSE", "2,FALSE", "x,FALSE"})
    void isOperator(char receivedPrecedence, boolean expectedPrecedence) {
        boolean isValid = IdentifyOperator.isOperator(receivedPrecedence);
        assertThat(isValid).isEqualTo(Boolean.valueOf(expectedPrecedence));
    }
}