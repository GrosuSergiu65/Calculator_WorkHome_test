package calculator_constructor;

import java.util.Stack;

public class CalculatorConstructor {

    private static Stack<Character> operatorStack = new Stack<>();
    private static Stack<Double> valueStack = new Stack<>();
    private static boolean error;

    public CalculatorConstructor() {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
        error = false;
    }

    public static Stack<Character> getOperatorStack() { return operatorStack; }
    public static Stack<Double> getValueStack() { return valueStack; }
    public static boolean isError() { return error; }
    public static void setError(boolean error) { CalculatorConstructor.error = error; }
}
