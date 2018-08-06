package in.ezeon.capp.test;

import in.ezeon.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author unknown
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql="INSERT INTO user(`name`,`phone`,`email`,`address`,`loginName`,`password`) VALUES (?,?,?,?,?,?)";
        Object[] param=new Object[]{"Felipe","78210545","f.quezada01@ufromail.cl","dir123","f","clave123"};
   jt.update(sql,param);
        System.out.println("-----------SQL Executed------------");
    
    }
}
