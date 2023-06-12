package Employee;//import required classes and packages


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.ResultSet;

//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class createuser extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field  
    JButton b1;
    JFrame f;
    JPanel p;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;

    //calling constructor  
    createuser()
    {
        f=new JFrame("Create User");
        //create label for username   
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1  

        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  

        //create label for password  
        passLabel = new JLabel();
        passLabel.setText("Password");      //set label value for textField2

        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  

        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  

        //create panel to put form elements  
        SpringLayout layout = new SpringLayout();
        p = new JPanel();
        p.setLayout(layout);
        p.add(userLabel);    //set username label to panel
        p.add(textField1);   //set text field to panel
        p.add(passLabel);    //set password label to panel
        p.add(textField2);   //set text field to panel
        p.add(b1);           //set button to panel

        //set border to panel   
        layout.putConstraint(SpringLayout.NORTH,userLabel,20,SpringLayout.NORTH,p);
        layout.putConstraint(SpringLayout.WEST,userLabel,20,SpringLayout.WEST,p);

        layout.putConstraint(SpringLayout.NORTH,passLabel,40,SpringLayout.NORTH,userLabel);
        layout.putConstraint(SpringLayout.WEST,passLabel,20,SpringLayout.WEST,p);

        layout.putConstraint(SpringLayout.WEST,textField1,25,SpringLayout.EAST,userLabel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,textField1,0,SpringLayout.VERTICAL_CENTER,userLabel);

        layout.putConstraint(SpringLayout.WEST,textField2,25,SpringLayout.EAST,passLabel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,textField2,0,SpringLayout.VERTICAL_CENTER,passLabel);

        layout.putConstraint(SpringLayout.NORTH,b1,30,SpringLayout.NORTH,passLabel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,b1,-30,SpringLayout.HORIZONTAL_CENTER,p);

        f.add(p);
        f.setSize ( 450,200  );
        f.setVisible(true);
        f.setLocation(400,300);
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button
    }

    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {
        String a = textField1.getText();
        String bb = textField2.getText();
        if(ae.getSource()==b1)
        {
            try{
                conn c1 = new conn();
                String q = "insert into mysql.login values('"+a+"','"+bb+"')";
                conn.s.executeQuery(q);
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"User Successfully Created");
                    new details().f.setVisible(true);
                    f.setVisible(false);
                }
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
    }
    public static void main(String[] arg){
        createuser c = new createuser();
    }
}
