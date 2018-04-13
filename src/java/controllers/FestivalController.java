package controllers;

import dao.FestivalDAO;
import dao.JuryDAO;
import entities.Festivals;
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
    private List<Integer> selectedJuries;

    public FestivalController() {
        this.festivalDao = new FestivalDAO();
        this.festivalList = new ArrayList();
    }
    
    public String updateForm(Festivals f){
        this.festival=f;
        return "festival";
    }
    
    public String update() {
        this.getFestivalDao().update(this.festival);
        return "festival";
    }
   
    public String delete(Festivals f) {
        this.getFestivalDao().delete(f);
        return "festival";
    }
    
    public String create(){
        this.getFestivalDao().create(this.festival);
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

    public List<Integer> getSelectedJuries() {
        return selectedJuries;
    }

    public void setSelectedJuries(List<Integer> selectedJuries) {
        this.selectedJuries = selectedJuries;
    }
 
}
