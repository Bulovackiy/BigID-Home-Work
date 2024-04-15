package com.bulovackiy.aggregator;

import com.bulovackiy.model.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationAggregatorTest {

    @Test
    void aggregate() {
        // GIVEN
        var aggregator = new LocationAggregator();
        var map1 = new HashMap<String, List<Location>>();
        map1.put("TEST_1", new ArrayList<>(List.of(new Location(1100, 1100),
                                         new Location(1200, 1200))));
        map1.put("TEST_2", new ArrayList<>(List.of(new Location(2100, 2100),
                                         new Location(2200, 2200))));
        
        var map2 = new HashMap<String, List<Location>>();
        map2.put("TEST_2", new ArrayList<>(List.of(new Location(3100, 3100),
                                         new Location(3200, 3200))));
        map2.put("TEST_3", new ArrayList<>(List.of(new Location(4100, 4100),
                                         new Location(4200, 4200))));
        
        var result = new HashMap<String, List<Location>>();
        result.put("TEST_1", new ArrayList<>(List.of(new Location(1100, 1100),
                                     new Location(1200, 1200))));
        result.put("TEST_2", new ArrayList<>(List.of(new Location(2100, 2100),
                                           new Location(2200, 2200),
                                           new Location(3100, 3100),
                                           new Location(3200, 3200))));
        result.put("TEST_3", new ArrayList<>(List.of(new Location(4100, 4100),
                                           new Location(4200, 4200))));
                
        // WHEN
        aggregator.aggregate(map1);
        aggregator.aggregate(map2);
        
        // THEN
        var allLoc = aggregator.getAllLoc();
        
        assertAll(() -> result.forEach((key, value) -> {
            assertIterableEquals(allLoc.get(key), value);
        }));
    }

    @Test
    void printResult() {
        
    }
    
    
}