package input_stage;

import static display_result.DisplayResult.displayResult;
import static input_stage.CalculatorHearth.setFillingContainers;
import static input_stage.calculator_containers.ReleasingContainers.getReleasingOperatorContainer;
import static input_stage.prepare_expression.prepareExpression.expressionFactoryPrepare;

public class InputStage {

    static String[] expression;

    public static void processInput(String input) {

        expression = expressionFactoryPrepare(input);
        setFillingContainers(expression);
        getReleasingOperatorContainer();
        displayResult();
    }
}
