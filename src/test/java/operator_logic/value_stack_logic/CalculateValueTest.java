//package operator_logic.value_stack_logic;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//class CalculateValueTest {
//
//    @ParameterizedTest
//    @DisplayName("Testing the functionality of popping an operand and an operator from the stack, and their successful calculation ")
//    @CsvSource({"+,1.2,2.8,0.0,4.0", "-,1.2,2.8,0.0,-1.5999999999999999",
//            "/,1.2,2.8,0.0,0.4285714285714286", "*, 1.2,2.8,0.0,3.36",
//            "!, 1.2,2.8,0.0,0.0"})
//    void stageOperator(char operator, double a, double b, double result, double expectedResult) {
//
//        result = CalculateValue.getResult(operator, a, b, result);
//        assertThat(result).isEqualTo(expectedResult);
//    }
//}