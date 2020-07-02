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

import Control.ManagersControl;
import Model.MangersModel;
import Operation.ManagersOperation;
import infor_manage.M_infor_manage;

public class ManagerAdd extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton Add = new JButton("添加");
    private JButton back = new JButton("返回");
    
	ManagersControl managercontrol = new ManagersControl();
	ManagersModel managermodel = new ManagersModel();

	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "姓名         ", "性别         ","联系方式"};

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	public ManagerAdd() throws Exception{

		lab1 = new JLabel("新增管理员信息");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("宋体", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("工号:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("宋体", Font.BOLD, 23));
		// frame.add(lab2);

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("宋体", Font.BOLD, 18));
		// frame.add(text);

		for (int i = 0; i < 3; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("华文行楷", Font.PLAIN, 18));
		}

		for (int i = 0; i < 3; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("隶书", Font.PLAIN, 16));
			textbox[i].setEditable(true);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		managerBox.add(lab2);
		maanagerBox.add(Box.createHorizontalStrut(36));
		managerBox.add(text);
		managerBox.add(Box.createHorizontalStrut(36));

		boxVertical.add(studentBox);
		boxVertical.add(Box.createVerticalStrut(60));

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
		boxVertical.add(Box.createVerticalStrut(15));

		jpbox.add(boxVertical);

		Add.setBounds(170, 375, 80, 25);
		Add.setVisible(true);
		frame.add(Add);

		back.setBounds(440, 375, 80, 25);
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
	            new M_infor_manage();
				}
		};
		back.addActionListener(backListener);
		
		Add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagersControl r = new ManagersControl();
				MaanagersModel rr = null;
				if (e.getSource() == Add) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "工号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							JOptionPane.showMessageDialog(null, "工号已存在，请重新输入", "系统提示", JOptionPane.ERROR_MESSAGE);
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
				ManagersOperation add = new StudentsOperation();
				try {
					add.AddManager(text.getText(), textbox);
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
