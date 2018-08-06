
package in.ezeon.dao;

import in.ezeon.domain.Contacto;
import java.util.List;

/**
 *
 * @author unknown
 */
public interface ContactoDAO {

    public void save(Contacto c);

    public void update(Contacto c);

    public void delete(Contacto c);

    public void delete(Integer contactId);

    public Contacto findById(Integer contactId);

    public List<Contacto> findAll();

    public List<Contacto> findByProperty(String propName, Object propValue);

}
