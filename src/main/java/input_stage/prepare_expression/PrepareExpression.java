package input_stage.prepare_expression;

import input_stage.prepare_expression.negative_operands.HandleNegativeOperands;
import input_stage.prepare_expression.space_equilibration.SpaceBetweenComponents;

import java.util.Arrays;

import static input_stage.prepare_expression.implies_multiplication.MultiplicationNearParentheses.putMultiplicationNearParentheses;

public class PrepareExpression extends HandleNegativeOperands{

    public String[] expressionFactoryPrepare(String input) {

        String[] unbalancedNegativeNumbers;
        String[] balancedWithNegativeNumber;
        String[] preparedExpression;

        unbalancedNegativeNumbers = SpaceBetweenComponents.runStraightenFreeSpace(input);
        balancedWithNegativeNumber = sortNegativeOperands(unbalancedNegativeNumbers);
        preparedExpression  = putMultiplicationNearParentheses(balancedWithNegativeNumber);


        return preparedExpression;
    }
}