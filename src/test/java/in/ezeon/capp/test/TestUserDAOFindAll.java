package in.ezeon.capp.test;

import in.ezeon.config.SpringRootConfig;
import in.ezeon.dao.UserDAO;
import in.ezeon.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author unknown
 */
public class TestUserDAOFindAll {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

        UserDAO userDAO = ctx.getBean(UserDAO.class);

        List<User> users = userDAO.findAll();

        System.out.println("----------User Detail List--------------");

        System.out.println("User List ==> "+users.toString());
        
        
        
        
    }

}
