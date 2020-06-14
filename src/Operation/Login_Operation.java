package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.DB;
import Model.Login_Model;

public class Login_Operation {
    JTextField text;
    JPasswordField pw;
    public static Login_Model lg = null;

    public Login_Model select(Integer identity, String account) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement sql = conn.prepareStatement(" select * from login where identity = ? and account = ? ");
        sql.setInt(1, identity);
        sql.setString(2, account);
        ResultSet rSet = sql.executeQuery();
        if(rSet.next()) {
            lg = new Login_Model();
            lg.setIdentity(rSet.getInt("identity"));
            lg.setAccount(rSet.getString("account"));
            lg.setPassword(rSet.getString("password"));
        }
        else {
            lg = null;
        }
        return lg;
    }
}