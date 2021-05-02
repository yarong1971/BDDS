package java_basics.java_test.model.classes;

import java_basics.java_test.model.interfaces.Reader;

import java.io.File;

public class JsonReader<T> implements Reader<T> {
    @Override
    public T read(File file) {
        return null;
    }
}
