package ButtonFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Control.Dorm_Control;
import Control.Stay_Control;
import Model.Dorm_Model;
import Model.Stay_Model;
import infor_manage.D_infor_manage;


public class DormSearch {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel();
    Dorm_Model dModel = null;
    Dorm_Control dControl = new Dorm_Control();
    private DefaultTableModel tModel = new DefaultTableModel();
    private JTable table = new JTable();
    private JButton button1 = new JButton("修改");
    private JButton button2 = new JButton("返回");
    Integer id = null;
    String ac = null;
    public DormSearch(Integer identity, String account, String dorm_id) {
        id = identity;
        ac = account;
        try{
            dModel = dControl.get(dorm_id);                 
        } catch(Exception e1) {}

        JLabel lab1 = new JLabel("宿舍:" + dModel.getDorm_id());
        lab1.setBounds(255, 40, 250, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab1);

        JLabel lab2 = new JLabel("总床位:" + dModel.getBed_num());
        lab2.setBounds(190, 90, 150, 50);
        lab2.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab2);

        JLabel lab3 = new JLabel("总人数:" + dModel.getStudent_num());
        lab3.setBounds(385, 90, 150, 50);
        lab3.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab3);

        String[][] data = new String[dModel.getBed_num()][4];
        String[] title = {"宿舍名", "床位", "姓名", "学号"};

        for(int i = 0; i < dModel.getBed_num(); i++) {
            Stay_Model sModel = null;
            Stay_Control sControl = new Stay_Control(); 
            try{
                sModel = sControl.get(dModel.getDorm_id(), i+1);  
                if(sModel == null) {
                    data[i] = new String[] {dModel.getDorm_id(), Integer.toString(i+1)};
                    continue;  
                }       
            } catch(Exception e1) {}
            data[i] = new String[] {dModel.getDorm_id(), Integer.toString(i+1), sModel.getName(), sModel.getStudent_id()};
        }

        tModel = new DefaultTableModel(data, title);
        table = new JTable(tModel);
        table.setEnabled(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.setRowHeight(30);
        table.setFont(new Font("宋体", Font.BOLD, 20));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("宋体", Font.BOLD, 20));

        DefaultTableCellRenderer tcren  = new DefaultTableCellRenderer();
        tcren.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcren);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80, 170, 540, 151);
        frame.add(scrollPane);

        button1.setBounds(155, 350, 150, 50);
        button1.setFont(new Font("宋体", Font.BOLD, 22));
        frame.add(button1);
        button1.addActionListener(new ButtonListener1());

        button2.setBounds(375, 350, 150, 50);
        button2.setFont(new Font("宋体", Font.BOLD, 22));
        frame.add(button2);
        button2.addActionListener(new ButtonListener2());
        
        jpl.setLayout(null);
        jpl.setFocusable(true);
        frame.add(jpl);

        frame.setTitle("查询");
        frame.setSize(700, 480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DormChange(id, ac, dModel.getDorm_id());
        }
            
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new D_infor_manage(id, ac);
        }
            
    }
}