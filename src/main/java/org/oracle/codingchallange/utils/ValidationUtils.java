package org.oracle.codingchallange.utils;

import org.oracle.codingchallange.constants.Constants;

/**
 * Utility class for data validations
 */
public class ValidationUtils implements Constants {
    /**
     * Validate the raw input.
     * validations are done for:
     *  1. input data row length
     *  2. input data having empty comma separated values
     *  3. input data has non-numeric customerId
     *  4. input data has non-numeric contractId
     *
     * @param buffer
     * @return
     */
    public static String validateInput(StringBuffer buffer) {
        String errorMessage = EMPTY_STRING;

        if (buffer == null || EMPTY_STRING.equals(buffer.toString())) {
            errorMessage = EMPTY_INPUT_PROVIDED;
        } else {
            String[] input = buffer.toString().split(NEW_LINE);
            for (String ip : input) {
                String [] val = ip.split(COMMA);
                if (val.length != 6) {
                    errorMessage = INVALID_INPUT_PARAMETERS_PROVIDED;
                    break;
                } else if (!emptyValCheck(val)) {
                    errorMessage = EMPTY_VALUES_PRESENT;
                    break;
                } else if (!checkNumeric(val[0])) {
                    errorMessage = NUMERIC_VALUE_EXPECTED_0;
                    break;
                } else if (!checkNumeric(val[1])) {
                    errorMessage = NUMERIC_VALUE_EXPECTED_1;
                    break;
                }
            }
        }
        return errorMessage;
    }

    /**
     * check if a string is numeric
     * @param val
     * @return
     */
    private static boolean checkNumeric(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    /**
     * check if the values in array are empty
     *
     * @param vals
     * @return
     */
    private static boolean emptyValCheck(String[] vals) {
        if (vals != null) {
            for (String val : vals) {
                if (val == null || EMPTY_STRING.equals(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
