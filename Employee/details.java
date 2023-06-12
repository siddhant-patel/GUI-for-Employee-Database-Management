package Employee;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class details  implements ActionListener{

    JFrame f;
    JPanel p;
    JLabel background,emp,icon;
    JButton b1,b2,b3,b4,b5, b6,b7,b8, b9;

    details(){
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        SpringLayout layout = new SpringLayout();
        p = new JPanel();
        p.setLayout(layout);

        //background = new JLabel();
        //background.setBounds(0,0,700,500);
        //background.setLayout(null);
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        //background.setIcon(i1);
        //f.add(background);
        icon=new JLabel();
        icon.setBounds(0,0,90,65);
        icon.setLayout(null);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("icons/logo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
        //ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        ImageIcon imageIcon = new ImageIcon(dimg);
        icon.setIcon(imageIcon);
        p.add(icon);

        emp = new JLabel("Employee Details");
        emp.setBounds(430,20,200,40);
        emp.setFont(new Font("serif",Font.BOLD,25));
        emp.setForeground(Color.black);
        //background.add(emp);
        p.add(emp);

        b1=new JButton("Add");
        //b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        //background.add(b1);
        p.add(b1);


        b2=new JButton("View");
        //b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        //background.add(b2);
        p.add(b2);

        b3=new JButton("Remove");
        //b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        //background.add(b3);
        p.add(b3);

        b4=new JButton("Update");
        //b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        //background.add(b4);
        p.add(b4);

        b5 = new JButton("Export to CSV file");
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        //background.add(b5);
        p.add(b5);

        b6 = new JButton("View All");
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        //background.add(b5);
        p.add(b6);

        b7 = new JButton("Export To PDF");
        b7.setFont(new Font("serif",Font.BOLD,15));
        b7.addActionListener(this);
        //background.add(b5);
        p.add(b7);

        b8 = new JButton("Upload to Drive");
        b8.setFont(new Font("serif",Font.BOLD,15));
        b8.addActionListener(this);
        //background.add(b5);
        p.add(b8);

        b9 = new JButton("Create New User");
        b9.setFont(new Font("serif",Font.BOLD,15));
        b9.addActionListener(this);
        //background.add(b5);
        p.add(b9);


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,emp,0,SpringLayout.HORIZONTAL_CENTER,p);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,emp,-150,SpringLayout.VERTICAL_CENTER,p);

        layout.putConstraint(SpringLayout.WEST,b1,75,SpringLayout.WEST,p);
        layout.putConstraint(SpringLayout.NORTH,b1,75,SpringLayout.NORTH,p);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b3,0,SpringLayout.HORIZONTAL_CENTER,b1);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b3,45,SpringLayout.VERTICAL_CENTER,b1);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b4,0,SpringLayout.HORIZONTAL_CENTER,b3);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b4,45,SpringLayout.VERTICAL_CENTER,b3);

        layout.putConstraint(SpringLayout.EAST,b2,-75,SpringLayout.EAST,p);
        layout.putConstraint(SpringLayout.NORTH,b2,75,SpringLayout.NORTH,p);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b6,0,SpringLayout.HORIZONTAL_CENTER,b2);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b6,45,SpringLayout.VERTICAL_CENTER,b2);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b5,0,SpringLayout.HORIZONTAL_CENTER,b6);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b5,45,SpringLayout.VERTICAL_CENTER,b6);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b7,0,SpringLayout.HORIZONTAL_CENTER,b5);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b7,90,SpringLayout.VERTICAL_CENTER,b6);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b8,0,SpringLayout.HORIZONTAL_CENTER,b4);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b8,45,SpringLayout.VERTICAL_CENTER,b4);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b9,0,SpringLayout.HORIZONTAL_CENTER,p);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,b9,90,SpringLayout.VERTICAL_CENTER,p);


        f.add(p);
        f.setVisible(true);
        f.setSize(400,400);
        f.setLocation(450,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee();
        }
        else if(ae.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
        else if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee();
        }
        else if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_Employee();
        }
        else if(ae.getSource()==b5){
            f.setVisible(true);
            new ExportToCSV();
        }
        else if(ae.getSource()==b6) {
            f.setVisible(false);
            new View_All();
        }
        else if(ae.getSource()==b7){
            f.setVisible(true);
            new ExportToPDF();
        }
        else if(ae.getSource()==b8){
            f.setVisible(true);
            new UploadToDrive();
        }
    }

    public static void main(String[ ] arg){
        details d = new details();
    }
}
