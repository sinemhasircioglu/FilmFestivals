package entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author sinem
 */
public class Multimedya {
    private Long id;
    private String url;
    private List<Actors> multimedyaActors;
    private List<Directors> multimedyaDirectors;
    private List<Films> multimedyaFilms;
    private List<Juries> multimedyaJuries;
    private List<Users> multimedyaUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Actors> getMultimedyaActors() {
        return multimedyaActors;
    }

    public void setMultimedyaActors(List<Actors> multimedyaActors) {
        this.multimedyaActors = multimedyaActors;
    }

    public List<Directors> getMultimedyaDirectors() {
        return multimedyaDirectors;
    }

    public void setMultimedyaDirectors(List<Directors> multimedyaDirectors) {
        this.multimedyaDirectors = multimedyaDirectors;
    }

    public List<Films> getMultimedyaFilms() {
        return multimedyaFilms;
    }

    public void setMultimedyaFilms(List<Films> multimedyaFilms) {
        this.multimedyaFilms = multimedyaFilms;
    }

    public List<Juries> getMultimedyaJuries() {
        return multimedyaJuries;
    }

    public void setMultimedyaJuries(List<Juries> multimedyaJuries) {
        this.multimedyaJuries = multimedyaJuries;
    }

    public List<Users> getMultimedyaUsers() {
        return multimedyaUsers;
    }

    public void setMultimedyaUsers(List<Users> multimedyaUsers) {
        this.multimedyaUsers = multimedyaUsers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Multimedya other = (Multimedya) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
