package Control;

import Model.Login_Model;
import Operation.Login_Operation;

public class Login_Control {
    public Login_Model get(Integer identity, String account) throws Exception {
        Login_Operation login_Operation = new Login_Operation();
        return login_Operation.select(identity, account);
    }
}