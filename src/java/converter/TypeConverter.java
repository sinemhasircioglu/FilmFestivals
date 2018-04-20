package converter;

import dao.TypeDAO;
import entities.Type;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="typeConverter")
public class TypeConverter implements Converter {
    private TypeDAO typeDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTypeDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Type t= (Type) value;
        return t.getId().toString();
    }

    public TypeDAO getTypeDao() {
        if(this.typeDao==null)
            this.typeDao=new TypeDAO();
        return typeDao;
    }
}
