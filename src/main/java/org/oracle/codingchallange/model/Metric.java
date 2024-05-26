package org.oracle.codingchallange.model;

import java.util.Map;

public class Metric {
    String metadata;
    Map<String, Object> metricData;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getMetricData() {
        return metricData;
    }

    public void setMetricData(Map<String, Object> metricData) {
        this.metricData = metricData;
    }

    public Metric() {
    }

    public Metric(String metadata, Map<String, Object> metricData) {
        this.metadata = metadata;
        this.metricData = metricData;
    }
}
