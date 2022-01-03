package prepare_expression.space_equilibration;

import static prepare_expression.space_equilibration.SpaceEqulibration.putSpaceBetweenComponents;

public class SpaceBetweenComponents {
    public static String runStraightenFreeSpace(String input) {

        String filter = putSpaceBetweenComponents(input);

        return CleanDoubleSpace.removeSuperfluousSpace(filter);
    }
}

