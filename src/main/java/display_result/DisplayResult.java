package display_result;

import static calculator_constructor.CalculatorConstructor.getValueStack;
import static calculator_constructor.CalculatorConstructor.isError;

public class DisplayResult {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static double result;

    public static void displayResult() {
        if (!isError() || !getValueStack().isEmpty()) {

            result = getValueStack().peek();
            getValueStack().pop();
            System.out.print("The result is " +ANSI_RED+ result+ANSI_RESET);
        }
    }

    public static double getResult() {return result;}
}
