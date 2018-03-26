package controllers;

import dao.ActorDAO;
import entities.Actors;
import java.io.Serializable;
import java.util.ArrayList;
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
    private ActorDAO actordao;
    private Actors actor;

    public ActorController() {
        this.actorList=new ArrayList();
        this.actordao=new ActorDAO();
    }

    public List<Actors> getActorList() {
        this.actorList=this.getActordao().findAll();
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public ActorDAO getActordao() {
        if(this.actordao==null)
            this.actordao=new ActorDAO();
        return actordao;
    }

    public void setActordao(ActorDAO actordao) {
        this.actordao = actordao;
    }

    public Actors getActor() {
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }
    
}
