package Employee;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

class login  implements ActionListener{

    JFrame f;
    JLabel username_label,password_label, icon;
    JPanel p;
    JTextField username_tfield;
    JPasswordField password_tfield;
    JButton b1,b2;

    login(){

        f=new JFrame("Login");
        p = new JPanel();

        SpringLayout layout = new SpringLayout();
        p.setLayout(layout);
        p.setBackground(Color.white);

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

        username_label = new JLabel("Username");
        username_label.setBackground(Color.white);

        password_label = new JLabel("Password");
        password_label.setBackground(Color.white);

        username_tfield=new JTextField();
        username_tfield.setBackground(Color.white);

        password_tfield=new JPasswordField();
        password_tfield.setBackground(Color.white);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);

        p.add(username_label);
        p.add(username_tfield);
        p.add(password_label);
        p.add(password_tfield);
        p.add(b1);
        p.add(b2);

        layout.putConstraint(SpringLayout.WEST,username_label,100,SpringLayout.WEST,p);
        layout.putConstraint(SpringLayout.NORTH,username_label,25,SpringLayout.NORTH,p);

        layout.putConstraint(SpringLayout.WEST,username_tfield,25,SpringLayout.EAST,username_label);
        layout.putConstraint(SpringLayout.EAST,username_tfield,200,SpringLayout.WEST,username_tfield);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,username_tfield,0,SpringLayout.VERTICAL_CENTER,username_label);

        layout.putConstraint(SpringLayout.WEST,password_label,100,SpringLayout.WEST,p);
        layout.putConstraint(SpringLayout.NORTH,password_label,25,SpringLayout.NORTH,username_label);

        layout.putConstraint(SpringLayout.WEST,password_tfield,28,SpringLayout.EAST,password_label);
        layout.putConstraint(SpringLayout.EAST,password_tfield,200,SpringLayout.WEST,password_tfield);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,password_tfield,0,SpringLayout.VERTICAL_CENTER,password_label);

        layout.putConstraint(SpringLayout.WEST,b1,100,SpringLayout.WEST,p);
        layout.putConstraint(SpringLayout.NORTH,b1,20,SpringLayout.SOUTH,password_label);

        layout.putConstraint(SpringLayout.WEST,b2,50,SpringLayout.EAST,b1);
        layout.putConstraint(SpringLayout.NORTH,b2,20,SpringLayout.SOUTH,password_label);


        f.add(p);
        f.setVisible(true);
        f.setSize(450,200);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String username = username_tfield.getText();
                String password = String.valueOf(password_tfield.getPassword()); //getPassword returns character array, so it needs to be converted to String
                String q = "select * from login where username='"+username+"' and password='"+password+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new details().f.setVisible(true);
                    f.setVisible(false);
                }else{
                    System.out.println(rs);
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(true);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Thank you!");
            f.setVisible(false);
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }
}