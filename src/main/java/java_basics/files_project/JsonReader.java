package java_basics.files_project;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader implements Reader {
    @SneakyThrows
    @Override
    public void read(File file) {

        byte[] fileBytes = Files.readAllBytes(Paths.get(file.getPath()));
        String jsonString = new String(fileBytes);

        //DeSerialization
        Gson gson = new Gson();
        Employee[] employeeArray = gson.fromJson(jsonString, Employee[].class);
    }
}
