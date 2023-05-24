package entity;

public class User {
    private int userId;
    private String username;
    private String password;
    private int role;
    private String name;
    private String cmnd;
    private String sdt;
    private String email;
    private String image;
    private String bankName;
    private String bankNumber;

    public User() {
    }

    public User(int userId, String username, String password, int role, String name, String cmnd, String sdt, String email, String image, String bankName, String bankNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
        this.image = image;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + ", name=" + name +
                ", cmnd=" + cmnd + ", sdt=" + sdt + ", email=" + email + ", bankName=" + bankName + ", bankNumber=" + bankNumber + '}';
    }

    
    
}
