package in.ezeon.service;

import in.ezeon.dao.BaseDAO;
import in.ezeon.dao.ContactoDAO;
import in.ezeon.domain.Contacto;
import in.ezeon.rm.ContactoRowMapper;
import in.ezeon.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author unknown
 */
@Service
public class ContactoServiceImpl extends BaseDAO implements ContactoService {

    @Autowired
    private ContactoDAO contactoDAO;

    @Override
    public void save(Contacto c) {
        contactoDAO.save(c);

    }

    @Override
    public void update(Contacto c) {

        contactoDAO.update(c);

    }

    @Override
    public void delete(Integer contactoId) {
        contactoDAO.delete(contactoId);
    }

    @Override
    public void delete(Integer[] contactoIds) {
        String ids = StringUtil.toCommaSeparatedString(contactoIds);
        String sql = "DELETE FROM contacto WHERE contactoId IN (" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contacto> finUserContacto(Integer userId) {
        return contactoDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contacto> findUserContacti(Integer userId, String txt) {
        String sql = "SELECT contactoId, userId, name, phone, email, address, remark FROM contacto WHERE userId=? AND (name LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt + "%' OR remark LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new ContactoRowMapper(), userId);
    }

    @Override
    public Contacto findById(Integer contactId) {
        return contactoDAO.findById(contactId);
    }

}
