package CSE306;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class lowsportscanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        for ( int i = 0;i <1024; i++){
            try {
                Socket s = new Socket(host, i);
                System.out.println("There is a server on port" + " "+ i + " "+ "of"+ " "+ host);
                s.close();
            }catch (UnknownHostException ex){
                System.err.println(ex);
                break;
            }catch (IOException ex){
               // System.out.println("Must not be a server in this port");
            }
        }
    }

}
