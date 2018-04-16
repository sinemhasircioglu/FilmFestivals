package controllers;

import dao.DirectorDAO;
import dao.FilmDAO;
import dao.MultimedyaDAO;
import entities.Directors;
import entities.Films;
import entities.Multimedya;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="directorController")
@SessionScoped
public class DirectorController implements Serializable{
    private DirectorDAO directorDao;
    private List<Directors> directorList;
    private Directors director;

    private Long selectedMultimedya;
    private MultimedyaDAO multimedyaDao;
    private List<Multimedya> multimedyaList;
    
    private FilmDAO filmDao; 
    private List<Films> filmList;
    private List<Long> selectedFilms;

    
    public String updateForm(Directors d){
        this.director=d;
        return"director";
    }
    
    public String update() {
        this.getDirectorDao().update(this.director);
        return "director";
    }
    
    public String create(){
        this.getDirectorDao().create(this.director, selectedMultimedya);
        return "director";
    }
    
    public String delete(Directors d){
        this.getDirectorDao().delete(d);
        return"director";
    }
    
    public DirectorDAO getDirectorDao() {
        if(this.directorDao==null)
            this.directorDao=new DirectorDAO();
        return directorDao;
    }

    public void setDirectorDao(DirectorDAO directorDao) {
        this.directorDao = directorDao;
    }

    public List<Directors> getDirectorList() {
        this.directorList=this.getDirectorDao().findAll();
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    public Directors getDirector() {
        if(this.director==null)
            this.director=new Directors();
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }

    public Long getSelectedMultimedya() {
        return selectedMultimedya;
    }

    public void setSelectedMultimedya(Long selectedMultimedya) {
        this.selectedMultimedya = selectedMultimedya;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
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

    public List<Long> getSelectedFilms() {
        return selectedFilms;
    }

    public void setSelectedFilms(List<Long> selectedFilms) {
        this.selectedFilms = selectedFilms;
    }   
}
