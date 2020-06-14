package infor_manage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import M_and_S.Manager;

public class D_infor_manage {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("查询宿舍信息");
    private JButton button2 = new JButton("新增宿舍信息");
    private JButton button3 = new JButton("更改宿舍信息");
    private JButton button4 = new JButton("删除宿舍信息");
    private JButton button5 = new JButton("返回");
    public D_infor_manage() {
        frame.setTitle("宿舍信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.setBounds(50, 50, 175, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(275, 50, 175, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button2);
        button2.addActionListener(new ButtonListener2());

        button3.setBounds(50, 150, 175, 50);
        button3.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button3);
        button3.addActionListener(new ButtonListener3());
        
        button4.setBounds(275, 150, 175, 50);
        button4.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button4);
        button4.addActionListener(new ButtonListener4());
        
        button5.setBounds(162, 250, 175, 50);
        button5.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button5);
        button5.addActionListener(new ButtonListener5());
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.clearSelection();

        jpl.setLayout(null);
        frame.add(jpl);

        

    }
    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new search();
        }
            
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new add();
        }
            
    }

    private class ButtonListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new change();
        }
            
    }
    private class ButtonListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new del();
        }
            
    }
    private class ButtonListener5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Manager();
        }
            
    }
    class search {}
    class add {}
    class change{}
    class del{}
}