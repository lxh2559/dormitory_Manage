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
import Model.ManagersModel;
import Operation.ManagersOperation;
import infor_manage.M_infor_manage;

public class ManagerSearch extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton search = new JButton("查询");
    private JButton change = new JButton("更改");
    private JButton OK = new JButton("确定");
    private JButton back = new JButton("返回");
    
	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "姓名         ", "性别         ","联系方式" };

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	public ManagerSearch() {

		lab1 = new JLabel("管理员信息查询");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("宋体", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("工号:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("宋体", Font.BOLD, 23));

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("宋体", Font.BOLD, 18));

		search.setBounds(600, 45, 80, 25);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ManagersControl r = new ManagersControl();
				ManagersModel rr = null;
				boolean bb = false;
				if (e.getSource() == search) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "工号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getStudent_id().equals(text.getText());
						} else {
							JOptionPane.showMessageDialog(null, "工号不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (bb) {
							new ManagersOperation();
							ManagersOperation.selectone(text.getText());
							textbox[0].setText(ManagersOperation.re.getName());
							textbox[1].setText(ManagersOperation.re.getSex());
							textbox[2].setText(ManagersOperation.re.getContact());
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

		/**
		 * 循环标签
		 */
		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("华文行楷", Font.PLAIN, 18));
		}
		/**
		 * 循环文本框
		 */
		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("隶书", Font.PLAIN, 16));
			textbox[i].setEditable(false);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		managerBox.add(lab2);
		managerBox.add(Box.createHorizontalStrut(30));
		managerBox.add(text);
		managerBox.add(Box.createHorizontalStrut(100));
		// managerBox.add(search);
		frame.add(search);
		boxVertical.add(ManagerBox);
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
		dateBox.add(labbox[3]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[3]);
		boxVertical.add(dateBox);
		boxVertical.add(Box.createVerticalStrut(15));

		jpbox.add(boxVertical);

		change.setBounds(130, 375, 80, 25);
		change.setVisible(true);
		frame.add(change);

		OK.setBounds(310, 375, 80, 25);
		OK.setVisible(true);
		frame.add(OK);
		
		back.setBounds(490, 375, 80, 25);
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		frame.add(jpl);
		frame.setTitle("查询");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		ActionListener ChangeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 3; i++) {
					textbox[i].setEditable(true);
				}
			}
		};
		change.addActionListener(ChangeListener);

		ActionListener OKListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagersOperation update = new ManagersOperation();
				try {
//					System.out.println(text.getText() + "传出去查询文本框中的工号");
//					System.out.println(textbox[1] + "gonghaogonghaogonghaogonghaogonghao");
					update.UpdateoneManagers(text.getText(), textbox);
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				for (int i = 0; i < 3; i++) {
					textbox[i].setEditable(false);
				}
			}
		};
		OK.addActionListener(OKListenter);
		
		ActionListener backListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new S_infor_manage();
			}
		};
		back.addActionListener(backListenter);
	}

	public JTextField gettext() {
		return text;
	}
}
