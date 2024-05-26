package org.oracle.codingchallenge.utils;

import org.oracle.codingchallenge.model.InputData;

import java.util.ArrayList;
import java.util.List;

import static org.oracle.codingchallenge.constants.Constants.COMMA;
import static org.oracle.codingchallenge.constants.Constants.NEW_LINE;

public class MappingUtil {
    /**
     * Map the raw input to InputData pojo
     * @param buffer
     * @return
     */
    public static List<InputData> mapRawInputToData(StringBuffer buffer) {
        List<InputData> inputDataList = new ArrayList<>();
        InputData inputData = null;
        if (buffer != null && !buffer.isEmpty()) {
            String [] inputLines = buffer.toString().split(NEW_LINE);
            for (String input : inputLines) {
                String [] val = input.split(COMMA);
                inputData = new InputData(val[0], val[1], val[2], val[3], val[4], val[5]);
                inputDataList.add(inputData);
            }
        }
        return inputDataList;
    }
}
