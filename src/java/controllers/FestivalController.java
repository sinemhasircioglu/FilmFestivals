package controllers;

import dao.FestivalDAO;
import entities.Festivals;
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

    public FestivalController() {
        this.festivalDao = new FestivalDAO();
        this.festivalList = new ArrayList();
    }
   
    public String delete(Festivals f) {
        this.getFestivalDao().delete(f);
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
    
    
}
