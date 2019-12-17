import java.time.chrono.ThaiBuddhistDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    Scanner input = new Scanner(System.in);  // for halting

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public Database() {

        try {
            Class.forName("com.mysql.jdbc.Database").newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Establishing a connection
        try {
            String databaseUrl = "jdbc:mysql://localhost:3306/database1?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "root";

            this.connection = DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established to: " + databaseUrl);
        } catch (
                Exception exception) {
            System.out.println("Connection failed");
            exception.printStackTrace();
        }
    }


    public ArrayList<Client> getClients() {
        ArrayList<Client> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "select * from database1.client";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { //reads the rest of the set
                Client c = new Client(resultSet.getString(2), resultSet.getString(4), resultSet.getString(3));
                list.add(c);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Register(Client cl) throws SQLException {

        statement = connection.createStatement();
        String sql = "insert into database1.client(username,email,password)values('" + cl.getUsername() + "','" + cl.getEmail() + "','" + cl.getPassword() + "')";

        statement.execute(sql);
    }


    public ArrayList<Movie_Dates> getMoviesByDate(String mvdate) throws SQLException {
        ArrayList<Movie_Dates> mlist = new ArrayList<>();
        statement = connection.createStatement();
        String sql = "SELECT database1.movie_has_dates.hour_played,\n" +
                "        database1.movie_has_dates.duration,\n" +
                "       database1. movie_dates.title FROM database1.movie_dates\n" +
                "        INNER JOIN database1.movie_has_dates ON database1.movie_dates.Movie_ID=database1.movie_has_dates.Movie_ID\n" +
                "        WHERE database1.movie_has_dates.Mdate ='" + mvdate + "'";
        resultSet = statement.executeQuery(sql);


        while (resultSet.next()) { //reads the rest of the set
            Movie_Dates mvdatee = new Movie_Dates(resultSet.getString(3),
                    resultSet.getInt(2),
                    resultSet.getString(1));
            mlist.add(mvdatee);
            System.out.println("this was sent "+ mlist.get(0).getDuration());

        }
        return mlist;
    }

    public void Booking(Bookings bok) throws SQLException
    {
        statement= connection.createStatement();
        System.out.println(bok.getBhour());
        String sql="insert into database1.bookings(title,Bdate,username,bhour)" +
                "values('"+ bok.getTitle() +"','"+ bok.getDate() +"','"+ bok.getUsername() +"','"+ bok.getBhour() +"')";
        statement.execute(sql);
    }

    public Client Login(Client log) throws SQLException {
        statement = connection.createStatement();
        String sql = "select database1.username, database1.password FROM database1.client" +
                "WHERE database1.username='" + log.getUsername() + "'";
        resultSet=statement.executeQuery(sql);
        resultSet.next();

            Client c = new Client(resultSet.getString(2), resultSet.getString(4));
        return c;


    }

public void AddMovie(Movie_Dates addmovie) throws SQLException
{
   // statement=connection.createStatement();
       //    / String sql="insert into"

}


}

// createBooking + Login + AddMovie + AddCinema + GetMoviesByDate +








