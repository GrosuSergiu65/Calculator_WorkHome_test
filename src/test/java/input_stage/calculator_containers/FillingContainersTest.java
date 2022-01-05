package input_stage.calculator_containers;


import calculator_constructor.Calculator;
import input_stage.CalculatorHearth;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//class FillingContainersTest {
//
//    @ParameterizedTest
//    @DisplayName("Checking that each element falls into the correct stack ")
//    @CsvSource({"-, True", "+,True", "(, True", "),False", "13,True", "13.3,True", "!,False", "Y, False"})
//    void setFillingContainers(String expression, boolean expectedResult) {
//
//        String[] input = new String[1];
//        input[0] = expression;
//
//        Calculator calculator = new Calculator();
//
//        CalculatorHearth.setFillingContainers(input);
//
//        boolean result = false;
//        if (!Calculator.getOperatorStack().isEmpty() || !Calculator.getValueStack().isEmpty()) {
//
//            result = true;
//
//            if (!Calculator.getValueStack().isEmpty()) {
//                System.out.println(Calculator.getValueStack().pop());
//            }
//            if (!Calculator.getOperatorStack().isEmpty()) {
//                System.out.println(Calculator.getOperatorStack().pop());
//            }
//        }
//
//        assertThat(result).isEqualTo(expectedResult);
//
//    }
//}