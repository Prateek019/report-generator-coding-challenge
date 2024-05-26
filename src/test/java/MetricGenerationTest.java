import org.junit.Test;
import org.oracle.codingchallange.model.Metric;
import org.oracle.codingchallange.service.metric.impl.ContractIdBased;
import org.oracle.codingchallange.service.metric.impl.GeoZoneBased;
import org.oracle.codingchallange.service.metric.MetricService;

import static org.junit.Assert.*;
import static org.oracle.codingchallange.constants.Constants.*;

import java.util.List;

public class MetricGenerationTest extends InitInput{

    MetricService contractIdBasedMetricService = new ContractIdBased();

    MetricService geoZoneBasedMetricService = new GeoZoneBased();

    @Test
    public void uniqueCustomerCountForContractIdTest() {
        List<Metric> metrics = contractIdBasedMetricService.getMetric(getInputDataList());
        assertNotNull(metrics);
        assertEquals(metrics.size(), 1);

        Metric metric = metrics.get(0);

        assertEquals(metric.getMetadata(), NO_OF_UNIQUE_CUSTOMER_IDS_FOR_CONTRACT_ID);
        assertNotEquals(metric.getMetricData().size(), 0);
        assertEquals(metric.getMetricData().get("2345"), 3);
        assertEquals(metric.getMetricData().get("2346"), 2);
    }

    @Test
    public void uniqueCustomerCountForGeoZoneTest() {
        List<Metric> metrics = geoZoneBasedMetricService.getMetric(getInputDataList());
        assertNotNull(metrics);
        assertNotEquals(metrics.size(), 0);

        assertTrue(metrics.stream().anyMatch(m -> m.getMetadata().equals(NO_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE)));

        metrics.stream()
                .filter(m -> m.getMetadata().equals(NO_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE))
                .forEach(m -> {
                    assertEquals(m.getMetricData().get("eu_west"), 2);
                    assertEquals(m.getMetricData().get("us_west"), 2);
                    assertEquals(m.getMetricData().get("us_east"), 1);
                });
    }

    @Test
    public void uniqueCustomerListForGeoZoneTest() {
        List<Metric> metrics = geoZoneBasedMetricService.getMetric(getInputDataList());
        assertNotNull(metrics);
        assertNotEquals(metrics.size(), 0);

        assertTrue(metrics.stream().anyMatch(m -> m.getMetadata().equals(LIST_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE)));

        metrics.stream()
                .filter(m -> m.getMetadata().equals(LIST_OF_UNIQUE_CUSTOMER_IDS_FOR_GEOZONE))
                .forEach(m -> {
                    assertEquals(m.getMetricData().get("eu_west"), "3244132,3244332");
                    assertEquals(m.getMetricData().get("us_west"), "1233456,1223456");
                    assertEquals(m.getMetricData().get("us_east"), "2343225");
                });
    }

    @Test
    public void averageBuildDurationForGeoZoneTest() {
        List<Metric> metrics = geoZoneBasedMetricService.getMetric(getInputDataList());
        assertNotNull(metrics);
        assertNotEquals(metrics.size(), 0);

        assertTrue(metrics.stream().anyMatch(m -> m.getMetadata().equals(AVG_BUILD_DURATION_FOR_GEOZONE)));

        metrics.stream()
                .filter(m -> m.getMetadata().equals(AVG_BUILD_DURATION_FOR_GEOZONE))
                .forEach(m -> {
                    assertEquals(m.getMetricData().get("eu_west"), "4222.0s");
                    assertEquals(m.getMetricData().get("us_west"), "2216.0s");
                    assertEquals(m.getMetricData().get("us_east"), "3445.0s");
                });
    }
}
