package nl.ein2vc.webtech;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import nl.ein2vc.webtech.model.Model;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyServletContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {

		arg0.getServletContext().setAttribute("myModel", new Model());
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
