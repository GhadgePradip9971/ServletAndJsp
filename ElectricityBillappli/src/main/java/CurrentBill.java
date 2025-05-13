
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentBill
 */
@WebServlet("/CurrentBill")
public class CurrentBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CurrentBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int Consumer_Number = Integer.parseInt(request.getParameter("cnumber"));
		String Consumer_Name = request.getParameter("cname");
		int Current_Reading = Integer.parseInt(request.getParameter("current"));
		int Previous_Reading = Integer.parseInt(request.getParameter("previous"));
		int Total_units = Current_Reading - Previous_Reading;

		double totalBill = 0.0;
		if (Total_units < 500) {
			totalBill = (Total_units * 1.75);
		} else if (Total_units >= 500 && Total_units < 750) {
			totalBill = (Total_units * 5.25);

		} else {
			totalBill = (Total_units * 9.25);
		}

		out.println("*******ELectricity Bil Details*******" + "<br>");
		out.println("Consumer Number=" + Consumer_Number + "<br>");
		out.println("Consumer Name=" + Consumer_Name + "<br>");

		out.println("Current Reading=" + Current_Reading + "<br>");

		out.println("Previous  Reading=" + Previous_Reading + "<br>");

		out.println("Total Units=" + Total_units + "<br>");
		out.println("Total Bill=" + totalBill + "<br>");

	}

}
