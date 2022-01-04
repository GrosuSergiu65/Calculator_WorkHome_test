package input_stage.prepare_expression.negative_operands;

public class HandleNegativeOperands {

  static String[] fixedArrayExpression;

    public static String[] sortNegativeOperands(String[] brokenArrayExpression) {
        fixedArrayExpression = ConcatNegativeIntegers.getConcatenateNegativeInteger(brokenArrayExpression);
        fixedArrayExpression = ExcludesNullsFromArray.getDeletedNulls(fixedArrayExpression);

        return fixedArrayExpression;
    }
}
