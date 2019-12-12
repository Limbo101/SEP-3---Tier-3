public class Cinemas {
    private int Cinemas_ID;
    private String Name;
    private String Location;

    public Cinemas(int cinemas_ID, String name, String location) {
        Cinemas_ID = cinemas_ID;
        Name = name;
        Location = location;
    }
    public int getCinemas_ID() {
        return Cinemas_ID;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }
}
