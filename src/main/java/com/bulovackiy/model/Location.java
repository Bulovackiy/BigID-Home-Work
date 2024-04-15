package com.bulovackiy.model;

import java.util.Objects;

/**
 * Represents information about String location
 * in Text Line
 *
 * @author ebulovackiy
 */
public record Location(int lineOffset, int charOffset) {
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return lineOffset == location.lineOffset && charOffset == location.charOffset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineOffset, charOffset);
    }

    @Override
    public String toString() {
        return "[lineOffset=%s, charOffset=%s]".formatted(lineOffset, charOffset);
    }
}
