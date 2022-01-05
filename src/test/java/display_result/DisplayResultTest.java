package display_result;

import calculator_constructor.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DisplayResultTest {
    Stack<Character> operatorStack;
    Stack<Double> valueStack;
    Calculator calculator;

    @BeforeEach
    void setUp(){
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
    }


    @ParameterizedTest
    @DisplayName("Checking if the output works on the expected three options")
    @CsvSource({"7.2,7.2,True, True", "0,3, true, true", "132131231.321321321,0, false, true",
            "3213213132132131232131321.321312312312312312, 3213213132132131232131321.321312312312312312, false, true"})
    void shouldDisplayTrueOrFalse(double a, double b, boolean c, boolean expectedResult) {
        calculator = new Calculator(operatorStack, valueStack, c);
        DisplayResult displayResult = new DisplayResult();

        operatorStack.push('/');

        valueStack.push(a);
        valueStack.push(b);

        displayResult.displayResult(calculator);

        double output = displayResult.getResult();
        boolean result = true;
        if(Double.isNaN(output)){
            result = false;
        } else if(Double.isInfinite(output)){
            result = false;}

        assertThat(result).isEqualTo(expectedResult);

    }

    @ParameterizedTest
    @DisplayName("Checking if the output works on the expected three options with negative values")
    @CsvSource({"-1,-6,True, True", "-0.0,1, true, true", "132131231.321321321,-0, false, true",
            "3213213132132131232131321.321312312312312312, -3213213132132131232131321.321312312312312312, false, true"})
    void shouldDisplayNegativeValues(double a, double b, boolean c, boolean expectedResult) {
        calculator = new Calculator(operatorStack, valueStack, c);
        DisplayResult displayResult = new DisplayResult();

        operatorStack.push('-');

        valueStack.push(a);
        valueStack.push(b);

        displayResult.displayResult(calculator);

        double output = displayResult.getResult();
        boolean result = true;
        if(Double.isNaN(output)){
            result = false;
        } else if(Double.isInfinite(output)){
            result = false;}

        assertThat(result).isEqualTo(expectedResult);

    }
}