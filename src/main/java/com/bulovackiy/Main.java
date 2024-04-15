package com.bulovackiy;

import com.bulovackiy.aggregator.LocationAggregator;
import com.bulovackiy.client.FileBigTextClient;
import com.bulovackiy.client.HttpBigTextClient;
import com.bulovackiy.resource.BigTextResourceWorker;
import com.bulovackiy.searcher.LocationSearcher;

/**
 * This program will find all Common English Names that provided in {@link com.bulovackiy.data.CommonEnglishNames}
 * and will print all founded data with location in text in console;
 *
 * <p>
 *     Can be used {@link HttpBigTextClient} to get text by HTTP call or {@link FileBigTextClient} to get text from /resources
 *     Each of them return the same text
 * </p>
 * 
 */
public class Main {
    public static void main(String[] args) {
        var client = new HttpBigTextClient();
//        var client = new FileBigTextClient();
        var aggregator = new LocationAggregator();
        var searcher = new LocationSearcher();
        var resource = new BigTextResourceWorker(1000);
        
        resource.init(client.getBigText(), 
                (line, startLineIndex) -> searcher.search(line, startLineIndex, aggregator::aggregate),
                () -> searcher.done(aggregator::printResult));
    }
}