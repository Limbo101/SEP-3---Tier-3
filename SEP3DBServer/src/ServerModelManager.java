import java.util.ArrayList;

public class ServerModelManager implements Model {

    private Database database;
    private ArrayList<Client> clients;

    public ServerModelManager(Database db) {

    }



    @Override
    public ArrayList<Client> getClients() {
        return database.getClients();
    }
}
