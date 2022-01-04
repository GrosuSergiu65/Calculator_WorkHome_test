package display_result;

import static calculator_constructor.CalculatorConstructor.getValueStack;
import static calculator_constructor.CalculatorConstructor.isError;

public class DisplayResult {

    public static void displayResult() {
        if (!isError()) {
            double result = getValueStack().peek();
            getValueStack().pop();
            System.out.print("The result is " + result);
        }
    }
}
