
import java.util.HashMap;
import java.util.Map;

/*
 * utils for working with strings
 */
public final class StringUtils {
    private StringUtils() {
    }

    public static Map<String, Integer> getFrequencyWord(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        String[] words = text.toLowerCase().split("\\s+|\\s*,\\s*|\\s*\\.\\s*");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count == null) ? 1 : count + 1);
        }
        return wordCount;
    }
}
