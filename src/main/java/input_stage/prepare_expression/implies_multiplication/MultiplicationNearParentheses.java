package input_stage.prepare_expression.implies_multiplication;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationNearParentheses {

    public static String[] putMultiplicationNearParentheses(String[] balancedWithNegativeNumber) {
        ArrayList<String> expressionList = new ArrayList<>(Arrays.asList(balancedWithNegativeNumber));

        CleanRedundantElements.removeRedundantParentheses(expressionList);
        InsertMultiplication.insertMultiplication(expressionList);
        return expressionList.toArray(new String[0]);
    }
}
