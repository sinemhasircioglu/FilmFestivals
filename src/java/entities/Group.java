package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Group {
    private int id;
    private String authority;
    private List<Users> userList;

    public Group() {
    }

    public Group(int id, String authority) {
        this.id = id;
        this.authority = authority;
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

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", authority=" + authority + ", userList=" + userList + '}';
    }
    
}
