package controllers;

import dao.FilmDAO;
import entities.Films;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="filmController")
@SessionScoped
public class FilmController implements Serializable{
    private FilmDAO filmDao;
    private Films film;
    private List<Films> filmList;

    public FilmController() {
        this.filmList=new ArrayList();
        this.filmDao=new FilmDAO();
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public void setFilmDao(FilmDAO filmDao) {
        this.filmDao = filmDao;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public List<Films> getFilmList() {
        this.filmList=this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }
           
}
