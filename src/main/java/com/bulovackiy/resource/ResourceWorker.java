package com.bulovackiy.resource;

import java.io.BufferedReader;
import java.util.function.BiConsumer;

/**
 * Worker that will process some resource of data
 *
 * @author Eugene Bulovackiy
 */
public interface ResourceWorker {

    /**
     * Initialising method that will start processing of some data
     * 
     * @param br - contains data that should be processed
     * @param processLine - {@link BiConsumer} that will consume processed data
     * @param onDone - {@link Runnable} that should be called when data processed
     *
     * @author Eugene Bulovackiy
     */
    void init(BufferedReader br, BiConsumer<String, Integer> processLine, Runnable onDone);
}
