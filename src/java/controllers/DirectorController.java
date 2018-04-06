package controllers;

import dao.DirectorDAO;
import entities.Directors;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="directorController")
@SessionScoped
public class DirectorController implements Serializable{
    private DirectorDAO directorDao;
    private List<Directors> directorList;
    private Directors director;

    public DirectorController() {
        this.directorDao = new DirectorDAO();
        this.directorList = new ArrayList();
    }

    public String create(){
        this.getDirectorDao().create(this.director);
        return "index";
    }
    
    public DirectorDAO getDirectorDao() {
        if(this.directorDao==null)
            this.directorDao=new DirectorDAO();
        return directorDao;
    }

    public void setDirectorDao(DirectorDAO directorDao) {
        this.directorDao = directorDao;
    }

    public List<Directors> getDirectorList() {
        this.directorList=this.getDirectorDao().findAll();
        return directorList;
    }

    public void setDirectorList(List<Directors> directorList) {
        this.directorList = directorList;
    }

    public Directors getDirector() {
        if(this.director==null)
            this.director=new Directors();
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }
}
