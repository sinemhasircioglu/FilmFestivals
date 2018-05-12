package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinem
 */
public class DBConnection {

    public Connection connect() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FilmFestival?user=postgres&password=1234");
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }
}
