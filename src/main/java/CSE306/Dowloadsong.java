package CSE306;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Dowloadsong {
    public static void main(String[] args) throws Exception {
        String url = "https://www.tanbinhtech.com:8443/sample10.wav";
        InputStream in = new URL(url).openStream();
        String outputPath = "C:\\Users\\Syhuy98\\Downloads\\Music\\downloaded.wav";
        FileOutputStream out = new FileOutputStream(outputPath);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.close();
        in.close();
        System.out.println("File downloaded!");
    }

}