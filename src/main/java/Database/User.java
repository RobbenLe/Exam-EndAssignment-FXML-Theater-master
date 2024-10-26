package Database;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String passWord;
    private Role role;

    public User(String name, String passWord, Role role) {
        this.userName = name;
        this.passWord = passWord;
        this.role = role;
    }
    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return passWord;
    }

    public Role getRole() {
        return role;
    }
}
