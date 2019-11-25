import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SClient implements SModel {
   private PrintWriter out;
   private Socket socket;
   private Gson gson;
   private String host = "10.10.22.181";
   private int port = 4545;
   private Receiver receiver;
   private SModel model;


   public SClient() {
      try {


         socket = new Socket(host, port);
         System.out.println("Connected to host: " + host + " at port " + port);
         out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         this.receiver=new Receiver(in,this);
         Thread t= new Thread(receiver);
         t.start();
      } catch (Exception e) {

      }
   }



}