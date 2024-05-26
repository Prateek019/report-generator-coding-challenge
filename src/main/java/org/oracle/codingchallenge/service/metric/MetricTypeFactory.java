package org.oracle.codingchallenge.service.metric;

import org.oracle.codingchallenge.service.metric.impl.ContractIdBased;
import org.oracle.codingchallenge.service.metric.impl.GeoZoneBased;

import static org.oracle.codingchallenge.constants.Constants.*;

/**
 * Metric service factory to get each metric generation type class
 */
public class MetricTypeFactory {

    /**
     * get the particular metric service class based on the qualifier name.
     *
     * @param type
     * @return
     */
    public MetricService getMetricGenerator(String type) {
        MetricService metricService = null;

        switch (type) {
            case GEOZONE : {
                metricService = new GeoZoneBased();
                break;
            }
            case CONTRACTID : {
                metricService = new ContractIdBased();
                break;
            }
            default : {
                System.out.println(METRIC_TYPE_NOT_FOUND);
                break;
            }
        }

        return metricService;
    }

}
