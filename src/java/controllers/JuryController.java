package controllers;

import dao.FestivalDAO;
import dao.JuryDAO;
import dao.MultimedyaDAO;
import entities.Festivals;
import entities.Juries;
import entities.Multimedya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="juryController")
@SessionScoped
public class JuryController implements Serializable{
    private JuryDAO juryDao;
    private List<Juries> juryList;
    private Juries jury;
    
    private Long selectedFestival;
    private FestivalDAO festivalDao;
    private List<Festivals> festivalList;
    
    private Long selectedMultimedya;
    private MultimedyaDAO multimedyaDao;
    private List<Multimedya> multimedyaList;
    
    public String updateForm(Juries j) {
        this.jury=j;
        this.selectedFestival=this.jury.getFestival().getId();
        this.selectedMultimedya=this.jury.getMultimedya().getId();
        return "jury";
    }
    
    public String update() {
        this.getJuryDao().update(this.jury, selectedFestival, selectedMultimedya);
        return "jury";
    }
    
    public String create(){
        this.getJuryDao().create(this.jury, selectedFestival, selectedMultimedya);
        return "jury";
    }
    
    public String delete() {
        this.getJuryDao().delete(this.jury);
        this.selectedFestival=null;
        this.selectedMultimedya=null;
        return"jury";
    }

    public JuryDAO getJuryDao() {
        if(this.juryDao==null)
            this.juryDao=new JuryDAO();
        return juryDao;
    }

    public void setJuryDao(JuryDAO juryDao) {
        this.juryDao = juryDao;
    }

    public List<Juries> getJuryList() {
        this.juryList=this.getJuryDao().findAll();
        return juryList;
    }

    public void setJuryList(List<Juries> juryList) {
        this.juryList = juryList;
    }

    public Juries getJury() {
        if(this.jury==null)
            this.jury=new Juries();
        return jury;
    }

    public void setJury(Juries jury) {
        this.jury = jury;
    }

    public Long getSelectedFestival() {
        return selectedFestival;
    }

    public void setSelectedFestival(Long selectedFestival) {
        this.selectedFestival = selectedFestival;
    }

    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }

    public List<Festivals> getFestivalList() {
        this.festivalList=this.getFestivalDao().findAll();
        return festivalList;
    }

    public void setFestivalList(List<Festivals> festivalList) {
        this.festivalList = festivalList;
    }

    public Long getSelectedMultimedya() {
        return selectedMultimedya;
    }

    public void setSelectedMultimedya(Long selectedMultimedya) {
        this.selectedMultimedya = selectedMultimedya;
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
