package input_stage.calculator_containers;


import calculator_constructor.CalculatorConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FillingContainersTest {

    @ParameterizedTest
    @DisplayName("Checking that each element falls into the correct stack ")
    @CsvSource({"-, True", "+,True", "(, True", "),False", "13,True", "13.3,True", "!,False", "Y, False"})
    void setFillingContainers(String expression, boolean expectedResult){

        String [] input = new String[1];
        input[0] = expression;

    FillingContainers.setFillingContainers(input);

        boolean result = false;
        if(!CalculatorConstructor.getOperatorStack().isEmpty() || !CalculatorConstructor.getValueStack().isEmpty()){

            result = true;

            if(!CalculatorConstructor.getValueStack().isEmpty()){ System.out.println(CalculatorConstructor.getValueStack().pop());}
            if(!CalculatorConstructor.getOperatorStack().isEmpty()){System.out.println(CalculatorConstructor.getOperatorStack().pop());}
        }

        assertThat(result).isEqualTo(expectedResult);

    }
}