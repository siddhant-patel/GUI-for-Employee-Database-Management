package Employee;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class View_All extends JFrame implements ActionListener {

    JFrame frame;
    JPanel p;
    JButton b;
    DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);
    public View_All() {
        frame = new JFrame();
        frame.setTitle("View All");
        frame.setSize(830, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        p = new JPanel();
        p.setLayout(layout);


        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("Age");
        model.addColumn("DOB");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Education");
        model.addColumn("Post");
        model.addColumn("Aadhar");
        model.addColumn("Emp_ID");

        try {
            PreparedStatement pstm = conn.c.prepareStatement("select * from employee;");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("name"), Rs.getString("fname"),Rs.getString("age"),Rs.getString("dob"),Rs.getString("address"),Rs.getString("phone"),Rs.getString("email"),Rs.getString("education"),Rs.getString("post"),Rs.getString("aadhar"),Rs.getString("emp_id")});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        jtbl.setPreferredScrollableViewportSize(new Dimension(825, 200));
        jtbl.setFillsViewportHeight(true);
        jtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pg = new JScrollPane(jtbl);
        p.add(pg);

        b=new JButton("Cancel");
        b.setBounds(0,0,30,30);
        b.addActionListener(this);
        p.add(b);

        layout.putConstraint(SpringLayout.NORTH,b,50,SpringLayout.SOUTH,pg);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b,0,SpringLayout.HORIZONTAL_CENTER,pg);


        frame.add(p);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b){
            frame.setVisible(false);
            details d=new details();
        }
    }
    public static void main(String[] args) { View_All v = new View_All(); }
}


