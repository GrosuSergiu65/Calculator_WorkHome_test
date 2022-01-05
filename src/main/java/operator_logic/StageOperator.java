package operator_logic;

import calculator_constructor.Calculator;
import operator_logic.value_stack_logic.CalculateValue;
import operator_logic.value_stack_logic.RetrievalValue;

import java.util.Stack;

public class StageOperator extends CalculateValue{

    public void stageOperator(Calculator calculator, char operator, Stack<Double> valueStack) {

        double b = RetrievalValue.getValueFromStack(calculator, valueStack);
        double a = RetrievalValue.getValueFromStack(calculator, valueStack);

        double result = getResult(calculator, operator, a, b);

        valueStack.push(result);
    }
}

