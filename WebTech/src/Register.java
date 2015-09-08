
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registreer
 */
@WebServlet("/Registreer")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			makeAccountCookie(name, password, response);
			return;
		} else {
			for (Cookie cookie : cookies) {
				System.out.println("komt die hier?");
				if (name.equals(cookie.getValue())) {
					System.out.println("Naam bestaat al");
					response.getWriter().println("Naam bestaat al");
				}
			}
			makeAccountCookie(name, password, response);
		}
	}

	public void makeAccountCookie(String name, String password, HttpServletResponse response) throws IOException {
		Cookie cookieName = new Cookie("name", name);
		Cookie cookiePassword = new Cookie("password", password);
		response.addCookie(cookieName);
		response.addCookie(cookiePassword);
		response.getWriter().println("Account is aangemaakt");
		System.out.println("Account is aangemaakt met naam: " + name + " en password: " + password);
	}
}
