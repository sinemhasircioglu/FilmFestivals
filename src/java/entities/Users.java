package entities;


/**
 *
 * @author sinem
 */
public class Users {

    private Long id;
    private String email;
    private String password;
    private String name;
    private boolean gender;
    private Multimedya multimedya;
    private Group group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Multimedya getMultimedya() {
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

}
