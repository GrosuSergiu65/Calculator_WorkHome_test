package input_stage.calculator_containers;

import calculator_constructor.Calculator;
import input_stage.CalculatorHearth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FillingValueStackTest extends FillingValueStack{

    @ParameterizedTest
    @DisplayName("Check if the number falls into the correct container")
    @CsvSource({"*, 3, False", "+,0, False", "(, 1, False", "),/,False", "-,321,True", "-,-1,True", "!,-3  ,True", "Y,3, True"})
    void setFillingContainers(char character, String nextToken, boolean expectedResult){
        Calculator calculator = new Calculator(new Stack<>(), new Stack<>(), false);

        boolean result = addValueToStack(calculator, character, nextToken);

        assertThat(result).isEqualTo(expectedResult);

    }
}
