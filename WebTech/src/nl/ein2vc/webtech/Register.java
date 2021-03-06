package nl.ein2vc.webtech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ein2vc.webtech.model.Leaser;
import nl.ein2vc.webtech.model.Model;
import nl.ein2vc.webtech.model.Renter;
import nl.ein2vc.webtech.model.User;

/**
 * Servlet implementation class Registreer
 */
@WebServlet("/Register")
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
		String userType = request.getParameter("radioButton");
		PrintWriter out = response.getWriter();
		Model model = (Model) getServletContext().getAttribute("myModel");

		if (name.length() < 1 || password.length() < 1) {
			out.println("Foute invoer");
		} else {
			if (!model.isUser(name)) {
				if (userType.equals("Renter")) {
					User user = new Renter(name, password);
					model.addUser(user);
				} else {
					User user = new Leaser(name, password);
					model.addUser(user);
				}

				response.sendRedirect("login.html");
			} else {
				System.out.println("De gebruiker bestaat al");
				out.println("De gebruikersnaam bestaat al");
			}

		}
	}
}