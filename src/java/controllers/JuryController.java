package controllers;

import dao.JuryDAO;
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
@Named(value="juryController")
@SessionScoped
public class JuryController implements Serializable{
    private JuryDAO juryDao;
    private List<Juries> juryList;
    private Juries jury;
    
    public String updateForm(Juries j) {
        this.jury=j;
        return "jury";
    }
    
    public String update() {
        this.getJuryDao().update(this.jury);
        return "jury";
    }
    
    public String create(){
        this.getJuryDao().create(this.jury);
        return "jury";
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
    
}
