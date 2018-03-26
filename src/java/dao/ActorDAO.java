package dao;

import entities.Actors;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class ActorDAO {

    private JuryDAO jurydao;

    public void create(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Actors\"(name,gender) VALUES ('" + ac.getName() + "','" + ac.isGender() + "'");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Actors> findAll() {
        List<Actors> actorList = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\"");
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getInt("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                //rs.getInt("filmid"),rs.getInt("fileid")
                actorList.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorList;
    }

    public Actors find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Actors ac = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE id=" + id + "");
            rs.next();
            ac = new Actors();
            ac.setId(rs.getInt("id"));
            ac.setName(rs.getString("name"));
            ac.setGender(rs.getBoolean("gender"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }
    
    public List<Actors> getFilmActors(int filmid){
        List<Actors> filmActors = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE filmid="+filmid+"");
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getInt("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                filmActors.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmActors;
    }
    
    public void update(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Actors\" SET name='" + ac.getName() + "' , gender='" + ac.isGender() + "' ");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Actors\" WHERE id=" + ac.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JuryDAO getJurydao() {
        if (this.jurydao == null) {
            this.jurydao = new JuryDAO();
        }
        return jurydao;
    }
}
