package org.oracle.codingchallenge.model;

import java.util.List;

public class Report {
    List<Metric> metrics;

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }
}
