package entities;

/**
 *
 * @author sinem
 */
public class Users {
    private int id;
    private String email;
    private String password;
    private int profileId;

    public Users(int id, String email, String password, int profileId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profileId=profileId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
