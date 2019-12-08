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




public class Server implements Runnable
{
   private ServerSocket welcomeSocket;
   private ArrayList<Socket> clients;
   private Database database;
   private Gson json;
    private BufferedReader in;
    private PrintWriter out;
    private Server server;
    private Model model;
    private Gson gson;





    public Server(int port) throws IOException {

        try {
            System.out.println("Starting server");
            welcomeSocket= new ServerSocket(port);
            clients=new ArrayList<>();
            this.gson=new Gson();
            System.out.println("Waiting for client");
            Socket socket = welcomeSocket.accept();
            System.out.println("accepted "+ socket.getInetAddress().getHostAddress());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out
                    .println("Currently not there (" + e.getMessage() + ")");
        }
    }




   public void run() {

         try{
             byte[] buffer = new byte[1024];
             json = new Gson();
         //===================================
             buffer = in.readLine().getBytes();
             String text = new String(buffer, StandardCharsets.UTF_8);
             System.out.println(text);
             Package target = gson.fromJson(text, Package.class);
             //asd(target);
             System.out.println("THIS IS THE PACKAGE " + target.toString());

         } catch (Exception e) {
             System.out.println("Errror");


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

