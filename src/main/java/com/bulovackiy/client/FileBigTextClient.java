package com.bulovackiy.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Getting text from file in {@code src/main/resources/big.txt}
 * 
 * @author Eugene Bulovackiy
 */
public class FileBigTextClient implements BigTextClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileBigTextClient.class);

    /**
     * Getting text from file in {@code src/main/resources/big.txt}
     *
     * Be carefully with this one. It's need to be closed in ideal world
     * 
     * @return {@link BufferedReader} with text
     */
    @Override
    public BufferedReader getBigText() {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/big.txt")));
        } catch (IOException e) {
            LOGGER.error("Some error with file reading", e);
        }

        return null;
    }
}
