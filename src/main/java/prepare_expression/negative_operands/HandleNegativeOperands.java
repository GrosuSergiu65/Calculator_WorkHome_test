package prepare_expression.negative_operands;

import static prepare_expression.negative_operands.ConcatNegativeIntegers.getConcatenateNegativeInteger;
import static prepare_expression.negative_operands.ExcludesNullsFromArray.getDeletedNulls;

public class HandleNegativeOperands {

  static String[] fixedArrayExpression;

    public static String[] sortNegativeOperands(String[] brokenArrayExpression) {
        fixedArrayExpression = getConcatenateNegativeInteger(brokenArrayExpression);
        fixedArrayExpression = getDeletedNulls(fixedArrayExpression);

        return fixedArrayExpression;
    }
}
