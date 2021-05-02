package java_basics.java_test;

import lombok.*;

import java.io.Serializable;

@Data

public class Quote implements Serializable {
    private long id;
    private String message;
    private QuoteStatus status;

    public Quote(){}

    public Quote(long id, String message) {
        this.id = id;
        this.message = message;
        this.status = QuoteStatus.get(message.length());
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Quote;
    }

}
