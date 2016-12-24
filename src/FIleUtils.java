import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Map;

/**
 * Utils for files
 */
public final class FIleUtils {
    private FIleUtils() {
    }
    public static Map<String,Integer> getWordFrequencyFromFile(String filename) throws IOException{
        String string;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // might be very looooong string!
        try {
            string = IOUtils.toString(reader);
        } finally {
            IOUtils.closeQuietly(reader);
        }
        Map<String, Integer> result = StringUtils.getFrequencyWord(string);
        return result;
    }

    public static void rewrite(InputStream in, String inEncoding, OutputStream out, String outEncoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, inEncoding));
        IOUtils.copy(reader, out, outEncoding);
        IOUtils.closeQuietly(reader);
    }
}