package Management;
import java.sql.*;

public class conn {

		// TODO Auto-generated method stub
		Connection c;
		Statement s;
		public conn()
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				c= DriverManager.getConnection("jdbc:mysql://localhost/courier management system?" +
						"user=root&password=");
						
				s=c.createStatement();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}

}
