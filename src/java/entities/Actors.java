package entities;

/**
 *
 * @author sinem
 */
public class Actors {
    private Long id;
    private String name;
    private boolean gender;
    private Films film;
    private Multimedya multimedya;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    } 

    public Multimedya getMultimedya() {
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }
  
}
