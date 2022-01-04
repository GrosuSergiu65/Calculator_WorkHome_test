package input_stage.prepare_expression.implies_multiplication;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationNearParantheses {

    static String [] settledExpression;
    static ArrayList<String> expressionList;

    public static String[] putMultiplicationNearParentheses(String[] balancedWithNegativeNumber) {

        expressionList = new ArrayList<>(Arrays.asList(balancedWithNegativeNumber));

        CleanRedundantParentheses.removeRedundantParentheses(expressionList);
        InsertMultiplication.insertMultiplication(expressionList);

        settledExpression = expressionList.toArray(new String[0]);
        return settledExpression;
    }
}
