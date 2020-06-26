package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {
    public static final int MIN_NAME_NUMBER = 2;
    public static final String LESS_THEN_MIN_NUMBER_LIMIT_MESSAGE = "최소 2명이상 참가해야 합니다.";
    private final List<Name> names;

    public Names(List<Name> names) {
        validateNames(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNames(List<Name> names) {
        if (names.size() < MIN_NAME_NUMBER) {
            throw new IllegalArgumentException(LESS_THEN_MIN_NUMBER_LIMIT_MESSAGE);
        }
    }

    public int calculatePersonNumber() {
        return names.size();
    }

    public List<Name> getValues() {
        return Collections.unmodifiableList(names);
    }
}
