package controllers;

import dao.RatesDAO;
import dao.TypeDAO;
import entities.Rates;
import entities.Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "typeController")
@SessionScoped
public class TypeController implements Serializable {
    private Type type;
    private List<Type> typeList;
    private TypeDAO typeDao;

    private List<Long> selectedRates;
    private RatesDAO ratesDao;
    private List<Rates> ratesList;

    public String create() {
        this.getTypeDao().create(this.type, selectedRates);
        return "type";
    }

    public void delete() {
        this.getTypeDao().delete(this.type);
        this.selectedRates = null;
    }

    public void update() {
        this.getTypeDao().update(this.type, selectedRates);
    }

    public void updateForm(Type t) {
        this.type = t;

        this.selectedRates = new ArrayList<>();
        for (Rates r : this.type.getRateList()) {
            this.selectedRates.add(r.getId());
        }
    }

    public Type getType() {
        if(this.type==null)
            this.type=new Type();
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Type> getTypeList() {
        this.typeList=this.getTypeDao().findAll();
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public TypeDAO getTypeDao() {
        if(this.typeDao==null)
            this.typeDao=new TypeDAO();
        return typeDao;
    }

    public List<Long> getSelectedRates() {
        return selectedRates;
    }

    public void setSelectedRates(List<Long> selectedRates) {
        this.selectedRates = selectedRates;
    }

    public RatesDAO getRatesDao() {
        if(this.ratesDao==null)
            this.ratesDao=new RatesDAO();
        return ratesDao;
    }

    public List<Rates> getRatesList() {
        this.ratesList=this.getRatesDao().findAll();
        return ratesList;
    }

    public void setRatesList(List<Rates> ratesList) {
        this.ratesList = ratesList;
    }   
}
