package org.oracle.codingchallenge.service.report.impl;

import org.oracle.codingchallenge.model.InputData;
import org.oracle.codingchallenge.model.Metric;
import org.oracle.codingchallenge.model.ReportParamEnum;
import org.oracle.codingchallenge.repository.Store;
import org.oracle.codingchallenge.service.metric.MetricService;
import org.oracle.codingchallenge.service.metric.MetricTypeFactory;
import org.oracle.codingchallenge.service.report.ReportService;

import java.util.*;

import static org.oracle.codingchallenge.constants.Constants.GENERATED_REPORT;
import static org.oracle.codingchallenge.constants.Constants.METRIC_PRINT_FORMATTER;

public class ConsoleReport implements ReportService {
    public static List<ReportParamEnum> PARAMS_FOR_REPORT_GENERATION = Arrays.asList(ReportParamEnum.CONTRACTID, ReportParamEnum.GEOZONE);
    Store store;

    MetricTypeFactory metricTypeFactory;

    List<Metric> metrics;
    public ConsoleReport(Store store) {
        this.store = store;
        this.metricTypeFactory = new MetricTypeFactory();
        this.metrics = new ArrayList<>();
    }

    /**
     * Report generation orchestrator method.
     * This method will manage the calls to various report generation classes
     * based on the params on which the report needs to be generated
     * <p>
     * Here its calling 2 report generation class's methods: ContractBased & GeoZoneBased
     * <p>
     * The Data for report generation is read from the global store.
     */
    @Override
    public void generateReport() {
        if (this.store != null) {
            List<InputData> storeDataList = this.store.read();
            for (ReportParamEnum reportParamEnum : PARAMS_FOR_REPORT_GENERATION) {
                MetricService metricService = metricTypeFactory.getMetricGenerator(reportParamEnum.name());
                if (metricService != null) {
                    metrics.addAll(metricService.getMetric(storeDataList));
                }
            }
        }
    }

    /**
     * Print report method implementation
     * This method will print the report on console.
     */
    @Override
    public void printReport() {
        if (this.metrics != null && !this.metrics.isEmpty()) {
            System.out.println(GENERATED_REPORT);
            for (Metric metric : this.metrics) {
                System.out.println(String.format(METRIC_PRINT_FORMATTER, metric.getMetadata(), metric.getMetricData()));
            }
        }
    }
}
