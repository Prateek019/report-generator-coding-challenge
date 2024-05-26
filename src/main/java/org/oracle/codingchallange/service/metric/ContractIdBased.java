package org.oracle.codingchallange.service.metric;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.model.Metric;
import org.oracle.codingchallange.utils.ReportGenerationUtils;

import java.util.*;

import static org.oracle.codingchallange.constants.Constants.*;

public class ContractIdBased implements MetricService {
    Map<String, List<InputData>> contractIdInputMap;

    public ContractIdBased() {
        if (contractIdInputMap == null) {
            this.contractIdInputMap = new HashMap<>();
        }
    }

    /**
     * get list of metrics based on contractId
     * <p>
     * This method will format the inputData list into a map.
     * Map structure: contractId (key) -> InputDataList (value)
     * <p>
     * Each contractId's bucket will have the list of inputData objects belonging to that contractId.
     * This will facilitate the contractId based metrics calculation
     * <p>
     * Further this method will call all the utility methods to get the required metrics based on contractId and return a list
     *
     * @param inputDataList
     * @return
     */
    @Override
    public List<Metric> getMetric(List<InputData> inputDataList) {
        List<Metric> metrics = new ArrayList<>();
        try {
            String contractId;
            for (InputData inputData : inputDataList) {
                contractId = inputData.getContractId();
                if (!contractIdInputMap.containsKey(contractId)) {
                    contractIdInputMap.put(String.valueOf(contractId), new ArrayList<>(Arrays.asList(inputData)));
                } else {
                    contractIdInputMap.get(contractId).add(inputData);
                }
            }
            Map<String, Object> customerCountMap = ReportGenerationUtils.getUniqueCustomerCountMap(contractIdInputMap);
            metrics.add(new Metric(NO_OF_UNIQUE_CUSTOMER_IDS_FOR_CONTRACT_ID, customerCountMap));
        } catch (Exception e) {
            System.out.println(EXCEPTION_CALCULATING_CONTRACT_ID_BASED_METRIC + e);
        }
        return metrics;
    }
}
