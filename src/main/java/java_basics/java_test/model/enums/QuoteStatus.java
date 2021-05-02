package java_basics.java_test.model.enums;

import java.util.Arrays;

public enum QuoteStatus {
    SHORT (0, 10, "Short Quote"),
    MEDIUM (11, 20, "Medium Quote"),
    LONG (21, 1000, "Long Quote");

    private final int min;
    private final int max;
    private final String description;

    QuoteStatus(int min, int max, String description) {
        this.min = min;
        this.max = max;
        this.description = description;
    }

    public static QuoteStatus get(int val) {
        return Arrays.stream(values())
                .filter(range -> val >= range.min && val <= range.max)
                .findFirst()
                .orElse(null);
    }
}
