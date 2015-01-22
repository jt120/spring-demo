package convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.util.Date;

@Configuration
public class AppConfig {

  @Bean
  public FormattingConversionService conversionService() {

    // Use the DefaultFormattingConversionService but do not register defaults
    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

    // Ensure @NumberFormat is still supported
    conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

    // Register date conversion with a specific global format
    DateFormatterRegistrar registrar = new DateFormatterRegistrar();
    registrar.setFormatter(new DateFormatter("yyyyMMdd"));
    registrar.registerFormatters(conversionService);

    return conversionService;
  }

//    @Autowired
//            @Qualifier("conversionService")
    FormattingConversionService conversionService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = new User();
        user.setName("hhh");
        user.setBirthday(new Date());
        System.out.println(user);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
        FormattingConversionService formattingConversionService = (FormattingConversionService) ctx.getBean("conversionService");
        System.out.println(formattingConversionService);
        String convert = formattingConversionService.convert(new Date(), String.class);
        System.out.println(convert);
//        new AppConfig().cv(user);
    }

    public void cv(User user) {
        String convert = conversionService.convert(user, String.class);
        System.out.println(convert);

    }
}