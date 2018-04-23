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
    private List<Multimedya> multimedyaList;
    private MultimedyaDAO multimedyaDao;
    
    @Inject
    private FilmController filmController;
    @Inject
    private UserController userController;
    @Inject
    private JuryController juryController;
    @Inject
    private ActorController actorController;
    @Inject
    private DirectorController directorController;  
    
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

    public FilmController getFilmController() {
        if(this.filmController==null)
            this.filmController=new FilmController();
        return filmController;
    }

    public UserController getUserController() {
        if(this.userController==null)
            this.userController=new UserController();
        return userController;
    }

    public JuryController getJuryController() {
        if(this.juryController==null)
            this.juryController=new JuryController();
        return juryController;
    }

    public ActorController getActorController() {
        if(this.actorController==null)
            this.actorController=new ActorController();
        return actorController;
    }

    public DirectorController getDirectorController() {
        if(this.directorController==null)
            this.directorController=new DirectorController();
        return directorController;
    }
}
