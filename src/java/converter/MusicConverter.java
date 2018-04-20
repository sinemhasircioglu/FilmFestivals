package converter;

import dao.MusicDAO;
import entities.Musics;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sinem
 */
@FacesConverter(value="musicConverter")
public class MusicConverter implements Converter {
    private MusicDAO musicDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMusicDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Musics m= (Musics) value;
        return m.getId().toString();
    }    

    public MusicDAO getMusicDao() {
        if(this.musicDao==null)
            this.musicDao=new MusicDAO();
        return musicDao;
    }
}
