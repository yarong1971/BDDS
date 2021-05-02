package java_basics.java_test;

import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.List;

@Data
public class Producer {

    public static void main(String[] args) {
        Quote quote = QuoteFactory.createQuote();
        System.out.println(quote);
        ObjectWriter<Quote> writer = new ObjectWriter<>();
        writer.write(quote);
    }
}
