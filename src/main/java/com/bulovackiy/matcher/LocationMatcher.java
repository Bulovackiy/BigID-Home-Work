package com.bulovackiy.matcher;

import com.bulovackiy.data.CommonEnglishNames;
import com.bulovackiy.model.Location;
import com.bulovackiy.utils.StringWithSeparatorUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Matcher to match Common English Names in text
 * @author Eugene Bulovackiy
 */
public class LocationMatcher implements Matcher {
    
    private final static Map<String, String> names = CommonEnglishNames.getNames();

    /**
     * Find all matches for Common english Names with some additional parameters:
     * <ul>
     *     <li>
     *         matches if name in lower case
     *     </li>
     *     <li>
     *         matches if name used in possessive way ('s)
     *     </li>
     * </ul>
     * 
     * @param text - text where all matches need to be checked
     * @param startLineNumber - if there is part of bigger text, to know from what line we work
     *
     * @return {@link Map} where:
     * <ul>
     *     <li>
     *         key - some Common English Name
     *     </li>
     *     <li>
     *         value - {@link List} with all {@link Location} of this name.
     *         <p>
     *             Location is showing the exact location of the word in each line
     *         </p>
     *     </li>
     * </ul>
     */
    @Override
    public Map<String, List<Location>> findMatch(String text, int startLineNumber) {
        var stringUtils = new StringWithSeparatorUtils(text);

        return Stream.iterate("", v -> stringUtils.hasNext(), v -> stringUtils.getNextWord().toLowerCase().replace("'s", ""))
                .map(names::get)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.mapping(n -> new Location(stringUtils.getCurrentLineNumber() + startLineNumber, stringUtils.getWordCharOffset()),
                                Collectors.toList())));
    }
}
