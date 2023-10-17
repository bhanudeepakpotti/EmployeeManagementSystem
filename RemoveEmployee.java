package employee.management.system;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid =new JLabel("Employee Id");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);
        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        try{
            Conn c =new Conn();
            String query="select * from employee";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname =new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname =new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelnumber =new JLabel("Number");
        labelnumber.setBounds(50,150,100,30);
        add(labelnumber);
        
        JLabel lblnumber =new JLabel();
        lblnumber.setBounds(200,150,100,30);
        add(lblnumber);
        
        JLabel labelemail =new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail =new JLabel();
        lblemail.setBounds(200,200,300,30);
        add(lblemail);
        
        try{
            Conn c =new Conn();
            String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblnumber.setText(rs.getString("number"));
                lblemail.setText(rs.getString("email"));
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c =new Conn();
            String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblnumber.setText(rs.getString("number"));
                lblemail.setText(rs.getString("email"));
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
                
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.addActionListener(this);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == delete){
            try{
                Conn c =new Conn();
                String query="delete from employee where empId='"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String []args){
        new RemoveEmployee();
    }
    
}