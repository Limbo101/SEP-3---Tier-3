import java.util.ArrayList;

public class Adapter implements Model{
    public Database database;

    public Adapter(Database database) {
        this.database = database;
    }
    public ArrayList<Client> getClients()
    {
        ArrayList<Client> clients=database.getClients();
        return clients;
    }
    public Package insertClients(Client cl)
    {
        database.insertClients(cl);
        Package packk = new Package("insert","ok");
        return packk;
    }


}
