import sun.misc.IOUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Archibald
 * @version:
 * @time: 6/15/2017.
 */
public class FileCreateTest {
    public static void main(String[] args) throws Exception {
        String localSrc = args[0];
        String dst = args[1];
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dst), conf);
        OutputStream out = fs.append(new Path(dst));
        IOUtils.copyBytes(in, out, 4096, true);
        in.close();
        out.close();
    }
}