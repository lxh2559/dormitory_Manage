package ButtonFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

public class StudentSearch extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton search = new JButton("查询");
    private JButton change = new JButton("更改");
    private JButton OK = new JButton("确定");
    private JButton back = new JButton("返回");
    
	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "姓名    ", "性别","联系方式",  "学院",
			"专业    ", "班级", "宿舍楼号", "床号" };

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	Integer id = null;
    String ac = null;
	public StudentSearch(Integer identity, String account) {
		id = identity;
        ac = account;

		lab1 = new JLabel("学生信息查询");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("宋体", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("学号:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("宋体", Font.BOLD, 23));

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("宋体", Font.BOLD, 18));

		search.setBounds(600, 45, 100, 25);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentsControl r = new StudentsControl();
				StudentsModel rr = null;
				boolean bb = false;
				if (e.getSource() == search) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "学号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getStudent_id().equals(text.getText());
						} else {
							JOptionPane.showMessageDialog(null, "学号不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (bb) {
							new StudentsOperation();
							StudentsOperation.selectone(text.getText());
							textbox[0].setText(StudentsOperation.re.getName());
							textbox[1].setText(StudentsOperation.re.getSex());
							textbox[2].setText(StudentsOperation.re.getContact());
							textbox[3].setText(StudentsOperation.re.getCollege());
							textbox[4].setText(StudentsOperation.re.getMajor());
							textbox[5].setText(StudentsOperation.re.getClasses());
							try {
								StudentsOperation.selectonedorm(text.getText());
								textbox[6].setText(StudentsOperation.re.getDorm_id());
								textbox[7].setText(StudentsOperation.re.getBed_id());						
							} catch (Exception e2) {
								// TODO: handle exception
							}


							return;
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}

			}
		});

		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("宋体", Font.PLAIN, 18));
		}

		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("宋体", Font.PLAIN, 16));
			textbox[i].setEditable(false);

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
		studentBox.add(Box.createHorizontalStrut(30));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(30));
		search.setFont(new Font("宋体", Font.BOLD, 18));
		studentBox.add(search);
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

		change.setBounds(130, 325, 80, 25);
		change.setFont(new Font("宋体", Font.BOLD, 18));
		change.setVisible(true);
		frame.add(change);

		OK.setBounds(310, 325, 80, 25);
		OK.setFont(new Font("宋体", Font.BOLD, 18));
		OK.setVisible(true);
		frame.add(OK);
		
		back.setBounds(490, 325, 80, 25);
		back.setFont(new Font("宋体", Font.BOLD, 18));
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		
		JLabel label = new JLabel(new ImageIcon("image\\background1.jpg"));
		label.setSize(700, 480);		
		jpl.add(label);  
		
		frame.add(jpl);
		frame.setTitle("查询");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		ActionListener ChangeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					textbox[i].setEditable(true);
				}
			}
		};
		change.addActionListener(ChangeListener);

		ActionListener OKListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsOperation update = new StudentsOperation();
				try {
					update.UpdateoneStudents(text.getText(), textbox);
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				for (int i = 0; i < 8; i++) {
					textbox[i].setEditable(false);
				}
			}
		};
		OK.addActionListener(OKListenter);
		
		ActionListener backListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new S_infor_manage(id, ac);
			}
		};
		back.addActionListener(backListenter);
	}

	public JTextField gettext() {
		return text;
	}
}
