package input_stage.prepare_expression.space_equilibration;

public class SpaceEqulibration {

    protected static String putSpaceBetweenComponents(String input) {
        String filter = input.replaceAll("[(]", " ( ").replaceAll("[)]", " ) ")
                .replaceAll("[+]", " + ").replaceAll("-", " - ")
                .replaceAll("/", " / ").replaceAll("[*]", " * ");
        filter = filter.replaceFirst("^\\s*", "");

        return filter;
    }
}
