import javax.swing.JFrame;

public class S_infor_manage {
    private JFrame frame = new JFrame();
    public S_infor_manage() {
        frame.setTitle("学生信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}