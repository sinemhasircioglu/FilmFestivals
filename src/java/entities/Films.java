package entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author sinem
 */
public class Films {

    private Long id;
    private String name;
    private String genre;
    private List<Actors> filmActors;
    private List<Musics> filmMusics;
    private List<Multimedya> filmMultimedyas;
    private List<Directors> filmDirectors;
    private Festivals festival;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Festivals getFestival() {
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public List<Multimedya> getFilmMultimedyas() {
        return filmMultimedyas;
    }

    public void setFilmMultimedyas(List<Multimedya> filmMultimedyas) {
        this.filmMultimedyas = filmMultimedyas;
    }

    public List<Directors> getFilmDirectors() {
        return filmDirectors;
    }

    public void setFilmDirectors(List<Directors> filmDirectors) {
        this.filmDirectors = filmDirectors;
    }

    public List<Actors> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(List<Actors> filmActors) {
        this.filmActors = filmActors;
    }

    public List<Musics> getFilmMusics() {
        return filmMusics;
    }

    public void setFilmMusics(List<Musics> filmMusics) {
        this.filmMusics = filmMusics;
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
        final Films other = (Films) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
