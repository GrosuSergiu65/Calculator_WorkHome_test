package sarcina;

import java.util.Stack;

import static sarcina2.CalculatorConstructor.setError;

public class StageOperator {
    public static void stageOperator(char operator, Stack<Double> valueStack) {
        double a, b;
        if (valueStack.empty()) {
            setError(true);
            return;
        } else {
            b = valueStack.peek();
            valueStack.pop();
        }
        if (valueStack.empty()) {
            setError(true);
            return;
        } else {
            a = valueStack.peek();
            valueStack.pop();
        }
        double result = 0;
        if (operator == '+') {
            result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else if (operator == '*') {
            result = a * b;
        } else if(operator == '/') {
            result = a / b;
        } else {
            System.out.println("Calculator at this moment calculator can't assume this kind of operation, please white for update and try again later!");
            setError(true);
        }
        valueStack.push(result);
    }
}

