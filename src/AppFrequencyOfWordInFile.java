import java.io.IOException;
import java.util.Map;

public class AppFrequencyOfWordInFile {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("argument filename is missing");
            return;
        }

        String filename = args[0];
        Map<String, Integer> result;
        try {
            result = FIleUtils.getWordFrequencyFromFile(filename);
        } catch (IOException e) {
            System.out.print("Something was wrong with fileStreams");
            return;
        }
        print(result);
    }

    private static void print(Map<String , Integer> map) {
        for (String key : map.keySet()) {
            System.out.print(key + ": " + map.get(key) + " ");
        }
    }
}