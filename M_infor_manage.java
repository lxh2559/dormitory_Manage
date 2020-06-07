import javax.swing.JFrame;

public class M_infor_manage {
    private JFrame frame = new JFrame();
    public M_infor_manage() {
        frame.setTitle("管理员信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}