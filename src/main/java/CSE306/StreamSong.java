package CSE306;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class StreamSong {
    public static void main(String[] args) {
        try {
            // Define the URL of the online audio file
            URL audioURL = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            // Open an audio input stream from the URL
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioURL);
            // Get an audio clip from the audio input stream
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            // Start playing the audio
            audioClip.start();
            // Wait for the audio to finish playing
            Thread.sleep(audioClip.getMicrosecondLength()/1000);
            // Close the audio clip and stream
            audioClip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
