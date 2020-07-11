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

public class ManagerDel extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton ok = new JButton("确定");
    private JButton change = new JButton("再次确定");
    private JButton back = new JButton("返回");
	boolean aa = false ;
	
	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "姓名    ", "性别    ","联系方式"};

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	Integer id = null;
	String ac = null;
	public ManagerDel(Integer identity, String account) {
		id = identity;
		ac = account;	

		lab1 = new JLabel("管理员信息删除");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("宋体", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("工号:");
		lab2.setBounds(100, 40, 100, 50);
		lab2.setFont(new Font("宋体", Font.BOLD, 23));

		text = new JTextField();
		text.setBounds(170, 50, 150, 30);
		text.setFont(new Font("宋体", Font.BOLD, 18));

		ok.setBounds(550, 47, 80, 25);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagersControl r = new ManagersControl();
				ManagersModel rr = null;
				boolean bb = false;
				if (e.getSource() == ok) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "工号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getManager_id().equals(text.getText());
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
							aa = true;
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
		for (int i = 0; i < 3; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("宋体", Font.PLAIN, 18));
		}
		/**
		 * 循环文本框
		 */
		for (int i = 0; i < 3; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("宋体", Font.PLAIN, 16));
			textbox[i].setEditable(false);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局

		boxVertical.add(Box.createVerticalStrut(15));
		titleBox.add(Box.createHorizontalStrut(50));
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(50));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(lab2);
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(ok);
		studentBox.add(Box.createHorizontalStrut(10));
		boxVertical.add(studentBox);
		boxVertical.add(Box.createVerticalStrut(25));

		Box nameBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		nameBox.add(Box.createHorizontalStrut(10));
		nameBox.add(labbox[0]);
		nameBox.add(Box.createHorizontalStrut(10));
		nameBox.add(textbox[0]);
		nameBox.add(Box.createHorizontalStrut(10));
		
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box sexBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		sexBox.add(Box.createHorizontalStrut(10));
		sexBox.add(labbox[1]);
		sexBox.add(Box.createHorizontalStrut(10));
		sexBox.add(textbox[1]);
		sexBox.add(Box.createHorizontalStrut(10));
		
		boxVertical.add(sexBox);
		boxVertical.add(Box.createVerticalStrut(15));
		
		
		Box telBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		telBox.add(Box.createHorizontalStrut(10));
		telBox.add(labbox[2]);
		telBox.add(Box.createHorizontalStrut(10));
		telBox.add(textbox[2]);
		telBox.add(Box.createHorizontalStrut(10));
		boxVertical.add(telBox);
		boxVertical.add(Box.createVerticalStrut(15));

		jpbox.add(boxVertical);

		change.setBounds(100, 250, 100, 25);
		change.setVisible(true);
		frame.add(change);

		back.setBounds(300, 250, 100, 25);
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		frame.add(jpl);
		frame.setTitle("删除管理员信息");
		frame.setSize(500, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		ActionListener ChangeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagersOperation delete = new ManagersOperation();

				try {
					delete.Delete(text.getText());
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					aa = false;
				}
				if(aa) {
					JOptionPane.showMessageDialog(null, "删除成功");
				}else {
					JOptionPane.showMessageDialog(null, "请输入正确工号", "系统提示", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		change.addActionListener(ChangeListener);

		ActionListener backListenter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new M_infor_manage(id, ac);
			}
		};
		back.addActionListener(backListenter);
	}

	public JTextField gettext() {
		return text;
	}
}