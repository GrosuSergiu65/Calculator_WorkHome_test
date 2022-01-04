package input_stage.calculator_containers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FillingValueStackTest {

    @ParameterizedTest
    @DisplayName("Check if the number falls into the correct container")
    @CsvSource({"*, 3, False", "+,0, False", "(, 1, False", "),/,False", "-,321,True", "-,-1,True", "!,-3  ,True", "Y,3, True"})
    void setFillingContainers(char character, String nextToken, boolean expectedResult){

        boolean result = FillingValueStack.addValueToStack(character, nextToken);

        assertThat(result).isEqualTo(expectedResult);

    }
}