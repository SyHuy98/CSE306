package CSE306;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
public class DowloadImage {
    public static void downloadImage(String imageUrl, String destinationFile) throws Exception {
        URL url = new URL(imageUrl);
        InputStream inputStream = url.openStream();
        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();

    }

    public static void main(String[] args) throws Exception {
        String imageUrl = "https://www.tanbinhtech.com:8443/july.webp";
        String destinationFile = "D:\\pentest";
        DowloadImage.downloadImage(imageUrl, destinationFile);

    }

}