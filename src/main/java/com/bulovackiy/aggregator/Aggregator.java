package com.bulovackiy.aggregator;

/**
 * Aggregator to aggregate some data to one field or collection
 *
 * @author Eugene Bulovackiy
 */
public interface Aggregator<T> {

    /**
     * Receive some data with type {@code T} and aggregate it some field or collection
     * 
     * @param t - data that need to be aggregated
     */
    void aggregate(T t);

    /**
     * Print all data that aggregated
     */
    void printResult();
}
