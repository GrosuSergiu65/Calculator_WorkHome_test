package prepare_expression.implies_multiplication;

import java.util.ArrayList;

public class InsertMultiplication {

    protected static ArrayList<String> insertMultiplication(ArrayList<String> expressionList){

        for (int index = 1; index < expressionList.size(); index++) {

            if (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals("+") ||
                    (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals("-")) ||
                    (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals("*")) ||
                    (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals("/"))) {
                continue;
            }

            if (expressionList.get(index).equals("(") && !expressionList.get(index - 1).equals("+") ||
                    (expressionList.get(index).equals("(") && !expressionList.get(index - 1).equals("-")) ||
                    (expressionList.get(index).equals("(") && !expressionList.get(index - 1).equals("*")) ||
                    (expressionList.get(index).equals("(") && !expressionList.get(index - 1).equals("/"))) {
                expressionList.add(index, ("*"));
                continue;
            }

            if (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals(")")) {
                expressionList.add(index, ("*"));
                index += 1;
                continue;
            }

            if (expressionList.size() > index + 1) {
                if (expressionList.get(index).equals(")") && !(expressionList.get(index + 1).equals("-") || expressionList.get(index + 1).equals("+") ||
                        expressionList.get(index + 1).equals("/") || expressionList.get(index + 1).equals("*") || expressionList.get(index + 1).equals("("))) {
                    expressionList.add(index + 1, ("*"));
                }
            }
        }
        return expressionList;
    }
}
