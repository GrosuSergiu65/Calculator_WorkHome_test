package input_stage.calculator_containers;

import static calculator_constructor.CalculatorConstructor.*;
import static operator_logic.GetPrecedence.getPrecedence;
import static operator_logic.IdentifyOperator.isOperator;
import static operator_logic.StageOperator.stageOperator;

public class FillingContainers {

    public static void setFillingContainers(String[] expression) {

        for (String nextToken : expression) {
            char character = nextToken.charAt(0);

            if (character != '(' && character != ')' && character != '+' && character != '*' && character != '/'
                    && (nextToken.contains("1") || nextToken.contains("2") || nextToken.contains("3") || nextToken.contains("4")
                    || nextToken.contains("5") || nextToken.contains("6") || nextToken.contains("7") || nextToken.contains("8")
                    || nextToken.contains("9"))) {
                double value = Double.parseDouble(nextToken);
                getValueStack().push(value);
            } else if (isOperator(character)) {
                if (!getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(getOperatorStack().peek())) {
                    while (!getOperatorStack().empty() && getPrecedence(character) <= getPrecedence(getOperatorStack().peek())) {
                        char toProcess = getOperatorStack().peek();
                        getOperatorStack().pop();
                        stageOperator(toProcess, getValueStack());
                    }
                }
                getOperatorStack().push(character);
            } else if (character == '(') {
                getOperatorStack().push(character);
            } else if (character == ')') {
                while (!getValueStack().empty() && isOperator(getOperatorStack().peek())) {
                    char toProcess = getOperatorStack().peek();
                    getOperatorStack().pop();
                    stageOperator(toProcess, getValueStack());
                }
                if (!getOperatorStack().empty() && getOperatorStack().peek() == '(') {
                    getOperatorStack().pop();
                } else {
                    System.out.println("Error: unbalanced parenthesis.");
                    setError(true);
                }
            }
        }
    }
}
