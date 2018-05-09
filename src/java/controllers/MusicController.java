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
@Named(value = "musicController")
@SessionScoped
public class MusicController implements Serializable {

    private List<Musics> fullMusicList;
    private MusicDAO musicDao;
    private Musics music;

    private FilmDAO filmDao;
    private List<Films> filmList;

    private int page = 1;
    private int pageSize = 3;
    private List<Musics> musicList;

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

    public void previous() {
        if (this.page == 1) {
            this.page = this.pageCount();
        } else {
            this.page--;
        }
    }

    public void next() {
        if (this.page == this.pageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public int pageCount() {
        return (int) Math.ceil(this.getMusicDao().findAll().size() / (double) pageSize);
    }

    public List<Musics> getMusicList() {
        this.musicList = this.getMusicDao().findAll(page,pageSize);
        return musicList;
    }

    public void setMusicList(List<Musics> musicList) {
        this.musicList = musicList;
    }

    public MusicDAO getMusicDao() {
        if (this.musicDao == null) {
            this.musicDao = new MusicDAO();
        }
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
        if (this.filmDao == null) {
            this.filmDao = new FilmDAO();
        }
        return filmDao;
    }

    public List<Films> getFilmList() {
        this.filmList = this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Musics> getFullMusicList() {
        this.fullMusicList=this.getMusicDao().findAll();
        return fullMusicList;
    }

    public void setFullMusicList(List<Musics> fullMusicList) {
        this.fullMusicList = fullMusicList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
