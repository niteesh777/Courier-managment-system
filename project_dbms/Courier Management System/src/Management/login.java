package Management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
		
	private JPanel panel;//It is same as div in html
	private JTextField textfield;
	private JPasswordField passwordfield;
	private JButton b1,b2;
	
	public login()
	{
		setLayout(null);
		setBackground(new Color(169,169,169));
		setBounds(600,300,600,400);
		
		panel=new JPanel();
		panel.setBackground(Color.PINK);
		setContentPane(panel);
		panel.setLayout(null);
		
		
		JLabel l=new JLabel("LOGIN");
		l.setBounds(224,30,150,50);
		l.setForeground(Color.BLACK);
		panel.add(l);
		
		JLabel l1=new JLabel("USERNAME : ");
		l1.setBounds(124,89,95,24);
		panel.add(l1);
		
		JLabel l2=new JLabel("PASSWORD : ");
		l2.setBounds(124,124,95,24);
		panel.add(l2);
		
		textfield = new JTextField();
		textfield.setBounds(210,93,157,20);
		panel.add(textfield);
		
		passwordfield=new JPasswordField();
		passwordfield.setBounds(210,128,157,20);
		panel.add(passwordfield);
		
		JLabel l3=new JLabel("");
		l3.setBounds(377,79,46,34);
		panel.add(l3);
		
		
		b1=new JButton("Login");
		b1.addActionListener(this);
		
		b1.setForeground(Color.CYAN);
		b1.setBackground(Color.BLUE);
		b1.setBounds(149,181,113,39);
		panel.add(b1);
		
		b2=new JButton("Signup");
		b2.addActionListener(this);
		
		b2.setForeground(Color.CYAN);
		b2.setBackground(Color.BLUE);
		b2.setBounds(289,181,113,39);
		panel.add(b2);

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			boolean status =false;
			try {
				conn con=new conn();
				String sql="select * from account where username=? and password=?";
				PreparedStatement st=con.c.prepareStatement(sql);
				
				st.setString(1, textfield.getText());
				st.setString(2,passwordfield.getText() );
				
				ResultSet rs=st.executeQuery();
				
				if(rs.next())
				{
					this.setVisible(false);
					new Add_staff().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Login");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource() == b2)
		{
			this.setVisible(false);
			new Signup().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login().setVisible(true);

	}

}
