package org.oracle.codingchallange.service.metric;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.model.Metric;
import org.oracle.codingchallange.utils.ReportGenerationUtils;

import java.util.*;

import static org.oracle.codingchallange.constants.Constants.*;

public class GeoZoneBased implements MetricService {

    Map<String, List<InputData>> geoZoneInputMap;

    public GeoZoneBased() {
        if (geoZoneInputMap == null) {
            this.geoZoneInputMap = new HashMap<>();
        }
    }

    /**
     * get list of metrics based on geozone
     * <p>
     * This method will format the inputData list into a map.
     * Map structure: geoZone (key) -> InputDataList (value)
     * <p>
     * Each geozone's bucket will have the list of inputData objects belonging to that geozone.
     * This will facilitate the geozone based metrics calculation
     * <p>
     * Further this method will call all the utility methods to get the required metrics based on geozone and return a list
     * @param inputDataList
     * @return
     */
    @Override
    public List<Metric> getMetric(List<InputData> inputDataList) {
        String geoZone;
        List<Metric> metrics = new ArrayList<>();
        try {
            for (InputData inputData : inputDataList) {
                geoZone = inputData.getGeoZone();
                if (!geoZoneInputMap.containsKey(geoZone)) {
                    geoZoneInputMap.put(geoZone, new ArrayList<>(Arrays.asList(inputData)));
                } else {
                    geoZoneInputMap.get(geoZone).add(inputData);
                }
            }
            metrics.add(new Metric(NO_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE, ReportGenerationUtils.getUniqueCustomerCountMap(geoZoneInputMap)));
            metrics.add(new Metric(LIST_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE, ReportGenerationUtils.getUniqueCustomerListMap(geoZoneInputMap)));
            metrics.add(new Metric(AVG_BUILD_DURATION_FOR_GEOZONE, ReportGenerationUtils.getAverageBuildDurationMap(geoZoneInputMap)));
        }
        catch (Exception e) {
            System.out.println(EXCEPTION_CALCULATING_GEO_ZONE_BASED_METRIC + e);
        }
        return metrics;
    }
}
