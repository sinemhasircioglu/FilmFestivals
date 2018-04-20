package converter;

import dao.FilmDAO;
import entities.Films;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="filmConverter")
public class FilmConverter implements Converter {
    private FilmDAO filmDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFilmDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Films f= (Films) value;
        return f.getId().toString();
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }
}
