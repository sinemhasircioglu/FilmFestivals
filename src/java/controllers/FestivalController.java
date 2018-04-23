package controllers;

import dao.FestivalDAO;
import dao.FilmDAO;
import dao.JuryDAO;
import entities.Festivals;
import entities.Films;
import entities.Juries;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="festivalController")
@SessionScoped
public class FestivalController implements Serializable{
    private FestivalDAO festivalDao;
    private Festivals festival;
    private List<Festivals> festivalList;
    
    private JuryDAO juryDao;
    private List<Juries> juryList;
    
    private FilmDAO filmDao;
    private List<Films> filmList;
  
    public void updateForm(Festivals f){
        this.festival=f;
    }
    
    public void clearForm() {
        this.festival=new Festivals();
    }
    
    public void update() {
        this.getFestivalDao().update(this.festival);
        this.clearForm();
    }
   
    public void delete() {
        this.getFestivalDao().delete(this.festival);
        this.clearForm();
    }
    
    public void create(){
        this.getFestivalDao().create(this.festival);
        this.clearForm();
    }
    
    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }

    public Festivals getFestival() {
        if(this.festival==null)
            this.festival=new Festivals();
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public List<Festivals> getFestivalList() {
        this.festivalList=this.getFestivalDao().findAll();
        return festivalList;
    }

    public void setFestivalList(List<Festivals> festivalList) {
        this.festivalList = festivalList;
    }

    public JuryDAO getJuryDao() {
        if(this.juryDao==null)
            this.juryDao=new JuryDAO();
        return juryDao;
    }

    public List<Juries> getJuryList() {
        this.juryList=this.getJuryDao().findAll();
        return juryList;
    }

    public void setJuryList(List<Juries> juryList) {
        this.juryList = juryList;
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
