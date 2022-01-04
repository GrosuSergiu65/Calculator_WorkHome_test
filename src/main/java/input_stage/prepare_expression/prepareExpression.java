package input_stage.prepare_expression;

import input_stage.prepare_expression.space_equilibration.SpaceBetweenComponents;

import java.util.Arrays;

import static input_stage.prepare_expression.implies_multiplication.MultiplicationNearParantheses.putMultiplicationNearParentheses;
import static input_stage.prepare_expression.negative_operands.HandleNegativeOperands.sortNegativeOperands;

public class prepareExpression {

static String[] unbalancedNegativeNumbers;
static String[] balancedWithNegativeNumber;
static String[] preparedExpression;

    public static String[] expressionFactoryPrepare(String input) {

        unbalancedNegativeNumbers = SpaceBetweenComponents.runStraightenFreeSpace(input);
        balancedWithNegativeNumber = sortNegativeOperands(unbalancedNegativeNumbers);
        preparedExpression  = putMultiplicationNearParentheses(balancedWithNegativeNumber);

        return preparedExpression;
    }
}