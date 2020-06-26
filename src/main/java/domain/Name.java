package domain;

public class Name {
    public static final int LIMIT_MAX_NAME_LENGTH = 5;
    public static final int LIMIT_MIN_NAME_LENGTH = 1;
    public static final String OVER_NAME_LENGTH_LIMIT_MESSAGE = "사람의 이름은 최소 1글자 이상 최대 5글까지만 가능합니다.";
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > LIMIT_MAX_NAME_LENGTH || name.length() < LIMIT_MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_NAME_LENGTH_LIMIT_MESSAGE);
        }
    }

    public String getValue() {
        return name;
    }
}
