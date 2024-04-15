package com.bulovackiy.searcher;

import com.bulovackiy.matcher.LocationMatcher;
import com.bulovackiy.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Searcher that will start {@link LocationMatcher} in asynchronous
 * way for each {@link #search(String, int, Consumer)} call
 * <p>
 *     for async work used {@link CompletableFuture}
 * </p>
 * 
 * @author Eugene Bulovackiy
 */
public class LocationSearcher implements Searcher {
    
    private final List<CompletableFuture<Void>> futures = new ArrayList<>();

    /**
     * This method should be called by some outside object that will just send {@param text} into this method
     * Also need to be provided some {@param action} to know what to do with results of searching
     * <p>
     *     For each call will be created new {@link CompletableFuture} with {@link LocationMatcher} run inside
     *     and when will be done data will be sent to {@param action}
     * </p>
     * 
     * @param text - text that will be checked
     * @param startLineNumber - number of started line to can work with partial data
     * @param action - will be called to process result of search 
     *
     * @author Eugene Bulovackiy
     */
    @Override
    public void search(String text, int startLineNumber, Consumer<Map<String, List<Location>>> action) {
        futures.add(CompletableFuture.supplyAsync(() -> new LocationMatcher().findMatch(text, startLineNumber))
                .thenAccept(action));
    }

    /**
     * Call this method to get know that outside object is finished
     * 
     * @param action - some action that can be run after all works done
     */
    public void done(Runnable action) {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        action.run();
    }
}
