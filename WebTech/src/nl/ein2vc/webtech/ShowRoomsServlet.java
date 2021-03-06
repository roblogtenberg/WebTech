package nl.ein2vc.webtech;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ein2vc.webtech.model.Leaser;
import nl.ein2vc.webtech.model.Room;
import nl.ein2vc.webtech.model.User;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRooms")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userLoggedIn");
		PrintWriter out = response.getWriter();
		
		if(user == null) {
			printLoginError(out);
		} else {
			if(user instanceof Leaser) {
				Leaser leaser = (Leaser) user;
				List<Room> rooms = leaser.getRooms();
				out.println("<!DOCTYPE html"
						+ "<html>"
						+ "<head><title>Rooms</title></head>"
						+ "<body>");
				
				for(Room room : rooms) {
					out.println(room);
				}
				
				out.println("<form method=\"POST\" action=\"ShowRooms\">"
						+	 "<input type=\"submit\" value=\"Kamer toevoegen\" >"
						+   "</form>"
						+ "</body>"
						+ "</html>");
			} else {
				printLoginError(out);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/addroom.html");
		dispatcher.forward(request, response);
	}

	private void printLoginError(PrintWriter out) {
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><title>Login error</title><head>"
				+ "<body>U bent niet ingelogd!</body>"
				+ "</html>");
	}
}
