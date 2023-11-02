package CSE306;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javazoom.jl.player.Player;
public class mp3song {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://ice10.outlaw.fm/KIEV2");
            InputStream inputStream = url.openStream();
            BufferedInputStream buffer = new BufferedInputStream(inputStream);
            Player mp3Player = new Player(buffer);
            mp3Player.play();
        } catch (Exception ex) {
            System.out.println("Error occured during playback process:" + ex.getMessage());
        }













//        try {
//
//            URL url = new URL("http://ice10.outlaw.fm/KIEV2");
//            InputStream inputStream = url.openStream();
//
//
//            BufferedInputStream buffIn = new BufferedInputStream(inputStream);
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(buffIn);
//            AudioFormat audioFormat = audioStream.getFormat();
//            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
//            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
//            sourceDataLine.open(audioFormat);
//            sourceDataLine.start();
//        byte[] bufferBytes = new byte[BUFFER_SIZE];
//        int readBytes = -1;
//        while ((readBytes = audioStream.read(bufferBytes)) != -1) {
//            sourceDataLine.write(bufferBytes, 0, readBytes);
//        }
//        sourceDataLine.drain();
//        sourceDataLine.close();
//        audioStream.close();
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            e.printStackTrace();
//        }
        }


    private static final int BUFFER_SIZE = 4096;
}
