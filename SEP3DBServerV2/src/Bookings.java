import java.sql.Date;

public class Bookings {
    private int Booking_ID;
    private String date;
    private int Movie_ID;
    private String title;
    private String username;
    private String hour;

    public Bookings(String date, String username, String title, String hour) {
        this.date = date;
        this.hour = hour;
        this.title = title;
       this.username=username;
    }

    public String getDate() { return date;}
    public String getUsername(){return username;}
    public String getTitle() {return title; }
    public String getBhour() {return hour; }
}
