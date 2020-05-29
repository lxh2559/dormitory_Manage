import javax.swing.JFrame;

public class Manager {
    private JFrame frame = new JFrame();
    public Manager() {
        frame.setTitle("管理员");
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}