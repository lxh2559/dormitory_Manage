package ButtonFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.StudentsControl;
import Model.StudentsModel;
import Operation.StudentsOperation;
import infor_manage.S_infor_manage;

public class StudentAdd extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton Add = new JButton("添加");
    private JButton back = new JButton("返回");
    
	StudentsControl studentcontrol = new StudentsControl();
	StudentsModel studentmodel = new StudentsModel();

	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "姓名    ", "性别","联系方式",  "学院",
			"专业    ", "班级", "宿舍楼号", "床号" };

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	Integer id = null;
    String ac = null;
	public StudentAdd(Integer identity, String account) throws Exception{
		id = identity;
        ac = account;

		lab1 = new JLabel("新增学生信息");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("宋体", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("学号:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("宋体", Font.BOLD, 23));
		// frame.add(lab2);

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("宋体", Font.BOLD, 18));
		// frame.add(text);

		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("宋体", Font.PLAIN, 18));
		}

		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("宋体", Font.PLAIN, 16));
			textbox[i].setEditable(true);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		boxVertical.add(Box.createVerticalStrut(15));
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		studentBox.add(lab2);
		studentBox.add(Box.createHorizontalStrut(36));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(36));

		boxVertical.add(studentBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box nameBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		nameBox.add(labbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(labbox[1]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[1]);
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box dateBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		dateBox.add(labbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(labbox[3]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[3]);
		boxVertical.add(dateBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box contactBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		contactBox.add(labbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(labbox[5]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[5]);
		boxVertical.add(contactBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box collegeBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		collegeBox.add(labbox[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(textbox[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(labbox[7]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(textbox[7]);
		boxVertical.add(collegeBox);
		boxVertical.add(Box.createVerticalStrut(15));

		jpbox.add(boxVertical);

		Add.setBounds(170, 325, 80, 25);
		Add.setFont(new Font("宋体", Font.BOLD, 18));
		Add.setVisible(true);
		frame.add(Add);

		back.setBounds(440, 325, 80, 25);
		back.setFont(new Font("宋体", Font.BOLD, 18));
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		frame.add(jpl);
		frame.setTitle("新增");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		
		ActionListener backListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new S_infor_manage(id, ac);
				}
		};
		back.addActionListener(backListener);
		
		Add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentsControl r = new StudentsControl();
				StudentsModel rr = null;
				if (e.getSource() == Add) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "学号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							JOptionPane.showMessageDialog(null, "学号已存在，请重新输入", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			
				if (textbox[0].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[1].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "性别不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[2].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "联系方式不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[3].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "学院不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[4].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "专业不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[5].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "班级不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[6].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "宿舍楼号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[7].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "床号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				StudentsOperation add = new StudentsOperation();
				try {
					add.AddStudent(text.getText(), textbox);
					JOptionPane.showMessageDialog(null, "添加成功");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	};
	public JTextField gettext() {
		return text;
	}
}
