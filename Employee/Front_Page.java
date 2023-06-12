package Employee;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
import javax.swing.border.Border;

class Front_Page implements ActionListener{
    JFrame f; //declaration
    JLabel logo_label, title_label, background;
    JPanel p;
    JButton b;

    Front_Page(){
 
        f=new JFrame("Employee Management System");
        p = new JPanel();

        SpringLayout layout = new SpringLayout();
        p.setLayout(layout);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        logo_label = new JLabel(i2);

        b = new JButton("→");
        b.setFont(new Font("Tahoma",Font.BOLD,25));
        b.setBackground(Color.white);
        Border br = BorderFactory.createRaisedBevelBorder();
        b.setBorder(br);
        b.addActionListener(this);

        title_label = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title_label.setFont(new Font("calibri",Font.PLAIN,30));
        title_label.setForeground(Color.BLACK);

        //p.add(background);
        p.add(logo_label);
        p.add(title_label);
        p.add(b);
        p.setBackground(Color.white);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,logo_label,0,SpringLayout.HORIZONTAL_CENTER,p);
        layout.putConstraint(SpringLayout.NORTH,logo_label,10,SpringLayout.NORTH,p);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,title_label,0,SpringLayout.HORIZONTAL_CENTER,p);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,title_label,100,SpringLayout.VERTICAL_CENTER,p);

        layout.putConstraint(SpringLayout.NORTH,b,50,SpringLayout.NORTH,title_label);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b,0,SpringLayout.HORIZONTAL_CENTER,p);


        f.add(p);
        f.setVisible(true);
        f.setSize ( 600,600  );

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b)
        {
            f.setVisible(false);
            new login();    
        }
    }

    public static void main(String[] arg){
        Front_Page f = new Front_Page();
    }
}