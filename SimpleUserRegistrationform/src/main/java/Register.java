import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("add");

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the database connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/servlet", "root", "Pradip@2001");

			// Prepare SQL statement
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO register (name, password, email, gender, address) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setString(5, address);

			// Execute the statement
			int i = ps.executeUpdate();

			// Output the result
			if (i > 0) {
				out.println("<h2>New User Registered Successfully!</h2>");
			} else {
				out.println("<h2>Registration Failed. Please Try Again.</h2>");
			}

			// Close the connection
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.println("<h2>Error: " + e.getMessage() + "</h2>");
		}
	}
}
