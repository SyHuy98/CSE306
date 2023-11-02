package CSE306;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dowloadsongandplay {
    public static void main(String[] args) throws Exception {
        // Specify the URL of the wav file to download
        URL audioURL = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
        // Create a temporary file to store the downloaded audio
        File tempFile = File.createTempFile("sample", ".wav");
        // Download the audio from the URL to the temporary file
        org.apache.commons.io.FileUtils.copyURLToFile(audioURL, tempFile);
        // Get the AudioInputStream from the temporary file
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(tempFile);
        // Create clip reference
        Clip clip = AudioSystem.getClip();

        // Open audio clip
        clip.open(audioStream);

        // Start playing the audio clip
        clip.start();

        Thread.sleep(clip.getMicrosecondLength() / 1000);
    }
}