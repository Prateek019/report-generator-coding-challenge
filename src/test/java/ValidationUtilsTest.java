import org.junit.Test;
import org.oracle.codingchallange.utils.ValidationUtils;

import static org.junit.Assert.*;
import static org.oracle.codingchallange.constants.Constants.*;

public class ValidationUtilsTest extends InitInput {

    @Test
    public void validateEmptyInputTest() {
        assertEquals(ValidationUtils.validateInput(getEmptyInput()), EMPTY_INPUT_PROVIDED);
    }

    @Test
    public void validateMissingParamsTest() {
        assertEquals(ValidationUtils.validateInput(getFaultyInput1()), INVALID_INPUT_PARAMETERS_PROVIDED);
        assertEquals(ValidationUtils.validateInput(getFaultyInput2()), EMPTY_VALUES_PRESENT);
        assertEquals(ValidationUtils.validateInput(getFaultyInput3()), EMPTY_VALUES_PRESENT);
    }

    @Test
    public void validateInvalidCustomerIdTest() {
        assertEquals(ValidationUtils.validateInput(getFaultyInput4()), NUMERIC_VALUE_EXPECTED_0);
    }

    @Test
    public void validateInvalidContractIdTest() {
        assertEquals(ValidationUtils.validateInput(getFaultyInput5()), NUMERIC_VALUE_EXPECTED_1);
    }
}
