package input_stage;

import calculator_constructor.CalculatorConstructor;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static display_result.DisplayResult.getResult;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputStageTest {

    @ParameterizedTest
    @DisplayName("Testing if the method correctly prioritizes the calculation ")
    @CsvSource({"-43(3-2)(3)(-4)23/23(-2), -1032", "-3(3-3)(-3)3+3,3",
            "=1+(2-6)/4,0", "-3-3-3-3-3--3-3-3-3--3*3/3*3*3,6", "!-3-3-3-3-3--3-3-3-3--3*3/3*3*3,6"})
    void shouldGetPrecedence(String expression, double expectedPrecedence) {
        InputStage.processInput(expression);
        double result = getResult();
        assertThat(result).isEqualTo(expectedPrecedence);

    }
}