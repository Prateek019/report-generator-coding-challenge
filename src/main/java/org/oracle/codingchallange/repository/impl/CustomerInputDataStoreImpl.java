package org.oracle.codingchallange.repository.impl;

import org.oracle.codingchallange.model.InputData;
import org.oracle.codingchallange.repository.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer Input data implementation for the store.
 * <p>
 * The object for this store class will hold the formatted input data which can be anywhere used for report generation
 * It has the implementations for the store interaction methods.
 * @param <T>
 */
public class CustomerInputDataStoreImpl<T> implements Store<T> {
    List<InputData> inputDataList = new ArrayList<>();

    @Override
    public List<T> read() {
        return (List<T>) inputDataList;
    }

    @Override
    public void save(List<T> dataList) {
        if (dataList != null) {
            List<InputData> dataToSave = dataList.stream().map(data -> (InputData) data).toList();
            this.inputDataList.addAll(dataToSave);
        } else {

        }
    }
}
