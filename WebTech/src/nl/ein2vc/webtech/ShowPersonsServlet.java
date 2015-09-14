package nl.ein2vc.webtech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ein2vc.webtech.model.Model;
import nl.ein2vc.webtech.model.User;

/**
 * Servlet implementation class ShowPersonsServlet
 */
@WebServlet("/ShowPersons")
public class ShowPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPersonsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userLoggedIn");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>" + "<html>" + "<head><title>Persons</title></head>" + "<body>");

		Cookie[] cookies = request.getCookies();

		boolean found = false;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("timesVisited")) {
				found = true;
				int visited = Integer.valueOf(cookie.getValue());
				out.println("De pagina is " + visited + " keer bezocht.");
				visited++;
				cookie.setValue(String.valueOf(visited));
				response.addCookie(cookie);
			}
		}

		if (!found) {
			Cookie cookie = new Cookie("timesVisited", "1");
			out.println("Dit is de eerste keer dat deze pagina bezocht wordt");
			response.addCookie(cookie);
		}

		if (user == null) {
			out.println("U bent niet ingelogd.");
		} else {
			Model model = (Model) getServletContext().getAttribute("myModel");
			List<User> users = model.getUsers();

			for (User u : users) {
				out.println(u);
			}
		}
		out.println("</body>" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
