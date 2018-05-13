package controllers;

import dao.ActorDAO;
import dao.FilmDAO;
import entities.Actors;
import entities.Films;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named
@FacesValidator("actorController")
@SessionScoped
public class ActorController implements Serializable {

    private List<Actors> fullActorList;
    private ActorDAO actorDao;
    private Actors actor;

    private FilmDAO filmDao;
    private List<Films> filmList;

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
        this.actor = new Actors();
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

    public boolean validateName(FacesContext fc, UIComponent c, Object value) throws ValidatorException {
        String name = (String) value;
        if (name.length() < 8 || name.length() > 25) {
            String msg = "Name 8 ile 25 karakter arasında olmalıdır";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
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

    public List<Films> getFilmList() {
        this.filmList = this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
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
