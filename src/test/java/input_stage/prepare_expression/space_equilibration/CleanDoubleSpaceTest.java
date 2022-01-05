package input_stage.prepare_expression.space_equilibration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CleanDoubleSpaceTest {

    @Test
    void removeSuperfluousSpace() {
        String testSuperfluous = "3+2          o             ";
        String result = CleanDoubleSpace.removeSuperfluousSpace(testSuperfluous);
        assertThat(result).isEqualTo("3+2 o");
    }
}