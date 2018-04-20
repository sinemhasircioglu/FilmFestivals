package converter;

import dao.GroupDAO;
import entities.Group;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="groupConverter")
public class GroupConverter implements Converter {
    private GroupDAO groupDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getGroupDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Group g = (Group) value;
        return g.getId().toString();
    }    

    public GroupDAO getGroupDao() {
        if(this.groupDao==null)
            this.groupDao= new GroupDAO();
        return groupDao;
    }
}
