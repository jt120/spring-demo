package config;

import javax.sql.DataSource;

/**
 * Created by ze.liu on 2015/1/23.
 */
public class JdbcAccountRepository implements AccountRepository {
    public JdbcAccountRepository(DataSource dataSource) {
    }
}
