
import javax.xml.crypto.Data;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.ArrayList;

public class RmiServer implements RemoteSv
{
    public static void main(String[] args)
            throws RemoteException, MalformedURLException
    {

        Database database= new Database();
        Model model=new ServerModelManager(database);
        startRegistry();
        Server server = new Server(model);
        System.out.println("Server started...");
        System.out.println(database.getClients().get(0).getEmail());
        }


    public static void startRegistry() throws RemoteException{
        try{
            Registry reg= LocateRegistry.createRegistry(1099);
            RmiServer server=new RmiServer();
            System.out.println("Registry started...");
        }catch (java.rmi.server.ExportException e)
        {
            System.out.println("Registry already started? " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Client> getClients() throws RemoteException {
        return getClients();
    }
}