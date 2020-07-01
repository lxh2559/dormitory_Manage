package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import Database.DB;
import Model.ManagersModel;


public class ManagersOperation {
	public static ManagersModel re = null;
	JTextField[] textbox;
	String manager_id;

	public  void AddManager(String manager_id,JTextField[] textbox) throws SQLException {
		this.manager_id = manager_id;
		this.textbox = textbox;
		Connection conn = DB.getConnection();
		PreparedStatement prepareadd = conn.prepareStatement(
			" insert into student " + " values(?,?,?)");
		prepareadd.setString(1, manager_id);		
		prepareadd.setString(2, textbox[0].getText());
		prepareadd.setString(3, textbox[1].getText());
		prepareadd.execute();
	}
	
	public  void UpdateoneManagers(String manager_id,JTextField[] textbox) throws SQLException {
		this.manager_id = maanager_id;
		this.textbox = textbox;
		Connection conn = DB.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update manager set name = ? ,sex = ? ,tel = ?");
		prepareupdate.setString(1, textbox[0].getText());
		prepareupdate.setString(2, textbox[1].getText());
		prepareupdate.setString(3, manager_id);
		prepareupdate.execute();
	}
	
	public void Delete(String ID) throws SQLException {
		Connection conn = DB.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from manaager where ID = ? ");
		delete.setString(1, ID);
		delete.execute();
	}

	public static ManagersModel selectone(String manager_id) throws Exception {
		Connection conn = DB.getConnection();
		PreparedStatement selectmanaager = conn.prepareStatement(" select * from manager where ID =  ? ");
		selectmanager.setString(1, manager_id);
		// 返回结果集
		ResultSet rs = selectmanager.executeQuery();
		if (rs.next()) {
			re = new ManagersModel();
			re.setManager_id(rs.getString("ID"));
			re.setName(rs.getString("name"));			
			re.setSex(rs.getString("sex"));
			re.setContact(rs.getString("tel"));
		}
		else {
			re = null;
		}
		return re;

		
	}

}

