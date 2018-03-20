package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class File {
    private int id;
    private String url;
    private List<Actors> actorList;
    private List<Directors> directorList;
    private List<Films> filmList;
    private List<Juries> juryList;
    private List<Users> userList;

    public File() {
    }

    public File(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public List<Directors> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    public List<Films> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Juries> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Juries> juryList) {
        this.juryList = juryList;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "File{" + "id=" + id + ", url=" + url + ", actorList=" + actorList + ", directorList=" + directorList + ", filmList=" + filmList + ", juryList=" + juryList + ", userList=" + userList + '}';
    }

}
