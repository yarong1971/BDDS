package java_basics.java_test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ReaderFactory <T> {
    final Map<String, Supplier<Reader<T>>> map = new HashMap<>();
    {
        map.put("OBJECT", ObjectReader<T>::new);
        map.put("JSON", JsonReader<T>::new);
    }
    public Reader<T> getReader(String readerType){
        Supplier<Reader<T>> reader = map.get(readerType.toUpperCase());
        if(reader != null) {
            return reader.get();
        }
        throw new IllegalArgumentException("No such reader " + readerType.toUpperCase());
    }
}
