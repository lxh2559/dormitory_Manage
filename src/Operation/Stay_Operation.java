package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DB;
import Model.Stay_Model;

public class Stay_Operation {
    public static Stay_Model sModel = null;

    public void updateStay(Stay_Model updateModel) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement prepare = conn.prepareStatement("update stay set student_id = ?, name = ? where dorm_id = ? and bed_id = ?");
        prepare.setString(1, updateModel.getStudent_id());
        prepare.setString(2, updateModel.getName());
        prepare.setString(3, updateModel.getDorm_id());
        prepare.setInt(4, updateModel.getBed_id());
        prepare.execute();
    }

    public void deleteStay(Stay_Model deleteModel) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement prepare = conn.prepareStatement("delete from stay where dorm_id = ? and bed_id = ?");
        prepare.setString(1, deleteModel.getDorm_id());
        prepare.setInt(2, deleteModel.getBed_id());
        prepare.execute();
    }

    public void addStay(Stay_Model addModel) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement prepare = conn.prepareStatement("insert into stay " + "values (?, ?, ?, ?)");
        prepare.setString(1, addModel.getStudent_id());
        prepare.setString(2, addModel.getName());
        prepare.setString(3, addModel.getDorm_id());
        prepare.setInt(4, addModel.getBed_id());
        prepare.execute();
    }
 
    public Stay_Model select(String dorm_id, Integer bed_id) throws Exception {
        Connection conn = DB.getConnection();
        PreparedStatement sql = conn.prepareStatement(" select * from stay where dorm_id = ? and bed_id = ? ");
        sql.setString(1, dorm_id);
        sql.setInt(2, bed_id);
        ResultSet rSet = sql.executeQuery();
        if(rSet.next()) {
            sModel = new Stay_Model();
            sModel.setStudent_id(rSet.getString("student_id"));
            sModel.setName(rSet.getString("name"));
            sModel.setDorm_id(rSet.getString("dorm_id"));
            sModel.setBed_id(rSet.getInt("bed_id"));
        }
        else {
            sModel = null;
        }
        return sModel;
    }

}