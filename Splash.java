package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements  ActionListener{
    JButton clickhere;
    Splash(){ 
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        clickhere =new JButton ("Admin");
        clickhere.setBounds(310,400,180,40);
        clickhere.setForeground( Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        JButton clickhere2 =new JButton ("Employee");
        clickhere2.setBounds(560,400,180,40);
        clickhere2.setForeground( Color.BLACK);
        clickhere2.addActionListener(this);
        image.add(clickhere2);
        
        setSize(1170, 650);
        setLocation(200,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()  ==clickhere){
        setVisible(false);
        new Login();
        }else {
            setVisible(false);
            new EmployeeView();
        }
    }
    
     public static void main(String args[]) {
         new Splash();
     }
}