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

public class StudentDel extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpbox = new JPanel();
    private JButton ok = new JButton("ȷ��");
    private JButton change = new JButton("�ٴ�ȷ��");
    private JButton back = new JButton("����");
	boolean aa = false ;
	
	JLabel[] labbox = new JLabel[13];
	String labstr[] = { "����         ", "�Ա�         ","��ϵ��ʽ",  "ѧԺ         ",
			"רҵ         ", "�༶         ", "����¥��", "����         " };

	public static JTextField[] textbox = new JTextField[13];
	JLabel lab1, lab2;
	JTextField text;

	public StudentDel() {

		lab1 = new JLabel("ѧ����Ϣɾ��");
		lab1.setBounds(255, 0, 150, 30);
		lab1.setFont(new Font("����", Font.BOLD, 23));
		frame.add(lab1);

		lab2 = new JLabel("ѧ��:");
		lab2.setBounds(100, 40, 100, 50);
		lab2.setFont(new Font("����", Font.BOLD, 23));

		text = new JTextField();
		text.setBounds(170, 50, 150, 30);
		text.setFont(new Font("����", Font.BOLD, 18));

		ok.setBounds(550, 47, 80, 25);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentsControl r = new StudentsControl();
				StudentsModel rr = null;
				boolean bb = false;
				if (e.getSource() == ok) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getStudent_id().equals(text.getText());
						} else {
							JOptionPane.showMessageDialog(null, "ѧ�Ų���ȷ", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
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
							textbox[6].setText(StudentsOperation.re.getDorm_id());
							textbox[7].setText(StudentsOperation.re.getBed_id() + "");
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
		 * ѭ����ǩ
		 */
		for (int i = 0; i < 8; i++) {
			labbox[i] = new JLabel(labstr[i]);
			labbox[i].setFont(new Font("�����п�", Font.PLAIN, 18));
		}
		/**
		 * ѭ���ı���
		 */
		for (int i = 0; i < 8; i++) {
			textbox[i] = new JTextField(15);
			textbox[i].setFont(new Font("����", Font.PLAIN, 16));
			textbox[i].setEditable(false);

		}

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // �������ϵ��º��Ӳ���
		Box titleBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box studentBox = Box.createHorizontalBox();// ���������Һ��Ӳ���
		studentBox.add(lab2);
		studentBox.add(Box.createHorizontalStrut(30));
		studentBox.add(text);
		studentBox.add(Box.createHorizontalStrut(100));
		frame.add(ok);
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

		change.setBounds(150, 375, 100, 25);
		change.setVisible(true);
		frame.add(change);

		back.setBounds(450, 375, 100, 25);
		back.setVisible(true);
		frame.add(back);

		jpl.setLayout(null);
		jpbox.setVisible(true);
		jpl.add(jpbox);
		frame.add(jpl);
		frame.setTitle("ɾ��ѧ����Ϣ");
		frame.setSize(700, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jpbox);
		frame.setVisible(true);

		ActionListener ChangeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsOperation delete = new StudentsOperation();

				try {
					delete.Delete(text.getText());
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
					aa = false;
				}
				if(aa) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}else {
					JOptionPane.showMessageDialog(null, "��������ȷѧ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		change.addActionListener(ChangeListener);

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
