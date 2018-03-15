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
    private int fileId;
    private boolean gender;
    private List<Films> filmlist;
    private File file;
    private Group group;

    public Users() {
    }

    public Users(int id, String email, String password, String name, boolean gender, int fileId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.fileId = fileId;
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

    public List<Films> getFilmlist() {
        return filmlist;
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

    public void setFilmlist(List<Films> filmlist) {
        this.filmlist = filmlist;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", gender=" + gender + ", filmlist=" + filmlist + '}';
    }
}
