import org.springframework.asm.Type;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author he
 * @since 2015/1/24
 * 把sql的行为, 变成了一个对象
 */
public class UserUpdate extends SqlUpdate {

    public UserUpdate(DataSource ds) {
        setDataSource(ds);
        setSql("update t_user set name=? where id=?;");
        declareParameter(new SqlParameter("name", Types.VARCHAR));
        declareParameter(new SqlParameter("id", Type.INT));
        compile();
    }

    public void exc(int id, String name) {
        update(name, id);
    }
}
