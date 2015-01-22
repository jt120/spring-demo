package sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author he
 * @since 2015/1/22
 */
public class HibernateFooRepository implements FooRepository<User> {

    SessionFactory sessionFactory;

    public HibernateFooRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sessionFactory.getConnection();
            statement = connection.createStatement();
            statement.execute("insert into t_user (name) values ('" + user.getName() + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement!=null)
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
