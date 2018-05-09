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
@Named(value = "ratesController")
@SessionScoped
public class RatesController implements Serializable {

    private Rates rate;
    private List<Rates> fullRateList;
    private RatesDAO ratesDao;

    private Long selectedRaterType;
    private Long selectedRatedType;
    private TypeDAO typeDao;
    private List<Type> typeList;

    private int page = 1;
    private int pageSize = 3;
    private List<Rates> rateList;

    public String create() {
        this.getRatesDao().create(this.rate, selectedRaterType, selectedRaterType);
        return "rates";
    }

    public void update() {
        this.getRatesDao().update(this.rate, selectedRaterType);
    }

    public void delete() {
        this.getRatesDao().delete(this.rate);
        this.selectedRaterType = null;
        this.selectedRatedType = null;
    }

    public void updateForm(Rates r) {
        this.rate = r;
        this.selectedRaterType = this.rate.getRaterType().getId();
        this.selectedRatedType = this.rate.getRatedType().getId();
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
        return (int) Math.ceil(this.getRatesDao().findAll().size() / (double) pageSize);
    }

    public Rates getRate() {
        if (this.rate == null) {
            this.rate = new Rates();
        }
        return rate;
    }

    public void setRate(Rates rate) {
        this.rate = rate;
    }

    public List<Rates> getRateList() {
        this.rateList = this.getRatesDao().findAll(page, pageSize);
        return rateList;
    }

    public void setRateList(List<Rates> rateList) {
        this.rateList = rateList;
    }

    public RatesDAO getRatesDao() {
        if (this.ratesDao == null) {
            this.ratesDao = new RatesDAO();
        }
        return ratesDao;
    }

    public Long getSelectedRaterType() {
        return selectedRaterType;
    }

    public void setSelectedRaterType(Long selectedRaterType) {
        this.selectedRaterType = selectedRaterType;
    }

    public TypeDAO getTypeDao() {
        if (this.typeDao == null) {
            this.typeDao = new TypeDAO();
        }
        return typeDao;
    }

    public List<Type> getTypeList() {
        this.typeList = this.getTypeDao().findAll();
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

    public List<Rates> getFullRateList() {
        this.fullRateList = this.getRatesDao().findAll();
        return fullRateList;
    }

    public void setFullRateList(List<Rates> fullRateList) {
        this.fullRateList = fullRateList;
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
