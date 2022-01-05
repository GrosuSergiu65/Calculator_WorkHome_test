package input_stage.prepare_expression.implies_multiplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class InsertMultiplicationTest {
    ArrayList<String> testList ;

    @BeforeEach
    void setUp(){
        testList = new ArrayList<>();
    }

    @Test
    @DisplayName("Insert multiplication near parentheses if it is near the value")
    void insertMultiplication() {
        testList.add("(");  testList.add("-3");testList.add(")");
        testList.add("3");

        InsertMultiplication.insertMultiplication(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{"(", "-3", ")", "*", "3"});
    }

    @Test
    @DisplayName("Method do not insert multiplication if there is another operand")
    void ignorInsertMultiplication() {
        testList.add("3");testList.add("/");testList.add("(");  testList.add("-3");testList.add(")");testList.add("/");
        testList.add("3");

        InsertMultiplication.insertMultiplication(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{"3","/","(", "-3", ")", "/", "3"});
    }

    @Test
    @DisplayName("Insert on the both ends of the parentheses")
    void setInsertMultiplication() {
        testList.add("3"); testList.add("(");  testList.add("-3");testList.add(")");testList.add("3");

        InsertMultiplication.insertMultiplication(testList);
        assertThat(testList.toArray()).isEqualTo(new String[]{"3","*","(", "-3", ")", "*", "3"});
    }
}