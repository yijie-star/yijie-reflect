package cn.cempro.user.domain;

/**
 * 实体类
 */
public class User {
    private int uid;
    private String username;
    private String password;
    private String securityCode;

    public User(String username, String password, String securityCode) {
        this.username = username;
        this.password = password;
        this.securityCode = securityCode;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
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

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
