package controllers;

import dao.DirectorDAO;
import dao.FilmDAO;
import entities.Directors;
import entities.Films;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "directorController")
@SessionScoped
public class DirectorController implements Serializable {
    private DirectorDAO directorDao;
    private List<Directors> fullDirectorList;
    private Directors director;

    private FilmDAO filmDao;
    private List<Films> filmList;
    
    private int page = 1;
    private int pageSize = 3;
    private List<Directors> directorList;

    public void updateForm(Directors d) {
        this.director = d;
    }
    
    public void clearForm() {
        this.director = new Directors();
    }

    public void update() {
        this.getDirectorDao().update(this.director);
        this.clearForm();
    }

    public void create() {
        this.getDirectorDao().create(this.director);
        this.clearForm();
    }

    public void delete() {
        this.getDirectorDao().delete(this.director);
        this.clearForm();
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
        return (int) Math.ceil(this.getDirectorDao().findAll().size() / (double) pageSize);
    }

    public DirectorDAO getDirectorDao() {
        if (this.directorDao == null) {
            this.directorDao = new DirectorDAO();
        }
        return directorDao;
    }

    public void setDirectorDao(DirectorDAO directorDao) {
        this.directorDao = directorDao;
    }

    public List<Directors> getDirectorList() {
        this.directorList = this.getDirectorDao().findAll(page,pageSize);
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    public Directors getDirector() {
        if (this.director == null) 
            this.director = new Directors();
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) 
            this.filmDao = new FilmDAO();
        return filmDao;
    }

    public List<Films> getFilmList() {
        this.filmList = this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Directors> getFullDirectorList() {
        this.fullDirectorList = this.getDirectorDao().findAll();
        return fullDirectorList;
    }

    public void setFullDirectorList(List<Directors> fullDirectorList) {
        this.fullDirectorList = fullDirectorList;
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
