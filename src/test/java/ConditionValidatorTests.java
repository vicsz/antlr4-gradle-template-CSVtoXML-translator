import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionValidatorTests {

    @ParameterizedTest
    @ValueSource(strings = {"1 == 1", "2 == 2", "2 == 2.2", "VAR == 2", "TEST == TEXT2", "TEST.TEST == 1"})
    public void validConditions(String condition){
        assertTrue(new ConditionValidator(condition).valid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1TEST == 5", "TEST = TEST1"})
    public void invalidConditions(String condition){
        assertFalse(new ConditionValidator(condition).valid());
    }
}
