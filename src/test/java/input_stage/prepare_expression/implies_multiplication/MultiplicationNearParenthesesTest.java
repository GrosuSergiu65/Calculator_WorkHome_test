package input_stage.prepare_expression.implies_multiplication;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MultiplicationNearParenthesesTest {

    @Test
    @DisplayName("Integration test of eliminate redundant parentheses and add multiply if needed")
    void putMultiplicationNearParentheses() {

        assertThat(MultiplicationNearParentheses
                .putMultiplicationNearParentheses(new String []{"3", "/", "(", "(",")","-3",")","/","3","(",")"}))
                .isEqualTo(new String[]{"3", "/", "(", "-3", ")", "/", "3"});
    }

}
