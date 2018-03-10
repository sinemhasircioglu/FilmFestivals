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
@Named
@SessionScoped
public class ActorController implements Serializable{
    private List<Actors> actorlist;
    private ActorDAO actordao;
    private Actors actor;

    public ActorController() {
        this.actorlist=new ArrayList();
        this.actordao=new ActorDAO();
    }

    public List<Actors> getActorlist() {
        this.actorlist=this.getActordao().list();
        return actorlist;
    }

    public void setActorlist(List<Actors> actorlist) {
        this.actorlist = actorlist;
    }

    public ActorDAO getActordao() {
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
