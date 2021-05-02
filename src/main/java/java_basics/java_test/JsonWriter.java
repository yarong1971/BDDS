package java_basics.java_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonWriter<T> implements Writer<T> {
    @SneakyThrows
    @Override
    public void write(T t) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "C:\\Yaron\\JsonFiles\\Quote_" + timeStamp + ".json";

        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(t);
        System.out.println("to json returned " + jsonString);

        BufferedWriter bw = null;

        try {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(jsonString);
            System.out.println("File " + fileName + " written Successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
}