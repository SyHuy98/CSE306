package CSE306;import java.io.*;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;

public class WavPlayer {

    public static void main(String[] args) throws Exception {
        // Specify the audio file path
        File audioFile = new File("C:\\Users\\Syhuy98\\Downloads\\Music\\demo.wav");
        // Get the AudioInputStream
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        // Create clip reference
        Clip clip = AudioSystem.getClip();
        // Open audio clip
        clip.open(audioStream);
        // Start playing the audio clip
        clip.start();
        Thread.sleep(clip.getMicrosecondLength() / 1000);
    }
}