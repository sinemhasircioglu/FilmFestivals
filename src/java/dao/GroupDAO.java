package dao;

import entities.Group;
import entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinem
 */
public class GroupDAO extends AbstractDAO{

    private UserDAO userDao;

    public void create(Group group) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Group\"(authority) VALUES ('" + group.getAuthority() + "')");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Group> findAll() {
        List<Group> groupList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Group\"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getLong("id"));
                group.setAuthority(rs.getString("authority"));
                group.setUserList(this.getUserDao().getGroupUsers(group.getId()));
                groupList.add(group);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupList;
    }

    public Group find(Long id) {
        Group group = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Group\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            group = new Group();
            group.setId(rs.getLong("id"));
            group.setAuthority(rs.getString("authority"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    public void update(Group group) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Group\" SET authority='" + group.getAuthority() + "' WHERE id="+group.getId()+" ");
            pst.executeUpdate();           
            for (Users u : group.getUserList()) {
                PreparedStatement pst2 = this.getConnection().prepareStatement("UPDATE public.\"Users\" SET groupid=" +group.getId()+ " WHERE id=" +u.getId()+" ");
                pst2.executeUpdate();
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Group group) {
        try {
            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("DELETE FROM public.\"Users\" WHERE groupid=" + group.getId() + "");
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("DELETE FROM public.\"Group\" WHERE id=" + group.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDAO();
        }
        return userDao;
    }
}
