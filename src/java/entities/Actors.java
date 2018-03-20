package entities;

/**
 *
 * @author sinem
 */
public class Actors {
    private int id;
    private String name;
    private boolean gender;
    private Films film;
    private File file;

    public Actors(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    } 

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }    
}
