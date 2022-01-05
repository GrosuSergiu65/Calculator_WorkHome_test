package input_stage.prepare_expression.negative_operands;

public class HandleNegativeOperands {

    public static String[] sortNegativeOperands(String[] brokenArrayExpression) {
      String[] fixedArrayExpression = ConcatNegativeIntegers.getConcatenatedNegativeValues(brokenArrayExpression);
        return ExcludesNullsFromArray.getListWithoutNulls(fixedArrayExpression);
    }
}
