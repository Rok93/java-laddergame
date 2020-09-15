package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Names {
    private static final int MIN_NAME_NUMBER = 2;
    private static final String LESS_THEN_MIN_NUMBER_LIMIT_MESSAGE = "최소 2명이상 참가해야 합니다.";
    private static final String NOT_FOUND_NAME_MESSAGE = "존재하지 않는 참가자입니다. ";

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

    public int findPositionNumber(Name personName) {
        return IntStream.range(0, names.size())
                .filter(position -> names.get(position).equals(personName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_NAME_MESSAGE));
    }

    public String getValue(int position) {
        return names.get(position).getValue();
    }
}
