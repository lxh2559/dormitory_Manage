package M_and_S;

import javax.swing.JFrame;

public class Student {
    private JFrame frame = new JFrame();
    public Student() {
        frame.setTitle("学生");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}