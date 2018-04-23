package controllers;

import dao.RatesDAO;
import dao.TypeDAO;
import entities.Rates;
import entities.Type;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="ratesController")
@SessionScoped
public class RatesController implements Serializable {
    private Rates rate;
    private List<Rates> rateList;
    private RatesDAO ratesDao;
    
    private Long selectedRaterType;
    private Long selectedRatedType;
    private TypeDAO typeDao;
    private List<Type> typeList;
    
    
     public String create(){
        this.getRatesDao().create(this.rate, selectedRaterType, selectedRaterType);
                return "rates";
    }
     
     public void update(){
        this.getRatesDao().update(this.rate,selectedRaterType);
    }
     
      public void delete(){
        this.getRatesDao().delete(this.rate);
        this.selectedRaterType=null;   
        this.selectedRatedType=null;
    }
     
      public void updateForm(Rates r){
       this.rate=r;
       this.selectedRaterType=this.rate.getRaterType().getId();
       this.selectedRatedType=this.rate.getRatedType().getId();
      }

    public Rates getRate() {
        if(this.rate==null)
            this.rate=new Rates();
        return rate;
    }
    
    public void setRate(Rates rate) {
        this.rate = rate;
    }

    public List<Rates> getRateList() {
         this.rateList=this.getRatesDao().findAll();
        return rateList;
    }

    public void setRateList(List<Rates> rateList) {
        this.rateList = rateList;
    }

    public RatesDAO getRatesDao() {
        if(this.ratesDao==null)
            this.ratesDao=new RatesDAO();
        return ratesDao;
    }

    public Long getSelectedRaterType() {
        return selectedRaterType;
    }

    public void setSelectedRaterType(Long selectedRaterType) {
        this.selectedRaterType = selectedRaterType;
    }

    public TypeDAO getTypeDao() {
        if(this.typeDao==null)
            this.typeDao=new TypeDAO();
        return typeDao;
    }

    public List<Type> getTypeList() {
        this.typeList=this.getTypeDao().findAll();
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public Long getSelectedRatedType() {
        return selectedRatedType;
    }

    public void setSelectedRatedType(Long selectedRatedType) {
        this.selectedRatedType = selectedRatedType;
    }
}
