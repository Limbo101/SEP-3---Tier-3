import java.net.Socket;

public class ServerMain
{

   public static void main(String[] args)
   {
       final int port= 3344;

      try {
          Database database= new Database();
          Adapter adapter = new Adapter(database);
          Server serv = new Server(port, adapter);
            Thread server=new Thread(serv);


          System.out.println(database.getClients().get(4).getPassword());

      server.start();




      }

      catch(Exception e) {
      }

   }

}
