package com.bulovackiy.client;

import java.io.BufferedReader;

/**
 * Interface for classes that should get some Big Text
 *
 * @author Eugene Bulovackiy
 */
public interface BigTextClient {

    /**
     * This method should return Big Text in {@link BufferedReader}
     *
     * @return {@link BufferedReader} with some Big Text
     */
    BufferedReader getBigText();
}
