package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
   
    JTextField tfusername ,tfpassword;
    JButton exit;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(150,250,100,30);
        add(lblusername);
        
        tfusername =new JTextField();
        tfusername.setBounds(250,250,150,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("PASSWORD");
        lblpassword.setBounds(150,300,100,30);
        add(lblpassword);
        
        tfpassword =new JTextField();
        tfpassword.setBounds(250,300,150,30);
        add(tfpassword);
        
        JButton login =new JButton ("LOGIN");
        login.setBounds(210,360,150,30);
        login.setBackground( Color.BLACK);
        login.setForeground( Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        exit =new JButton ("BACK");
        exit.setBounds(210,420,150,30);
        exit.setBackground( Color.RED);
        exit.setForeground( Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        JLabel lblwelcome = new JLabel("WELOCME!");
        lblwelcome.setBounds(220,110,170,120);
        lblwelcome.setFont(new java.awt.Font("Segoe UI", 1, 22)); 
        add(lblwelcome);
        
        JLabel lblaccount = new JLabel("Login To Your Account");
        lblaccount.setBounds(180,150,250,120);
        lblaccount.setFont(new java.awt.Font("Segoe UI", 1, 20)); 
        add(lblaccount);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);
        
        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()  ==exit){
            setVisible(false);
            new Splash();
        
            }
         else {
        try{
            String username = tfusername.getText();
            
            String password = tfpassword.getText();
            Conn c =new Conn();
            String query ="select * from login where username = '"+username+"' and password = '"+password+"'";       
            
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
               
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
            
    }
    }
    public static void main(String []args){
        new Login();
    }
}
 