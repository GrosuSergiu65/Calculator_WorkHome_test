package display_result;

import static sarcina2.CalculatorConstructor.getValueStack;
import static sarcina2.CalculatorConstructor.isError;

public class DisplayResult {

    public static void displayResult() {
        if (!isError()) {
            double result = getValueStack().peek();
            getValueStack().pop();
            System.out.print("The result is " + result);
        }
    }
}
