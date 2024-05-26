package org.oracle.codingchallange.repository;

import java.util.List;

/**
 * Global repository store for storing the data for report generation
 * Has 3 generic methods to help interaction with store & store data.
 *
 * @param <T>
 */
public interface Store<T> {

    List<T> read();

    void save(List<T> dataList);
}
