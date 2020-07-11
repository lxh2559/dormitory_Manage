package infor_manage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import System.Manager;
import ButtonFrame.*;

public class S_infor_manage {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("查询学生信息");
    private JButton button2 = new JButton("新增学生信息");
    private JButton button3 = new JButton("删除学生信息");
    private JButton button4 = new JButton("返回");
    Integer id = null;
    String ac = null;
    public S_infor_manage(Integer identity, String account) {
        id = identity;
        ac = account;

        button1.setBounds(50, 75, 175, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button1);
        button1.addActionListener(new SearchListener());
        button1.setOpaque(true);
        
        button2.setBounds(275, 75, 175, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button2);
        button2.addActionListener(new AddListener());

        button3.setBounds(50, 175, 175, 50);
        button3.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button3);
        button3.addActionListener(new DelListener());
        
        button4.setBounds(275, 175, 175, 50);
        button4.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(button4);
        button4.addActionListener(new BackListener());      
        
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
        
        frame.setTitle("学生信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new StudentSearch(id, ac);
        }
    }

    private class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            try {
				new StudentAdd(id, ac);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
        }
    }

    private class DelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new StudentDel(id, ac);
        }
    }
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Manager(id ,ac);
        }    
    }
}