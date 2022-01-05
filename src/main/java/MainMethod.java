import input_stage.InputStage;

import java.util.Arrays;
import java.util.Scanner;

public class MainMethod {

    public static void main(String[] args) {
        InputStage input = new InputStage();

        if (args.length > 0) {

            System.out.print("I have argument:" + Arrays.toString(args)+ "\n");
            input.processInput(Arrays.toString(args));

        } else {
            Scanner scan = new Scanner(System.in);

            System.out.print("Calculator will find the value of the given expression: ");
            String userInput = scan.nextLine();

            input.processInput(userInput);

        }
    }
}
