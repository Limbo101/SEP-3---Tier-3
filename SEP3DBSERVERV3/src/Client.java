public class Client {
    private int ID;
    private String HashValues;
    private String Email;
    
    public Client(int ID, String HashValues, String Email)
    {
        this.ID=ID;
        this.Email=Email;
        this.HashValues=HashValues;
    }
    public int getID() {
        return ID;
    }
    public String getHashValues() {
        return HashValues;
    }
    public String getEmail() {
        return Email;
    }

}

