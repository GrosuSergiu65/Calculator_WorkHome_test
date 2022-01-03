package prepare_expression.negative_operands;

public class HandleNegativeOperands {
  static  String[] fixedArrayExpression;

    public static String[] sortNegativeOperands(String[] brokenArrayExpression) {

        fixedArrayExpression = new String[brokenArrayExpression.length];

        for (int index = 0; index <= brokenArrayExpression.length - 1; index++) {
            if (brokenArrayExpression[index].equals("-") && index <= 0) {
                fixedArrayExpression[index] = brokenArrayExpression[index].concat(brokenArrayExpression[index + 1]);
                index += 1;
                continue;
            }
            if (brokenArrayExpression.length >= index + 1) {
                if (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index + 1].equals("(")) {
                    fixedArrayExpression[index] = brokenArrayExpression[index];
                    continue;
                }
            }

            if ((brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals("+")) ||
                    (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals("-")) ||
                    (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals("*")) ||
                    (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals("/")) ||
                    (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals(")")) ||
                    (brokenArrayExpression[index].equals("-") && brokenArrayExpression[index - 1].equals("("))) {
                fixedArrayExpression[index] = brokenArrayExpression[index].concat(brokenArrayExpression[index + 1]);
                index += 1;
                continue;
            }
            fixedArrayExpression[index] = brokenArrayExpression[index];
        }
        return fixedArrayExpression;
    }
}
