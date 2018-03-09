
package entities;

/**
 *
 * @author sinem
 */
public class Musics {
    private int id;
    private String name;
    private int filmId;

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
    
}
