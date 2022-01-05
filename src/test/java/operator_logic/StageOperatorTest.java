package operator_logic;

import calculator_constructor.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StageOperatorTest extends StageOperator {
    Stack<Character> operatorStack;
    Stack<Double> valueStack;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
        calculator = new Calculator(operatorStack, valueStack, false);
    }

    @ParameterizedTest
    @DisplayName("Testing the functionality of popping an operand and an operator from the stack, and their successful calculation ")
    @CsvSource({"+, 13.0", "-,1.4000000000000004", "/,1.2413793103448276", "*, 41.76", "!, 0"})
    void stageOperator(char operator, double expectedResult) {

        operatorStack.push(operator);

        valueStack.push(7.2);
        valueStack.push(5.8);

        char toProcess = operatorStack.pop();

        stageOperator(calculator, toProcess, calculator.getValueStack());
        double result = valueStack.peek();
        assertThat(result).isEqualTo(expectedResult);

    }
}