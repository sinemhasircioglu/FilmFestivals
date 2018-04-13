package entities;

import java.util.List;

/**
 *
 * @author sinem
 */

public class Films {

    private Long id;
    private String name;
    private String genre;
    private List<Actors> actorList;
    private List<Musics> musicList;
    private Festivals festival;
    private Multimedya multimedya;
    private List<Directors> filmDirectors;

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

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public List<Musics> getMusicList() {
        return musicList;
    }

    public void setMusiclist(List<Musics> musicList) {
        this.musicList = musicList;
    }

    public Festivals getFestival() {
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public Multimedya getFile() {
        return multimedya;
    }

    public void setFile(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    public Multimedya getMultimedya() {
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    public List<Directors> getFilmDirectors() {
        return filmDirectors;
    }

    public void setFilmDirectors(List<Directors> filmDirectors) {
        this.filmDirectors = filmDirectors;
    }
}
