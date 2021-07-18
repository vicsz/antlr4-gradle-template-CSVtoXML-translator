import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConditionValidatorTests {

    @Test
    public void simpleCheck(){
        String input = "1 == 1";

        ConditionValidator validator = new ConditionValidator(input);

        assertTrue(validator.valid());


    }
}
