package com.bulovackiy.matcher;

import com.bulovackiy.model.Location;

import java.util.List;
import java.util.Map;

/**
 * Matcher for checking some {@code text} or part of it
 * and returning {@link Location} for each match in {@code text}
 *
 * @author Eugene Bulovackiy
 */
public interface Matcher {

    /**
     * Finding all matches in {@param text}
     * 
     * @param text - text where all matches need to be checked
     * @param startLineNumber - if there is part of bigger text, to know from what line we work
     *                        
     * @return {@link Map} where:
     * <ul>
     *     <li>
     *         key - word that matched
     *     </li>
     *     <li>
     *         value - {@link List} of {@link Location} where word matched
     *     </li>
     * </ul>
     *
     * @author Eugene Bulovackiy
     */
    Map<String, List<Location>> findMatch(String text, int startLineNumber);
}
