import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;




public class Server implements Runnable {
    private ServerSocket welcomeSocket;
    private ArrayList<Socket> clients;
    private Database database;
    private BufferedReader in;
    private PrintWriter out;
    private Server server;
    private Model model;
    private Gson gson;
    private String ip;
    private Adapter adapter;


    public Server(int port, Adapter adapter) throws IOException {
        welcomeSocket = new ServerSocket(port);
        clients = new ArrayList<>();
        this.adapter=adapter;
    }

    public void run() {
            while(true)
            {
                try {
                    System.out.println("Waiting for client");
                    Socket socket = welcomeSocket.accept();
                    clients.add(socket);
                    System.out.println("accepted" + socket.getInetAddress().getHostName());
                    ThreadHandler cs = new ThreadHandler(socket, this, model, adapter);
                    Thread handler = new Thread(cs);
                    handler.start();
                    System.out.println("passed client");

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
    }




}


  /* public void message(Package pack) {
      Gson gson= new Gson();
      PrintWriter out=null;
      String reply= gson.toJson(pack);
      for(int i=0;i<clients.size();i++){
         try{
            out=new PrintWriter(clients.get(i).getOutputStream(), true);

            out.println(reply);

         }
         catch (Exception e){
            e.printStackTrace();
         }
      }
      System.out.println("sent to all");
   }
   */

