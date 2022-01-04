package prepare_expression;

import static prepare_expression.implies_multiplication.MultiplicationNearParantheses.putMultiplicationNearParentheses;
import static prepare_expression.negative_operands.HandleNegativeOperands.sortNegativeOperands;
import static prepare_expression.space_equilibration.SpaceBetweenComponents.runStraightenFreeSpace;

public class prepareExpression {

static String[] unbalancedNegativeNumbers;
static String[] balancedWithNegativeNumber;
static String[] preparedExpression;

    public static String[] expressionFactoryPrepare(String input) {

        unbalancedNegativeNumbers = runStraightenFreeSpace(input);
        balancedWithNegativeNumber = sortNegativeOperands(unbalancedNegativeNumbers);
        preparedExpression  = putMultiplicationNearParentheses(balancedWithNegativeNumber);

        return preparedExpression;
    }
}