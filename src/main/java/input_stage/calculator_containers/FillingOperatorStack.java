package input_stage.calculator_containers;

import calculator_constructor.Calculator;

import static operator_logic.IdentifyOperator.isOperator;

public class FillingOperatorStack extends ReleasingStacks {

    public void addOperatorToStack(Calculator calculator, char character) {
        if (isOperator(character)) {
            getReleasingValueStack(calculator, character);
            calculator.getOperatorStack().push(character);
        }
    }

    public void addOpenBracket(Calculator calculator, char character){
        if (character == '(') {
            calculator.getOperatorStack().push(character);
        }
    }

    public void addCloseBracket(Calculator calculator, char character){
        if (character == ')') {
            getReleasingOperatorStack(calculator);
            if (!calculator.getOperatorStack().empty() && calculator.getOperatorStack().peek() == '(') {
                calculator.getOperatorStack().pop();
            } else {
                System.out.println("Error: unbalanced parenthesis.");
                calculator.setError(true);
            }
        }
    }
}
