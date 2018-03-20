package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class FilmDirector {
    private int id;
    private int year;
    private List<Films> filmList;
    private List<Directors> directorList;

    public FilmDirector() {
    }

    public FilmDirector(int id, int year) {
        this.id = id;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Films> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Directors> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    @Override
    public String toString() {
        return "FilmDirector{" + "id=" + id + ", year=" + year + ", filmList=" + filmList + ", directorList=" + directorList + '}';
    }
    
}
