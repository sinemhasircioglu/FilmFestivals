package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Actors {
    private int id;
    private String name;
    private boolean gender;
    private int filmId;
    private int fileId;
    private Films film;
    private File file;
    private List<Juries> juryList; 

    public Actors(int id, String name, boolean gender, int filmId, int fileId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.filmId = filmId;
        this.fileId = fileId;
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

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    } 

    public List<Juries> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Juries> juryList) {
        this.juryList = juryList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileid(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "Actors{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", filmId=" + filmId + ", film=" + film + ", juryList=" + juryList + '}';
    }

    
}
