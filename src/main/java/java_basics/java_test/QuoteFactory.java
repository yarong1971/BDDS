package java_basics.java_test;

import java.util.List;
import java.util.function.Supplier;

public class QuoteFactory {

    //private Supplier<Quote> quoteSupplier = () -> new Quote(System.nanoTime(),getRandomQuote());

    private static List<String> quoteList = List.of(
             "Hasta la vista, baby",
             "I don’t know how much longer I can hold this",
             "I like this car",
             "Come with me if you want to live",
             "I need your clothes, your boots, and your motorcycle",
             "I’ll be back",
             "You complete me.",
             "I drink your milkshake!",
             "You make me want to be a better man.",
             "These go to eleven.",
             "They call it a Royale with cheese.",
             "They're here!",
             "Yo, Adrian!",
             "Wax on, wax off.");

    private static String getRandomQuote() {
        String quoteItem = RandomUtil.getRandomItem(quoteList);
        return quoteItem;
    }

    public static Quote createQuote() {
        return new Quote(System.nanoTime(),QuoteFactory.getRandomQuote());
    }
}
