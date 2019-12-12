import java.sql.Date;

public class Bookings {
    private int Booking_ID;
    private Date date;
    private String Location;
    private int Seat_nr;
    private int Movie_ID;

    public Bookings(int booking_ID, Date date, String location, int seat_nr, int movie_ID) {
        this.Booking_ID = booking_ID;
        this.date = date;
        this.Location = location;
        this.Seat_nr = seat_nr;
        this.Movie_ID = movie_ID;
    }
    public int getBooking_ID() {
        return Booking_ID;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return Location;
    }

    public int getSeat_nr() { return Seat_nr;
    }
    public int getMovie_ID() { return Movie_ID; }
}
