import java.util.Scanner;

import static input_stage.InputStage.processInput;

public class MainMethod {
    public static void main(String[] args) {
    if (args.length > 0) {

        StringBuilder argument = new StringBuilder();
        for(int index = 0; index<=args.length-1;index++){
            argument.append(args[index]); }

        System.out.print("I have argument:" + argument +"\n");
        processInput(argument.toString());

    } else {
        Scanner input = new Scanner(System.in);

        System.out.print("The calculator will find the value of the given expression: ");
        String userInput = input.nextLine();
        processInput(userInput);
    }
}
}
