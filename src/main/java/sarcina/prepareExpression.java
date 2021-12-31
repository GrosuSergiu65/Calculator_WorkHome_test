package sarcina;

import java.util.ArrayList;
import java.util.Arrays;

public class prepareExpression {
    public static String[] expresionFactoryPrepare(String input) {
        String filter = input.replaceAll("[(]", " ( ").replaceAll("[)]", " ) ")
                .replaceAll("[+]", " + ").replaceAll("-", " - ")
                .replaceAll("/", " / ").replaceAll("[*]", " * ");
        filter = filter.replaceFirst("^\\s*", "");


        StringBuilder expression = new StringBuilder();
        if (filter.startsWith(")")) {
            filter = filter.substring(2).replaceFirst("^\\s*", "");
        }

        for (int i = 0; i < filter.trim().length(); i++) {

            if (filter.charAt(i) == ' ' && filter.charAt(i + 1) == ' ') {
                continue;
            }
            expression.append(filter.charAt(i));
        }

        String[] readyArr = expression.toString().split("\\s");

        String[] test = new String[readyArr.length];
        for (int i = 0; i <= readyArr.length - 1; i++) {
            if (readyArr[i].equals("-") && i <= 0) {
                test[i] = readyArr[i].concat(readyArr[i + 1]);
                i += 1;
                continue;
            }
            if (readyArr.length >= i + 1) {
                if (readyArr[i].equals("-") && readyArr[i + 1].equals("(")) {
                    test[i] = readyArr[i];
                    continue;
                }
            }

            if ((readyArr[i].equals("-") && readyArr[i - 1].equals("+")) ||
                    (readyArr[i].equals("-") && readyArr[i - 1].equals("-")) ||
                    (readyArr[i].equals("-") && readyArr[i - 1].equals("*")) ||
                    (readyArr[i].equals("-") && readyArr[i - 1].equals("/")) ||
                    (readyArr[i].equals("-") && readyArr[i - 1].equals(")")) ||
                    (readyArr[i].equals("-") && readyArr[i - 1].equals("("))) {
                test[i] = readyArr[i].concat(readyArr[i + 1]);
                i += 1;
                continue;
            }
            test[i] = readyArr[i];
        }

        test = Arrays.stream(test)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        ArrayList<String> arr = new ArrayList<>(Arrays.asList(test));

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
        return readyArr;
    }
}