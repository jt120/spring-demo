package sample;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author he
 * @since 2015/1/22
 */
public class SessionFactory {

    private Connection connection;

    public SessionFactory(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void close() {
        try {
            if(connection!=null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
