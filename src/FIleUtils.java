import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Map;

/**
 * Utils for files
 */
public final class FIleUtils {
    private FIleUtils() {
    }

//    public static Map<String, Integer> frequencyWordsFromFile(String filename) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(filename));
//        //Map<String, Integer> result = StringUtils.frequencyWord(reader);
//        IOUtils.closeQuietly(reader);
//        //return result;
//    }

    public static void rewrite(InputStream in, String inEncoding, OutputStream out, String outEncoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, inEncoding));
        IOUtils.copy(reader, out, outEncoding);
        IOUtils.closeQuietly(reader);
    }
}