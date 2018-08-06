package in.ezeon.service;

import in.ezeon.domain.Contacto;
import java.util.List;

/**
 * The interface specifies all business operation for Contacto Entity.
 *
 * @author unknown
 */
public interface ContactoService {

    public void save(Contacto c);

    public void update(Contacto c);

    public void delete(Integer contactoId);

    public void delete(Integer[] contactoIds);

    public Contacto findById(Integer contactId);

    /**
     * This method returns all User Contactos (use who is logged in).
     *
     * @param userId
     * @return
     */
    public List<Contacto> finUserContacto(Integer userId);

    /**
     * The method search contacto for user (userId) based on given
     * free-text-criteria (txt).
     *
     * @param userId User who is is logged in
     * @param txt criteria used to search - free text search criteria.
     * @return
     */
    public List<Contacto> findUserContacti(Integer userId, String txt);

}
