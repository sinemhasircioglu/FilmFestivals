package controllers;

import dao.ActorDAO;
import dao.FilmDAO;
import dao.MultimedyaDAO;
import entities.Actors;
import entities.Films;
import entities.Multimedya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="actorController")
@SessionScoped
public class ActorController implements Serializable{
    private List<Actors> actorList;
    private ActorDAO actorDao;
    private Actors actor;

    private FilmDAO filmDao;
    private List<Films> filmList; 
    
    private MultimedyaDAO multimedyaDao;
    private List<Multimedya> multimedyaList; 
       
    
    public void create(){
         this.getActorDao().create(this.actor);
    }
    
     public void update(){
        this.getActorDao().update(this.actor);
    }
     
    public void delete(){
        this.getActorDao().delete(this.actor);
  
    }
 
    public void updateForm(Actors a){
       this.actor=a;
    }

    public Actors getActor() {
        if(this.actor==null)
            this.actor=new Actors();
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }

    public List<Actors> getActorList() {
        this.actorList=this.getActorDao().findAll();
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public ActorDAO getActorDao() {
         if(this.actorDao==null)
            this.actorDao=new ActorDAO();
        return actorDao;
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }

    public List<Films> getFilmList() {
        this.filmList=this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }
}
