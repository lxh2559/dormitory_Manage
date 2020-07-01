package System;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Operation.StudentsOperation;
import System.Login;

public class Student {
    private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton back = new JButton("返回");
    
	public static JTextField[] textbox = new JTextField[8];
	JLabel[] labbox = new JLabel[8];
	String labstr[] = { "姓名    ", "性别","联系方式",  "学院",
			"专业    ", "班级", "宿舍楼号", "床号" };
	
    public Student(String text) {
    	
		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("宋体", Font.PLAIN, 20));
		}
		/**
		 * 循环文本框
		 */
		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(8);
			textbox[i].setFont(new Font("宋体", Font.PLAIN, 16));
			textbox[i].setEditable(false);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		boxVertical.add(Box.createVerticalStrut(100));
		
		Box nameBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		nameBox.add(labbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(labbox[1]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[1]);
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(20));

		Box dateBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		dateBox.add(labbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(labbox[3]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[3]);
		boxVertical.add(dateBox);
		boxVertical.add(Box.createVerticalStrut(20));

		Box contactBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		contactBox.add(labbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(labbox[5]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[5]);
		boxVertical.add(contactBox);
		boxVertical.add(Box.createVerticalStrut(20));

		Box collegeBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		collegeBox.add(labbox[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(textbox[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(labbox[7]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(textbox[7]);
		boxVertical.add(collegeBox);
		boxVertical.add(Box.createVerticalStrut(20));

		jpbox.add(boxVertical);

		
		back.setBounds(300, 325, 100, 40);
		back.setFont(new Font("宋体", Font.BOLD, 18));
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		
		JLabel label = new JLabel(new ImageIcon("image\\background1.jpg"));
		label.setSize(500, 350);		
		jpl.add(label);  
		frame.add(jpl);
		frame.setTitle(text+"的学生信息");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);
    	
		new StudentsOperation();
		try {
			StudentsOperation.selectone(text);
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		textbox[0].setText(StudentsOperation.re.getName());
		textbox[1].setText(StudentsOperation.re.getSex());
		textbox[2].setText(StudentsOperation.re.getContact());
		textbox[3].setText(StudentsOperation.re.getCollege());
		textbox[4].setText(StudentsOperation.re.getMajor());
		textbox[5].setText(StudentsOperation.re.getClasses());
		textbox[6].setText(StudentsOperation.re.getDorm_id());
		textbox[7].setText(StudentsOperation.re.getBed_id() + "");

		
		
		ActionListener backListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new Login();
			}
		};
		back.addActionListener(backListenter);
        
    }
}
