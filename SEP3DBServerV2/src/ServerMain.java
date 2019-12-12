import java.net.Socket;

public class ServerMain
{

   public static void main(String[] args)
   {
       final int port= 3344;

      try {
          Server serv = new Server(port);
            Thread server=new Thread(serv);
            Database database= new Database();
          /*System.out.println("Server started...");
          System.out.println(database.getClients().get(0).getEmail());
            */
      server.start();




      }

      catch(Exception e) {
      }

   }

}
