package java_basics.java_test.model.classes;

import java_basics.java_test.model.interfaces.Reader;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReader<T> implements Reader<T> {
    @SneakyThrows
    @Override
    public T read(File file) {
        FileInputStream fis = new FileInputStream(String.valueOf(file));
        ObjectInputStream oos = new ObjectInputStream(fis);
        T obj = (T) oos.readObject();
        System.out.println(obj);

        try{
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
