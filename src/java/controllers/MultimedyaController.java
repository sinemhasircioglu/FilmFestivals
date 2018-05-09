package controllers;

import dao.MultimedyaDAO;
import entities.Multimedya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="multimedyaController")
@SessionScoped
public class MultimedyaController implements Serializable{
    private Multimedya multimedya;
    private List<Multimedya> fullMultimedyaList;
    private MultimedyaDAO multimedyaDao;
    
    @Inject
    private FilmController filmController;
    @Inject
    private ActorController actorController;
    
    private int page = 1;
    private int pageSize = 3;
    private List<Multimedya> multimedyaList;
  
    public void updateForm(Multimedya m) {
        this.multimedya=m;
    }
    
    public void clearForm() {
        this.multimedya= new Multimedya();
    }
    public void update() {
        this.getMultimedyaDao().update(this.multimedya);
        this.clearForm();
    }
    
    public void create(){
        this.getMultimedyaDao().create(this.multimedya);
        this.clearForm();
    }
    
    public void delete() {
        this.getMultimedyaDao().delete(this.multimedya);
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
        return (int) Math.ceil(this.getMultimedyaDao().findAll().size() / (double) pageSize);
    }

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
        this.multimedyaList=this.getMultimedyaDao().findAll(page,pageSize);
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

    public FilmController getFilmController() {
        if(this.filmController==null)
            this.filmController=new FilmController();
        return filmController;
    }

    public ActorController getActorController() {
        if(this.actorController==null)
            this.actorController=new ActorController();
        return actorController;
    }

    public List<Multimedya> getFullMultimedyaList() {
        this.fullMultimedyaList=this.getMultimedyaDao().findAll();
        return fullMultimedyaList;
    }

    public void setFullMultimedyaList(List<Multimedya> fullMultimedyaList) {
        this.fullMultimedyaList = fullMultimedyaList;
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
