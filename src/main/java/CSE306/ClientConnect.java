package CSE306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class ClientConnect {

  public static final int PORT = 19;

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {

      try (Socket socket = new Socket("localhost", PORT)) {
        
        Writer out = new OutputStreamWriter(socket.getOutputStream());
        out.write(new Date().toString() + "\r\n");
        out.flush();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = in.readLine();
        System.out.println(result);
        
      } catch (IOException ex) {
        ex.printStackTrace();
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }

    }

  }

}