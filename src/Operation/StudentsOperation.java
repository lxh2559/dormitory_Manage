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
import Model.StudentsModel;


public class StudentsOperation {
	public static StudentsModel re = null;
	JTextField[] textbox;
	String student_id;

	public  void AddStudent(String student_id,JTextField[] textbox) throws SQLException {
		this.student_id = student_id;
		this.textbox = textbox;
		Connection conn = DB.getConnection();
		PreparedStatement prepareadd = conn.prepareStatement(
			" insert into student " + " values(?,?,?,?,?,?,?,?,?)");
		prepareadd.setString(1, student_id);		
		prepareadd.setString(2, textbox[0].getText());
		prepareadd.setString(3, textbox[1].getText());
		prepareadd.setString(4, textbox[2].getText());
		prepareadd.setString(5, textbox[3].getText());
		prepareadd.setString(6, textbox[4].getText());
		prepareadd.setString(7, textbox[5].getText());
		prepareadd.setString(8, textbox[6].getText());
		prepareadd.setString(9, textbox[7].getText());

		prepareadd.execute();
	}
	
	public  void UpdateoneStudents(String student_id,JTextField[] textbox) throws SQLException {
		this.student_id = student_id;
		this.textbox = textbox;
		Connection conn = DB.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update student set name = ? ,sex = ? ,tel = ? ,  college = ? , major = ? ,class = ? ,d_ID = ? , b_ID = ?  where ID = ? ");
		prepareupdate.setString(1, textbox[0].getText());
		prepareupdate.setString(2, textbox[1].getText());
		prepareupdate.setString(3, textbox[2].getText());
		prepareupdate.setString(4, textbox[3].getText());
		prepareupdate.setString(5, textbox[4].getText());
		prepareupdate.setString(6, textbox[5].getText());
		prepareupdate.setString(7, textbox[6].getText());
		prepareupdate.setString(8, textbox[7].getText());
		prepareupdate.setString(9, student_id);
		prepareupdate.execute();
	}
	
	public void Delete(String ID) throws SQLException {
		Connection conn = DB.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from student where ID = ? ");
		delete.setString(1, ID);
		delete.execute();
	}

	public static StudentsModel selectone(String student_id) throws Exception {
		Connection conn = DB.getConnection();
		PreparedStatement selectstudent = conn.prepareStatement(" select * from student where ID =  ? ");
		selectstudent.setString(1, student_id);
		// 返回结果集
		ResultSet rs = selectstudent.executeQuery();
		if (rs.next()) {
			re = new StudentsModel();
			re.setStudent_id(rs.getString("ID"));
			re.setName(rs.getString("name"));			
			re.setSex(rs.getString("sex"));
			re.setContact(rs.getString("tel"));
			re.setCollege(rs.getString("college"));
			re.setMajor(rs.getString("major"));
			re.setClasses(rs.getString("class"));
			re.setDorm_id(rs.getString("d_id"));
			re.setBed_id(rs.getString("b_id"));
		}
		else {
			re = null;
		}
		return re;

		
	}

}

