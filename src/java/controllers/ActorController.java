package controllers;

import dao.ActorDAO;
import dao.FilmDAO;
import dao.MultimedyaDAO;
import entities.Actors;
import entities.Films;
import entities.Multimedya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "actorController")
@SessionScoped
public class ActorController implements Serializable {

    private List<Actors> fullActorList;
    private ActorDAO actorDao;
    private Actors actor;

    private FilmDAO filmDao;
    private List<Films> filmList;

    private MultimedyaDAO multimedyaDao;
    private List<Multimedya> multimedyaList;

    private int page = 1;
    private int pageSize = 3;
    private List<Actors> actorList;

    public void create() {
        this.getActorDao().create(this.actor);
        this.clearForm();
    }

    public void update() {
        this.getActorDao().update(this.actor);
        this.clearForm();
    }

    public void delete() {
        this.getActorDao().delete(this.actor);
        this.clearForm();
    }

    public void updateForm(Actors a) {
        this.actor = a;
    }
    
    public void clearForm() {
        this.actor=new Actors();
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
        return (int) Math.ceil(this.getActorDao().findAll().size() / (double) pageSize);
    }

    public Actors getActor() {
        if (this.actor == null) {
            this.actor = new Actors();
        }
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }

    public List<Actors> getActorList() {
        this.actorList = this.getActorDao().findAll(page, pageSize);
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public ActorDAO getActorDao() {
        if (this.actorDao == null) {
            this.actorDao = new ActorDAO();
        }
        return actorDao;
    }

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) {
            this.filmDao = new FilmDAO();
        }
        return filmDao;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if (this.multimedyaDao == null) {
            this.multimedyaDao = new MultimedyaDAO();
        }
        return multimedyaDao;
    }

    public List<Films> getFilmList() {
        this.filmList = this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList = this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }

    public List<Actors> getFullActorList() {
        this.actorList = this.getActorDao().findAll();
        return fullActorList;
    }

    public void setFullActorList(List<Actors> fullActorList) {
        this.fullActorList = fullActorList;
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
