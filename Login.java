import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Login {
    private Boolean identity = true;
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel();    
    public static JTextField text = new JTextField();
    JPasswordField pw = new JPasswordField();
    private JButton button = new JButton("登录");
    public Login() {
        JLabel lab1 = new JLabel("宿舍管理系统");
        lab1.setBounds(170, 0, 200, 50);
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

        rButton1.addChangeListener(evt-> {
            if(rButton1.isSelected()) {
                identity = true;
            }
        });
        rButton2.addChangeListener(evt-> {
            if(rButton2.isSelected()) {
                identity = false;
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

        button.addActionListener(new ButtonListener());

        jpl.setLayout(null);

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
            if(identity) {
                frame.dispose();
                new Student();
            }
            else {
                frame.dispose();
                new Manager();
            }

        }
        
    }

    public static void main(String[] args) {
        new Login();
    }
}