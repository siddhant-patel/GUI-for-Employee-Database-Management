package Employee;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

class Update_Employee extends Add_Employee implements ActionListener{

    JFrame f;
    JLabel name,fname,address,phone,email,education,job,title,aadhar,empid,bg,age2,dob2, icon;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1;
    String id_emp;

    Update_Employee(String id){
        super(0);
        f=new JFrame("Update Employee Details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        icon=new JLabel();
        icon.setBounds(0,0,150,80);
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

        id_emp=id;
        bg=new JLabel();
        bg.setBounds(0,0,900,500);
        bg.setLayout(null);
        //ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        //name5.setIcon(img);

        title = new JLabel("Update Employee Details");
        title.setBounds(250,10,500,50);
        title.setFont(new Font("serif",Font.BOLD,30));
        title.setForeground(Color.black);
        bg.add(title);
        f.add(bg);


        name = new JLabel("Name:");  
        name.setBounds(50,100,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        bg.add(name);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        bg.add(t1);

        fname = new JLabel("Father's Name:");
        fname.setBounds(400,100,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        bg.add(fname);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        bg.add(t2);

        address= new JLabel("Address:");
        address.setBounds(50,150,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        bg.add(address);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        bg.add(t3);

        phone= new JLabel("Mobile No:");
        phone.setBounds(400,150,100,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        bg.add(phone);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        bg.add(t4);

        email= new JLabel("Email Id:");
        email.setBounds(50,200,100,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        bg.add(email);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        bg.add(t5);

        education= new JLabel("Education:");
        education.setBounds(400,200,100,30);
        education.setFont(new Font("serif",Font.BOLD,20));    
        bg.add(education);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        bg.add(t6);

        job= new JLabel("Job Post:");
        job.setBounds(50,250,100,30);
        job.setFont(new Font("serif",Font.BOLD,20));
        bg.add(job);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        bg.add(t7);

        aadhar= new JLabel("Aadhar No:");
        aadhar.setBounds(400,250,100,30);  
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        bg.add(aadhar);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        bg.add(t8);

        empid= new JLabel("Employee Id:");
        empid.setBounds(50,300,150,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        bg.add(empid);
        //f.setVisible(false);

        t9=new JTextField();
        t9.setBounds(200,300,150,30);
        bg.add(t9);

        age2= new JLabel("Age");
        age2.setBounds(50,350,100,30);
        age2.setFont(new Font("serif",Font.BOLD,20));
        bg.add(age2);

        t10=new JTextField();
        t10.setBounds(200,350,150,30);
        bg.add(t10);

        dob2= new JLabel("D.O.B");
        dob2.setBounds(400,300,100,30);
        dob2.setFont(new Font("serif",Font.BOLD,20));
        bg.add(dob2);

        t11=new JTextField();
        t11.setBounds(600,300,150,30);
        bg.add(t11);
        f.setVisible(false);

        b=new JButton("Update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        bg.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        bg.add(b1);

        showData(id);
    }

    int i=0;
    String age,dat;

    void showData(String s){
        try{
            //conn con = new conn();
            //String str = "select * from employee where emp_id = '"+s+"'";
            ResultSet rs = conn.s.executeQuery("select * from employee where emp_id = '"+s+"'");

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                t6.setText(rs.getString(8));
                t7.setText(rs.getString(9));
                t8.setText(rs.getString(10));
                t9.setText(rs.getString(11));
                t10.setText(rs.getString(3));
                t11.setText(rs.getString(4));
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"ID not found");
            new Search_Employee();
        }catch(Exception ex){
            System.out.println("The error is " + ex);
        }
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                //conn con = new conn();
                String str = "update employee set name='"+t1.getText()+"',fname='"+t2.getText()+"',age='"+t10.getText()+"',dob='"+t11.getText()+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+"',post='"+t7.getText()+"',aadhar='"+t8.getText()+"',emp_id='"+t9.getText()+"' where emp_id='"+id_emp+"'";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully updated");
                f.setVisible(false);
                new Search_Employee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update_Employee("Update Employee");
    }
}