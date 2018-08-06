package in.ezeon.capp.test;

import in.ezeon.config.SpringRootConfig;
import in.ezeon.dao.UserDAO;
import in.ezeon.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author unknown
 */
public class TestUserDAOUpdate {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

        UserDAO userDAO = ctx.getBean(UserDAO.class);

        //the user detail will be taken from User-Reg-Form
        User u = new User();
        u.setUserId(1);
        u.setName("MRROOX");
        u.setPhone("12345577");
        u.setEmail("email@com.com");
        u.setAddress("Temuco");
        u.setRole(1); //Admin role
        u.setLoginStatus(1); //Active
        
        userDAO.update(u);
        
        System.out.println("--------Data Updated---------");

    }
}
