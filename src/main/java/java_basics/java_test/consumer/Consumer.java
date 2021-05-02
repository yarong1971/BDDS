package java_basics.java_test.consumer;

import java_basics.java_test.model.interfaces.Reader;
import java_basics.java_test.services.ReaderFactory;
import java_basics.java_test.model.interfaces.Writer;
import java_basics.java_test.services.WriterFactory;
import java_basics.java_test.model.classes.Quote;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Consumer {
    @SneakyThrows
    public static void main(String[] args) {
        final Path path = Path.of("C:/Yaron/ObjectFiles");
        ReaderFactory<Quote> readerFactory = new ReaderFactory<Quote>();
        WriterFactory<Quote> writerFactory = new WriterFactory<Quote>();

        while (!isEmpty(path)) {
            new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getId());
                File[] fileList = path.toFile().listFiles();
                File file = fileList[0];

                Reader<Quote> reader = readerFactory.getReader("object");
                Quote quote = reader.read(file);

                Writer<Quote> writer = writerFactory.getWriter("json");
                writer.write(quote);

                if (file.exists()) {
                    System.out.print("File " + fileList[0].getName());
                    if(fileList[0].delete())
                    {
                        System.out.println(" deleted successfully");
                    }
                    else
                    {
                        System.out.println(" failed to delete the file");
                    }
                }
            }).start();

            Thread.sleep(1500);
        }

        System.out.println("Directory " + path + " is empty");
    }

     static boolean isEmpty(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            try (Stream<Path> entries = Files.list(path)) {
                return !entries.findFirst().isPresent();
            }
        }

        return false;
    }
}
