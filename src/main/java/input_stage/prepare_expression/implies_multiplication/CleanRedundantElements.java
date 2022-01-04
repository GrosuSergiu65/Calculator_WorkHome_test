package input_stage.prepare_expression.implies_multiplication;

import java.util.ArrayList;

public class CleanRedundantElements {

    protected static void removeRedundantParentheses(ArrayList<String> expressionList) {

        for (int index = expressionList.size() - 1; index > 0; index--) {
            if (expressionList.get(index).equals(")") && expressionList.get(index - 1).equals("(")) {
                expressionList.remove(index);
                expressionList.remove(index - 1);
                index--;
            }
        }
    }
}
