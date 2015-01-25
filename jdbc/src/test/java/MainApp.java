import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author he
 * @since 2015/1/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class MainApp {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @Test
    public void test01() throws Exception {
//        jdbcTemplate.queryForObject("select id from t_user where name='zhangsan'", int.class);

        User user = jdbcTemplate.queryForObject("select id,name from t_user where id=?",new Object[]{1},
                new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        System.out.println(user);
    }


    public List<Map<String, Object>> getList() {
        return this.jdbcTemplate.queryForList("select * from t_user");
    }

    @Test
    public void testList() throws Exception {
        List<Map<String, Object>> list = getList();
        System.out.println(list);
        //[{id=1, name=hello}, {id=2, name=aaa}, {id=3, name=ddd}]
    }
    @Test
    public void test02() throws Exception {
        List<Actor> actors = this.jdbcTemplate.query(
                "select first_name, last_name from t_actor",
                new RowMapper<Actor>() {
                    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Actor actor = new Actor();
                        actor.setFirstName(rs.getString("first_name"));
                        actor.setLastName(rs.getString("last_name"));
                        return actor;
                    }
                });
    }

    public List<Actor> findAllActors() {
        return this.jdbcTemplate.query("select first_name, last_name from t_actor", new ActorMapper());
    }

    /**
     * 如果有多处使用
     */
    private static final class ActorMapper implements RowMapper<Actor> {

        public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Actor actor = new Actor();
            actor.setFirstName(rs.getString("first_name"));
            actor.setLastName(rs.getString("last_name"));
            return actor;
        }
    }

    @Test
    public void test03() throws Exception {
        String actorId = "12";
        this.jdbcTemplate.update(
                "insert into t_actor (first_name, last_name) values (?, ?)",
                "Leonor", "Watling");


        this.jdbcTemplate.update(
                "update t_actor set last_name = ? where id = ?",
                "Banjo", 5276L);

        this.jdbcTemplate.update(
                "delete from actor where id = ?",
                Long.valueOf(actorId));
    }

    @Test
    public void test04() throws Exception {
        this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");

        String unionId = "12";

//        this.jdbcTemplate.update(
//                "call SUPPORT.REFRESH_ACTORS_SUMMARY(?)",
//                Long.valueOf(unionId));
    }

    @Test
    public void test05() throws Exception {
        UserUpdate userUpdate = new UserUpdate(dataSource);
        userUpdate.exc(1,"world");
    }

    class User {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
