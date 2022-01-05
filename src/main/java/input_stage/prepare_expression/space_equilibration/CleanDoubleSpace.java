package input_stage.prepare_expression.space_equilibration;

public class CleanDoubleSpace {
    private final String expression = "";

    protected static String removeSuperfluousSpace(String input) {
        String expression = "";
        for (int index = 0; index < input.trim().length(); index++) {

            if (input.charAt(index) == ' ' && input.charAt(index + 1) ==' ') {
                continue;
            }
            expression+=input.charAt(index);
        }
        return expression;
    }
}
