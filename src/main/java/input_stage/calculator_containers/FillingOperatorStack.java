package input_stage.calculator_containers;

import static calculator_constructor.CalculatorConstructor.*;
import static input_stage.calculator_containers.ReleasingContainers.getReleasingValueContainer;
import static operator_logic.IdentifyOperator.isOperator;


public class FillingOperatorStack {
static boolean isOperatorInStack;

    public static boolean addOperatorToStack(char character) {
        if (isOperator(character)) {
            getReleasingValueContainer(character);
            getOperatorStack().push(character);
            return !isOperatorInStack;
        }
        return isOperatorInStack;
    }

    public static boolean addOpenBracket(char character){
        if (character == '(') {
            getOperatorStack().push(character);
            return !isOperatorInStack;
        }
        return isOperatorInStack;
    }

    public static boolean addCloseBracket(char character){
        if (character == ')') {
            ReleasingContainers.getReleasingOperatorContainer();
            if (!getOperatorStack().empty() && getOperatorStack().peek() == '(') {
                getOperatorStack().pop();
            } else {
                System.out.println("Error: unbalanced parenthesis.");
                setError(true);
            }
        }
        return isOperatorInStack;
    }
}
