public class Movie_Dates {
    private String title;
    private String cinema;
    private int duration;
    private String starthour;
    private String movieDate;


    public Movie_Dates(String title, int duration, String starthour) {
        this.title = title;
        this.duration = duration;
        this.starthour = starthour;
    }

    public String getTitle() {
        return title;
    }

    public String getCinema() {
        return cinema;
    }

    public int getDuration() {
        return duration;
    }

    public String getStarthour() {
        return starthour;
    }

    public String getMovieDate() {
        return movieDate;
    }
}
