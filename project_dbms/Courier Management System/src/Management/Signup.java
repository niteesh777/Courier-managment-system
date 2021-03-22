package Management;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;


public class Signup extends JFrame implements ActionListener{
	
	private JPanel contentpane;
	private JTextField textfield;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JButton b1,b2;
	private JComboBox combobox;
	
	public Signup()
	{
		setBounds(600,250,606,406);
		contentpane=new JPanel();
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane);
		contentpane.setBackground(Color.GREEN);
		contentpane.setLayout(null);
		
		JLabel lhead=new JLabel("SIGN UP");
		lhead.setForeground(Color.BLACK);
		lhead.setFont(new Font("Tahoma",Font.BOLD,14));
		lhead.setBounds(250,20,150,70);
		contentpane.add(lhead);
		
		JLabel luser=new JLabel("USERNAME : ");
		luser.setForeground(Color.DARK_GRAY);
		luser.setFont(new Font("Tahoma",Font.BOLD,14));
		luser.setBounds(99,86,150,26);
		contentpane.add(luser);
		
		JLabel lname=new JLabel("NAME : ");
		lname.setForeground(Color.DARK_GRAY);
		lname.setFont(new Font("Tahoma",Font.BOLD,14));
		lname.setBounds(99,123,150,26);
		contentpane.add(lname);
		
		JLabel lpass=new JLabel("Password : ");
		lpass.setForeground(Color.DARK_GRAY);
		lpass.setFont(new Font("Tahoma",Font.BOLD,14));
		lpass.setBounds(99,160,150,26);
		contentpane.add(lpass);
		
		JLabel lans=new JLabel("Answer : ");
		lans.setForeground(Color.DARK_GRAY);
		lans.setFont(new Font("Tahoma",Font.BOLD,14));
		lans.setBounds(99,234,150,26);
		contentpane.add(lans);
		
		combobox=new JComboBox();
		combobox.setModel(new DefaultComboBoxModel(new String[] {"Your Nickname?","Your Lucky name","Your favourite Cricketer"}));
		combobox.setBounds(265,202,148,20);
		contentpane.add(combobox);
		
		JLabel lsec=new JLabel("Security Question:");
		lsec.setForeground(Color.DARK_GRAY);
		lsec.setFont(new Font("Tahoma",Font.BOLD,14));
		lsec.setBounds(99,197,140,26);
		contentpane.add(lsec);
		
		textfield=new JTextField();
		textfield.setBounds(265,91,148,20);
		contentpane.add(textfield);
		textfield.setColumns(10);
		
		textfield1=new JTextField();
		textfield1.setBounds(265,128,148,20);
		contentpane.add(textfield1);
		textfield1.setColumns(10);

		textfield2=new JTextField();
		textfield2.setBounds(265,165,148,20);
		contentpane.add(textfield2);
		textfield2.setColumns(10);
		
		textfield3=new JTextField();
		textfield3.setBounds(265,239,148,20);
		contentpane.add(textfield3);
		textfield3.setColumns(10);
		
		b1=new JButton("Create");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma",Font.BOLD,13));
		b1.setBounds(140,289,100,30);
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.BLUE);
		contentpane.add(b1);
		
		b2=new JButton("Back");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma",Font.BOLD,13));
		b2.setBounds(300,289,100,30);
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.BLUE);
		contentpane.add(b2);

		JPanel panel=new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBounds(31,46,476,296);
		panel.setBackground(Color.GREEN);
		contentpane.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try {
			conn con = new conn();
			if(ae.getSource() == b1)
			{
				String sql="insert into account(username,name,password,sec_q,sec_ans) values(?,?,?,?,?)";
				PreparedStatement st=con.c.prepareStatement(sql);
				
				st.setString(1, textfield.getText());
				st.setString(2, textfield1.getText());
				st.setString(3, textfield2.getText());
				st.setString(4, (String)combobox.getSelectedItem());
				st.setString(5, textfield3.getText());
				int i=st.executeUpdate();
				System.out.println(i);
				
				if(i > 0)
				{
					JOptionPane.showMessageDialog(null,"Successfully created");
				}
				textfield.setText("");
				textfield1.setText("");
				textfield2.setText("");
				textfield3.setText("");
				
				
			}
			if(ae.getSource() == b2)
			{
				this.setVisible(false);
				new login().setVisible(true);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup().setVisible(true);

	}

}
