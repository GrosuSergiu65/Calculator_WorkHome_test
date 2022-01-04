package prepare_expression.negative_operands;

import java.util.Arrays;

public class ExcludesNullsFromArray {

    protected static String [] getDeletedNulls(String [] balancedWithNegativeNumber) {

        return Arrays.stream(balancedWithNegativeNumber)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }
}
