package input_stage.prepare_expression.space_equilibration;

public class SpaceEqulibration {

    protected static String putSpaceBetweenComponents(String input) {
        return input.replaceAll("[(]", " ( ").replaceAll("[)]", " ) ")
                .replaceAll("[+]", " + ").replaceAll("-", " - ")
                .replaceAll("/", " / ").replaceAll("[*]", " * ")
                .replaceAll("=", "").replaceAll("!", "").replaceFirst("^\\s*", "");
    }
}
