import com.google.gson.Gson;
public class Client {
    private String ID;
    private String username;
    private String password;
    private String email;
    
    public Client(String username,String Password, String Email)
    {

        this.username = username;
        this.email=Email;
        this.password=Password;
    }
    public Client(String username,String Password)
    {
        this.username = username;
        this.password=Password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }



}

