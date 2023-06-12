package Employee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Remove_Employee implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,icon;
    JButton b,b1,b2,b3;

    Remove_Employee(){
        f=new JFrame("Remove Employee");
        f.setBackground(Color.green);   
        f.setLayout(null);

        icon=new JLabel();
        icon.setBounds(0,0,120,70);
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
        f.add(icon);

        //l5=new JLabel();
        //l5.setBounds(0,0,500,500);
        //l5.setLayout(null);
        //ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        //l5.setIcon(img);
        //f.add(l5);

        
        l1=new JLabel("Employee ID");
        l1.setBounds(50,80,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif",Font.BOLD,25); 
        l1.setFont(f2);
        f.add(l1);

        t=new JTextField();
        t.setBounds(250,80,150,30);
        f.add(t);


        b=new JButton("Search");
        b.setBounds(220,130,100,30);
        b.addActionListener(this);
        f.add(b);

        b3=new JButton("Cancel");
        b3.setBounds(330,130,100,30);
        b3.addActionListener(this);
        f.add(b3);


        l2=new JLabel("Name:"); 
        l2.setBounds(50,180,250,30);
        l2.setForeground(Color.black);
        Font f3 = new Font("serif",Font.BOLD,20); 
        l2.setFont(f3);
        f.add(l2);

        l6=new JLabel();    
        l6.setBounds(200,180,350,30);
        l6.setForeground(Color.black);
        Font F6=new Font("serif",Font.BOLD,20); 
        l6.setFont(F6);
        f.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(50,230,250,30);
        l3.setForeground(Color.black);
        Font f4 = new Font("serif",Font.BOLD,20); 
        l3.setFont(f4);
        f.add(l3);


        l7=new JLabel();
        l7.setBounds(200,230,350,30);
        l7.setForeground(Color.black);
        Font F7=new Font("serif",Font.BOLD,20); 
        l7.setFont(F7);
        f.add(l7);



        l4=new JLabel("Email Id:");
        l4.setBounds(50,280,250,30);
        l4.setForeground(Color.black);
        Font F5=new Font("serif",Font.BOLD,20); 
        l4.setFont(F5);
        f.add(l4);

        l8=new JLabel();
        l8.setBounds(200,280,350,30);
        l8.setForeground(Color.black);
        Font f8=new Font("serif",Font.BOLD,20); 
        l8.setFont(f8);
        f.add(l8);

        b1=new JButton("Remove");
        b1.setBounds(200,330,100,30);
        b1.addActionListener(this);
        f.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,330,100,30);
        b2.addActionListener(this);
        f.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,250);
        f.setLocation(500,250);  
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            try{
                conn con = new conn();
                String str = "select name,phone,email from employee where emp_id ='"+t.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);

                int i=0;
                if(rs.next()){
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);

                    f.setSize(500,500);
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    //b2.setVisible(true);
                    i=1;
                    l6.setText(name);
                    l7.setText(mob);
                    l8.setText(email);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Id not found");
            }catch(Exception ex){
                System.out.println("The error is:"+ex);
            }
        }
        if(ae.getSource()==b1){
            try{
                conn con = new conn();
                String str = "delete from employee where emp_id = '"+t.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Deleted successfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[]ar){
        new Remove_Employee();
    }
}