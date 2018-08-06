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
public class TestUserDAOFindByProp {

    public static void main(String args[]) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        List<User> users = userDAO.findByProperty("userId", 1);

        for (User u : users) {

            System.out.println(u.getUserId() + " " + u.getName() + " " + u.getRole());

            //TODO: access other columns
        }

    }
}
