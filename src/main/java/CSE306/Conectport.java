package CSE306;

import java.*;
import java.io.*;
import java.net.*;
import java.net.URL;
public class Conectport {
    public static final String SERVER = "telehack.com";
    public static final int PORT = 23;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            //for (String word : args) {
               // define(word, writer, reader);
            //}
            int c ;
            boolean check = false;
            char prevC = 'a';
            while ((c = reader.read()) != -1){
                System.out.print((char) c);
                if ((char) c == '.' && prevC=='\n'){
                    break;
                }prevC = (char) c ;
            }
            String h = "eliza";
            while (!h.equals("quit\r\n")){
                define(h, writer, reader);
            }


            //writer.write("quit\r\n");
            //writer.write("quit.");
            writer.flush();
            String line = reader.readLine();
            while (!(line.equals("quit"))){
                writer.write(line +"\r\n");
                writer.flush();
                line =reader.readLine();

            }
            reader.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } finally { // dispose
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
    }

    static void define(String word, Writer writer, BufferedReader reader)
            throws IOException, UnsupportedEncodingException {
        writer.write( word + "\r\n");
        // writer.write("DEFINE fd-eng-lat " + word + ".");
        writer.flush();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//            if (line.startsWith("250 ")) { // OK
//                return;
//            } else if (line.startsWith("552 ")) { // no match
//                System.out.println("No definition found for " + word);
//                return;
//            } else if (line.matches("\\d\\d\\d .*")) continue;
//            else if (line.trim().equals(".")) continue;
//            else


                System.out.println(line);

        }
    }
    public static void readEliza(BufferedReader bif){
        int c;
        int count =0;
        try {
            while ((c = bif.read()) != -1 ){
                if (count ==3){
                    break;
                }else {
                    count++;
                }
                if (count == 2 ){
                    System.out.println((char) c);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFistBad(BufferedReader bof){
        int c;
        int count =0;
        try {
            while ((c = bof.read()) != -1 ){
                if (count ==2){
                    break;
                }else {
                    count++;
                }
                if (count == 1 ){
                    System.out.println((char) c);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}