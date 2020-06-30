package Button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Control.Dorm_Control;
import Control.Stay_Control;
import Model.Dorm_Model;
import Model.Stay_Model;
import infor_manage.D_infor_manage;

public class DormChange {
    private JFrame frame = new JFrame();
    private JPanel jpl = new JPanel();
    Dorm_Model dModel = null;
    Dorm_Control dControl = new Dorm_Control();
    private JTextField text1 = new JTextField();
    private JTextField text2 = new JTextField();
    private DefaultTableModel tModel = new DefaultTableModel();
    private JTable table = new JTable();
    private JButton button1 = new JButton("保存");
    private JButton button2 = new JButton("返回");
    private String[][] data = {};
    
    public DormChange(String dorm_id) {
        try{
            dModel = dControl.get(dorm_id);                 
        } catch(Exception e1) {}

        JLabel lab1 = new JLabel("宿舍:" + dModel.getDorm_id());
        lab1.setBounds(255, 40, 250, 50);
        lab1.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab1);

        JLabel lab2 = new JLabel("总床位:");
        lab2.setBounds(190, 90, 150, 50);
        lab2.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab2);

        text1.setText(Integer.toString(dModel.getBed_num()));
        text1.setBounds(280, 100, 50, 30);
        text1.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(text1);

        JLabel lab3 = new JLabel("总人数:");
        lab3.setBounds(385, 90, 150, 50);
        lab3.setFont(new Font("宋体", Font.BOLD, 25));
        jpl.add(lab3);

        text2.setText(Integer.toString(dModel.getStudent_num()));
        text2.setBounds(475, 100, 50, 30);
        text2.setFont(new Font("宋体", Font.BOLD, 20));
        jpl.add(text2);

        data = new String[dModel.getBed_num()][4];
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

        tModel = new DefaultTableModel(data, title) {
            public boolean isCellEditable(int row, int column) {
                if(column == 0 || column == 1)
                    return false;
                else    
                    return true;
            }
        };
        table = new JTable(tModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.setRowHeight(30);
        table.setFont(new Font("宋体", Font.BOLD, 20));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("宋体", Font.BOLD, 20));

        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 20));
        textField.setBorder(null);

        DefaultCellEditor CellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellEditor(CellEditor);
        }

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

        frame.setTitle("修改");
        frame.setSize(700, 480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } 
    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dModel.setBed_num(Integer.parseInt(text1.getText()));
            dModel.setStudent_num(Integer.parseInt(text2.getText()));
            try {
                dControl.update(dModel);
                
            } catch (Exception e1) {}
            
            System.out.println(table.getValueAt(0, 2));
            frame.dispose();
            new DormChange(dModel.getDorm_id());
        }
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new D_infor_manage();
        }
            
    }
}