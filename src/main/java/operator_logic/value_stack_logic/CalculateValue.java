package operator_logic.value_stack_logic;

import calculator_constructor.Calculator;

public class CalculateValue {

    public double getResult(Calculator calculator, char operator, double a, double b) {
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
            System.out.println("Calculator at this moment can't assume this kind of operation, please white for update and try again later!");
            calculator.setError(true);
        }
        return result;
    }
}
