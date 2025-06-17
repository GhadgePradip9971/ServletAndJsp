import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Name")
public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Name() {
		super();
	}

	@Override
	public ServletConfig getServletConfig() {
		return super.getServletConfig();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int roll_no = 41;
		String name = "Pradip";

		out.println("<h1>My roll number is: " + roll_no + "</h1>");
		out.println("<h1>My name is: " + name + "</h1>");

		out.close();
	}
}
