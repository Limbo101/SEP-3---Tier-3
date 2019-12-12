import java.util.ArrayList;

public interface Model {
    ArrayList<Client> getClients();
    Package insertClients(Client cl);

}

