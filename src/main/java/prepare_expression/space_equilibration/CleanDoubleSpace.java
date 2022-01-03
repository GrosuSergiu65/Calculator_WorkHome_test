package prepare_expression.space_equilibration;

public class CleanDoubleSpace {
    static String expression = "";

    protected static String removeSuperfluousSpace(String filter) {
        for (int index = 0; index < filter.trim().length(); index++) {

            if (filter.charAt(index) == ' ' && filter.charAt(index + 1) ==' ') {
                continue;
            }
            expression+=filter.charAt(index);
        }
        return expression;
    }
}
