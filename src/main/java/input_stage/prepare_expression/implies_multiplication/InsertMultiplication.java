package input_stage.prepare_expression.implies_multiplication;

import java.util.ArrayList;

public class InsertMultiplication {

    protected static ArrayList<String> insertMultiplication(ArrayList<String> expressionList){

        for (int index = 1; index < expressionList.size(); index++) {
            for (int operandsIndex = 0; operandsIndex < 4; operandsIndex++) {
                String[] operands = new String[4];
                operands[0] = "+"; operands[1] = "-"; operands[2] = "*"; operands[3] = "/";

                if (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals(operands[operandsIndex]))
                {break; }

                if (expressionList.get(index).equals("(") && !expressionList.get(index - 1).matches("[-+*/]" ))
                {expressionList.add(index, ("*"));  index +=1 ; break;}

                if (expressionList.get(index).equals("(") && expressionList.get(index - 1).equals(")"))
                {expressionList.add(index, ("*")); index += 1; break;}

                if (expressionList.size() > index + 1) {
                    if (expressionList.get(index).equals(")") && !(expressionList.get(index + 1).equals("-") || expressionList.get(index + 1).equals("+") ||
                            expressionList.get(index + 1).equals("/") || expressionList.get(index + 1).equals("*") || expressionList.get(index + 1).equals("("))) {
                        expressionList.add(index + 1, ("*"));
                    }
                }
            }
        }
        return expressionList;
    }
}
