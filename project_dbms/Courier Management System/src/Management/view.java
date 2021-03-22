package Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class view extends JFrame implements ActionListener{
	
	JFrame f;
	JTextField tf;
	JLabel l1;
	JButton b1,b2;
	
	view()
	{
		f=new JFrame("View");
		f.setBackground(Color.GREEN);
		f.setLayout(null);
		
		l1=new JLabel("Employee Id");
		l1.setBounds(40,60,250,30);
		l1.setForeground(Color.BLACK);
		Font F1 = new Font("serif",Font.BOLD,30);
		l1.setFont(F1);
		f.add(l1);
		
		tf=new JTextField();
        tf.setBounds(240,60,220,30);
        f.add(tf);

        b1=new JButton("Search");
        b1.setBounds(240,150,100,30);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        f.add(b2);

        f.setVisible(true);
	    f.setSize(900,700);
	    f.getContentPane().setBackground(Color.cyan);
	    f.setLocation(400,150);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String a=tf.getText();
		int b=Integer.parseInt(a);
		if(ae.getSource() == b2)
		{
			f.setVisible(false);
			options o=new options();
		}
		if(ae.getSource() == b1)
		{
			f.setVisible(false);
			booking c=new booking(b);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		view p=new view();

	}

}
