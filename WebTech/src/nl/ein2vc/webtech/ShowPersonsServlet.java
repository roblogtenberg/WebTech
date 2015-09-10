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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userLoggedIn");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			//make new cookie
		}
		
		if(user == null) {
			out.println("<!DOCTYPE html>"
					+ "<html>"
					+ "<head><title>Not logged in</title></head>"
					+ "<body>"
					+ "U bent niet ingelogd."
					+ "</body>"
					+ "</html>");
		} else {
			Model model = (Model) getServletContext().getAttribute("myModel");
			List<User> users = model.getUsers();
			out.println("<!DOCTYPE html"
					+ "<html>"
					+ "<head><title>Persons</title><head>"
					+ "<body>");
			
			for(User u : users) {
				out.println(u);
			}
			
			out.println("</body>"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
