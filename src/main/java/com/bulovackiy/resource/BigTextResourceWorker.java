package com.bulovackiy.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.BiConsumer;

/**
 * Worker to process data in {@link BufferedReader} by parts in some size {@link #lineCount} that can be configured
 * by constructor
 * 
 * @author Eugene Bulovackiy
 */
public class BigTextResourceWorker implements ResourceWorker {

    private static final Logger LOG = LoggerFactory.getLogger(BigTextResourceWorker.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();
    
    private final int lineCount;
    private int workedLineCount = 0;

    public BigTextResourceWorker(int lineCount) {
        this.lineCount = lineCount;
    }

    /**
     * Process data from {@param br} in partial way
     * and join all line together by {@link StringBuilder}
     * line will be separated by {@link #LINE_SEPARATOR} for ability to count them
     * 
     * @param br - contains data that should be processed
     * @param processLine - {@link BiConsumer} that will consume processed data
     * @param onDone - {@link Runnable} that should be called when data processed
     *
     * @author Eugene Bulovackiy
     */
    @Override
    public void init(BufferedReader br, BiConsumer<String, Integer> processLine, Runnable onDone) {
        try (br) {
                String line;
                int count = 0;
                var sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    if (count == lineCount) {
                        processLine.accept(sb.toString(), workedLineCount);
                        workedLineCount += count;
                        sb.setLength(0);
                        count = 0;
                    }
                    sb.append(line.toCharArray());
                    sb.append(LINE_SEPARATOR);
                    count++;
                }
                processLine.accept(sb.toString(), workedLineCount);
            onDone.run();
        } catch (IOException e) {
            LOG.error("Error occurred when trying to get information from BufferedReader", e);
        }
    }
}
