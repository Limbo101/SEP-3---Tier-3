import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        SClient client=new SClient();
        Database database=new Database();
        Socket s = new Socket("localhost",4545);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println( database.getClients().get(0).getEmail());
        pr.flush();
    }
}
