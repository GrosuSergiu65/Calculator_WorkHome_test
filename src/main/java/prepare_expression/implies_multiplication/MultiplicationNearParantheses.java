package prepare_expression.implies_multiplication;

import java.util.ArrayList;
import java.util.Arrays;

import static prepare_expression.implies_multiplication.CleanRedundantParentheses.removeRedundantParentheses;
import static prepare_expression.implies_multiplication.InsertMultiplication.insertMultiplication;

public class MultiplicationNearParantheses {

    static String [] settledExpression;
    static ArrayList<String> expressionList;

    public static String[] putMultiplicationNearParentheses(String[] balancedWithNegativeNumber) {

        expressionList = new ArrayList<>(Arrays.asList(balancedWithNegativeNumber));

        removeRedundantParentheses(expressionList);
        insertMultiplication(expressionList);

        settledExpression = expressionList.toArray(new String[0]);
        return settledExpression;
    }
}
