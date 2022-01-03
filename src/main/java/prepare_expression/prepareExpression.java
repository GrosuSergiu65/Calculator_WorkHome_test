package prepare_expression;

import java.util.ArrayList;
import java.util.Arrays;

import static prepare_expression.negative_operands.HandleNegativeOperands.sortNegativeOperands;
import static prepare_expression.space_equilibration.SpaceBetweenComponents.runStraightenFreeSpace;


public class prepareExpression {
static String balancedWhiteSpaceExpression;
static String[] brokenArrayExpression;
static String[] fixedArrayExpression;

    public static String[] expresionFactoryPrepare(String input) {

        balancedWhiteSpaceExpression = runStraightenFreeSpace(input);
        System.out.println(balancedWhiteSpaceExpression);
        brokenArrayExpression = balancedWhiteSpaceExpression.split("\\s");
        System.out.println(Arrays.toString(brokenArrayExpression));


        System.out.println(Arrays.toString(brokenArrayExpression));
        fixedArrayExpression = sortNegativeOperands(brokenArrayExpression);
        System.out.println(Arrays.toString(fixedArrayExpression));

        fixedArrayExpression = Arrays.stream(fixedArrayExpression)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);


        ArrayList<String> arr = new ArrayList<>(Arrays.asList(fixedArrayExpression));



        for (int index = arr.size() - 1; index > 0; index--) {
            if (arr.get(index).equals(")") && arr.get(index - 1).equals("(")) {
                arr.remove(index);
                arr.remove(index - 1);
                index--;
            }
        }

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).equals("(") && arr.get(i - 1).equals("+") ||
                    (arr.get(i).equals("(") && arr.get(i - 1).equals("-")) ||
                    (arr.get(i).equals("(") && arr.get(i - 1).equals("*")) ||
                    (arr.get(i).equals("(") && arr.get(i - 1).equals("/"))) {
                continue;
            }
            if (arr.get(i).equals("(") && !arr.get(i - 1).equals("+") ||
                    (arr.get(i).equals("(") && !arr.get(i - 1).equals("-")) ||
                    (arr.get(i).equals("(") && !arr.get(i - 1).equals("*")) ||
                    (arr.get(i).equals("(") && !arr.get(i - 1).equals("/"))) {
                arr.add(i, ("*"));
                continue;
            }

            if (arr.get(i).equals("(") && arr.get(i - 1).equals(")")) {
                arr.add(i, ("*"));
                i += 1;
                continue;
            }
            if (arr.size() > i + 1) {
                if (arr.get(i).equals(")") && !(arr.get(i + 1).equals("-") || arr.get(i + 1).equals("+") ||
                        arr.get(i + 1).equals("/") || arr.get(i + 1).equals("*") || arr.get(i + 1).equals("("))) {
                    arr.add(i + 1, ("*"));
                }
                String[] myArray = new String[arr.size()];
                return arr.toArray(myArray);

            }
        }
        return brokenArrayExpression;
    }

}