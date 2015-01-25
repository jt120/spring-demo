package embedded;

import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author he
 * @since 2015/1/24
 */
public class TestMain {

    @Test
    public void test01() throws Exception {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("my-schema.sql").addScript
                ("my-test-data.sql").build();
        // do stuff against the db (EmbeddedDatabase extends javax.sql.DataSource)
        db.shutdown();
    }
}
