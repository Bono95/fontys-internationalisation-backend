package app;

import data.crud.CrudService;
import data.crud.HibernateCrudOperation;
import service.user.DefaultUserService;
import service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService() {
        return new DefaultUserService();
    }

    @Bean
    public CrudService crudService(){
        return new CrudService(new HibernateCrudOperation());
    }
}

