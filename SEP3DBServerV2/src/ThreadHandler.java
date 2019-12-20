import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializationContext;
import com.google.gson.stream.JsonReader;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;



public class ThreadHandler implements Runnable {

    private OutputStream out;
    private BufferedReader in;
    private Server server;
    private Model model;
    private Gson gson;
    private Adapter adapter;

    public ThreadHandler(Socket socket, Server sv, Model model, Adapter adapter) {
        this.model = model;
        this.gson = new Gson();
        this.server = sv;
        this.adapter=adapter;

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            System.out.println("Currently not there (" + e.getMessage() + ")");
        }
    }


    public void run() {
        try {
            Gson gson = new Gson();

                System.out.println("Works!!!!");
                String message = in.readLine();
                System.out.println("1");
                Package target = gson.fromJson(message, Package.class);
                System.out.println("2");
                System.out.println("THIS IS THE PACKAGE " + target.getOperation() + " " +target.getArgument());
                //receive(target);
                Package pack = receive(target);
                if(pack.getArgument().equals("login") ) return;
                String toSend=gson.toJson(pack);
                Send(toSend + "\0"); //-----IMPORTANT TERMINATE BUFFERS !!!!!
                System.out.println("ToSend=" + toSend);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Package receive(Package pack) throws IOException {
        switch (pack.getOperation()) {
            case "register":
               return adapter.Register(gson.fromJson(pack.getArgument(),Client.class));
            case "Date":
                return adapter.getMoviesByDate(pack.getArgument());
            case"Booking":
                return adapter.Booking(gson.fromJson(pack.getArgument(), Bookings.class));
            case"Login":
            {
                sendBackLogin(pack);
                return new Package("login", "login");
            }
        }
        return new Package("register", "bad");
    }

    public void sendBackLogin(Package pack) throws IOException {
       Client client = adapter.Login(gson.fromJson(pack.getArgument(), Client.class));
        String toSend=gson.toJson(client);
       Send(toSend + "\0");
        System.out.println("ToSend= ** " + toSend);
    }

    public void Send(String send) throws IOException {


        byte[] buffer = new byte[1024];
        buffer = send.getBytes();
       out.write(buffer);
       //System.out.println(send + " " + buffer);

    }

}


