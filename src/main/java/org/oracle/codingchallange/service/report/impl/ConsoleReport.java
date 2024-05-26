package org.oracle.codingchallange.service.report.impl;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.model.Metric;
import org.oracle.codingchallange.model.ReportParamEnum;
import org.oracle.codingchallange.repository.Store;
import org.oracle.codingchallange.service.metric.MetricTypeFactory;
import org.oracle.codingchallange.service.report.ReportService;

import java.util.*;

import static org.oracle.codingchallange.constants.Constants.METRIC_PRINT_FORMATTER;

public class ConsoleReport implements ReportService {
    public static List<ReportParamEnum> PARAMS_FOR_REPORT_GENERATION = Arrays.asList(ReportParamEnum.GEOZONE, ReportParamEnum.CONTRACTID);
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
                metrics.addAll(metricTypeFactory.getMetricGenerator(reportParamEnum.name()).getMetric(storeDataList));
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
            for (Metric metric : this.metrics) {
                System.out.println(String.format(METRIC_PRINT_FORMATTER, metric.getMetadata(), metric.getMetricData()));
            }
        }
    }
}
