package org.oracle.codingchallenge.service.report.impl;

import org.oracle.codingchallenge.repository.Store;
import org.oracle.codingchallenge.service.report.ReportService;

/**
 * Report service implementation to generate File based report
 *
 * Note: This class has not been implemented as it's out of scope from this assignment.
 * But to display the scalability of the system this empty class has been placed
 */
public class FileReport implements ReportService {

    Store store;
    public FileReport(Store store) {
        this.store = store;
    }

    /**
     * Orchestrator method to generate file based report
     */
    @Override
    public void generateReport() {

    }

    /**
     * Print report method implementation
     * This method will print/write the report in a file
     */
    @Override
    public void printReport() {

    }
}
