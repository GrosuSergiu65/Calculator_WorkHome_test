package input_stage;

import calculator_constructor.Calculator;
import input_stage.calculator_containers.FillingOperatorStack;
import input_stage.calculator_containers.FillingValueStack;


public class CalculatorHearth {
private final FillingValueStack stackValue = new FillingValueStack();
private final FillingOperatorStack stackOperator = new FillingOperatorStack();
    public void setFillingContainers(Calculator calculator, String[] expression) {

        for (String nextToken : expression) {
            char character = nextToken.charAt(0);

        if(stackValue.addValueToStack(calculator, character, nextToken)){continue;}
            stackOperator.addOperatorToStack(calculator, character);
            stackOperator.addOpenBracket(calculator, character);
            stackOperator.addCloseBracket(calculator, character);

        }
    }
}
