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
                boolean notFirstReceive = false;
                while(true)
                {
                    Gson gson=new Gson();
                    byte[] buffer = in.readLine().getBytes();
                    String fixedMessage;
                    String message = new String(buffer, Charset.forName("UTF-8"));
                    if(notFirstReceive)
                    {
                        fixedMessage = message.substring(1); // gets rid of messages first character
                    }
                    else fixedMessage = message;
                    System.out.println(fixedMessage);
                    Package target = gson.fromJson(fixedMessage, Package.class);
                    System.out.println("THIS IS THE PACKAGE " + target.toString());
                    notFirstReceive=true;
                }
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



