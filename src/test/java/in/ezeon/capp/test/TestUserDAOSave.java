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
public class TestUserDAOSave {

    public static void main(String args[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

        UserDAO userDAO = ctx.getBean(UserDAO.class);

        //the user detail will be taken from User-Reg-Form
        User u = new User();
        u.setName("MRROOX");
        u.setPhone("12345577");
        u.setEmail("email@com.com");
        u.setAddress("Temuco");
        u.setLoginName("mrroox");
        u.setPassword("super123");
        u.setRole(1); //Admin role
        u.setLoginStatus(1); //Active
        
        userDAO.save(u);
        
        System.out.println("--------Data Save---------");

    }
}
