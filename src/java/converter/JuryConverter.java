package converter;

import dao.JuryDAO;
import entities.Juries;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="juryConverter")
public class JuryConverter implements Converter {
    private JuryDAO juryDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getJuryDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Juries j = (Juries) value;
        return j.getId().toString();
    }

    public JuryDAO getJuryDao() {
        if(this.juryDao==null)
            this.juryDao=new JuryDAO();
        return juryDao;
    }
}
