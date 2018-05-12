package utility;

import entities.Users;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="loginController")
@SessionScoped
public class LoginController implements Serializable {
    private Users user;

    public String login() {
        if(this.user.getEmail().equals("deneme") && this.user.getPassword().equals("deneme")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "/admin/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/frontend/login?faces-redirect=true";
        }
    }
    
    public Users getUser() {
        if(this.user==null)
            this.user = new Users();
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }    
}
