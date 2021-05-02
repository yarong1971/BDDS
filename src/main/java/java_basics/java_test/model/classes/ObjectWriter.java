package java_basics.java_test.model.classes;

import java_basics.java_test.model.interfaces.Writer;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectWriter<T> implements Writer<T> {
    @SneakyThrows
    @Override
    public void write(T t) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "C:\\Yaron\\ObjectFiles\\Quote_" + timeStamp + ".obj";

        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }

        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t);
        System.out.println(fileName + " was created");

        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
