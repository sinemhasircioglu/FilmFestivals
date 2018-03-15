package entities;

/**
 *
 * @author sinem
 */
public class File {
    private int id;
    private String url;
    private Actors actor;
    private Directors director;
    private Films film;
    private Juries jury;
    private Users user;

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

    public Actors getActor() {
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public Juries getJury() {
        return jury;
    }

    public void setJury(Juries jury) {
        this.jury = jury;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
}
