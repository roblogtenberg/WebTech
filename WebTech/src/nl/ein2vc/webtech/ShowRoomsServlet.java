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
		Leaser leaser = (Leaser) request.getSession().getAttribute("userLoggedIn");
		List<Room> rooms = leaser.getRooms();
		PrintWriter out = response.getWriter();
		for(Room r : rooms) {
			out.println(r.getPlace() + " " + r.getPrice() + " " + r.getSquareMeters());
			System.out.println("room shown");
		}
		
		out.println("<!DOCTYPE html"
				+ "<html>"
				+ "<head><title>Rooms</title></head>"
				+ "<body>"
				+ "<form method=\"POST\" action=\"ShowRooms\">"
				+	 "<input type=\"submit\" >"
				+   "</form>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/addroom.html");
		dispatcher.forward(request, response);
	}

}
