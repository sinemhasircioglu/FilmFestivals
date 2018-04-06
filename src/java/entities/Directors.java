package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Directors {

    private int id;
    private String name;
    private Multimedya multimedya;
    private List<Films> directorFilms;

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

    public Multimedya getMultimedya() {
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    public List<Films> getDirectorFilms() {
        return directorFilms;
    }

    public void setDirectorFilms(List<Films> directorFilms) {
        this.directorFilms = directorFilms;
    }

    @Override
    public String toString() {
        return "Directors{" + "id=" + id + ", name=" + name + ", multimedya=" + multimedya + ", directorFilms=" + directorFilms + '}';
    }
    
}
