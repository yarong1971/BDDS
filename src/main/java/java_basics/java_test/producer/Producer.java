package java_basics.java_test.producer;

import java_basics.java_test.producer.services.QuoteFactory;
import java_basics.java_test.model.interfaces.Writer;
import java_basics.java_test.services.WriterFactory;
import java_basics.java_test.model.classes.Quote;
import lombok.Data;

@Data
public class Producer {
    public static void main(String[] args) {
        WriterFactory<Quote> writerFactory = new WriterFactory<Quote>();

        Quote quote = QuoteFactory.createQuote();
        System.out.println(quote);

        Writer<Quote> writer = writerFactory.getWriter("object");
        writer.write(quote);
    }
}
