public class Client {
    private int Client_ID;
    private String HashValues;
    private String Email;
    
    public Client(int Client_ID, String HashValues, String Email)
    {
        this.Client_ID=Client_ID;
        this.Email=Email;
        this.HashValues=HashValues;
    }
    public int getID() {
        return Client_ID;
    }
    public String getHashValues() {
        return HashValues;
    }
    public String getEmail() {
        return Email;
    }

}

