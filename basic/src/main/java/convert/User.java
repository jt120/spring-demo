package convert;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author he
 * @since 2015/1/23
 */
public class User {

    private String name;
    @DateTimeFormat
    private Date birthday;

    public User() {
    }

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
