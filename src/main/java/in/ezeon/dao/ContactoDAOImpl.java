package in.ezeon.dao;

import in.ezeon.domain.Contacto;
import in.ezeon.rm.ContactoRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unknown
 */
@Repository
public class ContactoDAOImpl extends BaseDAO implements ContactoDAO {

    @Override
    public void save(Contacto c) {
        String sql = "INSERT INTO contacto (userId, name, phone, email, address, remark) VALUES(:userId, :name, :phone, :email, :address, :remark)";
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getMail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);

        c.setContacId(kh.getKey().intValue());

    }

    @Override
    public void update(Contacto c) {
        String sql = "UPDATE contacto SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactoId=:contactoId";

        Map m = new HashMap();
        m.put("contactoId", c.getContacId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getMail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Contacto c) {
        this.delete(c.getContacId());
    }

    @Override
    public void delete(Integer contactId) {
        String sql = "DELETE FROM contacto WHERE contactoId=?";
        getJdbcTemplate().update(sql, contactId);
    }

    @Override
    public Contacto findById(Integer contactId) {
        String sql = "SELECT contactoId, userId, name, phone, email, address, remark FROM contacto WHERE contactoId=?";
        return getJdbcTemplate().queryForObject(sql, new ContactoRowMapper(), contactId);

    }

    @Override
    public List<Contacto> findAll() {
        String sql = "SELECT contactoId, userId, name, phone, email, address, remark FROM contacto";
        return getJdbcTemplate().query(sql, new ContactoRowMapper());

    }

    @Override
    public List<Contacto> findByProperty(String propName, Object propValue) {
        String sql = "SELECT contactoId, userId, name, phone, email, address, remark FROM contacto WHERE "+propName+"=? ";
        return getJdbcTemplate().query(sql, new ContactoRowMapper(),propValue);

    }

}
