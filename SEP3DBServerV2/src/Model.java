import java.util.ArrayList;

public interface Model {
    ArrayList<Client> getClients();
    Package Register(Client cl);
    Package getMoviesByDate(String date);
    Package Booking(Bookings bok);
    Client Login(Client log);
    Package AddMovie(Movie_Dates addmovie);

}

