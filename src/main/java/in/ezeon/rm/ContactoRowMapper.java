package in.ezeon.rm;

import in.ezeon.domain.Contacto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author unknown
 */
public class ContactoRowMapper implements RowMapper<Contacto> {
    
    @Override
    public Contacto mapRow(ResultSet rs, int i) throws SQLException {
        Contacto c = new Contacto();
        c.setContacId(rs.getInt("contactoId"));
        c.setUserId(rs.getInt("userId"));
        c.setName(rs.getString("name"));
        c.setMail(rs.getString("email"));
        c.setAddress(rs.getString("address"));
        c.setPhone(rs.getString("phone"));
        c.setRemark(rs.getString("remark"));
        
        return c;
        
    }
    
}
