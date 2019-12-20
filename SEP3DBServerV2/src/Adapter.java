import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;

public class Adapter implements Model {
    public Database database;
    public Gson gson;

    public Adapter(Database database) {
        this.database = database;
        this.gson=new Gson();
    }

    public ArrayList<Client> getClients() {
        ArrayList<Client> clients = database.getClients();
        return clients;
    }

    public Package Register(Client cl) {
        try {
            database.Register(cl);
            Package packk = new Package("register", "ok");
            return packk;
        } catch (Exception e) {
            e.printStackTrace();
            return new Package("register", "error");
        }

    }

    public Package getMoviesByDate(String mvdate) {
        try {
            ArrayList<Movie_Dates> mvdates =new ArrayList<>();
            mvdates=database.getMoviesByDate(mvdate);
            String data1 = gson.toJson(mvdates);
            Package pack= new Package("getMoviesByDate",data1);
            return pack;
        } catch (Exception e) {
            e.printStackTrace();
            return new Package("moviesByDate", "error");
        }

    }

    public Package Booking(Bookings bok) {
        try {
            database.Booking(bok);
            Package packkk = new Package("booking", "ok");
            return packkk;
        }catch (Exception e)
        {
            e.printStackTrace();
            return new Package("booking","error");
        }
    }

    @Override
    public Client Login(Client log) {
        try{
            Client returnable = database.Login(log);
            //Package packk = new Package("login","ok");
            return  returnable;

        }

        catch (SQLException e) {
            e.printStackTrace();
           // return new Package("login","error");
        }
        return null;
    }

    @Override
    public Package AddMovie(Movie_Dates addmovie) {
        return null;
    }
}






