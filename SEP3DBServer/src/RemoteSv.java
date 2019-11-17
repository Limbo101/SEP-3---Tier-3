

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface RemoteSv extends Remote {

    ArrayList<Client> getClients() throws RemoteException;
}

