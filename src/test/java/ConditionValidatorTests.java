import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConditionValidatorTests {

    @ParameterizedTest(name = "{2}")
    @CsvFileSource(resources = "/condition_validation_tests.csv", numLinesToSkip = 1)
    public void tests(String condition, boolean expectedResult, String testName){

        ConditionValidator validator = new ConditionValidator(condition);
        boolean result = validator.valid();

        assertEquals(expectedResult, result, testName + ", validation (" + condition + "): ");
    }

}
