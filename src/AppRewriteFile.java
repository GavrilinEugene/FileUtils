import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Rewrite from UTF-16 to cp-1251
 */
public class AppRewriteFile {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("arguments: input filename, output filename");
            return;
        }

        String inFile = args[0];
        String outFile = args[1];

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(inFile);
            out = new FileOutputStream(outFile);
            FIleUtils.rewrite(in, "UTF-16", out, "cp-1251");
        } catch (IOException e) {
            System.err.println("Something was wrong with fileStreams");
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }
}