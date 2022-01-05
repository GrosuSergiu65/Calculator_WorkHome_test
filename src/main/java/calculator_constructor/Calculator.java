package calculator_constructor;

import java.util.Stack;

public class Calculator {

    private final Stack<Character> operatorStack;
    private final Stack<Double> valueStack;
    private boolean error;

    public Calculator(Stack<Character> operatorStack, Stack<Double> valueStack, boolean error) {
        this.operatorStack = operatorStack;
        this.valueStack = valueStack;
        this.error = error;
    }

    public Stack<Character> getOperatorStack() {return operatorStack;}
    public Stack<Double> getValueStack() {return valueStack;}
    public boolean isError() {return error;}
    public void setError(boolean error) {this.error = error;}
}


