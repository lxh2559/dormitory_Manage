package System;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Control.Login_Control;
import System.Manager;
import System.Student;
import infor_manage.D_infor_manage;
import Model.Login_Model;

public class Login {
    private Integer identity = 1;
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel();    
    public static JTextField text = new JTextField();
    JPasswordField pw = new JPasswordField();
    private JButton button = new JButton("登录");
    public Login() {
        JLabel lab1 = new JLabel("宿舍管理系统");
        lab1.setBounds(170, 10, 200, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        frame.add(lab1);

        JLabel lab2 = new JLabel("身份");
        lab2.setBounds(100, 60, 100, 50);
        lab2.setFont(new Font("宋体", Font.BOLD, 20));        
        jpl.add(lab2);

        JRadioButton rButton1 = new JRadioButton("学生");
        rButton1.setBounds(180, 60, 100, 50);
        rButton1.setFont(new Font("宋体", Font.BOLD, 20));
        JRadioButton rButton2 = new JRadioButton("管理员");
        rButton2.setBounds(280, 60, 100, 50);
        rButton2.setFont(new Font("宋体", Font.BOLD, 20));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rButton1);
        buttonGroup.add(rButton2);
        rButton1.setSelected(true);
        jpl.add(rButton1);
        jpl.add(rButton2);
        rButton1.setContentAreaFilled(false);
        rButton2.setContentAreaFilled(false);

        rButton1.addChangeListener(evt-> {
            if(rButton1.isSelected()) {
                identity = 1;
            }
        });
        rButton2.addChangeListener(evt-> {
            if(rButton2.isSelected()) {
                identity = 0;
            }
        });

        JLabel lab3 = new JLabel("账号");
        lab3.setBounds(60, 120, 100, 50);
        lab3.setFont(new Font("宋体", Font.BOLD, 25));
        frame.add(lab3);

        JLabel lab4 = new JLabel("密码");
        lab4.setBounds(60, 180, 100, 50);
        lab4.setFont(new Font("宋体", Font.BOLD, 25));
        frame.add(lab4);

        text.setBounds(130, 126, 250, 40);
        text.setFont(new Font("宋体", Font.BOLD, 20));
        frame.add(text);

        pw.setBounds(130, 186, 250, 40);
        pw.setFont(new Font("宋体", Font.BOLD, 20));
        frame.add(pw);

        button.setBounds(150, 250, 200, 50);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button);
        button.setContentAreaFilled(true);

        button.addActionListener(new ButtonListener());

        jpl.setLayout(null);
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(500, 350);		
		jpl.add(label);  

        frame.add(jpl);
        frame.setTitle("登录");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Login_Model lModel = null;
            Login_Control lControl = new Login_Control();
            boolean k = false;
            if(text.getText().length() == 0 || pw.getPassword().length == 0) {
                final JDialog dialog = new JDialog(frame, "提示", true);
                dialog.setSize(400, 280);
                dialog.setLocationRelativeTo(frame);

                JLabel mess1 = new JLabel("账号或密码为空");
                mess1.setBounds(100, 50, 300, 50);
                mess1.setFont(new Font("宋体", Font.BOLD, 25));

                JButton button = new JButton("确定");
                button.setBounds(115, 140, 150, 50);
                button.setFont(new Font("宋体", Font.BOLD, 20));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                JPanel jpl = new JPanel();
                jpl.add(mess1);
                jpl.add(button);
                jpl.setLayout(null);
                dialog.setContentPane(jpl);
                dialog.setVisible(true);
                return;
            }
            else {
                try{
                    lModel = lControl.get(identity, text.getText());                 
                } catch(Exception e1) {
                    return;
                }
                if(lModel == null) {
                    final JDialog dialog = new JDialog(frame, "提示", true);
                    dialog.setSize(400, 280);
                    dialog.setLocationRelativeTo(frame);

                    JLabel mess2 = new JLabel("账号不存在");
                    mess2.setBounds(127, 50, 300, 50);
                    mess2.setFont(new Font("宋体", Font.BOLD, 25));

                    JButton button = new JButton("确定");
                    button.setBounds(115, 140, 150, 50);
                    button.setFont(new Font("宋体", Font.BOLD, 20));
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.dispose();
                        }
                    });

                    JPanel jpl = new JPanel();
                    jpl.add(mess2);
                    jpl.add(button);
                    jpl.setLayout(null);
                    dialog.setContentPane(jpl);
                    dialog.setVisible(true);
                    pw.setText(null);
                    return;
                }
                else {
                    k = lModel.getPassword().equals(String.valueOf(pw.getPassword()));
                    if(!k) {
                        final JDialog dialog = new JDialog(frame, "提示", true);
                        dialog.setSize(400, 280);
                        dialog.setLocationRelativeTo(frame);
    
                        JLabel mess3 = new JLabel("密码错误");
                        mess3.setBounds(137, 50, 300, 50);
                        mess3.setFont(new Font("宋体", Font.BOLD, 25));
    
                        JButton button = new JButton("确定");
                        button.setBounds(115, 140, 150, 50);
                        button.setFont(new Font("宋体", Font.BOLD, 20));
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialog.dispose();
                            }
                        });
    
                        JPanel jpl = new JPanel();
                        jpl.add(mess3);
                        jpl.add(button);
                        jpl.setLayout(null);
                        dialog.setContentPane(jpl);
                        dialog.setVisible(true);
                        pw.setText(null);
                        return; 
                    }
                    else {
                        if(identity == 1) {
                            frame.dispose();
                            new Student(identity, text.getText());
                        }
                        else {
                            frame.dispose();
                            new Manager(identity, text.getText());
                        }
                    }
                }
            }
        }  
    }

    public static void main(String[] args) {
        new Login();
    }
}

