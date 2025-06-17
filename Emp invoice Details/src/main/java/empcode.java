
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empcode
 */
@WebServlet("/empcode")
public class empcode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public empcode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			String Eid = request.getParameter("id");
			String Ename = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			double ta = 0.0, da = 0.0, hra = 0.0, pf = 0.0, gross_salary = 0.0, Net_salary = 0.0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "pradip", "ghadge");

			if (salary < 30000) {
				ta = 0.07 * salary;
				da = 0.09 * salary;
				hra = 0.11 * salary;
				pf = 0.17 * salary;
			} else if (salary >= 30000 && salary < 60000) {
				ta = 0.11 * salary;
				da = 0.13 * salary;
				hra = 0.1725 * salary;
				pf = 0.2175 * salary;
			} else {
				ta = 0.17 * salary;
				da = 0.1825 * salary;
				hra = 0.2122 * salary;
				pf = 0.3325 * salary;
			}
			gross_salary = ta + da + hra + pf;
			Net_salary = gross_salary - pf;

			PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, Eid);
			ps.setString(2, Ename);
			ps.setDouble(3, salary);
			ps.setDouble(4, ta);
			ps.setDouble(5, da);
			ps.setDouble(6, hra);
			ps.setDouble(7, pf);
			ps.setDouble(8, gross_salary);
			ps.setDouble(9, Net_salary);

			int i = ps.executeUpdate();

			if (i > 0) {
				out.println("New employee record inserted successfull");
			} else {
				out.println("failed data.....");
			}
			con.close();
		} catch (Exception orcl) {
			out.print(orcl);
		}

	}

}
