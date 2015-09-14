package nl.ein2vc.webtech;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.ein2vc.webtech.model.Model;
import nl.ein2vc.webtech.model.Renter;
import nl.ein2vc.webtech.model.User;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/LoginCheck")
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

		Model model = (Model) getServletContext().getAttribute("myModel");

		if (model.isUser(name)) {
			User user = model.getUser(name);
			if (password.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.removeAttribute("userLoggedIn");
				session.setAttribute("userLoggedIn", user);
				System.out.println("Logged in succesfully");
				if(user instanceof Renter) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/renter.html");
					dispatcher.forward(request, response);
				} else {
					response.sendRedirect("ShowRooms");
				}
			} else {
				response.sendRedirect("badLogin.html");
				System.out.println("Wrong username or password");
			}

		} else {
			response.sendRedirect("badLogin.html");
			System.out.println("Wrong username or password");
		}

	}
}
