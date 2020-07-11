package Control;

import Model.Login_Model;
import Operation.Login_Operation;

public class Login_Control {
    public void update(Login_Model lModel) throws Exception {
        Login_Operation login_Operation = new Login_Operation();
        login_Operation.updateLogin(lModel);
    }

    public Login_Model get(Integer identity, String account) throws Exception {
        Login_Operation login_Operation = new Login_Operation();
        return login_Operation.select(identity, account);
    }
}
