import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;

public class Receiver implements Runnable
{
   private BufferedReader in;
   private SClient client;
   
   public Receiver(BufferedReader in, SClient client) {
      this.in=in;
      this.client=client;
   }

   @Override
   public void run()
   {
      while(true) {
      String reply;
      try {
         reply = in.readLine();
         System.out.println(reply);
         Gson gson = new Gson();
         Package target = gson.fromJson(reply, Package.class);
         System.out.println(target.getName() + target.getText());
      }
      catch (IOException e) {}
      }
   }

   }


