package converter;

import dao.MultimedyaDAO;
import entities.Multimedya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="multimedyaConverter")
public class MultimedyaConverter implements Converter {
    private MultimedyaDAO multimedyaDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMultimedyaDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Multimedya m = (Multimedya) value;
        return m.getId().toString();
    }    

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao= new MultimedyaDAO();
        return multimedyaDao;
    }
}
