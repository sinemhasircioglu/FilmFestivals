package converter;

import dao.FestivalDAO;
import entities.Festivals;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="festivalConverter")
public class FestivalConverter implements Converter {
    private FestivalDAO festivalDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFestivalDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Festivals fest = (Festivals) value;
        return fest.getId().toString();
    }   

    public FestivalDAO getFestivalDao() {
        if(this.festivalDao==null)
            this.festivalDao=new FestivalDAO();
        return festivalDao;
    }
}
