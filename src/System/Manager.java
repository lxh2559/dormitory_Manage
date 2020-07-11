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
import Control.Login_Control;
import Model.Login_Model;
import infor_manage.*;

public class Manager {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("管理员信息管理");
    private JButton button2 = new JButton("学生信息管理");
    private JButton button3 = new JButton("宿舍信息管理");
    private JButton button4 = new JButton("修改密码");
    private JButton button5 = new JButton("注销账号");
    Login_Model lModel = null;
    Login_Control lControl = new Login_Control();
    public Manager(Integer identity, String account) {
        try{
            lModel = lControl.get(identity, account);                 
        } catch(Exception e1) {}

        button4.setBounds(80, 20, 150, 50);
        button4.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button4);
        button4.addActionListener(new ButtonListener4());
        
        button5.setBounds(270, 20, 150, 50);
        button5.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button5);
        button5.addActionListener(new ButtonListener5());

        button1.setBounds(150, 90, 200, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(150, 165, 200, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button2);
        button2.addActionListener(new ButtonListener2());

        button3.setBounds(150, 240, 200, 50);
        button3.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button3);
        button3.addActionListener(new ButtonListener3());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.add(button4);
        buttonGroup.add(button5);
        buttonGroup.clearSelection();

        jpl.setLayout(null);
        jpl.setFocusable(true);
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(500, 350);		
		jpl.add(label);  
		
        frame.add(jpl);
        frame.setTitle("管理员");
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
            new M_infor_manage(lModel.getIdentity(), lModel.getAccount());
        }    
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new S_infor_manage(lModel.getIdentity(), lModel.getAccount());
        }      
    }

    private class ButtonListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new D_infor_manage(lModel.getIdentity(), lModel.getAccount());
        }    
    }

    private class ButtonListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new LoginChange(lModel.getIdentity(), lModel.getAccount());
        }       
    }

    private class ButtonListener5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Login();
        }    
    }

}