package in.ezeon.controller;

import in.ezeon.domain.Contacto;
import in.ezeon.service.ContactoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author unknown
 */
@Controller
public class ContactController {

    @Autowired
    private ContactoService contactoService;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m) {
        Contacto contact = new Contacto();
        m.addAttribute("command", contact);
        return "contact_form"; //JSP form view
    }

    /**
     * Este metodo fue cambiado de nombre desde saveContact a
     * saveOrUpdateContact
     *
     * @param c
     * @param m
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contacto c, Model m, HttpSession session) {
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if (contactId == null) {
            //Save task.
            try {
                Integer userId = (Integer) session.getAttribute("userId");
                c.setContacId(userId);
                c.setUserId(userId); //FK ; logged in userId
                contactoService.save(c);
                return "redirect:clist?act=sv"; //redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            //Update task.
            try {

                c.setContacId(contactId); //PK
                contactoService.update(c);
                return "redirect:clist?act=ed"; //redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            }

        }
    }

    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        m.addAttribute("contactList", contactoService.finUserContacto(userId));

        return "clist"; //JSP 
    }

    @RequestMapping(value = "/user/del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        contactoService.delete(contactId);
        return "redirect:clist?act=del";
    }

    @RequestMapping(value = "/user/edit_contact")
    public String preparedEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contacto c = contactoService.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form"; //JSP form view
    }

    @RequestMapping(value = "/user/contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactoService.findUserContacti(userId, freeText));
        return "clist"; //JSP
    }

    @RequestMapping(value = "/user/bulk_cdelete")
    public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
        contactoService.delete(contactIds);
        return "redirect:clist?act=del";
    }

}
