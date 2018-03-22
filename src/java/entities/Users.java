package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Users {

    private int id;
    private String email;
    private String password;
    private String name;
    private boolean gender;
    private Multimedya multimedya;
    private Group group;

    public Users() {
    }

    public Users(int id, String email, String password, String name, boolean gender) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Multimedya getFile() {
        return multimedya;
    }

    public void setFile(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", gender=" + gender + ", multimedya=" + multimedya + ", group=" + group + '}';
    }

}
