package org.oracle.codingchallange;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.repository.Store;
import org.oracle.codingchallange.repository.impl.CustomerInputDataStoreImpl;
import org.oracle.codingchallange.service.input.impl.ConsoleInputService;
import org.oracle.codingchallange.service.input.InputService;
import org.oracle.codingchallange.service.report.ReportService;
import org.oracle.codingchallange.service.report.impl.ConsoleReport;
import org.oracle.codingchallange.utils.MappingUtil;
import org.oracle.codingchallange.utils.ValidationUtils;

import java.util.List;

import static org.oracle.codingchallange.constants.Constants.*;

/**
 * Main class to initiate the flow of report generation
 */
public class Main {
    public static void main(String[] args) {
        try {
            //Init repo/store
            Store<InputData> store = new CustomerInputDataStoreImpl<>();

            //Init input service
            InputService consoleInputService = new ConsoleInputService(store);

            //Read input from console
            System.out.println(ENTER_INPUT_LINES_MESSAGE);
            StringBuffer consoleInput = consoleInputService.read();

            //Validate input as per the required input data format
            String errorMessage = ValidationUtils.validateInput(consoleInput);
            if (!EMPTY_STRING.equals(errorMessage)) {
                System.out.println(String.format(INPUT_DATA_VALIDATION_EXCEPTION, errorMessage));
                System.exit(1);
            }

            //Map input data to model
            List<InputData> inputDataList = MappingUtil.mapRawInputToData(consoleInput);

            //Save in the global store
            store.save(inputDataList);

            //Generate Report
            ReportService reportService = new ConsoleReport(store);
            reportService.generateReport();

            //print report
            reportService.printReport();
        } catch (Exception e) {
            System.out.println(EXCEPTION_RUNNING_APP + e);
        }
    }
}