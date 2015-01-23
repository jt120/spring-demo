import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ze.liu on 2015/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class TestMain {

    @Autowired
    ApplicationContext context;

    @Test
    public void test01() throws Exception {
        Assert.assertNotNull(context);
        final double v = 3 / 2.0;
        System.out.println(Math.ceil(v));

    }
}
