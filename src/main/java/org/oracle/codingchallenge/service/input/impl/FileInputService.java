package org.oracle.codingchallenge.service.input.impl;

import org.oracle.codingchallenge.repository.Store;
import org.oracle.codingchallenge.service.input.InputService;

/**
 * Input service class implementation to read from file
 *
 * Note: This class has not been implemented as it's out of scope from this assignment.
 * But to display the scalability of the system this empty class has been placed
 *
 */
public class FileInputService implements InputService {

    Store store;
    public FileInputService(Store store) {
        this.store = store;
    }


    @Override
    public StringBuffer read() {
        return null;
    }
}
