package converter;

import dao.UserDAO;
import entities.Users;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="userConverter")
public class UserConverter implements Converter {
    private UserDAO userDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getUserDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Users u = (Users) value;
        return u.getId().toString();
    }   

    public UserDAO getUserDao() {
        if(this.userDao==null)
            this.userDao=new UserDAO();
        return userDao;
    }
}
