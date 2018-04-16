package controllers;

import dao.MultimedyaDAO;
import entities.Multimedya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="multimedyaController")
@SessionScoped
public class MultimedyaController implements Serializable{
    private Multimedya multimedya;
    private List<Multimedya> multimedyaList;
    private MultimedyaDAO multimedyaDao;

    public Multimedya getMultimedya() {
        if (this.multimedya == null) {
            this.multimedya = new Multimedya();
        }
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if (this.multimedyaDao == null) {
            this.multimedyaDao = new MultimedyaDAO();
        }
        return multimedyaDao;
    }

}
