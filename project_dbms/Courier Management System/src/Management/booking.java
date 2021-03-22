package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class booking extends JFrame implements ActionListener {
	
	JFrame f;
	JLabel l,l1,lt1,l2,lt2,l3,lt3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2;
	String name,address,contact;
	
	booking(int eid)
	{
		try {
			conn con=new conn();
			String str="select * from staff where empid= " + eid;
			ResultSet rs=con.s.executeQuery(str);
			
			while(rs.next())
			{
				name=rs.getString("name");
				address=rs.getString("branchaddress");
				contact=rs.getString("contact");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		f=new JFrame("Booking");
        f.setBackground(Color.white);
        f.setLayout(null);

		
		l=new JLabel("Booking Details");
		l.setBounds(200,10,250,30);
		l.setFont(new Font("serif",Font.BOLD,25));
		f.add(l);
		
		l1=new JLabel("Name");
		l1.setBounds(50,70,200,30);
		l1.setFont(new Font("serif",Font.BOLD,25));
		f.add(l1);
		
		lt1=new JLabel(name);
		lt1.setBounds(270, 70, 120, 30);
		lt1.setFont(new Font("serif",Font.BOLD,25));
		f.add(lt1);
		
		l2=new JLabel("Branch Address");
		l2.setBounds(50,120,200,30);
		l2.setFont(new Font("serif",Font.BOLD,25));
		f.add(l2);
		
		lt2=new JLabel(address);
		lt2.setBounds(270, 120, 150, 30);
		lt2.setFont(new Font("serif",Font.BOLD,25));
		f.add(lt2);
		
		l3=new JLabel("Contact No");
		l3.setBounds(50,170,200,30);
		l3.setFont(new Font("serif",Font.BOLD,25));
		f.add(l3);
		
		lt3=new JLabel(contact);
		lt3.setBounds(270, 170, 120, 30);
		lt3.setFont(new Font("serif",Font.BOLD,25));
		f.add(lt3);
		
		l4=new JLabel("Courier Weight");
		l4.setBounds(50,220,200,30);
		l4.setFont(new Font("serif",Font.BOLD,25));
		f.add(l4);
		
		t1=new JTextField();
		t1.setBounds(270, 220, 150, 30);
		f.add(t1);
		
		l5=new JLabel("Courier Type");
		l5.setBounds(50,270,200,30);
		l5.setFont(new Font("serif",Font.BOLD,25));
		f.add(l5);
		
		t2=new JTextField();
		t2.setBounds(270, 270, 150, 30);
		f.add(t2);
		
		
		l6=new JLabel("Courier Number");
		l6.setBounds(50,320,200,30);
		l6.setFont(new Font("serif",Font.BOLD,25));
		f.add(l6);
		
		t3=new JTextField();
		t3.setBounds(270, 320, 150, 30);
		f.add(t3);
		
		b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,400,100,50);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,400,100,50);
        b2.addActionListener(this);
		f.add(b2);
		
		f.setVisible(true);
        f.setSize(595,642);
        f.getContentPane().setBackground(Color.YELLOW);
        f.setLocation(450,200);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		
		int d=Integer.parseInt(c);
		if(ae.getSource() == b1)
		{
			try {
			conn c1=new conn();
			String q="insert into booking(name, branchaddress, contact, courierweight, couriertype, couriernumber) values('" + name + "', '" + address + "','" + contact + "','" + a +"','" + b + "','" + d + "')";
			c1.s.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
			this.setVisible(false);
			new options();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		if(ae.getSource() == b2)
		{
			this.setVisible(false);
			new options();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		booking b=new booking(10);
		
	}

}
