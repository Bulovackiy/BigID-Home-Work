package com.bulovackiy.aggregator;

import com.bulovackiy.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implements {@link Aggregator} for word location that collects in {@link Map<>} where:
 * <ul>
 *     <li>
 *         key -> is {@link String} with word
 *     </li>
 *     <li>
 *         value -> is {@link List} of {@link Location} where this word appear
 *     </li>
 * </ul>
 * 
 * @author Eugene Bulovackiy
 */
public class LocationAggregator implements Aggregator<Map<String, List<Location>>> {
    
    private static final Logger LOG = LoggerFactory.getLogger(LocationAggregator.class);

    private final Map<String, List<Location>> allLoc = new ConcurrentHashMap<>();

    /**
     * Aggregate data into {@link #allLoc}
     * <p>
     *     If there will be collision by key, value will be added to previous one;
     * </p>
     * 
     * @param locations - data that need to be aggregated
     *
     * @author Eugene Bulovackiy
     */
    @Override
    public void aggregate(Map<String, List<Location>> locations) {
        locations.forEach((k, v) -> allLoc.merge(k, v, (v1, v2) -> {
            v1.addAll(v2);
            return v1;
        }));
    }

    /**
     * Printing all data from {@link #allLoc} in console by {@link #LOG}
     * 
     * @author Eugene Bulovackiy
     */
    @Override
    public void printResult() {
        allLoc.forEach((k, v) -> LOG.info("%s --> %s".formatted(k, v)));
    }
    
    protected Map<String, List<Location>> getAllLoc() {
        return this.allLoc;
    }
}
