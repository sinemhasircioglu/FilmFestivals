package controllers;

import dao.FestivalDAO;
import dao.JuryDAO;
import entities.Festivals;
import entities.Juries;
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
    private List<Juries> fullJuryList;
    private Juries jury;
    
    private FestivalDAO festivalDao;
    private List<Festivals> festivalList;
        
    private int page = 1;
    private int pageSize = 3;
    private List<Juries> juryList;
    
    public void updateForm(Juries j) {
        this.jury=j;
    }
    
    public void clearForm() {
        this.jury= new Juries();
    }
    public void update() {
        this.getJuryDao().update(this.jury);
        this.clearForm();
    }
    
    public void create(){
        this.getJuryDao().create(this.jury);
        this.clearForm();
    }
    
    public void delete() {
        this.getJuryDao().delete(this.jury);
        this.clearForm();
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
        return (int) Math.ceil(this.getJuryDao().findAll().size() / (double) pageSize);
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
        this.juryList=this.getJuryDao().findAll(page,pageSize);
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

    public List<Juries> getFullJuryList() {
        this.fullJuryList=this.getJuryDao().findAll();
        return fullJuryList;
    }

    public void setFullJuryList(List<Juries> fullJuryList) {
        this.fullJuryList = fullJuryList;
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
