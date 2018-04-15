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
    private List<Long> selectedJuries;
    
    private FilmDAO filmDao;
    private List<Films> filmList;
    private List<Long> selectedFilms;
  
    public String updateForm(Festivals f){
        this.festival=f;
        
        this.selectedJuries=new ArrayList<>();
        for(Juries j : this.festival.getJuryList()) {
            this.selectedJuries.add(j.getId());
        }
        
        this.selectedFilms=new ArrayList<>();
        for(Films film :this.festival.getFilmList()){
            this.selectedFilms.add(film.getId());
        }
        return "festival";
    }
    
    public String update() {
        this.getFestivalDao().update(this.festival,selectedJuries,selectedFilms);
        return "festival";
    }
   
    public String delete(Festivals f) {
        this.getFestivalDao().delete(f);
        return "festival";
    }
    
    public String create(){
        this.getFestivalDao().create(this.festival,selectedJuries,selectedFilms);
        return "festival";
    }
    
    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }

    public void setFestivalDao(FestivalDAO festivalDao) {
        this.festivalDao = festivalDao;
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

    public List<Long> getSelectedJuries() {
        return selectedJuries;
    }

    public void setSelectedJuries(List<Long> selectedJuries) {
        this.selectedJuries = selectedJuries;
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
