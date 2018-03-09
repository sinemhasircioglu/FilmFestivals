package entities;

/**
 *
 * @author sinem
 */
public class Actors {
    private int id;
    private String name;
    private boolean gender;
    private int filmId;

    public Actors(int id, String name, boolean gender, int filmId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.filmId = filmId;
    }

    public Actors() {
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
