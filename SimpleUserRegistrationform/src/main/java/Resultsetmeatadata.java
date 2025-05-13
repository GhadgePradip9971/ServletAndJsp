import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Resultsetmeatadata {
	public static void main(String args[]) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/servlet", "root", "Pradip@2001");

			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rss = rs.getMetaData();
			System.out.println("total columns=" + rss.getColumnCount());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
