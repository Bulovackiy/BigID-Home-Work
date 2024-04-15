package com.bulovackiy.utils;

import java.text.BreakIterator;

/**
 * Class to help work with {@link String}
 *
 * @author ebulovackiy
 */
public class StringWithSeparatorUtils {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    
    private final BreakIterator iterator = BreakIterator.getWordInstance();
    private final String text;

    private int lastIndex;
    private int previousIndex;
    private int currentLineNumber = 1;
    private int previousLineIndex = 0;

    public StringWithSeparatorUtils(String text) {
        this.text = text;
        iterator.setText(text);
        lastIndex = iterator.first();
    }

    public boolean hasNext() {
        return iterator.getText().getEndIndex() != lastIndex;
    }

    public int getCurrentLineNumber() {
        return currentLineNumber;
    }

    public int getWordCharOffset() {
        return (previousIndex - previousLineIndex);
    }

    /**
     * Will return word {@link #text} in one by one way
     * Have some additional abilities:
     * <ul>
     *     <li>
     *        Skip " ";
     *     </li>
     *     <li>
     *         Count line by {@link #LINE_SEPARATOR}
     *     </li>
     * </ul>
     * Need to use {@link #hasNext()} method to avoid exception when text will be over
     * 
     * @return word
     */
    public String getNextWord() {
        previousIndex = lastIndex;
        lastIndex = iterator.next();

        var result = text.substring(previousIndex, lastIndex);

        if ((result.contains(LINE_SEPARATOR)) && hasNext()) {
            currentLineNumber++;
            previousLineIndex = lastIndex;
            result = getNextWord();
        }

        if (result.equals(" ") && hasNext()) {
            result = getNextWord();
        }

        return result;
    }
}
