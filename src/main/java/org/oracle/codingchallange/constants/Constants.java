package org.oracle.codingchallange.constants;

public interface Constants {
    String EMPTY_STRING = "";
    String NEW_LINE = "\n";
    String COMMA = ",";
    String METRIC_PRINT_FORMATTER = "%s : %s";
    String BUILD_DURATION_FORMATTER = "%ss";
    String GEOZONE = "GEOZONE";
    String CONTRACTID = "CONTRACTID";

    //Error & Exception messages
    String EMPTY_INPUT_PROVIDED = "Empty input provided";
    String INVALID_INPUT_PARAMETERS_PROVIDED = "Invalid input parameters provided";
    String NUMERIC_VALUE_EXPECTED_0 = "Numeric value expected at pos 0";
    String NUMERIC_VALUE_EXPECTED_1 = "Numeric value expected at pos 1";
    String EMPTY_VALUES_PRESENT = "Invalid input, empty values provided";
    String EXCEPTION_CALCULATING_CUSTOMER_ID_COUNT_METRIC = "Exception calculating unique customer count metric";
    String EXCEPTION_CALCULATING_CUSTOMER_ID_LIST_METRIC = "Exception calculating unique customer list metric";
    String EXCEPTION_CALCULATING_AVG_BUILD_DURATION_METRIC = "Exception calculating avg build duration metric";
    String EXCEPTION_CALCULATING_CONTRACT_ID_BASED_METRIC = "Exception calculating contractId based metric";
    String EXCEPTION_CALCULATING_GEO_ZONE_BASED_METRIC = "Exception calculating geozone based metric";
    String EXCEPTION_RUNNING_APP = "Error in running the application ";
    String INPUT_DATA_VALIDATION_EXCEPTION = "Input data validation exception : %s please re-enter";
    String CONSOLE_READ_ERROR = "Error reading from console ";

    //Output metrics message
    String NO_OF_UNIQUE_CUSTOMER_IDS_FOR_CONTRACT_ID = "The number of unique customerId for each contractId";
    String NO_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE = "The number of unique customerId for each geozone";
    String LIST_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE = "The list of unique customerId for each geozone";
    String AVG_BUILD_DURATION_FOR_GEOZONE = "The average buildduration for each geozone";

    String ENTER_INPUT_LINES_MESSAGE = "Enter input lines. Enter empty line to stop...";
    String GENERATED_REPORT = "*************** REPORT ****************";
}
