package utility;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="navigationController")
@RequestScoped
public class NavigationController implements Serializable{
    
    public String goToFrontendPage(String page) {
        return "/frontend/"+page+"?faces-redirect=true";
    }    
    
    public String goToAdminPage(String page) {
        return "/admin/"+page+"/"+page+"?faces-redirect=true";
    } 
}
