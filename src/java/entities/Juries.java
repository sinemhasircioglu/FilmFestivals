package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Juries {
    private int id;
    private String name;
    private int festivalId;
    private int fileId;
    private List<Actors> actorList;
    private List<Musics> musiclist;
    private List<Directors> directorlist;
    private List<Films> filmlist;
    private Festivals festival;
    private File file;

    public Juries() {
    }

    public Juries(int id, String name, int festivalId, int fileId) {
        this.id = id;
        this.name = name;
        this.festivalId = festivalId;
        this.fileId = fileId;
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

    public int getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public List<Musics> getMusiclist() {
        return musiclist;
    }

    public void setMusiclist(List<Musics> musiclist) {
        this.musiclist = musiclist;
    }

    public List<Directors> getDirectorlist() {
        return directorlist;
    }

    public void setDirectorlist(List<Directors> directorlist) {
        this.directorlist = directorlist;
    }

    public List<Films> getFilmlist() {
        return filmlist;
    }

    public void setFilmlist(List<Films> filmlist) {
        this.filmlist = filmlist;
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

    @Override
    public String toString() {
        return "Juries{" + "id=" + id + ", name=" + name + ", festivalId=" + festivalId + ", fileId=" + fileId + ", actorList=" + actorList + ", musiclist=" + musiclist + ", directorlist=" + directorlist + ", filmlist=" + filmlist + ", festival=" + festival + ", file=" + file + '}';
    }
    
}
