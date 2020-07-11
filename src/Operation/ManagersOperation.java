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
			" insert into manager " + " values(?,?,?,?)");
		prepareadd.setString(1, manager_id);		
		prepareadd.setString(2, textbox[0].getText());
		prepareadd.setString(3, textbox[1].getText());
		prepareadd.setString(4, textbox[2].getText());
		prepareadd.execute();
	}
	
	public  void UpdateoneManagers(String manager_id,JTextField[] textbox) throws SQLException {
		this.manager_id = manager_id;
		this.textbox = textbox;
		Connection conn = DB.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update manager set name = ? ,sex = ? ,tel = ? where manager_id = ? ");
		prepareupdate.setString(1, textbox[0].getText());
		prepareupdate.setString(2, textbox[1].getText());
		prepareupdate.setString(3, textbox[2].getText());
		prepareupdate.setString(4, manager_id);
		prepareupdate.execute();
	}
	
	public void Delete(String ID) throws SQLException {
		Connection conn = DB.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from manager where manager_id = ? ");
		delete.setString(1, ID);
		delete.execute();
	}

	public static ManagersModel selectone(String manager_id) throws Exception {
		Connection conn = DB.getConnection();
		PreparedStatement selectmanager = conn.prepareStatement(" select * from manager where manager_id =  ? ");
		selectmanager.setString(1, manager_id);
		ResultSet rs = selectmanager.executeQuery();
		if (rs.next()) {
			re = new ManagersModel();
			re.setManager_id(rs.getString("manager_id"));
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