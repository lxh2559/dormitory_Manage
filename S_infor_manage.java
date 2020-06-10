import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class S_infor_manage {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel(); 
    private JButton button1 = new JButton("查询学生信息");
    private JButton button2 = new JButton("新增学生信息");
    private JButton button3 = new JButton("更改学生信息");
    private JButton button4 = new JButton("删除学生信息");
    private JButton button5 = new JButton("返回");
    public S_infor_manage() {
        frame.setTitle("学生信息管理");
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
    class search{
    	private JFrame frame = new JFrame();
        public JTextField ID = new JTextField();
        private JPanel jpl1 = new JPanel();    
        private JButton button1 = new JButton("确定");
        private JButton button2 = new JButton("返回");
    	public search() {
        frame.setTitle("查询学生信息");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel lab1 = new JLabel("请输入学生学号：");
        lab1.setBounds(25, 20, 225, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl1.add(lab1);
        
        ID.setBounds(250, 26, 225, 40);
        ID.setFont(new Font("宋体", Font.BOLD, 20));
        jpl1.add(ID);
        
        button1.setBounds(100, 75, 100, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl1.add(button1);
        
        button2.setBounds(300, 75, 100, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl1.add(button2);
        button2.addActionListener(new ButtonListener12());
        
        jpl1.setLayout(null);
        frame.add(jpl1);
    	}
    	
        private class ButtonListener12 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new S_infor_manage();
            }
                
        }
    }
    
    class add{
    	private JFrame frame = new JFrame();
        private JPanel jpl2 = new JPanel();    
        private JButton button1 = new JButton("确定");
        private JButton button2 = new JButton("返回");
    	public add() {
        frame.setTitle("新增学生信息");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        button1.setBounds(100, 250, 100, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl2.add(button1);
        
        button2.setBounds(300, 250, 100, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl2.add(button2);
        button2.addActionListener(new ButtonListener22());
        
        jpl2.setLayout(null);
        frame.add(jpl2);
    	}
    	
        private class ButtonListener22 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new S_infor_manage();
            }
                
        }
    }
    
    class change{
    	private JFrame frame = new JFrame();
        private JPanel jpl3 = new JPanel();    
        private JButton button1 = new JButton("确定");
        private JButton button2 = new JButton("返回");
    	public change() {
        frame.setTitle("更改学生信息");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        button1.setBounds(100, 250, 100, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl3.add(button1);
        
        button2.setBounds(300, 250, 100, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl3.add(button2);
        button2.addActionListener(new ButtonListener32());
        
        jpl3.setLayout(null);
        frame.add(jpl3);
    	}
    	
        private class ButtonListener32 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new S_infor_manage();
            }
                
        }
    }
    
    class del{
    	private JFrame frame = new JFrame();
        public JTextField ID = new JTextField();
        private JPanel jpl4 = new JPanel();    
        private JButton button1 = new JButton("确定");
        private JButton button2 = new JButton("返回");
    	public del() {
        frame.setTitle("删除学生信息");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel lab1 = new JLabel("请输入学生学号：");
        lab1.setBounds(25, 20, 225, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl4.add(lab1);
        
        ID.setBounds(225, 26, 240, 40);
        ID.setFont(new Font("宋体", Font.BOLD, 20));
        jpl4.add(ID);
        
        button1.setBounds(100, 75, 100, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl4.add(button1);
        
        button2.setBounds(300, 75, 100, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl4.add(button2);
        button2.addActionListener(new ButtonListener42());
        
        jpl4.setLayout(null);
        frame.add(jpl4);
    	}
    	
        private class ButtonListener42 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new S_infor_manage();
            }
                
        }
    }
}
