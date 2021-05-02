package java_basics.java_test.producer.utils;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static <T>  T getRandomItem(List<T> list)
    {
        int i = getNumber(list.size()) - 1;
        return list.get(i);
    }

    public static int getNumber(int num) {
        return random.nextInt(num);
    }
}
