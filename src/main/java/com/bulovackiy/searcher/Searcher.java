package com.bulovackiy.searcher;

import com.bulovackiy.model.Location;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Searcher that should 
 */
public interface Searcher {

    /**
     * This method should be called by some outside object that will just send {@param text} into this method
     * Also need to be provided some {@param action} to know what to do with results of searching
     *
     * @param text - text that will be checked
     * @param startLineNumber - number of started line to can work with partial data
     * @param action - will be called to process result of search
     *
     * @author Eugene Bulovackiy
     */
    void search(String text, int startLineNumber, Consumer<Map<String, List<Location>>> action);

    /**
     * To get know that outside resource is finished
     * 
     * @param action - some action that can be run after all works done
     *
     * @author Eugene Bulovackiy
     */
    void done(Runnable action);
}
