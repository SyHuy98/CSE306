package CSE306;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientAsk {
	 public static final int PORT = 19;
  public static void main(String[] args) throws IOException, InterruptedException {
  
    Socket socket = new Socket("localhost", PORT);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.print("Enter message: ");
      String input = scanner.nextLine();
      out.println(input);
      
      if("quit".equals(input)) {
        break;
      }
      Thread.sleep(1000);
      String resp = in.readLine();
      System.out.println(resp);
      
    }
    
    socket.close();
    
  }

}