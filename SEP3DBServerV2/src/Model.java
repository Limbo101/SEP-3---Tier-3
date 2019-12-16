import java.util.ArrayList;

public interface Model {
    ArrayList<Client> getClients();
    Package Register(Client cl);
    Package getMoviesByDate(Movie_Dates mvdate);
    Package Booking(Bookings bok);
    Package Login(Client log);
    Package AddMovie(Movie_Dates addmovie);

}

