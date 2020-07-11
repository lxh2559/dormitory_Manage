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

import ButtonFrame.*;
import System.Manager;

public class M_infor_manage {
	   private JFrame frame = new JFrame();
	    private JPanel jpl = new JPanel(); 
	    private JButton button1 = new JButton("查询管理员信息");
	    private JButton button2 = new JButton("新增管理员信息");
	    private JButton button3 = new JButton("删除管理员信息");
		private JButton button4 = new JButton("返回");
		Integer id = null;
		String ac = null;
	    public M_infor_manage(Integer identity, String account) {
			id = identity;
			ac = account;	

	        button1.setBounds(30, 75, 200, 50);
	        button1.setFont(new Font("宋体", Font.BOLD, 20));
	        jpl.add(button1);
	        button1.addActionListener(new SearchListener());
	        button1.setOpaque(true);
	        
	        button2.setBounds(270, 75, 200, 50);
	        button2.setFont(new Font("宋体", Font.BOLD, 20));
	        jpl.add(button2);
	        button2.addActionListener(new AddListener());

	        button3.setBounds(30, 175, 200, 50);
	        button3.setFont(new Font("宋体", Font.BOLD, 20));
	        jpl.add(button3);
	        button3.addActionListener(new DelListener());
	        
	        button4.setBounds(270, 175, 200, 50);
	        button4.setFont(new Font("宋体", Font.BOLD, 20));
	        jpl.add(button4);
	        button4.addActionListener(new BackListener());      
	        
	        ButtonGroup buttonGroup = new ButtonGroup();
	        buttonGroup.add(button1);
	        buttonGroup.add(button2);
	        buttonGroup.add(button3);
	        buttonGroup.clearSelection();

	        jpl.setLayout(null);
			JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
			label.setSize(500, 350);		
			jpl.add(label);  
	        frame.add(jpl);
	        
	        frame.setTitle("管理员信息管理");
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
	            new ManagerSearch(id, ac);
	        }
	    }

	    private class AddListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            try {
					new ManagerAdd(id, ac);
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
	            new ManagerDel(id, ac);
	        }
	    }
	    private class BackListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            new Manager(id, ac);
	        }    
	    }
}