package input;

import static display_result.DisplayResult.displayResult;
import static sarcina.StageOperator.stageOperator;
import static sarcina.GetPrecedence.getPrecedence;
import static sarcina.IdentifyOperator.isOperator;
import static sarcina.prepareExpression.expresionFactoryPrepare;
import static sarcina2.CalculatorConstructor.*;

public class InputStage {
    public static void processInput(String input) {

        String[] arr = expresionFactoryPrepare(input);

        for (String nextToken : arr) {
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

        while (!getOperatorStack().empty() && isOperator(getOperatorStack().peek())) {
            char toProcess = getOperatorStack().peek();
            getOperatorStack().pop();
            stageOperator(toProcess, getValueStack());
        }

        displayResult();
    }
}
