package controllers;

import dao.ActorDAO;
import dao.DirectorDAO;
import dao.FestivalDAO;
import dao.FilmDAO;
import dao.MultimedyaDAO;
import dao.MusicDAO;
import entities.Actors;
import entities.Directors;
import entities.Festivals;
import entities.Films;
import entities.Multimedya;
import entities.Musics;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "filmController")
@SessionScoped
public class FilmController implements Serializable {
    private Films film;
    private List<Films> fullFilmList;
    private FilmDAO filmDao;

    private ActorDAO actorDao;
    private MusicDAO musicDao;
    private DirectorDAO directorDao;
    private FestivalDAO festivalDao;
    private MultimedyaDAO multimedyaDao;

    private List<Actors> actorList;
    private List<Musics> musicList;
    private List<Directors> directorList;
    private List<Festivals> festivalList;
    private List<Multimedya> multimedyaList;
    
    private int page = 1;
    private int pageSize = 3;
    private List<Films> filmList;

    public void delete() {
        this.getFilmDao().delete(this.film);
        this.clearForm();
    }

    public void updateForm(Films f) {
        this.film = f;
    }
    
    public void clearForm() {
        this.film= new Films();
    }

    public void update() {
        this.getFilmDao().update(this.film);
        this.clearForm();
    }

    public void create() {
        this.getFilmDao().insert(this.film);
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
        return (int) Math.ceil(this.getFilmDao().findAll().size() / (double) pageSize);
    }
    
    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public ActorDAO getActorDao() {
        if(this.actorDao==null)
            this.actorDao=new ActorDAO();
        return actorDao;
    }

    public MusicDAO getMusicDao() {
        if(this.musicDao==null)
            this.musicDao=new MusicDAO();
        return musicDao;
    }

    public DirectorDAO getDirectorDao() {
        if(this.directorDao==null)
            this.directorDao=new DirectorDAO();
        return directorDao;
    }

    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }

    public Films getFilm() {
        if(this.film==null)
            this.film=new Films();
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public List<Films> getFilmList() {
        this.filmList=this.getFilmDao().findAll(page,pageSize);
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Actors> getActorList() {
        this.actorList=this.getActorDao().findAll();
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public List<Musics> getMusicList() {
        this.musicList=this.getMusicDao().findAll();
        return musicList;
    }

    public void setMusicList(List<Musics> musicList) {
        this.musicList = musicList;
    }

    public List<Directors> getDirectorList() {
        this.directorList=this.getDirectorDao().findAll();
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    public List<Festivals> getFestivalList() {
        this.festivalList=this.getFestivalDao().findAll();
        return festivalList;
    }

    public void setFestivalList(List<Festivals> festivalList) {
        this.festivalList = festivalList;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }

    public List<Films> getFullFilmList() {
        this.fullFilmList= this.getFilmDao().findAll();
        return fullFilmList;
    }

    public void setFullFilmList(List<Films> fullFilmList) {
        this.fullFilmList = fullFilmList;
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
