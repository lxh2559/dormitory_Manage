package ButtonFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.Login_Control;
import Model.Login_Model;
import System.Manager;
import System.Student;

public class LoginChange {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("确认");
    private JButton button2 = new JButton("取消");
    JPasswordField pw1 = new JPasswordField();
    JPasswordField pw2 = new JPasswordField();
    Login_Model lModel = null;
    Login_Control lControl = new Login_Control();
    public LoginChange(Integer identity, String account) {
        try{
            lModel = lControl.get(identity, account);                 
        } catch(Exception e1) {}

        JLabel lab1 = new JLabel("输入新密码:");
        lab1.setBounds(60, 50, 200, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab1);

        pw1.setBounds(203, 56, 220, 40);
        pw1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(pw1);

        JLabel lab2 = new JLabel("确认新密码:");
        lab2.setBounds(60, 120, 200, 50);
        lab2.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab2);

        pw2.setBounds(203, 126, 220, 40);
        pw2.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(pw2);

        button1.setBounds(80, 210, 150, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(270, 210, 150, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(button2);
        button2.addActionListener(new ButtonListener2());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.clearSelection();

        jpl.setLayout(null);
        jpl.setFocusable(true);	 
		
        frame.add(jpl);
        frame.setTitle("修改密码");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(pw1.getPassword().length == 0) {
                final JDialog dialog = new JDialog(frame, "提示", true);
                dialog.setSize(400, 280);
                dialog.setLocationRelativeTo(frame);

                JLabel mess1 = new JLabel("输入新密码为空");
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
                String s1 = new String(pw1.getPassword());
                String s2 = new String(pw2.getPassword());
                if(s1.equals(s2) == false) {
                    final JDialog dialog = new JDialog(frame, "提示", true);
                    dialog.setSize(400, 280);
                    dialog.setLocationRelativeTo(frame);

                    JLabel mess1 = new JLabel("输入密码前后不一致");
                    mess1.setBounds(73, 50, 300, 50);
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
                    lModel.setPassword(s1);
                    try {
                        lControl.update(lModel);
                    } catch (Exception e2) {}
                    final JDialog dialog = new JDialog(frame, "提示", true);
                    dialog.setSize(400, 280);
                    dialog.setLocationRelativeTo(frame);

                    JLabel mess1 = new JLabel("修改成功");
                    mess1.setBounds(137, 50, 300, 50);
                    mess1.setFont(new Font("宋体", Font.BOLD, 25));

                    JButton button = new JButton("确定");
                    button.setBounds(115, 140, 150, 50);
                    button.setFont(new Font("宋体", Font.BOLD, 20));
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.dispose();
                            frame.dispose();
                            if(lModel.getIdentity() == 0)
                                new Manager(lModel.getIdentity(), lModel.getAccount());
                            else
                                new Student(lModel.getIdentity(), lModel.getAccount());
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
            }
        }    
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Manager(lModel.getIdentity(), lModel.getAccount());
        }      
    }
    
}