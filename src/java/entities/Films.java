package entities;

import java.util.List;

/**
 *
 * @author sinem
 */

public class Films {

    private int filmid;
    private String filmname;
    private int festivalid;
    private String genre;
    private int directorid;
    private int fileId;
    private List<Actors> actorList;
    private List<Users> userlist;
    private List<Musics> musiclist;
    private List<Juries> jurylist;
    private Festivals festival;
    private File file;
    private Directors director;

    public Films(int filmid, String filmname, int festivalid, String genre, int directorid, int fileId) {
        this.filmid = filmid;
        this.filmname = filmname;
        this.festivalid = festivalid;
        this.genre = genre;
        this.directorid = directorid;
        this.fileId=fileId;
    }

    public Films() {
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public int getFestivalid() {
        return festivalid;
    }

    public void setFestivalid(int festivalid) {
        this.festivalid = festivalid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public List<Users> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<Users> userlist) {
        this.userlist = userlist;
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

    public List<Juries> getJurylist() {
        return jurylist;
    }

    public void setJurylist(List<Juries> jurylist) {
        this.jurylist = jurylist;
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

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Films{" + "filmid=" + filmid + ", filmname=" + filmname + ", festivalid=" + festivalid + ", genre=" + genre + ", directorid=" + directorid + ", actorList=" + actorList + ", userlist=" + userlist + '}';
    }
}
