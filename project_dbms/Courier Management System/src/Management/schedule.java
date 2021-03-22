package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class schedule extends JFrame implements ActionListener{

	JFrame f;
	JLabel l,l1,l2,l3,l4;
	JTextField tf1,tf2,tf3,tf4;
	JButton b1,b2;
	
	schedule()
	{

		f=new JFrame("Booking");
        f.setBackground(Color.white);
        f.setLayout(null);

		
		l=new JLabel("Schedule Details");
		l.setBounds(200,10,250,30);
		l.setFont(new Font("serif",Font.BOLD,25));
		f.add(l);
		
		l1=new JLabel("Date");
		l1.setBounds(50, 80, 200, 40);
		l1.setFont(new Font("serif",Font.BOLD,25));
		f.add(l1);
		
		tf1=new JTextField();
		tf1.setBounds(270, 80, 150, 40);
		f.add(tf1);
		
		l2=new JLabel("Courier Number");
		l2.setBounds(50, 140, 200, 40);
		l2.setFont(new Font("serif",Font.BOLD,25));
		f.add(l2);
		
		tf2=new JTextField();
		tf2.setBounds(270, 140, 150, 40);
		f.add(tf2);
		
		l3=new JLabel("Branch Code");
		l3.setBounds(50, 200, 200, 40);
		l3.setFont(new Font("serif",Font.BOLD,25));
		f.add(l3);
		
		tf3=new JTextField();
		tf3.setBounds(270, 200, 150, 40);
		f.add(tf3);
		
		l4=new JLabel("Staff Name");
		l4.setBounds(50, 260, 200, 40);
		l4.setFont(new Font("serif",Font.BOLD,25));
		f.add(l4);
		
		tf4=new JTextField();
		tf4.setBounds(270, 260, 150, 40);
		f.add(tf4);
		
		b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,340,100,50);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,340,100,50);
        b2.addActionListener(this);
		f.add(b2);

		f.setVisible(true);
	    f.setSize(900,700);
	    f.setLocation(400,150);
	    f.getContentPane().setBackground(Color.YELLOW);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		String a=tf1.getText();
		String b=tf2.getText();
		String c=tf3.getText();
		String d=tf4.getText();
		
		int e=Integer.parseInt(b);
		int f=Integer.parseInt(c);
		
		if(ae.getSource() == b1)
		{
			try {
			conn cc=new conn();
			String q="insert into schedule(date, couriernumber, branchcode, staffname) values('" + a + "' , '" + e + "' , '" + f + "','" + d + "')";
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
		schedule s=new schedule();
		

	}

}
