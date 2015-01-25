package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author he
 * @since 2015/1/25
 */
@Configuration
@ContextConfiguration(classes = {WebConfigB.class})
public class MainWeb {

    public static void main(String[] args) {

    }
}
