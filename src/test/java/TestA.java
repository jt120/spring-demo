import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author he
 * @since 2015/1/22
 */
public class TestA {

    @Test
    public void test01() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
    }
}
