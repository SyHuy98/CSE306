package CSE306;

import java.io.*;
import java.net.*;

public class ServerAnswer {
	 public static final int PORT = 19;
  public static void main(String[] args) throws IOException {
    
    ServerSocket server = new ServerSocket(PORT);
    boolean quit = false;
    while (true) {
    
      Socket socket = server.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      
      String input;
      while ((input = in.readLine()) != null) {
        if ("quit".equals(input)) {
        	quit = true;
          break;
        }
        out.println("Echo: " + input);
      }

      socket.close();
      if(quit) {
    	  break;
      }
    }

  }

}