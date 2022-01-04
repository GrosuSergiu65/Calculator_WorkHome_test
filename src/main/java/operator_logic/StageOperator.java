package operator_logic;

import operator_logic.value_stack_logic.CalculateValue;
import operator_logic.value_stack_logic.RetrievalValue;

import java.util.Stack;

public class StageOperator {
    private static double result = 0;

    public static void stageOperator(char operator, Stack<Double> valueStack) {

        double b = RetrievalValue.getValueFromStack(valueStack);
        double a = RetrievalValue.getValueFromStack(valueStack);

        result = CalculateValue.getResult(operator, a, b, result);

        valueStack.push(result);
    }
}

