package prepare_expression.space_equilibration;

import static prepare_expression.space_equilibration.SpaceEqulibration.putSpaceBetweenComponents;

public class SpaceBetweenComponents {

    static String expression;
    static String[] inflatedExpression;

    public static String[] runStraightenFreeSpace(String input) {

        expression = putSpaceBetweenComponents(input);
        expression = CleanDoubleSpace.removeSuperfluousSpace(expression);
        inflatedExpression = expression.split("\\s");

        return inflatedExpression;
    }
}

