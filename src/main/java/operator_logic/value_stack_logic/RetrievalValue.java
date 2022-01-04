package operator_logic.value_stack_logic;

import java.util.Stack;

import static calculator_constructor.CalculatorConstructor.setError;

public class RetrievalValue {

    static double valueFromStack;

    public static double getValueFromStack(Stack<Double> valueStack) {

        if (valueStack.empty()) {
            setError(true);
        } else {
            valueFromStack = valueStack.peek();
            valueStack.pop();
        }
        return valueFromStack;
    }
}
