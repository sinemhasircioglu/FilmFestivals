package converter;

import dao.DirectorDAO;
import entities.Directors;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="directorConverter")
public class DirectorConverter implements Converter{
    private DirectorDAO directorDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getDirectorDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Directors d=(Directors) value;
        return d.getId().toString();
    }

    public DirectorDAO getDirectorDao() {
        if(this.directorDao==null)
            this.directorDao=new DirectorDAO();
        return directorDao;
    }
}
