package entities;

/**
 *
 * @author sinem
 */
public class Group {
    private int id;
    private String authority;
    private int userId;
    private Users user;

    public Group() {
    }

    public Group(int id, String authority, int userId) {
        this.id = id;
        this.authority = authority;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", authority=" + authority + ", userId=" + userId + ", user=" + user + '}';
    }
    
}
