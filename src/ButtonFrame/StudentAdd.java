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
    private JButton Add = new JButton("����");
    private JButton back = new JButton("����");
    
	StudentsControl studentcontrol = new StudentsControl();
	StudentsModel studentmodel = new StudentsModel();

	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "����         ", "�Ա�         ","��ϵ��ʽ",  "ѧԺ         ",
			"רҵ         ", "�༶         ", "����¥��", "����         " };

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	public StudentAdd() throws Exception{

		lab1 = new JLabel("����ѧ����Ϣ");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("����", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("ѧ��:");
		lab2.setBounds(100, 40, 150, 50);
		lab2.setFont(new Font("����", Font.BOLD, 23));
		// frame.add(lab2);

		text = new JTextField();
		text.setBounds(170, 50, 200, 30);
		text.setFont(new Font("����", Font.BOLD, 18));
		// frame.add(text);

		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("�����п�", Font.PLAIN, 18));
		}

		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("����", Font.PLAIN, 16));
			textbox[i].setEditable(true);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // �������ϵ��º��Ӳ���
		Box titleBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		studentBox.add(lab2);
		studentBox.add(Box.createHorizontalStrut(36));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(36));

		boxVertical.add(studentBox);
		boxVertical.add(Box.createVerticalStrut(60));

		Box nameBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		nameBox.add(labbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(labbox[1]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(textbox[1]);
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box dateBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		dateBox.add(labbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(labbox[3]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(textbox[3]);
		boxVertical.add(dateBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box contactBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		contactBox.add(labbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(labbox[5]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(textbox[5]);
		boxVertical.add(contactBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box collegeBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
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
		frame.setTitle("����");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		
		ActionListener backListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new S_infor_manage();
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
							JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							JOptionPane.showMessageDialog(null, "ѧ���Ѵ��ڣ�����������", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			
				if (textbox[0].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "��������Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[1].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�Ա���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[2].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "��ϵ��ʽ����Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[3].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ѧԺ����Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[4].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "רҵ����Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[5].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�༶����Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[6].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "����¥�Ų���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textbox[7].getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "���Ų���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				StudentsOperation add = new StudentsOperation();
				try {
					add.AddStudent(text.getText(), textbox);
					JOptionPane.showMessageDialog(null, "���ӳɹ�");
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