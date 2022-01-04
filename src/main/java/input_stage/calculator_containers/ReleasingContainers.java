package input_stage.calculator_containers;

import static calculator_constructor.CalculatorConstructor.getOperatorStack;
import static calculator_constructor.CalculatorConstructor.getValueStack;
import static operator_logic.GetPrecedence.getPrecedence;
import static operator_logic.IdentifyOperator.isOperator;
import static operator_logic.StageOperator.stageOperator;

public class ReleasingContainers {

    public static void getReleasingOperatorContainer() {

        while (!getOperatorStack().empty() && isOperator(getOperatorStack().peek())) {
            char toProcess = getOperatorStack().peek();
            getOperatorStack().pop();
            stageOperator(toProcess, getValueStack());
        }
    }

    public static void getReleasingValueContainer(char character) {
        if (!getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(getOperatorStack().peek())) {
            while (!getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(getOperatorStack().peek())) {
                char toProcess = getOperatorStack().peek();
                getOperatorStack().pop();
                stageOperator(toProcess, getValueStack());
            }
        }
    }
}
