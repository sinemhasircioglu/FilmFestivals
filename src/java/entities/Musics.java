package entities;

/**
 *
 * @author sinem
 */
public class Musics {
    private Long id;
    private String name;
    private Films film;

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

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Musics{" + "id=" + id + ", name=" + name + ", film=" + film + '}';
    }
 
}
