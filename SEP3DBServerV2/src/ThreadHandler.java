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
            boolean notFirstReceive = false;
            while (true) {
                Gson gson = new Gson();
                byte[] buffer = in.readLine().getBytes();
                String fixedMessage;
                String message = new String(buffer, Charset.forName("UTF-8"));
                if (notFirstReceive) {
                    fixedMessage = message.substring(1); // gets rid of messages first character
                } else fixedMessage = message;


                System.out.println(fixedMessage);
                Package target = gson.fromJson(fixedMessage, Package.class);
                System.out.println("THIS IS THE PACKAGE " + target.getOperation() + " " +target.getArgument());
                receive(target);
                Package pack = receive(target);
                String toSend=gson.toJson(pack);
                Send(toSend);

                System.out.println("...");
                notFirstReceive = true;
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public Package receive(Package pack)
    {
        switch (pack.getOperation()) {
            case "register":
               return adapter.Register(gson.fromJson(pack.getArgument(),Client.class));
            case "Date":
                return adapter.getMoviesByDate(pack.getArgument());
            case"Booking":
                return adapter.Booking(gson.fromJson(pack.getArgument(), Bookings.class));
            case"Login":
                return adapter.Login(gson.fromJson(pack.getArgument(), Client.class));
        }
        return new Package("register", "bad");
    }

    public void Send(String send) throws IOException {


        byte[] buffer = new byte[1024];
        buffer = send.getBytes();
       out.write(buffer);
       System.out.println(send + " " + buffer);

    }

}


