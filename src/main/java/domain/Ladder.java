package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final Names names;
    private final Lines lines;

    public Ladder(Names names, Lines lines) {
        this.names = new Names(names.getValues());
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }

    public Names getNames() {
        return new Names(names.getValues());
    }
}
