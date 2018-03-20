package entities;

import java.util.List;

/**
 *
 * @author sinem
 */

public class Films {

    private int id;
    private String name;
    private String genre;
    private List<Actors> actorList;
    private List<Musics> musiclist;
    private Festivals festival;
    private File file;
    private FilmDirector filmDirector;

    public Films() {
    }

    public Films(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public List<Musics> getMusiclist() {
        return musiclist;
    }

    public void setMusiclist(List<Musics> musiclist) {
        this.musiclist = musiclist;
    }

    public Festivals getFestival() {
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
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
        return "Films{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", actorList=" + actorList + ", musiclist=" + musiclist + ", festival=" + festival + ", file=" + file + ", filmDirector=" + filmDirector + '}';
    }
   
}
