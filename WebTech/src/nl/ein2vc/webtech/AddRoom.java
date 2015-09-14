package nl.ein2vc.webtech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ein2vc.webtech.model.Leaser;
import nl.ein2vc.webtech.model.User;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRoom() {
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

		if (user == null) {
			out.println("<!DOCTYPE html>" 
					+ "<html>" 
					+ "<head><title>Login error</title></head>" 
					+ "<body>U bent niet ingelogd! <a href=\"login.html\">Naar inlog pagina</a></body>" 
					+ "</html>");
		} else {
			String squareMetersString = request.getParameter("squaremeters");
			String priceString = request.getParameter("price");
			String place = request.getParameter("place");
			
			if (squareMetersString.length() < 1 || priceString.length() < 1 || place.length() < 1) {
				out.println("<!DOCTYPE html>"
						+ "<html>" 
						+ "<head><title>Input error</title></head>" 
						+ "<body>U heeft een foute invoer gemaakt.</body>" 
						+ "</html>");
			} else {
				int squareMeters = Integer.valueOf(squareMetersString);
				double price = Double.valueOf(priceString);
				Leaser leaser = (Leaser) user;

				leaser.addRoom(squareMeters, price, place);

				response.sendRedirect("ShowRooms");
			}
		}
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
