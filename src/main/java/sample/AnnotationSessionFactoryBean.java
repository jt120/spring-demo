package sample;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author he
 * @since 2015/1/22
 */
public class AnnotationSessionFactoryBean {

    private DataSource dataSource;

    private SessionFactory sessionFactory;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SessionFactory getObject() {
        try {
            return new SessionFactory(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
