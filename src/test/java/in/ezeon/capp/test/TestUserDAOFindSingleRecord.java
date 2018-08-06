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
public class TestUserDAOFindSingleRecord {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = userDAO.findById(1);

        System.out.println("------------User Detail---------------");
        System.out.println("Details ===> " + u.toString());
    }

}
