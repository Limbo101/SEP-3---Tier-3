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
    public Package Register(Client cl)
    {
        try {
            database.Register(cl);
            Package packk = new Package("register", "ok");
            return packk;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new Package("register","eroare");
        }

    }
    public void Register2(Client cl)
    {
        try {
            database.Register(cl);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }


}
