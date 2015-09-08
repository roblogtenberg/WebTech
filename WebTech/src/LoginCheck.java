
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class LoginCheck extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			System.out.println("Er zijn geen koekjes");
			return;
		} else {
			for (Cookie cookie : cookies) {
				if (password.equals(cookie.getValue())) {
					System.out.println("Ingelogd");
					response.getWriter().println("Ingelogd");
				} else {
					response.getWriter().println("Naam of wachtwoord is onjuist");
					System.out.println("Naam of wachtwoord is onjuist");
				}
			}
		}
	}
}
