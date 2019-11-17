import com.mysql.fabric.ServerMode;


import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;


public class Server implements RemoteSv{


    private Model model;


    public Server(Model m) throws RemoteException, MalformedURLException{
        this.model=m;
        // UnicastRemoteObject.exportObject(this, 0);
        RemoteSv stub=(RemoteSv) UnicastRemoteObject.exportObject(this, 0);
        Naming.rebind("MovieSv", stub);


    }


    @Override
    public ArrayList<Client> getClients() throws RemoteException {
        return model.getClients();
    }
}