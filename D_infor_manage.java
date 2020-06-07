import javax.swing.JFrame;

public class D_infor_manage {
    private JFrame frame = new JFrame();
    public D_infor_manage() {
        frame.setTitle("宿舍信息管理");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}