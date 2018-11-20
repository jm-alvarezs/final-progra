import java.io.Serializable;

public class User implements Serializable {
    private int userid;
    private String user;
    private String pass;
    private int level;

    public User(int userid, String user, String pass, int level) {
        setUserId(userid);
        setUser(user);
        setPass(pass);
        setLevel(level);
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

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public int getUserId() {
        return userid;
    }

    public int getLevel() {
        return level;
    }

    public boolean login(String password) {
        return password.equals(this.getPass());
    }

    public String getPass() {
        return pass;
    }

    public String toString() {
        return "UserID: "+getUserId()+"\nUsername: "+getUser()+"\nNivel: "+getLevel();
    }

}