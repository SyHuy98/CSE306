package CSE306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TicTacToeClient {
    public static final String SERVER_ADDRESS = "localhost";
    public static final int SERVER_PORT = 19;
    public static final int TIMEOUT = 2000;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        socket.setSoTimeout(TIMEOUT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        try {
            while (true) {
                //System.out.println("Waiting for server response...");
                String serverResponse = in.readLine();

                if (serverResponse == null) break;

                System.out.println( serverResponse);

                // Game over conditions
                if (serverResponse.startsWith("Player X wins!") ||
                        serverResponse.startsWith("Player O wins!") ||
                        serverResponse.startsWith("The game is a draw!")) {
                    break;
                }

                if (serverResponse.contains("enter your move")) {
                    System.out.print("Enter your move (row[1-3] column[1-3]): ");
                    userInput = userInputBR.readLine();
                    out.println(userInput);
                }

            }
        } finally {
            socket.close();
            userInputBR.close();
        }
    }
}