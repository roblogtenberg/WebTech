
import java.io.IOException;
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
public class Registreer extends HttpServlet {

	private Cookie cookie;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registreer() {
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
			return;
		} else {
			for (Cookie cookie : cookies) {
				System.out.println("komt die hier?");
				if (name.equals(cookie.getValue())) {
					System.out.println("Naam bestaat al");
				} else {
					cookie = new Cookie("name", name);
					response.addCookie(cookie);
					System.out.println("Account is aangemaakt met naam: " + name + " en password: " + password);
				}
			}
		}

		doGet(request, response);
	}

}
