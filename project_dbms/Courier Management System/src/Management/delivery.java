package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class delivery extends JFrame implements ActionListener{
	
	JFrame f;
	JLabel l,l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton b1,b2;
	
	delivery()
	{

		f=new JFrame("Delivery");
        f.setBackground(Color.white);
        f.setLayout(null);

		
		l=new JLabel("Delivery Details");
		l.setBounds(200,10,250,30);
		l.setFont(new Font("serif",Font.BOLD,25));
		f.add(l);
		
		l1=new JLabel("Courier Number");
		l1.setBounds(50, 100, 200, 40);
		l1.setFont(new Font("serif",Font.BOLD,25));
		f.add(l1);
		
		tf1=new JTextField();
		tf1.setBounds(270, 100, 150, 40);
		f.add(tf1);
		
		l2=new JLabel("Branch Name");
		l2.setBounds(50, 160, 200, 40);
		l2.setFont(new Font("serif",Font.BOLD,25));
		f.add(l2);
		
		tf2=new JTextField();
		tf2.setBounds(270, 160, 150, 40);
		f.add(tf2);
		
		l3=new JLabel("Staff Name");
		l3.setBounds(50, 220, 200, 40);
		l3.setFont(new Font("serif",Font.BOLD,25));
		f.add(l3);
		
		tf3=new JTextField();
		tf3.setBounds(270, 220, 150, 40);
		f.add(tf3);
		
		l4=new JLabel("Delivered To");
		l4.setBounds(50, 280, 200, 40);
		l4.setFont(new Font("serif",Font.BOLD,25));
		f.add(l4);
		
		tf4=new JTextField();
		tf4.setBounds(270, 280, 150, 40);
		f.add(tf4);
		
		l5=new JLabel("Delivered on");
		l5.setBounds(50, 340, 200, 40);
		l5.setFont(new Font("serif",Font.BOLD,25));
		f.add(l5);
		
		tf5=new JTextField();
		tf5.setBounds(270, 340, 150, 40);
		f.add(tf5);
		
		b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,420,100,50);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,420,100,50);
        b2.addActionListener(this);
		f.add(b2);

		f.setVisible(true);
	    f.setSize(900,700);
	    f.getContentPane().setBackground(Color.YELLOW);
	    f.setLocation(400,150);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		String a=tf1.getText();
		String b=tf2.getText();
		String c=tf3.getText();
		String d=tf4.getText();
		String e=tf5.getText();
		
		int f=Integer.parseInt(a);
		
	
		if(ae.getSource() == b1)
		{
			try {
			conn cc=new conn();
			String q="insert into delivery (couriernumber, branchname, staffname, deliveredto, deliveredon) values('" + f + "' , '" + b + "' , '" + c + "','" + d + "','" + e + "')";
			cc.s.executeUpdate(q);
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
		delivery d=new delivery();
	}

}
