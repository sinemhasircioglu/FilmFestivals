package utility;

import entities.Users;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
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
        /* 
        kullanıcı email ve password kontrolu
        var ise sessionAttribute ile valid_user
        
        */
        
        return "";
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
