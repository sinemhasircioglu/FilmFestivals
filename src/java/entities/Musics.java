
package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Musics {
    private int id;
    private String name;
    private int filmId;
    private Films film;
    private List<Juries> jurylist;

    public Musics() {
    }

    public Musics(int id, String name, int filmId) {
        this.id = id;
        this.name = name;
        this.filmId = filmId;
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

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public List<Juries> getJurylist() {
        return jurylist;
    }

    public void setJurylist(List<Juries> jurylist) {
        this.jurylist = jurylist;
    }

    @Override
    public String toString() {
        return "Musics{" + "id=" + id + ", name=" + name + ", filmId=" + filmId + ", film=" + film + ", jurylist=" + jurylist + '}';
    }
    
}
