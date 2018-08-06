package in.ezeon.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author unknown
 */

//NOTE: do not @Repository or  @Service or @Component annotation
public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource ds) {
        super.setDataSource(ds);

    }
}
