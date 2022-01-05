package operator_logic;

public class GetPrecedence {
    public static int getPrecedence(char ch) {

        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
