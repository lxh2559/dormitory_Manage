package System;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ButtonFrame.LoginChange;
import ButtonFrame.Search;
import Control.Login_Control;
import Model.Login_Model;

public class Student {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("查询信息");
    private JButton button2 = new JButton("修改密码");
    private JButton button3 = new JButton("注销账号");

    Login_Model lModel = null;
    Login_Control lControl = new Login_Control();
    public Student(Integer identity, String account) {
        try{
            lModel = lControl.get(identity, account);                 
        } catch(Exception e1) {}

        button1.setBounds(150, 50, 200, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(150, 130, 200, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button2);
        button2.addActionListener(new ButtonListener2());

        button3.setBounds(150, 210, 200, 50);
        button3.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button3);
        button3.addActionListener(new ButtonListener3());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.clearSelection();

        jpl.setLayout(null);
        jpl.setFocusable(true);
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(500, 350);		
		jpl.add(label);  
		
        frame.add(jpl);
        frame.setTitle("学生");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    
	}
	
    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new Search(lModel.getIdentity(), lModel.getAccount());
        }    
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new LoginChange(lModel.getIdentity(), lModel.getAccount());
        }      
    }

    private class ButtonListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Login();
        }    
	}
		
}