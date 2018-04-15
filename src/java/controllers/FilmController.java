package controllers;

import dao.FilmDAO;
import dao.MultimedyaDAO;
import entities.Films;
import entities.Multimedya;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "filmController")
@SessionScoped
public class FilmController implements Serializable {

    private FilmDAO filmDao;
    private Films film;
    private List<Films> filmList;
    
    @Inject
    private DirectorController directorController;
    
    private MultimedyaDAO multimedyaDao; 
    private List<Multimedya> multimedyaList;
    private Long selectedMultimedya;
    private Long selectedFestival;
    private List<Long> selectedDirectors;

    public String create() {
        this.getFilmDao().insert(this.film, selectedMultimedya, selectedFestival, selectedDirectors);
        return "film";
    }

    public String updateForm(Films f) {
        this.film = f;
        return "film";
    }

    public String update() {
        this.getFilmDao().update(this.film);
        return "film";
    }

    public String delete(Films f) {
        this.getFilmDao().delete(f);
        return "film";
    }

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) {
            this.filmDao = new FilmDAO();
        }
        return filmDao;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public List<Films> getFilmList() {
        this.filmList = this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public DirectorController getDirectorController() {
        if(this.directorController==null)
            this.directorController=new DirectorController();
        return directorController;
    }

    public void setDirectorController(DirectorController directorController) {
        this.directorController = directorController;
    }

    public Long getSelectedMultimedya() {
        return selectedMultimedya;
    }

    public void setSelectedMultimedya(Long selectedMultimedya) {
        this.selectedMultimedya = selectedMultimedya;
    }

    public Long getSelectedFestival() {
        return selectedFestival;
    }

    public void setSelectedFestival(Long selectedFestival) {
        this.selectedFestival = selectedFestival;
    }

    public List<Long> getSelectedDirectors() {
        return selectedDirectors;
    }

    public void setSelectedDirectors(List<Long> selectedDirectors) {
        this.selectedDirectors = selectedDirectors;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }
    
}
