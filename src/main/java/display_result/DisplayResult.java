package display_result;

import calculator_constructor.Calculator;
import java.util.EmptyStackException;

public class DisplayResult{

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private double result;

    public double displayResult(Calculator calculator) {
        DisplayResult displayResult = new DisplayResult();

        if (!calculator.isError()) {
            try {
               displayResult.setResult(calculator.getValueStack().pop());
                System.out.print("The result is " + ANSI_RED + displayResult.getResult() + ANSI_RESET);
            } catch (EmptyStackException e) {
                System.err.print("\n" + e);
                System.out.print(ANSI_CYAN + "Please verify if the expression is written correct" + ANSI_RESET);
            }
        } else {System.out.println(ANSI_CYAN + "Please verify if the expression is written correct" + ANSI_RESET); return -1;}
        return displayResult.getResult();
    }

    public double getResult() {return result;}
    public void setResult(double result) {this.result = result;}

}
