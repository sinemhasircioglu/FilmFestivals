package entities;

import java.sql.Date;

/**
 *
 * @author sinem
 */
public class Profiles {
    private int id;
    private String name;
    private Date birthday;
    private int userId;
    private String imageUrl;
    private boolean gender;

    public Profiles(int id, String name, Date birthday, int userId, String imageUrl, boolean gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.gender = gender;
    }

    public Profiles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
