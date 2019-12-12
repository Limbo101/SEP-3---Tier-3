import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;



public class ThreadHandler implements Runnable {

    private PrintWriter out;
    private BufferedReader in;
    private Server server;
    private Model model;
    private Gson gson;

    public ThreadHandler(Socket socket, Server sv, Model model) {
       this.model = model;
       this.gson=new Gson();
        this.server = sv;

            try {

                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), false);

            } catch (Exception e) {
                System.out.println("Currently not there (" + e.getMessage() + ")");
            }
        }


    public void run() {
            try {
                Gson gson=new Gson();
                byte[] buffer = in.readLine().getBytes();
                String message = new String(buffer, Charset.forName("UTF-8"));

                System.out.println(message);
                Package target = gson.fromJson(message, Package.class);
               // method(target);

                System.out.println("THIS IS THE PACKAGE " + target.toString());


            } catch (Exception e) {
                e.printStackTrace();
            }
    }



    public void method(Package pack)
    {
       String operation = null;
       String argument;
            switch (operation){
                case ("login"):


            }

        }



    }



