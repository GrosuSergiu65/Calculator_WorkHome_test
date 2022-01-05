package input_stage.calculator_containers;


import calculator_constructor.Calculator;
import input_stage.CalculatorHearth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FillingOperatorStackTest {
    Calculator calculator;
    Stack<Double> valueStack;
    Stack<Character> operatorStack;
    CalculatorHearth calculatorHearth;
    String[] input;

    @BeforeEach
    void setUp() {
        calculatorHearth = new CalculatorHearth();
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
        calculator = new Calculator(operatorStack, valueStack, false);
        input = new String[1];
    }

    @ParameterizedTest
    @DisplayName("Checking that each element falls into the correct stack ")
    @CsvSource({"-, True", "+,True", "(, True", "),False", "13,True", "13.3,True", "!,False", "Y, False"})
    void setFillingContainers(String expression, boolean expectedResult) {

        input[0] = expression;
        calculatorHearth.setFillingContainers(calculator, input);

        boolean result = false;
        if (!calculator.getOperatorStack().isEmpty() || !calculator.getValueStack().isEmpty()) {

            result = true;

            if (!calculator.getValueStack().isEmpty()) {
                calculator.getValueStack().pop();
            }
            if (!calculator.getOperatorStack().isEmpty()) {
               calculator.getOperatorStack().pop();
            }
        }

        assertThat(result).isEqualTo(expectedResult);
    }
}