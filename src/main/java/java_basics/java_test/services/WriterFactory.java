package java_basics.java_test.services;

import java_basics.java_test.model.classes.JsonWriter;
import java_basics.java_test.model.classes.ObjectWriter;
import java_basics.java_test.infra.Writer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WriterFactory<T> {
    final Map<String, Supplier<Writer<T>>> map = new HashMap<>();
    {
        map.put("OBJECT", ObjectWriter<T>::new);
        map.put("JSON", JsonWriter<T>::new);
    }
    public Writer<T> getWriter(String writerType){
        Supplier<Writer<T>> writer = map.get(writerType.toUpperCase());
        if(writer != null) {
            return writer.get();
        }
        throw new IllegalArgumentException("No such writer " + writerType.toUpperCase());
    }
}
