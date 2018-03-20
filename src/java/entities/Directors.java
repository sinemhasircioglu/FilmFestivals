package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Directors {

    private int id;
    private String name;
    private File file;
    private FilmDirector filmDirector;

    public Directors() {
    }

    public Directors(int id, String name) {
        this.id = id;
        this.name= name;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FilmDirector getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(FilmDirector filmDirector) {
        this.filmDirector = filmDirector;
    }

    @Override
    public String toString() {
        return "Directors{" + "id=" + id + ", name=" + name + ", file=" + file + ", filmDirector=" + filmDirector + '}';
    }

}
