package nl.ein2vc.webtech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ein2vc.webtech.model.Model;
import nl.ein2vc.webtech.model.Room;

/**
 * Servlet implementation class SearchRoomServlet
 */
@WebServlet("/SearchRoom")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int squareMeters = Integer.valueOf(request.getParameter("squaremeters"));
		double price = Double.valueOf(request.getParameter("maxprice"));
		String place = request.getParameter("place");
		PrintWriter out = response.getWriter();
		
		Model model = (Model) getServletContext().getAttribute("myModel");
		List<Room> rooms = model.getRooms();

		for (Room room : rooms) {
			if(squareMeters >= room.getSquareMeters() && price <= room.getPrice() && place.toLowerCase().contains(room.getPlace().toLowerCase())) {
				out.println(room);
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
