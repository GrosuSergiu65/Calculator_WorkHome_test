package input_stage;

import static input_stage.calculator_containers.FillingOperatorStack.*;
import static input_stage.calculator_containers.FillingValueStack.addValueToStack;

public class CalculatorHearth {

    public static void setFillingContainers(String[] expression) {

        for (String nextToken : expression) {
            char character = nextToken.charAt(0);

        if(addValueToStack(character, nextToken)){continue;}
        addOperatorToStack(character);
        addOpenBracket(character);
        addCloseBracket(character);

        }
    }
}
