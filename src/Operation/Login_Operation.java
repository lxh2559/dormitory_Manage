package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DB;
import Model.Login_Model;

public class Login_Operation {
    public static Login_Model lModel = null;

    public void updateLogin(Login_Model updateModel) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement prepare = conn.prepareStatement("update login set password = ? where identity = ? and account = ?");
        prepare.setString(1, updateModel.getPassword());
        prepare.setInt(2, updateModel.getIdentity());
        prepare.setString(3, updateModel.getAccount());
        prepare.execute();
    }

    public Login_Model select(Integer identity, String account) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement sql = conn.prepareStatement("select * from login where identity = ? and account = ? ");
        sql.setInt(1, identity);
        sql.setString(2, account);
        ResultSet rSet = sql.executeQuery();
        if(rSet.next()) {
            lModel = new Login_Model();
            lModel.setIdentity(rSet.getInt("identity"));
            lModel.setAccount(rSet.getString("account"));
            lModel.setPassword(rSet.getString("password"));
        }
        else {
            lModel = null;
        }
        return lModel;
    }
}