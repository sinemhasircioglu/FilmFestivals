package controllers;

import dao.FestivalDAO;
import dao.FilmDAO;
import dao.JuryDAO;
import entities.Festivals;
import entities.Films;
import entities.Juries;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="festivalController")
@SessionScoped
public class FestivalController implements Serializable{
    private FestivalDAO festivalDao;
    private Festivals festival;
    private List<Festivals> fullFestivalList;
    
    private JuryDAO juryDao;
    private List<Juries> juryList;
    
    private FilmDAO filmDao;
    private List<Films> filmList;
  
     private int page = 1;
    private int pageSize = 3;
    private List<Festivals> festivalList;
    public void updateForm(Festivals f){
        this.festival=f;
    }
    
    public void clearForm() {
        this.festival=new Festivals();
    }
    
    public void update() {
        this.getFestivalDao().update(this.festival);
        this.clearForm();
    }
   
    public void delete() {
        this.getFestivalDao().delete(this.festival);
        this.clearForm();
    }
    
    public void create(){
        this.getFestivalDao().create(this.festival);
        this.clearForm();
    }
    
    public boolean validateName(FacesContext fc, UIComponent c, Object value) throws ValidatorException {
        String name = (String) value;
        if (name.length() < 8 || name.length() > 25) {
            String msg = "Name 8 ile 25 karakter arasında olmalıdır";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
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
        return (int) Math.ceil(this.getFestivalDao().findAll().size() / (double) pageSize);
    }
    
    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }

    public Festivals getFestival() {
        if(this.festival==null)
            this.festival=new Festivals();
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public List<Festivals> getFestivalList() {
        this.festivalList=this.getFestivalDao().findAll(page,pageSize);
        return festivalList;
    }

    public void setFestivalList(List<Festivals> festivalList) {
        this.festivalList = festivalList;
    }

    public JuryDAO getJuryDao() {
        if(this.juryDao==null)
            this.juryDao=new JuryDAO();
        return juryDao;
    }

    public List<Juries> getJuryList() {
        this.juryList=this.getJuryDao().findAll();
        return juryList;
    }

    public void setJuryList(List<Juries> juryList) {
        this.juryList = juryList;
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public List<Films> getFilmList() {
        this.filmList=this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Films> filmList) {
        this.filmList = filmList;
    }

    public List<Festivals> getFullFestivalList() {
        this.fullFestivalList = this.getFestivalDao().findAll();
        return fullFestivalList;
    }

    public void setFullFestivalList(List<Festivals> fullFestivalList) {
        this.fullFestivalList = fullFestivalList;
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
