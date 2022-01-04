package input_stage.calculator_containers;

import static calculator_constructor.CalculatorConstructor.getOperatorStack;
import static calculator_constructor.CalculatorConstructor.getValueStack;
import static operator_logic.IdentifyOperator.isOperator;
import static operator_logic.StageOperator.stageOperator;

public class ReleasingContainers {

    public static void getReleasingContainers() {

        while (!getOperatorStack().empty() && isOperator(getOperatorStack().peek())) {
            char toProcess = getOperatorStack().peek();
            getOperatorStack().pop();
            stageOperator(toProcess, getValueStack());
        }
    }
}
