package input_stage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputStageTest {
    InputStage input;

    @BeforeEach
    void setUp(){
       input = new InputStage();
    }

    @ParameterizedTest
    @DisplayName("Testing the full functionality through prepared test Cases ")
    @CsvSource(value = {"-43(3-2)(3)(-4)23/23(-2) : -1032", "-3(3-3)(-3)3+3 : 3","1+1-1(-3) : 5"
    ,"-3+-2 : -5", "=1+(2-6)/4 : 0 ", "3(-3)3 : -27", "-3-3-3-3-3(-3)3-3-3--3*3/3*3*3 : 36"}, delimiter = ':')
    void shouldGetPrecedence(String expression, double expectedPrecedence) {

        assertThat(input.processInput(expression)).isEqualTo(expectedPrecedence);
    }
}