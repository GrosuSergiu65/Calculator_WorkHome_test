package input_stage;

import calculator_constructor.Calculator;
import display_result.DisplayResult;
import input_stage.calculator_containers.ReleasingStacks;
import input_stage.prepare_expression.PrepareExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class InputStageTest {

    @ParameterizedTest
    @DisplayName("Testing the full functionality through prepared test Cases ")
    @CsvSource(value = {"-43(3-2)(3)(-4)23/23(-2) : -1032", "-3(3-3)(-3)3+3 : 3", "1+1-1(-3) : 5"}, delimiter = ':')
    void shouldGetPrecedence(String expression, double expectedPrecedence) {
        final PrepareExpression prepare = new PrepareExpression();
        final DisplayResult displayResult = new DisplayResult();
         final Stack<Character> operatorStack = new Stack<>();
         final Stack<Double> valueStack = new Stack<>();
        final ReleasingStacks releasingContainers = new ReleasingStacks();
         final CalculatorHearth calculatorHearth = new CalculatorHearth();
        InputStage pc = new InputStage();
        Calculator calculator = new Calculator(operatorStack,valueStack, false );


        pc.processInput(expression);
        String[] solution = prepare.expressionFactoryPrepare(expression);

        calculatorHearth.setFillingContainers(calculator, solution);
        releasingContainers.getReleasingOperatorStack(calculator);
        displayResult.displayResult(calculator);

        assertThat(displayResult.getResult()).isEqualTo(expectedPrecedence);
    }
}