package input_stage;

import calculator_constructor.Calculator;
import display_result.DisplayResult;
import input_stage.calculator_containers.ReleasingStacks;
import input_stage.prepare_expression.PrepareExpression;

import java.util.Stack;

public class InputStage {
    private final PrepareExpression prepare = new PrepareExpression();
    private final ReleasingStacks releasingContainers = new ReleasingStacks();
    private final CalculatorHearth calculatorHearth = new CalculatorHearth();
    private final DisplayResult displayResult = new DisplayResult();
    private final Stack<Character> operatorStack = new Stack<>();
    private final Stack<Double> valueStack = new Stack<>();

    public void processInput(String input) {
        String[] expression = prepare.expressionFactoryPrepare(input);

        Calculator calculator = new Calculator(operatorStack,valueStack, false);

        calculatorHearth.setFillingContainers(calculator, expression);
        releasingContainers.getReleasingOperatorStack(calculator);
        displayResult.displayResult(calculator);
    }
}
