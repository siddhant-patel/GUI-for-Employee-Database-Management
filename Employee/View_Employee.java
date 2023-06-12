package Employee;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class View_Employee implements ActionListener{

    JFrame f;
    JTextField t;
    JLabel l1,l2, icon;
    JButton b,b2;

    View_Employee(){
        f=new JFrame("View");
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



        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,80,250,30);
        l2.setForeground(Color.BLACK);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1);
        f.add(l2);


        t=new JTextField();
        t.setBounds(240,80,220,30);
        f.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        f.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        f.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            Print_Data p=new Print_Data(t.getText());
        }

    }

    public static void main(String[]ar){
        View_Employee v=new View_Employee();
    }
}