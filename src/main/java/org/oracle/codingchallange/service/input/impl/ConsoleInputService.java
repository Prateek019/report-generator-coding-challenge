package org.oracle.codingchallange.service.input.impl;

import org.oracle.codingchallange.repository.Store;
import org.oracle.codingchallange.service.input.InputService;

import java.util.Scanner;

import static org.oracle.codingchallange.constants.Constants.CONSOLE_READ_ERROR;
import static org.oracle.codingchallange.constants.Constants.NEW_LINE;

/**
 * Input service class implementation to read from console
 */
public class ConsoleInputService implements InputService {

    Store store;
    public ConsoleInputService(Store store) {
        this.store = store;
    }

    /**
     * Read implementation to read the given set of string lines from console
     * This will read multiple lines of input till empty line is entered
     *
     * View Readme.md for more details on input format
     */
    @Override
    public StringBuffer read() {
        StringBuffer buffer = new StringBuffer();
        try(Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                if (read == null || read.isEmpty()) {
                    break;
                }
                buffer.append(read).append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println(CONSOLE_READ_ERROR + e);
        }
        return buffer;
    }
}
