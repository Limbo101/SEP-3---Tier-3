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
            String sql = "insert into database1.client(username,email,password)values('"+cl.getUsername()+"','"+cl.getEmail()+"','"+cl.getPassword()+"')";

            statement.execute(sql);


// createBooking + Login + AddMovie + AddCinema + GetMoviesByDate +
    }






}

