package in.ezeon.capp.test;

import in.ezeon.config.SpringRootConfig;
import in.ezeon.domain.User;
import in.ezeon.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author unknown
 */
public class TestUserServiceRegister {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        User u = new User();
        u.setName("Hola");
        u.setPhone("555555555");
        u.setEmail("rayos@email.com");
        u.setAddress("Noruega");
        u.setLoginName("root");
        u.setPassword("password123");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);

        userService.register(u);

        System.out.println("----------User Registered Successfully--------------");

    }

}
