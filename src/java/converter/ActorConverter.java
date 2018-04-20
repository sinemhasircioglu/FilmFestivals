package converter;

import dao.ActorDAO;
import entities.Actors;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="actorConverter")
public class ActorConverter implements Converter {
    private ActorDAO actorDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getActorDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Actors a= (Actors) value;
        return a.getId().toString();
    }

    public ActorDAO getActorDao() {
        if(this.actorDao==null)
            this.actorDao=new ActorDAO();
        return actorDao;
    }    
}
