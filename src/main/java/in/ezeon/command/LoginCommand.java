
package in.ezeon.command;

/**
 *
 * @author unknown
 */
public class LoginCommand {

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    String loginName;
    String password;
    
}
