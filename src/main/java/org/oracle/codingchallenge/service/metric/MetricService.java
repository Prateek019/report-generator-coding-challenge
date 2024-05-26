package org.oracle.codingchallenge.service.metric;

import org.oracle.codingchallenge.model.InputData;
import org.oracle.codingchallenge.model.Metric;

import java.util.List;

public interface MetricService {

    List<Metric> getMetric(List<InputData> inputDataList);
}
