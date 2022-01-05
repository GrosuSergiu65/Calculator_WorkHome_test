package input_stage.prepare_expression.implies_multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CleanRedundantElementsTest {
    ArrayList<String> testList ;

    @BeforeEach
    void setUp(){
        testList = new ArrayList<>();
    }

    @Test
    @DisplayName("Check if method eliminated all redundant parentheses")
    void removeRedundantParentheses() {
        testList.add("("); testList.add(")");
        testList.add("("); testList.add(")");
        testList.add("("); testList.add("3");
        testList.add("("); testList.add(")");
        testList.add("("); testList.add(")");
        testList.add("("); testList.add(")");

        CleanRedundantElements.removeRedundantParentheses(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{"(", "3"});
    }

    @Test
    @DisplayName("Check if method eliminated all redundant parentheses if there are pair")
    void removeRedundant() {
        testList.add("("); testList.add(")");

        CleanRedundantElements.removeRedundantParentheses(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{});
    }

    @Test
    @DisplayName("Check if method eliminated all redundant parentheses except in case there is something in")
    void removeRedundantExceptWhichAreInParentheses() {
        testList.add("(");  testList.add("3");testList.add(")");

        CleanRedundantElements.removeRedundantParentheses(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{"(", "3", ")"});

    }
}