package Management;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Add_staff extends JFrame implements ActionListener{

	JFrame f;
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b,b1;
	
	
	
	Add_staff()
	{
		f=new JFrame();
		f.setLayout(null);
		
		l=new JLabel("Employee Details");
		l.setBounds(320,30,500,50);
		l.setFont(new Font("serif",Font.ITALIC,25));
		l.setForeground(Color.BLACK);
		f.add(l);
		
		l1=new JLabel("Name");
		l1.setBounds(50,150,150,30);
		l1.setFont(new Font("serif",Font.ITALIC,25));
		l1.setForeground(Color.BLACK);
		f.add(l1);
		
		t1=new JTextField();
		t1.setBounds(220,150,150,30);
		f.add(t1);
		
		l2=new JLabel("Employee ID");
		l2.setBounds(50,200,150,30);
		l2.setFont(new Font("serif",Font.ITALIC,25));
		l2.setForeground(Color.BLACK);
		f.add(l2);
		
		t2=new JTextField();
		t2.setBounds(220,200,150,30);
		f.add(t2);
		
		l3=new JLabel("Contact No");
		l3.setBounds(50,250,150,30);
		l3.setFont(new Font("serif",Font.ITALIC,25));
		l3.setForeground(Color.BLACK);
		f.add(l3);
		
		t3=new JTextField();
		t3.setBounds(220,250,150,30);
		f.add(t3);
		
		l4=new JLabel("Branch Name");
		l4.setBounds(50,300,150,30);
		l4.setFont(new Font("serif",Font.ITALIC,25));
		l4.setForeground(Color.BLACK);
		f.add(l4);
		
		t4=new JTextField();
		t4.setBounds(220,300,150,30);
		f.add(t4);
		
		l5=new JLabel("Branch Address");
		l5.setBounds(50,350,180,30);
		l5.setFont(new Font("serif",Font.ITALIC,25));
		l5.setForeground(Color.BLACK);
		f.add(l5);
		
		t5=new JTextField();
		t5.setBounds(250,350,150,30);
		f.add(t5);
		
		l6=new JLabel("Branch Pin");
		l6.setBounds(50,400,150,30);
		l6.setFont(new Font("serif",Font.ITALIC,25));
		l6.setForeground(Color.BLACK);
		f.add(l6);
		
		t6=new JTextField();
		t6.setBounds(220,400,150,30);
		f.add(t6);
		
	
		b = new JButton("Submit");
	    b.setBackground(Color.BLACK);
	    b.setForeground(Color.WHITE);
	    b.setBounds(250,550,150,40);
	    
	    f.add(b);
	
	    b1=new JButton("Cancel");   
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
	    b1.setBounds(450,550,150,40);
	    
	    f.add(b1);
	    
	    b.addActionListener(this);
	    b1.addActionListener(this);
	    
	    
	    f.setVisible(true);
	    f.setSize(900,700);
	    f.getContentPane().setBackground(Color.YELLOW);
	    f.setLocation(400,150);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String a,i,c,d,e,f;
		a=t1.getText();
		i=t2.getText();
		c=t3.getText();
		d=t4.getText();
		e=t5.getText();
		f=t6.getText();
		
		int g=Integer.parseInt(i);  
        int h=Integer.parseInt(f);  
		
		if(ae.getSource() == b)
		{
			try {
				conn cc=new conn();
				String q="insert into staff(name, empid, contact, branchname, branchaddress, branchcode) values('"+a+"',"+g+",'"+c+"','"+d+"','"+e+"','"+h+"')";
				cc.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                this.setVisible(false);
                new options();
				
 			}catch(Exception e1)
			{
 				e1.printStackTrace();
			}
		}else if(ae.getSource() == b1){
			this.setVisible(false);
            new options();
        }
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Add_staff();
	}

}
