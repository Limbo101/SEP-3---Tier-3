public class Movie {
    private int Movie_id;
    private String title;

    public Movie(int movie_id, String title) {
        Movie_id = movie_id;
        this.title = title;
    }

    public int getMovie_id() {
        return Movie_id;
    }

    public String getTitle() {
        return title;
    }
}
