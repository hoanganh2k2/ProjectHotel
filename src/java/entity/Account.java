package entity;

/**
 *
 * @author Nguyễn Hoàng Anh
 */
public class Account {
    
    private String username;
    private String password;
    private String email;
    private int role;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(String username, String password, String email, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + '}';
    }
    
    
}
