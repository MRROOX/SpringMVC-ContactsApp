package in.ezeon.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author unknown
 */
@Configuration
@ComponentScan(basePackages = {"in.ezeon.dao","in.ezeon.service"})
public class SpringRootConfig {
//TODO: Services, DAO, DataSource, Email Sender or Some other businness leyer beans

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
        ds.setUsername("root");
        ds.setPassword("super123");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("Select 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
    
}
