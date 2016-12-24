import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Tests
 */
public class FIleUtilsTest {
    @Test
    public void rewrite() throws Exception {
        String inFile = "inputRewrite.txt";
        String inEncoding = "UTF-16";
        String outFile = "outputRewrite.txt";
        String outEncoding = "cp1251";

        BufferedWriter writerExpected = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("expected.txt"), outEncoding));
        BufferedWriter writerInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inFile), inEncoding));

        String text = "This is the sample text to check that this bloody code работает&";

        writerExpected.write(text);
        writerInput.write(text);

        writerInput.flush();
        writerInput.close();
        writerExpected.flush();
        writerExpected.close();

        FileInputStream in = new FileInputStream(inFile);
        FileOutputStream out = new FileOutputStream(outFile);

        FIleUtils.rewrite(in, inEncoding, out, outEncoding);
        in.close();
        out.close();

        BufferedReader expectedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), inEncoding));
        BufferedReader actualReader = new BufferedReader(new InputStreamReader(new FileInputStream(outFile), outEncoding));

        String expectedLine;
        String actualLine;
        while ((actualLine = actualReader.readLine()) != null &&
                (expectedLine = expectedReader.readLine()) != null) {
            assertEquals(expectedLine, actualLine);
        }
        expectedReader.close();
        actualReader.close();
    }

    @Test
    public void frequencyWordsFromFile() throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testFrequency.txt"), "UTF-8"));
        String text = "we\n all love, love love\n cats\t cats Cats.";
        writer.write(text);
        writer.flush();
        writer.close();

        Map<String, Integer> expected = new TreeMap<>();
        expected.put("we", 1);
        expected.put("all", 1);
        expected.put("cats", 3);
        expected.put("love", 3);
        assertEquals(expected, FIleUtils.getWordFrequencyFromFile("testFrequency.txt"));
    }
}