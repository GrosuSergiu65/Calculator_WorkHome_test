package input_stage.prepare_expression.space_equilibration;

import static input_stage.prepare_expression.space_equilibration.SpaceEqulibration.putSpaceBetweenComponents;

public class SpaceBetweenComponents {

    public static String[] runStraightenFreeSpace(String input) {

        String expression= putSpaceBetweenComponents(input);
        return CleanDoubleSpace.removeSuperfluousSpace(expression).split("\\s");
    }
}

