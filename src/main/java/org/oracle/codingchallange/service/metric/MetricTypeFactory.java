package org.oracle.codingchallange.service.metric;

import org.oracle.codingchallange.service.metric.impl.ContractIdBased;
import org.oracle.codingchallange.service.metric.impl.GeoZoneBased;

import static org.oracle.codingchallange.constants.Constants.CONTRACTID;
import static org.oracle.codingchallange.constants.Constants.GEOZONE;

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
                metricService = null;
                break;
            }
        }

        return metricService;
    }

}
