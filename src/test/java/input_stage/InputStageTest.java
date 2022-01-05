package input_stage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static display_result.DisplayResult.getResult;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputStageTest {

    @ParameterizedTest
    @DisplayName("Testing the full functionality through prepared test Cases ")
    @CsvSource(value = {"-43(3-2)(3)(-4)23/23(-2) : -1032", "-3(3-3)(-3)3+3 : 3"}, delimiter = ':')
    void shouldGetPrecedence(String expression, double expectedPrecedence) {
        InputStage.processInput(expression);
        double result = getResult();
        assertThat(result).isEqualTo(expectedPrecedence);
    }
}