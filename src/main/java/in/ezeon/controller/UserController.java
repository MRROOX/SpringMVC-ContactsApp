package in.ezeon.controller;

import in.ezeon.command.LoginCommand;
import in.ezeon.command.UserCommand;
import in.ezeon.domain.User;
import in.ezeon.service.UserService;
import in.ezeon.service.exception.UserBlockedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author unknown
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Metodo para utilizar con Ajax
    @RequestMapping(value = "/admin/change_status")
    @ResponseBody//Resuelve automaticamente y retorna en forma de json y lo inyecta intantaneamente en la vista JSP
    public String changeLoginStatus(HttpSession session, @RequestParam Integer userId, @RequestParam Integer loginStatus) {
     User u=new User();
     u=(User) session.getAttribute("user");
     
        System.out.println("Usuario de session : "+u.getName());
        if (session==null) {
            System.out.println("Session NULL :O");
        }
        
        if (session!=null) {
            try {
                userService.cancheLoginStatus(userId, loginStatus);
                return "SUCCESS: Status Changed";
            } catch (Exception e) {
                e.printStackTrace();
                return "ERROR: Unable to Change Status";
            }

        } else {
            return "Session Inactiva o Null ";
        }
    }

    //Metodo para utilizar con Ajax
    @RequestMapping(value = "/check_avail")
    @ResponseBody //Resuelve automaticamente y retorna en forma de json y lo inyecta intantaneamente en la vista JSP
    public String checkAvailability(@RequestParam String username) {
        if (userService.isUsernameExist(username)) {
            return "This username is already taken. Choose another name";
        } else {
            return "Yes! you can take this";
        }
    }

    /**
     *
     * @param m
     * @return String whit the JSP page.
     */
    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }

    /**
     * Method to redirect an User to logout.
     *
     * @param session HttpSession from User to logout.
     * @return String whit the JSP page.
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:index?act=lo";
    }

    /**
     * Method to redirect to dashboard_user.
     *
     * @return
     */
    @RequestMapping(value = {"/user/dashboard"})
    public String userDashboard() {
        return "dashboard_user"; //JSP
    }

    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m) {

        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);

        return "reg_form"; //JSP
    }

    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(user);
            return "redirect:index?act=reg"; //Login page
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
            m.addAttribute("err", "Username is already registered. Please select another username.");
            return "reg_form"; //JSP
        }
    }

    /**
     * Method to redirect to dashboard_admin
     *
     * @return
     */
    @RequestMapping(value = {"/admin/dashboard"})
    public String adminDashboard() {
        return "dashboard_admin"; //JSP
    }

    @RequestMapping(value = {"/admin/users"})
    public String getUserList(Model m) {
        m.addAttribute("usersList", userService.getUserList());
        return "users"; //JSP
    }

    /**
     * Method to Add User object to new Session instance.
     *
     * @param u
     * @param session
     */
    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());

    }

    /**
     * handle Login (manejar iniciar session), es un driver (conductor para
     * iniciar session).
     *
     * @param cmd LoginCommand, object whit the Login name and Password from the
     * user.
     * @param m Modelo object to send atributes to the jsp page.
     * @param session HttpSession for start a session from one User.
     * @return String of the jsp page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());

            if (loggedInUser == null) {
                //FAILED
                //Add error menssage and go back to login-form
                m.addAttribute("err", "Login Fail! Enter valid credentials.");
                return "index"; //JSP - Login FORM
            } else {
                //SUCCESS
                //Check the role and redirect to appropiate dashboard
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {

                    //add user detail in session (assign session to logged in user)
                    addUserInSession(loggedInUser, session);

                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    //add user detail in session (assign session to logged in user)
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";

                } else {
                    //Add error menssage and go back to login-form
                    m.addAttribute("err", "Invalid User ROLE");
                    return "index"; //JSP - Login FORM
                }
            }

        } catch (UserBlockedException ex) {
            //Add error menssage and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index"; //JSP - Login FORM
        }
    }

}
