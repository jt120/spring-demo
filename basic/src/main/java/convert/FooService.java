package convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ze.liu on 2015/1/23.
 */
@Service
public class FooService {

    @Autowired
    UserService userService;

    private Map<String, UserService> map = new ConcurrentHashMap<String, UserService>();

    @PostConstruct
    public void init() {
        map.put("good", userService);
    }

    public void good() {
        userService.show(new User("jjj",new Date()));
    }

    public void good(String s) {
        map.get(s).show(new User("fff",new Date()));
    }
}
