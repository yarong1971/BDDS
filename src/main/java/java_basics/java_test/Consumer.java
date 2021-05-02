package java_basics.java_test;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class Consumer {
    @SneakyThrows
    public static void main(String[] args) {
        final Path path = Path.of("C:/Yaron/ObjectFiles");

        while (!isEmpty(path)) {
            new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getId());
                File[] fileList = path.toFile().listFiles();
                File file = fileList[0];

                ObjectReader<Quote> reader = new ObjectReader<>();
                Quote quote = reader.read(file);
                JsonWriter<Quote> writer = new JsonWriter<>();
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

            Thread.sleep(3000);
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
