package in.ezeon.capp.test;

import in.ezeon.config.SpringRootConfig;
import in.ezeon.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author unknown
 */
public class TestUserDAODelete {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        
        userDAO.delete(2);
        
        System.out.println("--------------Data Deleted------------");
    }
}
