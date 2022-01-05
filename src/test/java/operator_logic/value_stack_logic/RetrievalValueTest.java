package operator_logic.value_stack_logic;

import calculator_constructor.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RetrievalValueTest {
    Calculator calculator;
    Stack<Double> testStack;

    @BeforeEach
    void setUp() {
        testStack = new Stack<>();
        calculator = new Calculator(new Stack<>(), new Stack<>(), false);
    }

    @Test
    @DisplayName("Verify if error switcher works fine in case the Stack is empty")
    void getErrorFromEmptyStack() {
        RetrievalValue.getValueFromStack(calculator, calculator.getValueStack());
        assertThat(calculator.isError()).isEqualTo(true);
    }

    @Test
    @DisplayName("Verify if error switcher works fine in case the Stack is filled with value")
    void getErrorFromStack() {
        calculator.getValueStack().push(1.1);
        RetrievalValue.getValueFromStack(calculator, calculator.getValueStack());
        assertThat(calculator.isError()).isEqualTo(false);
    }

    @Test
    @DisplayName("Verify if error switcher works fine in case the Stack is filled with value")
    void getValueFromStack() {
        calculator.getValueStack().push(2.2);
        double result = RetrievalValue.getValueFromStack(calculator, calculator.getValueStack());

        assertThat(result).isEqualTo(2.2);
    }
}