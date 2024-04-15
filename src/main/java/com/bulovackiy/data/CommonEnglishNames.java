package com.bulovackiy.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Singleton class contains 50 most common English names
 */
public class CommonEnglishNames {

    private static final Map<String, String> instance = new HashMap<>();

    static {
        init();
    }

    /**
     * Just returning instance with 50 most common English names
     *
     * @return {@link List} of {@link String} that contains 50 common English names
     */
    public static synchronized Map<String, String> getNames() {
        return instance;
    }

    private static void init() {
        instance.put("james", "James");
        instance.put("john", "John");
        instance.put("robert", "Robert");
        instance.put("michael", "Michael");
        instance.put("william", "William");
        instance.put("david", "David");
        instance.put("richard", "Richard");
        instance.put("charles", "Charles");
        instance.put("joseph", "Joseph");
        instance.put("thomas", "Thomas");
        instance.put("christopher", "Christopher");
        instance.put("daniel", "Daniel");
        instance.put("paul", "Paul");
        instance.put("mark", "Mark");
        instance.put("donald", "Donald");
        instance.put("george", "George");
        instance.put("kenneth", "Kenneth");
        instance.put("steven", "Steven");
        instance.put("edward", "Edward");
        instance.put("brian", "Brian");
        instance.put("ronald", "Ronald");
        instance.put("anthony", "Anthony");
        instance.put("kevin", "Kevin");
        instance.put("jason", "Jason");
        instance.put("matthew", "Matthew");
        instance.put("gary", "Gary");
        instance.put("timothy", "Timothy");
        instance.put("jose", "Jose");
        instance.put("larry", "Larry");
        instance.put("jeffrey", "Jeffrey");
        instance.put("frank", "Frank");
        instance.put("scott", "Scott");
        instance.put("eric", "Eric");
        instance.put("stephen", "Stephen");
        instance.put("andrew", "Andrew");
        instance.put("raymond", "Raymond");
        instance.put("gregory", "Gregory");
        instance.put("joshua", "Joshua");
        instance.put("gerry", "Jerry");
        instance.put("dennis", "Dennis");
        instance.put("walter", "Walter");
        instance.put("patrick", "Patrick");
        instance.put("peter", "Peter");
        instance.put("harold", "Harold");
        instance.put("douglas", "Douglas");
        instance.put("henry", "Henry");
        instance.put("carl", "Carl");
        instance.put("arthur", "Arthur");
        instance.put("ryan", "Ryan");
        instance.put("roger", "Roger");
    }

}
