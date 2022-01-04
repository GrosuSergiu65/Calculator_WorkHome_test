package operator_logic.value_stack_logic;

import static calculator_constructor.CalculatorConstructor.setError;

public class CalculateValue {

    public static double getResult(char operator, double a, double b, double result) {
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
            setError(true);
        }
        return result;
    }
}
