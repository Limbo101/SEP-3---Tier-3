import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;

public class Adapter implements Model {
    public Database database;
    public Gson gson;

    public Adapter(Database database) {
        this.database = database;
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
            return new Package("register", "eroare");
        }

    }

    public Package getMoviesByDate(Movie_Dates mvdate) {
        try {
            ArrayList<Movie_Dates> mvdates = database.getMoviesByDate(mvdate);
            String muie = gson.toJson(mvdates);
            Package pack= new Package(muie,"ok");
            return pack;
        } catch (Exception e) {
            e.printStackTrace();
            return new Package("moviesByDate", "eroare");
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
    public Package Login(Client log) {
        try{
            database.Login(log);
            Package packk = new Package("login","ok");
            return  packk;

        } catch (SQLException e) {
            e.printStackTrace();
            return new Package("login","error");
        }
    }

    @Override
    public Package AddMovie(Movie_Dates addmovie) {
        return null;
    }
}






