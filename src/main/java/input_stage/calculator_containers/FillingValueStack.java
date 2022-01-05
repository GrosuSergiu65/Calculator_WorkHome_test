package input_stage.calculator_containers;

import calculator_constructor.Calculator;

public class FillingValueStack {
    boolean isValueInStack = false;

    public boolean addValueToStack(Calculator calculator, char character, String nextToken){
        for(int index = 1; index<10; index++){
            if (character != '(' && character != ')' && character != '+' && character != '*' && character != '/'
                    && (nextToken.contains(String.valueOf(index)))){
                double value = Double.parseDouble(nextToken);
                calculator.getValueStack().push(value);
                return !isValueInStack;
            }
        }
    return isValueInStack;
    }
}
