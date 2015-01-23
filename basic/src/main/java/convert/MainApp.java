package convert;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.support.FormattingConversionService;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ze.liu on 2015/1/23.
 */
@Configuration
@Import(AppConfig.class)
public class MainApp {

    //@Autowired
    //FormattingConversionService conversionService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        //final ArrayList<String> strings = Lists.newArrayList(beanDefinitionNames);
        //System.out.println(strings);
        //User user = new User();
        //user.setBirthday(new Date());
        //UserService userService = (UserService) ctx.getBean("userService");
        //System.out.println(user.getBirthday());
        //MainApp app = new MainApp();
        //userService.show(user);

        final FooService bean = ctx.getBean(FooService.class);
        bean.good("good");
    }

    //public void show(User user) {
    //    userService.show(user);
    //}
}
