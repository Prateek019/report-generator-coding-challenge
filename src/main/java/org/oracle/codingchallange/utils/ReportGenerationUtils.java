package org.oracle.codingchallange.utils;

import org.oracle.codingchallange.model.InputData;

import java.util.*;
import java.util.stream.Collectors;

import static org.oracle.codingchallange.constants.Constants.*;

/**
 * Utility class to generate reports
 */
public class ReportGenerationUtils {
    /**
     * get build duration time in double value from string value
     *
     * @param duration
     * @return
     */
    public static double getBuildDurationTime(String duration) {
        double time = 0.0;
        if (duration != null) {
            duration = duration.substring(0, duration.indexOf("s"));
            time = Double.parseDouble(duration);
        }
        return time;
    }

    /**
     * get unique customer count map from the input param(key) map
     * Input is expected to be a map with reporting param as key & list of inputData for that param as values
     *
     * @param inputParamDataMap
     * @return
     */
    public static Map<String, Object> getUniqueCustomerCountMap(Map<String, List<InputData>> inputParamDataMap) {
        Set<String> customerIds = new HashSet<>();
        Map<String, Object> customerCountMap = new HashMap<>();
        try {
            if (inputParamDataMap != null && !inputParamDataMap.isEmpty()) {
                for (Map.Entry<String, List<InputData>> kv : inputParamDataMap.entrySet()) {
                    customerIds = kv.getValue().stream().map(InputData::getCustomerId).collect(Collectors.toSet());
                    customerCountMap.put(kv.getKey(), customerIds.size());
                }
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION_CALCULATING_CUSTOMER_ID_COUNT_METRIC + e);
        }
        return customerCountMap;
    }

    /**
     * get unique customer list from the input param(key) map
     * Input is expected to be a map with reporting param as key & list of inputData for that param as values
     *
     * @param inputParamDataMap
     * @return
     */
    public static Map<String, Object> getUniqueCustomerListMap(Map<String, List<InputData>> inputParamDataMap) {
        Set<String> customerIds = new HashSet<>();
        Map<String, Object> customerIdsMap = new HashMap<>();
        try {
            if (inputParamDataMap != null && !inputParamDataMap.isEmpty()) {
                for (Map.Entry<String, List<InputData>> kv : inputParamDataMap.entrySet()) {
                    customerIds = kv.getValue().stream().map(InputData::getCustomerId).collect(Collectors.toSet());
                    customerIdsMap.put(kv.getKey(), customerIds.stream().map(String::valueOf).collect(Collectors.joining(COMMA)));
                }
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION_CALCULATING_CUSTOMER_ID_LIST_METRIC + e);
        }
        return customerIdsMap;
    }

    /**
     * get average build duration for each param(key) of the input param map
     * Input is expected to be a map with reporting param as key & list of inputData for that param as values
     *
     * @param inputParamDataMap
     * @return
     */
    public static Map<String, Object> getAverageBuildDurationMap(Map<String, List<InputData>> inputParamDataMap) {
        Map<String, Object> avgBuildDurationMap = new HashMap<>();
        double totalBuildDuration = 0.0, avgBuildDuration = 0.0;
        try {
            if (inputParamDataMap != null && !inputParamDataMap.isEmpty()) {
                for (Map.Entry<String, List<InputData>> kv : inputParamDataMap.entrySet()) {
                    totalBuildDuration = kv.getValue().stream()
                            .map(input -> getBuildDurationTime(input.getBuildDuration()))
                            .mapToDouble(Double::valueOf).sum();
                    avgBuildDuration = totalBuildDuration / kv.getValue().size();
                    avgBuildDurationMap.put(kv.getKey(), String.format(BUILD_DURATION_FORMATTER, avgBuildDuration));
                }
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION_CALCULATING_AVG_BUILD_DURATION_METRIC + e);
        }
        return avgBuildDurationMap;
    }
}
