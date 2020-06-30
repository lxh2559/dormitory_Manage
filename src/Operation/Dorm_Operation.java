package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DB;
import Model.Dorm_Model;

public class Dorm_Operation {
    public static Dorm_Model dModel = null;

    public void updateDorm(Dorm_Model updateModel) throws SQLException {
        Connection conn = DB.getConnection();
        PreparedStatement prepare = conn.prepareStatement("update dorm set bed_num = ?, student_num = ? where dorm_id = ?");
        prepare.setInt(1, updateModel.getBed_num());
        prepare.setInt(2, updateModel.getStudent_num());
        prepare.setString(3, updateModel.getDorm_id());
        prepare.execute();
    }

    public Dorm_Model select(String dorm_id) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement sql = conn.prepareStatement(" select * from dorm where dorm_id = ? ");
        sql.setString(1, dorm_id);
        ResultSet rSet = sql.executeQuery();
        while(rSet.next()) {
            dModel = new Dorm_Model();
            dModel.setDorm_id(rSet.getString("dorm_id"));
            dModel.setBed_num(rSet.getInt("bed_num"));
            dModel.setStudent_num(rSet.getInt("student_num"));
        }
        return dModel;
    }
}