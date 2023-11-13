package CSE306;
import java.io.*;
import java.net.*;



public class testconect {
    public static final String SERVER = "telehack.com";
    public static final int PORT = 23;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String command;

            System.out.println("Connected to telehack.com. Type 'quit' to exit.");

            do {
                System.out.print("Enter a word to define: ");
                command = userInput.readLine();

                if (!command.equalsIgnoreCase("quit")) {
                    define(command, writer, reader);
                }

            } while (!command.equalsIgnoreCase("quit"));

            writer.write("quit.\r\n");
            writer.flush();

            socket.close();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    static void define(String word, Writer writer, BufferedReader reader)
            throws IOException, UnsupportedEncodingException {
        writer.write("DEFINE fd-eng-lat " + word + "\r\n");
        writer.flush();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            System.out.println(line);
        }
    }
}
