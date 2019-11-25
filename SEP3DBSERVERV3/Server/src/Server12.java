

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;

public class Server12 {
    private Socket socket = null;
    private ServerSocket server = null;
   // private DataInputStream in = null;
    private BufferedReader in = null;
    private  Database db = null;
    private PrintWriter out = null;
    private Gson json = null;

    //constr with port
    public Server12(int port) throws Exception {
        //starts server and waits for a connection
        // inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //Java succ... It was reading a string that had no end
        //  We've put in a buffer and encoding to server side
        //to do: handle bigger sizes than before (buffers are too small for json)

        try {
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client" + " "+  socket.getInetAddress().getHostName() + " accepted" );

            //takes input from client socket
             in = new BufferedReader(new InputStreamReader( socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] buffer = new byte[2048];

        //Cinema cinema = new Cinema("PrimeCinema","Horsens", 3, 5);
        //ArrayList<Movie> movieObj = new ArrayList<>();

        /*movieObj.add(new Movie("Andrei", cinema, 123, 10));
        movieObj.add(new Movie("Karolis", cinema, 124, 11));
        movieObj.add(new Movie("Catalin", cinema, 125, 12));
        movieObj.add(new Movie("Adrian", cinema, 126, 13));
        */

        //String movielist = json.toJson(movieObj);

        //ByteBuffer bytebuffer = StandardCharsets.UTF_8.encode(message);

       /* byte[] buffer2 = message.getBytes();
        String messageSent = new String(buffer2, "UTF-8");

        */
        //byte[] sendBuffer = movielist.getBytes(Charset.forName("UTF-8"));

        try {
          String data =  in.readLine();
           //String s = new String(buffer, StandardCharsets.UTF_8);

            System.out.println(data);

        //bytebuffer

            //socket.getOutputStream().write(sendBuffer);

         // out.write();
          //out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //close connection
        /*try {
            socket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

    }

    public static void main(String[] args) throws Exception {
        Server12 server = new Server12(4545);

    }
}
