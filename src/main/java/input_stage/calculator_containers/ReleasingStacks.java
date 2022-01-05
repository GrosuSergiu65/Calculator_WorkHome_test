package input_stage.calculator_containers;

import calculator_constructor.Calculator;
import operator_logic.StageOperator;

import static operator_logic.GetPrecedence.getPrecedence;
import static operator_logic.IdentifyOperator.isOperator;


public class ReleasingStacks extends StageOperator {

    public void getReleasingOperatorStack(Calculator calculator) {

        while (!calculator.getOperatorStack().empty() && isOperator(calculator.getOperatorStack().peek())) {
            char toProcess = calculator.getOperatorStack().peek();
            calculator.getOperatorStack().pop();
            stageOperator(calculator, toProcess, calculator.getValueStack());
        }
    }

    public void getReleasingValueStack(Calculator calculator, char character) {
        if (!calculator.getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(calculator.getOperatorStack().peek())) {
            while (!calculator.getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(calculator.getOperatorStack().peek())) {
                char toProcess = calculator.getOperatorStack().pop();
                stageOperator(calculator, toProcess, calculator.getValueStack());
            }
        }
    }
}
