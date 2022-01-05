package operator_logic.value_stack_logic;

import calculator_constructor.Calculator;

import java.util.Stack;

public class RetrievalValue {

    public static double getValueFromStack(Calculator calculator, Stack<Double> valueStack) {

        if (valueStack.empty()) {
            calculator.setError(true);
            return 0;
        }
        return valueStack.pop();
    }
}
