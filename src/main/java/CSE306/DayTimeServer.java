package CSE306;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
    public final static int PORT = 19;
    public static void main(String[] args) {
        try(ServerSocket ser = new ServerSocket(PORT)){
            while(true){
                try(Socket conection = ser.accept()){
                    Writer out = new OutputStreamWriter(conection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString()+ "\r\n");
                    out.flush();
                    conection.close();
                }catch (IOException ex){

                }
            }//
        }catch(IOException ex){
            System.err.println(ex);
        }
    }


}
