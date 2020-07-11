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
    private JButton search = new JButton("��ѯ");
    private JButton change = new JButton("����");
    private JButton OK = new JButton("ȷ��");
    private JButton back = new JButton("����");
    
	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "����    ", "�Ա�    ","��ϵ��ʽ" };

	public static JTextField[] textbox = new JTextField[3];
	JLabel lab1, lab2;
	JTextField text;

	Integer id = null;
	String ac = null;
	public ManagerSearch(Integer identity, String account) {
		id = identity;
		ac = account;	

		lab1 = new JLabel("����Ա��Ϣ��ѯ");
		lab1.setBounds(190, 20, 150, 30);
		lab1.setFont(new Font("����", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("����:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("����", Font.BOLD, 23));

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("����", Font.BOLD, 18));

		search.setBounds(350, 45, 80, 25);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ManagersControl r = new ManagersControl();
				ManagersModel rr = null;
				boolean bb = false;
				if (e.getSource() == search) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "���Ų���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getManager_id().equals(text.getText());
						} else {
							JOptionPane.showMessageDialog(null, "���Ų���ȷ", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
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
		 * ѭ����ǩ
		 */
		for (int i = 0; i < 3; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("����", Font.PLAIN, 18));
		}
		/**
		 * ѭ���ı���
		 */
		for (int i = 0; i < 3; i++) {
			textbox[i] = new JTextField(3);
			textbox[i].setFont(new Font("����", Font.PLAIN, 16));
			textbox[i].setEditable(false);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // �������ϵ��º��Ӳ���
		Box titleBox = Box.createHorizontalBox();// ���������Һ��Ӳ���

		boxVertical.add(Box.createVerticalStrut(15));
		titleBox.add(Box.createHorizontalStrut(50));
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(50));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(lab2);
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(10));
		studentBox.add(search);
		studentBox.add(Box.createHorizontalStrut(10));
		boxVertical.add(studentBox);
		boxVertical.add(Box.createVerticalStrut(25));

		Box nameBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		nameBox.add(Box.createHorizontalStrut(10));
		nameBox.add(labbox[0]);
		nameBox.add(Box.createHorizontalStrut(10));
		nameBox.add(textbox[0]);
		nameBox.add(Box.createHorizontalStrut(10));
		
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box sexBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		sexBox.add(Box.createHorizontalStrut(10));
		sexBox.add(labbox[1]);
		sexBox.add(Box.createHorizontalStrut(10));
		sexBox.add(textbox[1]);
		sexBox.add(Box.createHorizontalStrut(10));
		
		boxVertical.add(sexBox);
		boxVertical.add(Box.createVerticalStrut(15));
		
		
		Box telBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		telBox.add(Box.createHorizontalStrut(10));
		telBox.add(labbox[2]);
		telBox.add(Box.createHorizontalStrut(10));
		telBox.add(textbox[2]);
		telBox.add(Box.createHorizontalStrut(10));
		boxVertical.add(telBox);
		boxVertical.add(Box.createVerticalStrut(15));

		jpbox.add(boxVertical);

		change.setBounds(65, 250, 80, 25);
		change.setVisible(true);
		frame.add(change);

		OK.setBounds(210, 250, 80, 25);
		OK.setVisible(true);
		frame.add(OK);
		
		back.setBounds(355, 250, 80, 25);
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		frame.add(jpl);
		frame.setTitle("��ѯ");
		frame.setSize(500, 350);
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
					update.UpdateoneManagers(text.getText(), textbox);
					JOptionPane.showMessageDialog(null, "���ĳɹ�");
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
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
	            new M_infor_manage(id, ac);
			}
		};
		back.addActionListener(backListenter);
	}

	public JTextField gettext() {
		return text;
	}
}