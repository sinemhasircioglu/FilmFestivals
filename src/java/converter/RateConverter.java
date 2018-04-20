package converter;

import dao.RatesDAO;
import entities.Rates;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="rateConverter")
public class RateConverter implements Converter{
    private RatesDAO rateDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getRateDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Rates r= (Rates) value;
        return r.getId().toString();
    }

    public RatesDAO getRateDao() {
        if(this.rateDao==null)
            this.rateDao=new RatesDAO();
        return rateDao;
    }
}
