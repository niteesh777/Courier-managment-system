package Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class options implements ActionListener {
	
	JFrame f;
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	
	options()
	{
		f=new JFrame("Buttons");
		f.setBackground(Color.WHITE);
		f.setLayout(null);
		
		l1=new JLabel();
		l1.setBounds(0,0,700,500);
		l1.setLayout(null);
		//ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource(""))
		//l1.setIcon(i1)
		f.add(l1);
		
		l2=new JLabel("OPTIONS");
		l2.setBounds(200,20,230,50);
		l2.setFont(new Font("serif",Font.BOLD,25));
		l2.setForeground(Color.BLACK);
		l1.add(l2);
		
		b1=new JButton("Staff");
		b1.setBounds(120,100,100,40);
		b1.setFont(new Font("serif",Font.BOLD,25));
		b1.addActionListener(this);
		l1.add(b1);
		
		b2=new JButton("Booking");
		b2.setBounds(300,100,120,40);
		b2.setFont(new Font("serif",Font.BOLD,25));
		b2.addActionListener(this);
		l1.add(b2);
		
		b3=new JButton("Schedule");
		b3.setBounds(120,160,150,40);
		b3.setFont(new Font("serif",Font.BOLD,25));
		b3.addActionListener(this);
		l1.add(b3);
		
		b4=new JButton("Delivery");
		b4.setBounds(300,160,130,40);
		b4.setFont(new Font("serif",Font.BOLD,25));
		b4.addActionListener(this);
		l1.add(b4);
		
		f.setVisible(true);
		f.setSize(700,500);
		f.getContentPane().setBackground(Color.CYAN);
		f.setLocation(450, 200);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_staff();
        }
		if(ae.getSource()==b2){
            f.setVisible(false);
            new view();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new schedule();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new delivery();
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		options o=new options();

	}

	

}
