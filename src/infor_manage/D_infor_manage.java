package infor_manage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Button.DormChange;
import Button.DormSearch;
import Control.Dorm_Control;
import M_and_S.Manager;
import Model.Dorm_Model;

public class D_infor_manage {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    public static JTextField text = new JTextField();
    private JButton button1 = new JButton("查询宿舍信息");
    private JButton button2 = new JButton("更改宿舍信息");
    private JButton button3 = new JButton("返回");
    public D_infor_manage() {
        JLabel lab1 = new JLabel("输入宿舍号");
        lab1.setBounds(80, 30, 150, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab1);

        text.setBounds(220, 36, 200, 40);
        text.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(text);

        button1.setBounds(162, 100, 175, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 22));
        jpl.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(162, 170, 175, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 22));
        jpl.add(button2);
        button2.addActionListener(new ButtonListener2());
       
        button3.setBounds(162, 240, 175, 50);
        button3.setFont(new Font("宋体", Font.BOLD, 22));
        jpl.add(button3);
        button3.addActionListener(new ButtonListener3());
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.clearSelection();

        jpl.setLayout(null);
        frame.add(jpl);

        frame.setTitle("宿舍信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dorm_Model dModel = null;
            Dorm_Control dControl = new Dorm_Control();
            if(text.getText().length() == 0) {
                final JDialog dialog = new JDialog(frame, "提示", true);
                dialog.setSize(400, 280);
                dialog.setLocationRelativeTo(frame);

                JLabel mess1 = new JLabel("宿舍号为空");
                mess1.setBounds(127, 50, 300, 50);
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
                    dModel = dControl.get(text.getText());                 
                } catch(Exception e1) {
                    return;
                }
                if(dModel == null) {
                    final JDialog dialog = new JDialog(frame, "提示", true);
                    dialog.setSize(400, 280);
                    dialog.setLocationRelativeTo(frame);

                    JLabel mess2 = new JLabel("宿舍不存在");
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
                    return;
                }
                else {
                    frame.dispose();
                    new DormSearch(text.getText());
                }
            } 
        }        
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dorm_Model dModel = null;
            Dorm_Control dControl = new Dorm_Control();
            if(text.getText().length() == 0) {
                final JDialog dialog = new JDialog(frame, "提示", true);
                dialog.setSize(400, 280);
                dialog.setLocationRelativeTo(frame);

                JLabel mess1 = new JLabel("宿舍号为空");
                mess1.setBounds(127, 50, 300, 50);
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
                    dModel = dControl.get(text.getText());                 
                } catch(Exception e1) {
                    return;
                }
                if(dModel == null) {
                    final JDialog dialog = new JDialog(frame, "提示", true);
                    dialog.setSize(400, 280);
                    dialog.setLocationRelativeTo(frame);

                    JLabel mess2 = new JLabel("宿舍不存在");
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
                    return;
                }
                else {
                    frame.dispose();
                    new DormChange(text.getText());
                }
            } 
        }      
    }

    private class ButtonListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Manager();
        }
            
    }
}