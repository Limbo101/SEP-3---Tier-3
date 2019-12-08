/*import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ThreadHandler implements Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private Server server;
    private Model model;
    private Gson gson;

    public ThreadHandler(Socket socket, Server sv, Model model) {
       this.model = model;
       this.gson=new Gson();
        this.server = sv;
        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out
                    .println("Currently not there (" + e.getMessage() + ")");
        }
    }

    public void run() {

        while (true) {
            try {


                String text = in.readLine();
                System.out.println(text);
                Package target = gson.fromJson(text, Package.class);
                //asd(target);
                System.out.println("THIS IS THE PACKAGE " + target.toString());

            } catch (Exception e) {
                System.out.println("Errror");
            }
        }
    }



  //  public void asd(Package p){switch ()}
    }

*/

