package dao;

import java.sql.Connection;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class AbstractDAO {

    private DBConnection connector;
    private Connection connection;

    public DBConnection getConnector() {
        if(this.connector == null)
            this.connector = new DBConnection();
        return connector;
    }

    public void setConnector(DBConnection connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if(this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
