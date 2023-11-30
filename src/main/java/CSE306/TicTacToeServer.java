package CSE306;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TicTacToeServer {
    public static final int PORT = 19;
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        initBoard();

        try {
            System.out.println("Server is running....");
            Socket socket = server.accept();
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to Tic Tac Toe. Player X goes first.");
            printBoard(out);

            while (true) {
                out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
                String input = in.readLine();
               if (input == null || "quit".equals(input)) {
                   break;
               }
                if (handleMove(input, out)) {
                    printBoard(out);
                    if (checkForWin()) {
                        out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isBoardFull()) {
                        out.println("The game is a draw!");
                        break;
                    }
                    switchPlayer();
                }
            }
        } finally {
            server.close();
        }
    }

    private static void initBoard() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }
    private static class ClientHandler implements Runnable {

        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client connection
            // (Move existing client handling logic here)
        }
    }


    private static boolean handleMove(String move, PrintWriter out) {
        try {
            String[] parts = move.split(" ");
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                return true;
            } else {
                out.println("Invalid move. Try again.");
                return false;
            }
        } catch (Exception e) {
            out.println("Invalid input. Please enter the row and column numbers separated by a space.");
            return false;
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private static boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonalsForWin() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static void printBoard(PrintWriter out) {
        for (int i = 0; i < 3; i++) {
            out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                out.println("---+---+---");
            }
        }
    }
}