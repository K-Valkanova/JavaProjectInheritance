import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractUser implements IUser {
    private String username;
    private String registrationDate;
    private boolean isLogged;
    private boolean isAdmin;

    public AbstractUser(String username){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date currentDate = new Date();

        this.username = username;
        this.isAdmin = false;
        this.registrationDate = df.format(currentDate);
    }

    public AbstractUser(String username, boolean isAdmin){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date currentDate = new Date();

        this.username = username;
        this.isAdmin = isAdmin;
        this.registrationDate = df.format(currentDate);
    }

    @Override
    public void logIn() {
        this.isLogged = true;
        System.out.println("Welcome, " + this.username + "!");
    }

    @Override
    public void logOut() {
        isLogged = false;
        System.out.println("User " + this.username + " has logged out.");
    }
    public String getUsername(){
        return this.username;
    }
    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    public String getRegistrationDate() {
        return this.registrationDate;
    }

    @Override
    public String toString() {
        return "[username= " + username + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", isLogged=" + isLogged +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
