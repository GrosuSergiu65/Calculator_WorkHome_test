import java.util.Arrays;
import java.util.Scanner;

import static input_stage.InputStage.processInput;

public class MainMethod {
    public static void main(String[] args) {
        if (args.length > 0) {

            System.out.print("I have argument:" + Arrays.toString(args)+ "\n");
            processInput(Arrays.toString(args));

        } else {
            Scanner input = new Scanner(System.in);

            System.out.print("Calculator will find the value of the given expression: ");
            String userInput = input.nextLine();

            processInput(userInput);
        }
    }
}
