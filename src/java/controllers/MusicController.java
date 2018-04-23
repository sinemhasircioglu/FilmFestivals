package controllers;

import dao.FilmDAO;
import dao.MusicDAO;
import entities.Films;
import entities.Musics;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="musicController")
@SessionScoped
public class MusicController implements Serializable{
    private List<Musics> musicList;
    private MusicDAO musicDao;
    private Musics music;
 
    private FilmDAO filmDao;
    private List<Films> filmList;
    
    public void updateForm(Musics m) {
        this.music = m;
    }
    
    public void clearForm() {
        this.music = new Musics();
    }

    public void delete() {
        this.getMusicDao().delete(this.music);
        this.clearForm();
    }

    public void update() {
        this.getMusicDao().update(this.music);
        this.clearForm();
    }

    public void create() {
        this.getMusicDao().create(this.music);
        this.clearForm();
    }

    public List<Musics> getMusicList() {
        this.musicList=this.getMusicDao().findAll();
        return musicList;
    }

    public void setMusicList(List<Musics> musicList) {
        this.musicList = musicList;
    }

    public MusicDAO getMusicDao() {
        if(this.musicDao==null)
            this.musicDao=new MusicDAO();
        return musicDao;
    }

    public Musics getMusic() {
        if (this.music == null) {
            this.music = new Musics();
        }
        return music;
    }

    public void setMusic(Musics music) {
        this.music = music;
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public List<Films> getFilmList() {
        this.filmList=this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }
}
