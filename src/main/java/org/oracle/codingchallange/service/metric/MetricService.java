package org.oracle.codingchallange.service.metric;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.model.Metric;

import java.util.List;

public interface MetricService {

    List<Metric> getMetric(List<InputData> inputDataList);
}
