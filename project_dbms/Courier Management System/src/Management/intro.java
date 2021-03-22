package Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class intro extends JFrame implements ActionListener{
	
	JFrame f;
	JButton b;
	JLabel l;
	
	intro()
	{
		f=new JFrame();
		f.setLayout(null);
		
		l=new JLabel("Courier Management System");
		l.setFont(new Font("serif",Font.ITALIC,25));
		l.setBounds(270,50,1500,100);
		l.setForeground(Color.BLACK);
		f.add(l);
		
		b=new JButton("Click Here");
		b.setForeground(Color.BLACK);
		b.setBounds(380,250,100,50);
		b.setBackground(Color.BLUE);
		b.addActionListener(this);
		f.add(b);
		
		f.setVisible(true);
	    f.setSize(900,400);
	    f.getContentPane().setBackground(Color.ORANGE);
	    f.setLocation(200,100);
	    while(true)
	    {
	    	l.setVisible(false);
	    	try {
	    		Thread.sleep(200);
	    	}catch(Exception e){}
	    	
	    	l.setVisible(true);
	    	try {
	    		Thread.sleep(500);
	    	}catch(Exception e)	    	{}
	    }
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b)
		{
			f.setVisible(false);
			new login().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new intro();
	}

}
