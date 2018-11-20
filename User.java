import java.io.Serializable;

public class User implements Serializable {
    private int userid;
    private String user;
    private String pass;

    public User(int userid, String user, String pass) {
        setUserId(userid);
        setUser(user);
        setPass(pass);
    }

    public User() {

    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public int getUserId() {
        return userid;
    }

    public boolean login(String password) {
        return password.equals(this.getPass());
    }

    public String getPass() {
        return pass;
    }

    public String toString() {
        return "UserID: "+getUserId()+"\nUsername: "+getUser();
    }

}