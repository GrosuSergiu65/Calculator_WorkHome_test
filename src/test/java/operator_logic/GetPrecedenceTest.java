package operator_logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class GetPrecedenceTest {

    @ParameterizedTest
    @DisplayName("TTesting if the method correctly prioritizes the calculation ")
    @CsvSource({"-, 1", "+,1", "/,2", "*,2", "!,0", "2,0", "x,0"})
    void shouldGetPrecedence(char receivedPrecedence, int expectedPrecedence) {
        int isValid = GetPrecedence.getPrecedence(receivedPrecedence);
        assertThat(isValid).isEqualTo(expectedPrecedence);

    }
}