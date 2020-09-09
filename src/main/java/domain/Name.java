package domain;

import java.util.Objects;

public class Name {
    public static final int LIMIT_MAX_NAME_LENGTH = 5;
    public static final int LIMIT_MIN_NAME_LENGTH = 1;
    public static final String NAME_LENGTH_RANGE_LIMIT_MESSAGE = "사람의 이름은 최소 1글자 이상 최대 5글까지만 가능합니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > LIMIT_MAX_NAME_LENGTH || name.length() < LIMIT_MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_LIMIT_MESSAGE);
        }
    }

    public String getValue() {
        return name;
    }

    public boolean isEqualTo(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
