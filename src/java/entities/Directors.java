package entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author sinem
 */
public class Directors {

    private Long id;
    private String name;
    private Multimedya multimedya;
    private List<Films> directorFilms;

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
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Directors other = (Directors) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
