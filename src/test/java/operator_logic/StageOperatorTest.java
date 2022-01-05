package operator_logic;

import calculator_constructor.Calculator;
import operator_logic.value_stack_logic.CalculateValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StageOperatorTest {

    @ParameterizedTest
    @DisplayName("Testing the functionality of popping an operand and an operator from the stack, and their successful calculation ")
    @CsvSource({"+, 13.0", "-,1.4000000000000004", "/,1.2413793103448276", "*, 41.76", "!, 0"})
    void stageOperator(char operator,  double expectedResult) {
        Stack<Character> stackOperator = new Stack<>();
        stackOperator.push(operator);

        Stack<Double> STACK = new Stack<>();
        STACK.push(7.2);
        STACK.push(5.8);

        StageOperator test = new StageOperator();
//
//        test.stageOperator(new Calculator(StageOperator, STACK)operator, STACK);
        double result = STACK.peek();
        assertThat(result).isEqualTo(expectedResult);

    }
}