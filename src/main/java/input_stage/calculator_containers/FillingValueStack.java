package input_stage.calculator_containers;

import static calculator_constructor.CalculatorConstructor.getValueStack;

public class FillingValueStack {

    static boolean isValueInStack;

    public static boolean addValueToStack(char character, String nextToken){

        if (character != '(' && character != ')' && character != '+' && character != '*' && character != '/'
                && (nextToken.contains("1") || nextToken.contains("2") || nextToken.contains("3") || nextToken.contains("4")
                || nextToken.contains("5") || nextToken.contains("6") || nextToken.contains("7") || nextToken.contains("8")
                || nextToken.contains("9"))) {
            double value = Double.parseDouble(nextToken);
            getValueStack().push(value);
            return !isValueInStack;
        }
    return isValueInStack;
    }
}
